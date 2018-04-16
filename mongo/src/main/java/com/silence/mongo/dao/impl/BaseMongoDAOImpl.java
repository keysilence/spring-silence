package com.silence.mongo.dao.impl;

import com.silence.mongo.dao.BaseMongoDAO;
import com.silence.mongo.model.BaseMongoModel;
import com.silence.mongo.model.Page;
import com.silence.mongo.model.SEQ;
import com.silence.mongo.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public abstract class BaseMongoDAOImpl<T extends BaseMongoModel> implements BaseMongoDAO<T> {
    Logger logger = LoggerFactory.getLogger(BaseMongoDAOImpl.class);


    @Autowired
    protected MongoTemplate mongoTemplate;

    private static final String SEQ_ID = "_SEQ";

    @Override
    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    @Override
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    @Override
    public boolean update(Query query, Update update) {
        return mongoTemplate.findAndModify(query, update, this.getEntityClass()) != null;
    }

    @Override
    public T save(T entity) {
        if (entity != null) {
            if (entity.getId() == null || (Long) entity.getId() == 0L) {
                Long id = incId();
                entity.setId(id);
            }
            mongoTemplate.save(entity);
            return entity;
        }
        return null;
    }

    @Override
    public T insert(T entity) {
        if (entity != null) {
            if (entity.getId() == null || (Long) entity.getId() == 0L) {
                Long id = incId();
                entity.setId(id);
            }
            logger.info("entity:{}",entity.toString());
            mongoTemplate.insert(entity);
            return entity;
        }
        return null;
    }

    @Override
    public T findById(Long id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    @Override
    public T findById(Long id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    @Override
    public void delete(Query query) {
        mongoTemplate.remove(query, this.getEntityClass());
    }

    @Override
    public Page<T> findPage(Page<T> page, Query query) {
        long count = this.count(query);
        page.setTotalCount((int) count);
        int pageNumber = page.getCurrentPage();
        int pageSize = page.getPageSize();
        query.skip((pageNumber - 1) * pageSize).limit(pageSize);
        List<T> rows = this.find(query);
        page.setResult(rows);
        return page;
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, this.getEntityClass());
    }


    @Override
    public long incId() {
        long id = 0;
        Document document = this.getEntityClass().getAnnotation(Document.class);
        if (document != null && document.collection() != null) {
            String collection = document.collection();
            Query query = new Query();
            query.addCriteria(new Criteria("seqKey").is(collection + SEQ_ID));
            Update update = new Update();
            update.inc("seqValue", 1);
            SEQ seq = mongoTemplate.findAndModify(query, update, SEQ.class);
            if (seq == null) {
                seq = new SEQ();
                seq.setSeqKey(collection + SEQ_ID);
                seq.setSeqValue(1L);
                mongoTemplate.insert(seq);
            }
            id = seq.getSeqValue();

        }
        return id;
    }

    @Override
    public GroupByResults<T> groupBy(Criteria criteria, GroupBy groupBy) {
        String collectionName = this.getEntityClass().getAnnotation(Document.class).collection();
        return mongoTemplate.group(criteria, collectionName, groupBy, this.getEntityClass());
    }


    private Class<T> getEntityClass() {
        return ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public MongoTemplate getMongoTemplate() {
        return this.mongoTemplate;
    }

}

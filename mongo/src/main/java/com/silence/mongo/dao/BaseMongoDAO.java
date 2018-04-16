package com.silence.mongo.dao;

import com.silence.mongo.model.Page;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface BaseMongoDAO<T> {
    /**
     * 通过条件查询实体(集合)
     *
     * @param query
     */
    List<T> find(Query query);

    /**
     * 通过一定的条件查询一个实体
     *
     * @param query
     * @return
     */
    T findOne(Query query);

    /**
     * 通过条件查询更新数据
     *
     * @param query
     * @param update
     * @return
     */
    boolean update(Query query, Update update);

    /**
     * 保存一个对象到mongodb
     *
     * @param entity
     * @return
     */
    T save(T entity);


    /**
     * 创建一个对象到mongodb
     *
     * @param entity
     * @return
     */
    T insert(T entity);


    /**
     * 通过ID获取记录
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     *
     * @param id
     * @param collectionName 集合名
     * @return
     */
    T findById(Long id, String collectionName);

    /**
     * 分页查询
     *
     * @param page
     * @param query
     * @return
     */
    Page<T> findPage(Page<T> page, Query query);

    void delete(Query query);

    /**
     * 求数据总和
     *
     * @param query
     * @return
     */
    long count(Query query);

    long incId() throws Exception;

    GroupByResults<T> groupBy(Criteria criteria, GroupBy groupBy);
}

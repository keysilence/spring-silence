package com.silence.mongo.dao.impl;

import com.silence.mongo.dao.TestDao;
import com.silence.mongo.model.Test;
import org.springframework.stereotype.Repository;

/**
 * Created by Silence on 2018/4/16.
 */
@Repository("testDao")
public class TestDaoImpl extends BaseMongoDAOImpl<Test> implements TestDao {

    @Override
    public Test add(Test test) {
        return insert(test);
    }

}

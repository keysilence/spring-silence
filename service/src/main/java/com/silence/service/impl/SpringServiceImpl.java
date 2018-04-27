package com.silence.service.impl;

import com.silence.dao.SpringMapper;
import com.silence.domain.Spring;
import com.silence.service.api.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Silence on 2018/4/10.
 */
@Repository
public class SpringServiceImpl implements SpringService {

    @Autowired
    private SpringMapper springMapper;

    @Override
    public List<Spring> findSprings() {

        return springMapper.selectList(null);

    }

    @Transactional
    @Override
    public void transactionTest() {

        this.save();
        this.update();

    }

    private void save() {

        Spring spring = new Spring();
        spring.setName("Second");
        springMapper.save(spring);

    }

    private void update() {

        throw new RuntimeException("Save Error!");

    }

}

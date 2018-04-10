package com.silence.service.impl;

import com.silence.dao.SpringMapper;
import com.silence.domain.Spring;
import com.silence.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Silence on 2018/4/10.
 */
@Service
public class SpringServiceImpl implements SpringService {

    @Autowired
    private SpringMapper springMapper;

    @Override
    public List<Spring> findSprings() {

        return springMapper.selectList(null);

    }

}

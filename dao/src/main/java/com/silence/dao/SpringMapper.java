package com.silence.dao;

import com.silence.domain.Spring;
import java.util.List;
import java.util.Map;

public interface SpringMapper {

    public long save(Spring spring);

    public long update(Spring spring);

    public long delete(Long id);

    public List<Spring> selectList(Map<String, Object> params);

    public Integer selectListCount(Map<String, Object> params);

    public Spring selectById(Long id);

    public List<Spring> selectByBatchIds(Map<String, Object> params);

}

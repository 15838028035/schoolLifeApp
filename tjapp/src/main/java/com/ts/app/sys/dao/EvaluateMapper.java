package com.ts.app.sys.dao;

import java.util.List;

import com.ts.app.sys.domain.Evaluate;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer evaluateid);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaluateid);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
    
    public List<Evaluate> queryListByArticeId(Integer articleid);
}
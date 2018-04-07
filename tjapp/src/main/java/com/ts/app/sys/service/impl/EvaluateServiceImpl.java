package com.ts.app.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.EvaluateMapper;
import com.ts.app.sys.domain.Evaluate;
import com.ts.app.sys.service.EvaluateService;

@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	private EvaluateMapper evaluateMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer evaluateid) {
		return evaluateMapper.deleteByPrimaryKey(evaluateid);
	}


	@Override
	public int insertSelective(Evaluate record) {
		return evaluateMapper.insertSelective(record);
	}

	@Override
	public int insert(Evaluate record) {
		return evaluateMapper.insert(record);
	}


	@Override
	public Evaluate selectByPrimaryKey(Integer evaluateid) {
		return evaluateMapper.selectByPrimaryKey(evaluateid);
	}

	@Override
	public int updateByPrimaryKeySelective(Evaluate record) {
		return evaluateMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Evaluate record) {
		return evaluateMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Evaluate> queryListByArticeId(Integer articleid) {
		return evaluateMapper.queryListByArticeId(articleid);
	}
	
}

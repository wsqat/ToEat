package com.toeat.service;

import java.util.ArrayList;
import java.util.List;

import com.toeat.dao.BaseDao;
/**
 * @author sage_wang
 * 对Object的Service
 * 包含了一些通用的方法
 */
public class BaseServiceImpl implements BaseService {
	
	private BaseDao baseDao;
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		baseDao.save(object);
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		baseDao.update(object);
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		baseDao.delete(object);
	}

	@Override
	public Object ReadByID(String targetName,int id) {
		// TODO Auto-generated method stub
		return baseDao.ReadSingle(targetName,"id", id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List ReadAll(String targetName) {
		// TODO Auto-generated method stub
		return baseDao.ReadAll(targetName);
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List ReadByProperty(String targetName, String propertyName,
			Object propertyValue) {
		// TODO Auto-generated method stub
		return baseDao.ReadByProperty(targetName, propertyName, propertyValue);
	}

	@Override
	public Object ReadSingle(String targetName, String propertyName,
			Object propertyValue) {
		// TODO Auto-generated method stub
		return baseDao.ReadSingle(targetName, propertyName, propertyValue);
	}

	@Override
	public List ReadLimitedByOrder(String targetName, String propertyName,
			int num, String order) {
		return baseDao.ReadLimitedByOrder(targetName,propertyName,num,order);
	}
	
	@Override
	public int ReadCount(String targetName) {
		// TODO Auto-generated method stub
		return baseDao.ReadCount(targetName);
	}

	@Override
	public int ReadCountByProperty(String targetName,String propertyName, Object value) {
		// TODO Auto-generated method stub
		return baseDao.ReadCountByProperty(targetName,propertyName,value);
	}

	@Override
	public List ReadByPropertyAndLimitedByOrder(String targetName,
			String readpropertyName, Object readvalue,
			String orderpropertyName, int num, String order) {
		return baseDao.ReadByPropertyAndLimitedByOrder(targetName, readpropertyName, readvalue,
				orderpropertyName, num, order);
	}

	@Override
	public Object ReadByDouble(String targetName, String propertyName,
			Object propertyValue, String propertyName2, Object propertyValue2) {
		// TODO Auto-generated method stub
		return baseDao.ReadSingleByDouble(targetName, propertyName, propertyValue,propertyName2,propertyValue2);
	}

	@Override
	public Object ReadSingleByDouble(String targetName, String propertyName,
			Object propertyValue, String propertyName2, Object propertyValue2) {
		// TODO Auto-generated method stub
		return baseDao.ReadSingleByDouble(targetName, propertyName, propertyValue,propertyName2,propertyValue2);
	}

}

/** 
 * <pre>项目名称:ssh-exc-hanyn 
 * 文件名称:ExcDaoImpl.java 
 * 包名:com.jk.dao.impl 
 * 创建日期:2017-10-13上午9:04:18 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jk.dao.ExcDao;
import com.jk.model.Exceptions;
import com.jk.model.PageFlag;

/** 
 * <pre>项目名称：ssh-exc-hanyn    
 * 类名称：ExcDaoImpl    
 * 类描述：    
 * 创建人：韩雅宁 cht_java@126.com    
 * 创建时间：2017-10-13 上午9:04:18    
 * 修改人：韩雅宁 cht_java@126.com  
 * 修改时间：2017-10-13 上午9:04:18    
 * 修改备注：       
 * @version </pre>    
 */
public class ExcDaoImpl extends HibernateDaoSupport implements ExcDao{

	@Override
	public void insertExc(Exceptions exceptions) {
		this.getHibernateTemplate().save(exceptions);
		
	}

	/* (non-Javadoc)    
	 * @see com.jk.dao.ExcDao#queryExc(java.lang.Exception)    
	 */
	@Override
	public List<Exceptions> queryExc(String hql, PageFlag pageFlag) {
		// TODO Auto-generated method stub
		List<Exceptions> list = new ArrayList<Exceptions>();
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
			
			 
		query.setFirstResult((pageFlag.getPageIndex()-1) *pageFlag.getPageSize());
			
		query.setMaxResults(pageFlag.getPageSize());
		        
			list = query.list();
		return list;
	}

	/* (non-Javadoc)    
	 * @see com.jk.dao.ExcDao#queryUserCount(java.lang.String)    
	 */
	@Override
	public long queryUserCount(String hql) {
		long userTotal = 0;
		
		 List list = this.getHibernateTemplate().find(hql);
			
			if (list != null) {
				userTotal = list.size();
			}
		
			return userTotal; 
	}

	/* (non-Javadoc)    
	 * @see com.jk.dao.ExcDao#deleteAllCar(java.lang.String, java.util.List)    
	 */
	@Override
	public void deleteAllCar(String hql, List<Integer> idList) {
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameterList("ids",idList);
		query.executeUpdate();
		
	}


       
}

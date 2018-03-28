/** 
 * <pre>项目名称:ssh-exc-hanyn 
 * 文件名称:ExcService.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2017-10-13上午9:03:06 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jk.dao.ExcDao;
import com.jk.model.Exceptions;
import com.jk.model.PageFlag;
import com.jk.service.ExcService;

/** 
 * <pre>项目名称：ssh-exc-hanyn    
 * 类名称：ExcService    
 * 类描述：    
 * 创建人：韩雅宁 cht_java@126.com    
 * 创建时间：2017-10-13 上午9:03:06    
 * 修改人：韩雅宁 cht_java@126.com  
 * 修改时间：2017-10-13 上午9:03:06    
 * 修改备注：       
 * @version </pre>    
 */
public class ExcServiceImpl implements ExcService{
    private ExcDao excDao;

	public ExcDao getExcDao() {
		return excDao;
	}

	public void setExcDao(ExcDao excDao) {
		this.excDao = excDao;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.ExcService#insertExc(java.lang.Exception)    
	 */
	@Override
	public void insertExc(Exceptions exceptions) {
		
		excDao.insertExc(exceptions);
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.ExcService#queryExc(java.lang.Exception)    
	 */
	@Override
	public List<Exceptions> queryExc(Exceptions exceptions,PageFlag pageFlag) {
		// TODO Auto-generated method stub
		String hql=" from Exceptions";
		return excDao.queryExc(hql,pageFlag);
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.ExcService#queryUserCount(com.jk.model.PageFlag, com.jk.model.Exceptions)    
	 */
	@Override
	public PageFlag queryUserCount(PageFlag pageFlag, Exceptions exceptions) {
		if (pageFlag == null) {
			pageFlag = new PageFlag();
		}
		
		if (pageFlag.getPageIndex() == null) {
			pageFlag.setPageIndex(1);
		}
		
		if (pageFlag.getPageSize() == null) {
			pageFlag.setPageSize(3);
		}
		 String hql = "  from Exceptions where 1=1 ";
			
			
			
		
		
		long userTotal = excDao.queryUserCount(hql);
		
		long userResidue = userTotal - (pageFlag.getPageIndex() * pageFlag.getPageSize()) < 0 ? 0 : userTotal - (pageFlag.getPageIndex() * pageFlag.getPageSize());
		
		long pageTotal = userTotal % pageFlag.getPageSize() == 0  ? userTotal / pageFlag.getPageSize() : userTotal / pageFlag.getPageSize() + 1; 
		
		pageFlag.setDataTotal(userTotal);
		pageFlag.setDataResidue(userResidue);
		pageFlag.setPageTotal(pageTotal);
		
		List<Integer> currentNum = new ArrayList<Integer>();
		for (int i = 1; i <= pageTotal; i++) {
			currentNum.add(i);
		}
		pageFlag.setCurrentPageList(currentNum);
		
		return pageFlag;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.ExcService#deleteAllExc(java.lang.String)    
	 */
	@Override
	public void deleteAllExc(String ids) {
		List<Integer> idList = new ArrayList<Integer>();
		String hql = " delete from Exceptions where excId in (:ids)";
		String[] split = ids.split(",");
		for(int i =0;i<split.length;i++){
			idList.add(Integer.parseInt(split[i]));
		}
		excDao.deleteAllCar(hql,idList);
	}
    
}

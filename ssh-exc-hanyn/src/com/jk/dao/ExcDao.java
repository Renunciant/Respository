/** 
 * <pre>项目名称:ssh-exc-hanyn 
 * 文件名称:ExcDao.java 
 * 包名:com.jk.dao 
 * 创建日期:2017-10-13上午9:03:42 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.List;

import com.jk.model.Exceptions;
import com.jk.model.PageFlag;

/** 
 * <pre>项目名称：ssh-exc-hanyn    
 * 类名称：ExcDao    
 * 类描述：    
 * 创建人：韩雅宁 cht_java@126.com    
 * 创建时间：2017-10-13 上午9:03:42    
 * 修改人：韩雅宁 cht_java@126.com  
 * 修改时间：2017-10-13 上午9:03:42    
 * 修改备注：       
 * @version </pre>    
 */
public interface ExcDao {

	/** <pre>insertExc(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午9:09:58    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午9:09:58    
	 * 修改备注： 
	 * @param exception</pre>    
	 */
	void insertExc(Exceptions exceptions);

	/** <pre>queryExc(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午9:20:11    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午9:20:11    
	 * 修改备注： 
	 * @param pageFlag 
	 * @param exception
	 * @return</pre>    
	 */
	List<Exceptions> queryExc(String hql, PageFlag pageFlag);

	/** <pre>queryUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午9:56:26    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午9:56:26    
	 * 修改备注： 
	 * @param hql
	 * @return</pre>    
	 */
	long queryUserCount(String hql);

	/** <pre>deleteAllCar(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午10:06:51    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午10:06:51    
	 * 修改备注： 
	 * @param hql
	 * @param idList</pre>    
	 */
	void deleteAllCar(String hql, List<Integer> idList);



}

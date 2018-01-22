/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:MenuService.java 
 * 包名:com.jk.service 
 * 创建日期:2017年11月28日上午10:52:42 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;


import com.jk.model.Menu;

import java.util.List;





/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：MenuService    
 * 类描述：    
 * 创建人：韩雅宁 hanyaningde@sina.com    
 * 创建时间：2017年11月28日 上午10:52:42    
 * 修改人：韩雅宁 hanyaningde@sina.com  
 * 修改时间：2017年11月28日 上午10:52:42    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuService {

	/** <pre>selectTree(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@sina.com      
	 * 创建时间：2017年11月28日 上午11:06:58    
	 * 修改人：韩雅宁 hanyaningde@sina.com       
	 * 修改时间：2017年11月28日 上午11:06:58    
	 * 修改备注： 
	 * @param i</pre>    
	 * @return 
	 */
	List<Menu> selectTree(int i);

}

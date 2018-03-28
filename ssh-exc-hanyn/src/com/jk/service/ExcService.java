/** 
 * <pre>项目名称:ssh-exc-hanyn 
 * 文件名称:ExcService.java 
 * 包名:com.jk.service 
 * 创建日期:2017-10-13上午9:02:49 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.List;

import com.jk.model.Exceptions;
import com.jk.model.PageFlag;

/** 
 * <pre>项目名称：ssh-exc-hanyn    
 * 类名称：ExcService    
 * 类描述：    
 * 创建人：韩雅宁 cht_java@126.com    
 * 创建时间：2017-10-13 上午9:02:49    
 * 修改人：韩雅宁 cht_java@126.com  
 * 修改时间：2017-10-13 上午9:02:49    
 * 修改备注：       
 * @version </pre>    
 */
public interface ExcService {

	/** <pre>insertExc(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午9:08:44    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午9:08:44    
	 * 修改备注： 
	 * @param exception</pre>    
	 */
	void insertExc(Exceptions exceptions);

	/** <pre>queryExc(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午9:19:11    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午9:19:11    
	 * 修改备注： 
	 * @param pageFlag 
	 * @param exception
	 * @return</pre>    
	 */
	List<Exceptions> queryExc(Exceptions exceptions, PageFlag pageFlag);

	/** <pre>queryUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午9:55:32    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午9:55:32    
	 * 修改备注： 
	 * @param pageFlag
	 * @param exceptions
	 * @return</pre>    
	 */
	PageFlag queryUserCount(PageFlag pageFlag, Exceptions exceptions);

	/** <pre>deleteAllExc(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 cht_java@126.com     
	 * 创建时间：2017-10-13 上午10:05:09    
	 * 修改人：韩雅宁 cht_java@126.com      
	 * 修改时间：2017-10-13 上午10:05:09    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteAllExc(String ids);
    
}

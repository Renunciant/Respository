/** 
 * <pre>项目名称:dubbo-boot-customer 
 * 文件名称:ProductService.java 
 * 包名:com.jk.service 
 * 创建日期:2018年1月18日下午7:31:43 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.List;

import com.jk.model.Product;

/** 
 * <pre>项目名称：dubbo-boot-customer    
 * 类名称：ProductService    
 * 类描述：    
 * 创建人：韩雅宁 hanyaningde@163.com    
 * 创建时间：2018年1月18日 下午7:31:43    
 * 修改人：韩雅宁 hanyaningde@163.com  
 * 修改时间：2018年1月18日 下午7:31:43    
 * 修改备注：       
 * @version </pre>    
 */
public interface ProductService {

	/** <pre>queryProductInfo(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:26:13    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:26:13    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @return</pre>    
	 */
	List<HashMap<String, Object>> queryProductInfo(Integer pageSize, Integer start);

	/** <pre>queryDaaTotal(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:26:16    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:26:16    
	 * 修改备注： 
	 * @return</pre>    
	 */
	long queryDaaTotal();

	/** <pre>queryProductById(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:26:22    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:26:22    
	 * 修改备注： 
	 * @param productid
	 * @return</pre>    
	 */
	Product queryProductById(Integer productid);

	/** <pre>saveOrUpdate(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:26:29    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:26:29    
	 * 修改备注： 
	 * @param product</pre>    
	 */
	void saveOrUpdate(Product product);

	/** <pre>updateProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:26:32    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:26:32    
	 * 修改备注： 
	 * @param product</pre>    
	 */
	void updateProduct(Product product);

	/** <pre>delProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:26:41    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:26:41    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void delProduct(String ids);

}

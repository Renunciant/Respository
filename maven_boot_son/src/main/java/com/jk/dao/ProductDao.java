/** 
 * <pre>项目名称:dubbo-boot-provider 
 * 文件名称:ProductDao.java 
 * 包名:com.jk.dao 
 * 创建日期:2018年1月18日下午4:29:44 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/** 
 * <pre>项目名称：dubbo-boot-provider    
 * 类名称：ProductDao    
 * 类描述：    
 * 创建人：韩雅宁 hanyaningde@163.com    
 * 创建时间：2018年1月18日 下午4:29:44    
 * 修改人：韩雅宁 hanyaningde@163.com  
 * 修改时间：2018年1月18日 下午4:29:44    
 * 修改备注：       
 * @version </pre>    
 */
@Mapper
public interface ProductDao {

	

	/** <pre>queryProductInfo(查询list集合)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:31:21    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:31:21    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @return</pre>    
	 */
	//@ResultType(java.util.LinkedHashMap.class)
	@Select("SELECT * FROM product LIMIT #{start},#{pageSize}")
	List<HashMap<String, Object>> queryProductInfo(@Param("pageSize")Integer pageSize, @Param("start")Integer start);

	/** <pre>queryDaaTotal(查询总条数)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午8:31:24    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午8:31:24    
	 * 修改备注： 
	 * @return</pre>    
	 */
	@Select("select count(*) from product")
	long queryDaaTotal();

	/** <pre>delProduct(删除)   
	 * 创建人：韩雅宁 hanyaningde@163.com     
	 * 创建时间：2018年1月18日 下午10:14:01    
	 * 修改人：韩雅宁 hanyaningde@163.com      
	 * 修改时间：2018年1月18日 下午10:14:01    
	 * 修改备注： 
	 * @param list</pre>    
	 */
	@Delete("delete from product"+
             "where productId in"+
             "<foreach collection=\"list\" item=\"it\"  separator=\",\" open=\"(\" close=\")\">"+
             "#{it}"+ 
             "</foreach>")
	void delProduct(List<String> list);

}

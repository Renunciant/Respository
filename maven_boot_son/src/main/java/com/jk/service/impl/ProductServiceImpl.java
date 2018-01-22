/** 
 * <pre>项目名称:dubbo-boot-provider 
 * 文件名称:ProductServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2018年1月18日下午4:29:32 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.ProductDao;
import com.jk.model.Product;
import com.jk.service.ProductService;

/** 
 * <pre>项目名称：dubbo-boot-provider    
 * 类名称：ProductServiceImpl    
 * 类描述：    
 * 创建人：韩雅宁 hanyaningde@163.com    
 * 创建时间：2018年1月18日 下午4:29:32    
 * 修改人：韩雅宁 hanyaningde@163.com  
 * 修改时间：2018年1月18日 下午4:29:32    
 * 修改备注：       
 * @version </pre>    
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	

	/* 查询总条数
	 */
	public long queryDaaTotal() {
		return productDao.queryDaaTotal();
	}

	/* 修改回显 
	 */
	public Product queryProductById(Integer productid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 新增   
	 */
	public void saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		
	}

	/* 修改
	 */
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	/* 删除
	 */
	public void delProduct(String ids) {
		String[] split = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < split.length; i++) {
			list.add(split[i]);
		}
		productDao.delProduct(list);
		
	}

	/* 查询list集合    
	 */
	public List<HashMap<String, Object>> queryProductInfo(Integer pageSize, Integer start) {
		System.out.println("start=============="+start+"pageSize==============="+pageSize);
		return productDao.queryProductInfo(pageSize,start);
	}

	
}

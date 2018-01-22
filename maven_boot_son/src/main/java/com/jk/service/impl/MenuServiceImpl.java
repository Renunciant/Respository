/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:MenuServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2017年11月28日上午10:53:23 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.impl;

import com.jk.dao.MenuDao;
import com.jk.model.Menu;
import com.jk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;





/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：MenuServiceImpl    
 * 类描述：    
 * 创建人：韩雅宁 hanyaningde@sina.com    
 * 创建时间：2017年11月28日 上午10:53:23    
 * 修改人：韩雅宁 hanyaningde@sina.com  
 * 修改时间：2017年11月28日 上午10:53:23    
 * 修改备注：       
 * @version </pre>    
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;


	public List<Menu> selectTree(int i) {


		return menuDao.selectTree(i);
	}



	
}

/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:MuneController.java 
 * 包名:com.jk.controller 
 * 创建日期:2017年11月28日上午10:51:11 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import com.jk.model.Menu;
import com.jk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;









/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：MuneController    
 * 类描述：    
 * 创建人：韩雅宁 hanyaningde@sina.com    
 * 创建时间：2017年11月28日 上午10:51:11    
 * 修改人：韩雅宁 hanyaningde@sina.com  
 * 修改时间：2017年11月28日 上午10:51:11    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping(value="tree")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	/**
	 * <pre>selectTree(查询父节点)   
	 * 创建人：韩雅宁 hanyaningde@sina.com      
	 * 创建时间：2017年11月28日 上午11:35:14    
	 * 修改人：韩雅宁 hanyaningde@sina.com       
	 * 修改时间：2017年11月28日 上午11:35:14    
	 * 修改备注： 
	 * @return</pre>+
	 */
	@RequestMapping(value="selectTree")
	@ResponseBody
	public List<Menu> selectTree(){
		List<Menu> list = menuService.selectTree(0);
		List<Menu> selectChildTree = getSunTree(list);
		
		return selectChildTree;
	}
	
	/**
	 * <pre>selectChildTree(查询子节点)   
	 * 创建人：韩雅宁 hanyaningde@sina.com      
	 * 创建时间：2017年11月28日 下午12:07:07    
	 * 修改人：韩雅宁 hanyaningde@sina.com       
	 * 修改时间：2017年11月28日 下午12:07:07    
	 * 修改备注： 
	 * @param list
	 * @return</pre>
	 */
	/*public List<Menu> selectChildTree(List<Menu> list){
		List<Menu> childList =new ArrayList<Menu>();
		
		for (int i = 0; i < list.size(); i++) {
			Menu menu = list.get(i);
			List<Menu> selectTree = menuService.selectTree(menu.getId());
			if(selectTree.size()>0){
			List<Menu> getSunTree =	getSunTree(selectTree);
			menu.setChildren(getSunTree);
			childList.add(menu);
			}else{
				childList.add(menu);
			}
			
		}
		return childList;
	}*/

	/** <pre>getSunTree(子节点)   
	 * 创建人：韩雅宁 hanyaningde@sina.com      
	 * 创建时间：2017年11月28日 上午11:34:46    
	 * 修改人：韩雅宁 hanyaningde@sina.com       
	 * 修改时间：2017年11月28日 上午11:34:46    
	 * 修改备注： 
	 * @param selectTree
	 * @return</pre>    
	 */
	private List<Menu> getSunTree(List<Menu> list) {
		List<Menu> childList =new ArrayList<Menu>();
		for (int i = 0; i < list.size(); i++) {
			Menu menu = list.get(i);
			List<Menu> selectTree = menuService.selectTree(menu.getId());
			//判断是否有子节点
			if(selectTree.size()>0){
				//当前子节点集合
				List<Menu> getSunTree =	getSunTree(selectTree);
				//将子节点装入list
				menu.setNodes(getSunTree);
				childList.add(menu);
			}else{
				childList.add(menu);
			}
		}
		return childList;
	}
}

/**
 * <pre>项目名称:dubbo-boot-customer
 * 文件名称:ProductController.java
 * 包名:com.jk.controller
 * 创建日期:2018年1月18日下午8:24:37
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.jk.controller;

import com.jk.model.Product;
import com.jk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>项目名称：dubbo-boot-customer
 * 类名称：ProductController
 * 类描述：
 * 创建人：韩雅宁 hanyaningde@163.com
 * 创建时间：2018年1月18日 下午8:24:37
 * 修改人：韩雅宁 hanyaningde@163.com
 * 修改时间：2018年1月18日 下午8:24:37
 * 修改备注：
 * @version </pre>
 */
@Controller
@RequestMapping(value="product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value="queryProductInfo")
	@ResponseBody
	public Map queryProduct(Integer pageSize,Integer start){
		Map<String, Object> map = new HashMap<String, Object>();
		//查询总条数
		long  count=productService.queryDaaTotal();
		//查询产品的list集合
		List<HashMap<String, Object>> list=productService.queryProductInfo(pageSize,start);
		map.put("rows", list);
		map.put("total", count);
		return map;
	}

	//跳转到新增页面和修改页面
	@RequestMapping(value="toSaveOrUpdatePage")
	public ModelAndView toSaveOrUpdatePage(Integer productid){
		ModelAndView mv = new ModelAndView();
		if(productid==null){
			//新增
			mv.setViewName("addpProductPage");
		}else{
			//修改回显
			Product p=productService.queryProductById(productid);
			if(p.getProducttime()!=null){
				SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
				p.setShowTime(sdf.format(p.getProducttime()));
			}

			mv.addObject("product", p);
			mv.setViewName("addpProductPage");
		}
		return mv;
	}

	//新增或者修改
	@RequestMapping(value="saveOrUpdate")
	@ResponseBody
	public void saveOrUpdate(Product product){
		if(product.getProductid()==null){
			//新增
			productService.saveOrUpdate(product);
		}else{
			//修改
			productService.updateProduct(product);
		}

	}

	//删除
	@RequestMapping(value="delProduct")
	@ResponseBody
	public void delProduct(String ids){
		productService.delProduct(ids);
	}
}

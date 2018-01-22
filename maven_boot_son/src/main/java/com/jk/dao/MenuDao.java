package com.jk.dao;

import com.jk.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository("MenuMapper")
@Mapper
public interface MenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

	/** <pre>selectTree(查询父节点)   
	 * 创建人：韩雅宁 hanyaningde@sina.com      
	 * 创建时间：2017年11月28日 上午11:10:38    
	 * 修改人：韩雅宁 hanyaningde@sina.com       
	 * 修改时间：2017年11月28日 上午11:10:38    
	 * 修改备注： 
	 * @param i
	 * @return</pre>    
	 */
	@Select("select m.ID as id,m.TEXT as text,m.HREF as url,m.PID as pid \n" +
			"  \t\tfrom T_TREE2 m\n" +
			"  \t\twhere \n" +
			"  \t\t\tpid = #{i}")
	List<Menu> selectTree(int i);
}
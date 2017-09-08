/**   
 * <p>@Title: ItemCatServiceImpl.java</P> 
 * <p>Company: www.itcast.cn</p> 
 * @author congqing  
 * @date 2017年9月6日 下午8:02:21 
 * @version V1.0   
 */
package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EsayUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;

/**
 * @Description:商品类目展示service
 * @author congqing
 * @date 2017年9月6日 
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	/**
	 * 展示商品类目
	 * @Title: getCatList 
	 * @param  parentId 目父节点ID 
	 * @return List<EsayUITreeNode>
	 */
	@Override
	public List<EsayUITreeNode> getCatList(long parentId) {
		
		//创件数据库查询对象范例
		TbItemCatExample tbItemCatExample  = new TbItemCatExample();
		
		//设置查询条件
	    Criteria createCriteria = tbItemCatExample.createCriteria();
	    createCriteria.andParentIdEqualTo(parentId);
	    List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
	    
		//转换成EsayUI列表
	    List<EsayUITreeNode> treeList = new ArrayList<>();
	    EsayUITreeNode node = null;
	    for (TbItemCat tbItemCat : list) {
	    	
	    	node = new EsayUITreeNode();
	        node.setId(tbItemCat.getId());	//子节点ID
	    	node.setText(tbItemCat.getName());//叶子节点名称
	    	node.setState(tbItemCat.getIsParent() ? "closed":"open"); //判断当前节点下有无子节点
	    	
	    	//添加到List集合
	    	treeList.add(node);
		}
		return treeList;
	}


}

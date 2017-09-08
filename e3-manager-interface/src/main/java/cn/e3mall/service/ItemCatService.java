/**   
 * <p>@Title: ItemCatService.java</P> 
 * <p>Company: www.itcast.cn</p> 
 * @author congqing  
 * @date 2017年9月6日 下午8:01:07 
 * @version V1.0   
 */
package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.EsayUITreeNode;

/**
 * @Description:商品类目展示service
 * @author congqing
 * @date 2017年9月6日 
 */
public interface ItemCatService {
		
	public List<EsayUITreeNode> getCatList(long parentId);
}

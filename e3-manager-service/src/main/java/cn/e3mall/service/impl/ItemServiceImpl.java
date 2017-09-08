package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}

	/**
	 * 查询分页商品列表
	 */
	@Override
	public DataGridResult getItemList(int page, int rows) {
		
		//设置分页信息，执行查询
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);

		//获取查询结果，将list强转为page对象
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		//取总记录数
		long total = pageInfo.getTotal();
		
		//取商品列表,封装数据返回
		DataGridResult dataGridResult =new  DataGridResult();
		dataGridResult.setRows(list);
		dataGridResult.setTotal(total);
		
		//返回结果
		return dataGridResult;
	}

}

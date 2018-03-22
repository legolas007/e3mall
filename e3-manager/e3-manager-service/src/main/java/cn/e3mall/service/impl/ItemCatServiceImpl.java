package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.service.ItemCatService;

/**
 * 商品分类管理
 * 
 * @author usher
 *
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper ItemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatlist(long parentId) {
		// TODO Auto-generated method stub
		//根据parentId查询子节点列表
		TbItemCatExample example = new TbItemCatExample();
		cn.e3mall.pojo.TbItemCatExample.Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = ItemCatMapper.selectByExample(example);
		// 创建返回结果List
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();

			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			// 添加到结果列表
			resultList.add(node);
		}
		// 返回结果
		return resultList;
	}

}

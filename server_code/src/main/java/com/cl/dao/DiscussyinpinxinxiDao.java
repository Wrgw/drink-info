package com.cl.dao;

import com.cl.entity.DiscussyinpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinpinxinxiView;


/**
 * 饮品信息评论表
 * 
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface DiscussyinpinxinxiDao extends BaseMapper<DiscussyinpinxinxiEntity> {
	
	List<DiscussyinpinxinxiView> selectListView(@Param("ew") Wrapper<DiscussyinpinxinxiEntity> wrapper);

	List<DiscussyinpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinpinxinxiEntity> wrapper);
	
	DiscussyinpinxinxiView selectView(@Param("ew") Wrapper<DiscussyinpinxinxiEntity> wrapper);


}

package com.cl.dao;

import com.cl.entity.YinpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinxinxiView;


/**
 * 饮品信息
 * 
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface YinpinxinxiDao extends BaseMapper<YinpinxinxiEntity> {
	
	List<YinpinxinxiView> selectListView(@Param("ew") Wrapper<YinpinxinxiEntity> wrapper);

	List<YinpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YinpinxinxiEntity> wrapper);
	
	YinpinxinxiView selectView(@Param("ew") Wrapper<YinpinxinxiEntity> wrapper);


}

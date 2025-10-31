package com.cl.dao;

import com.cl.entity.DianpufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianpufenleiView;


/**
 * 店铺分类
 * 
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface DianpufenleiDao extends BaseMapper<DianpufenleiEntity> {
	
	List<DianpufenleiView> selectListView(@Param("ew") Wrapper<DianpufenleiEntity> wrapper);

	List<DianpufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<DianpufenleiEntity> wrapper);
	
	DianpufenleiView selectView(@Param("ew") Wrapper<DianpufenleiEntity> wrapper);


}

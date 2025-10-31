package com.cl.dao;

import com.cl.entity.DianzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianzhangView;


/**
 * 店长
 * 
 * @author 
 * @email 
 * @date 2025-03-03 12:58:39
 */
public interface DianzhangDao extends BaseMapper<DianzhangEntity> {
	
	List<DianzhangView> selectListView(@Param("ew") Wrapper<DianzhangEntity> wrapper);

	List<DianzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DianzhangEntity> wrapper);
	
	DianzhangView selectView(@Param("ew") Wrapper<DianzhangEntity> wrapper);


}

package com.cl.dao;

import com.cl.entity.CaigoujihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaigoujihuaView;


/**
 * 采购计划
 * 
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface CaigoujihuaDao extends BaseMapper<CaigoujihuaEntity> {
	
	List<CaigoujihuaView> selectListView(@Param("ew") Wrapper<CaigoujihuaEntity> wrapper);

	List<CaigoujihuaView> selectListView(Pagination page,@Param("ew") Wrapper<CaigoujihuaEntity> wrapper);
	
	CaigoujihuaView selectView(@Param("ew") Wrapper<CaigoujihuaEntity> wrapper);


}

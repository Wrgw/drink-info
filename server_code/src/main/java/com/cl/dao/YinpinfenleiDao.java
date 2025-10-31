package com.cl.dao;

import com.cl.entity.YinpinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinfenleiView;


/**
 * 饮品分类
 * 
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface YinpinfenleiDao extends BaseMapper<YinpinfenleiEntity> {
	
	List<YinpinfenleiView> selectListView(@Param("ew") Wrapper<YinpinfenleiEntity> wrapper);

	List<YinpinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YinpinfenleiEntity> wrapper);
	
	YinpinfenleiView selectView(@Param("ew") Wrapper<YinpinfenleiEntity> wrapper);


}

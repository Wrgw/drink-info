package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CaigoujihuaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaigoujihuaView;


/**
 * 采购计划
 *
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface CaigoujihuaService extends IService<CaigoujihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaigoujihuaView> selectListView(Wrapper<CaigoujihuaEntity> wrapper);
   	
   	CaigoujihuaView selectView(@Param("ew") Wrapper<CaigoujihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaigoujihuaEntity> wrapper);
   	
   
}


package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DianzhangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianzhangView;


/**
 * 店长
 *
 * @author 
 * @email 
 * @date 2025-03-03 12:58:39
 */
public interface DianzhangService extends IService<DianzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianzhangView> selectListView(Wrapper<DianzhangEntity> wrapper);
   	
   	DianzhangView selectView(@Param("ew") Wrapper<DianzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianzhangEntity> wrapper);
   	
   
}


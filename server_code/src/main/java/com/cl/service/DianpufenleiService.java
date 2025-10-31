package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DianpufenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianpufenleiView;


/**
 * 店铺分类
 *
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface DianpufenleiService extends IService<DianpufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianpufenleiView> selectListView(Wrapper<DianpufenleiEntity> wrapper);
   	
   	DianpufenleiView selectView(@Param("ew") Wrapper<DianpufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianpufenleiEntity> wrapper);
   	
   
}


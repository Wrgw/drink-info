package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinpinfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinfenleiView;


/**
 * 饮品分类
 *
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface YinpinfenleiService extends IService<YinpinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinpinfenleiView> selectListView(Wrapper<YinpinfenleiEntity> wrapper);
   	
   	YinpinfenleiView selectView(@Param("ew") Wrapper<YinpinfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinpinfenleiEntity> wrapper);
   	
   
}


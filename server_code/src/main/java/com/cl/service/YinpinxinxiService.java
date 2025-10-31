package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinpinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinxinxiView;


/**
 * 饮品信息
 *
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface YinpinxinxiService extends IService<YinpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinpinxinxiView> selectListView(Wrapper<YinpinxinxiEntity> wrapper);
   	
   	YinpinxinxiView selectView(@Param("ew") Wrapper<YinpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinpinxinxiEntity> wrapper);
   	
   
}


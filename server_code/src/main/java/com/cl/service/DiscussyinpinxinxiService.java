package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyinpinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinpinxinxiView;


/**
 * 饮品信息评论表
 *
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
public interface DiscussyinpinxinxiService extends IService<DiscussyinpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinpinxinxiView> selectListView(Wrapper<DiscussyinpinxinxiEntity> wrapper);
   	
   	DiscussyinpinxinxiView selectView(@Param("ew") Wrapper<DiscussyinpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinpinxinxiEntity> wrapper);
   	
   
}


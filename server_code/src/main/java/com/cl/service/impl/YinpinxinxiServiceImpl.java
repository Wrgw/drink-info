package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YinpinxinxiDao;
import com.cl.entity.YinpinxinxiEntity;
import com.cl.service.YinpinxinxiService;
import com.cl.entity.view.YinpinxinxiView;

@Service("yinpinxinxiService")
public class YinpinxinxiServiceImpl extends ServiceImpl<YinpinxinxiDao, YinpinxinxiEntity> implements YinpinxinxiService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinpinxinxiEntity> page = this.selectPage(
                new Query<YinpinxinxiEntity>(params).getPage(),
                new EntityWrapper<YinpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinpinxinxiEntity> wrapper) {
		  Page<YinpinxinxiView> page =new Query<YinpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinpinxinxiView> selectListView(Wrapper<YinpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinpinxinxiView selectView(Wrapper<YinpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}

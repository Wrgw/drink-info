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


import com.cl.dao.YinpinfenleiDao;
import com.cl.entity.YinpinfenleiEntity;
import com.cl.service.YinpinfenleiService;
import com.cl.entity.view.YinpinfenleiView;

@Service("yinpinfenleiService")
public class YinpinfenleiServiceImpl extends ServiceImpl<YinpinfenleiDao, YinpinfenleiEntity> implements YinpinfenleiService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinpinfenleiEntity> page = this.selectPage(
                new Query<YinpinfenleiEntity>(params).getPage(),
                new EntityWrapper<YinpinfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinpinfenleiEntity> wrapper) {
		  Page<YinpinfenleiView> page =new Query<YinpinfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinpinfenleiView> selectListView(Wrapper<YinpinfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinpinfenleiView selectView(Wrapper<YinpinfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}

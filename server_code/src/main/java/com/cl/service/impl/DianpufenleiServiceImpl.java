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


import com.cl.dao.DianpufenleiDao;
import com.cl.entity.DianpufenleiEntity;
import com.cl.service.DianpufenleiService;
import com.cl.entity.view.DianpufenleiView;

@Service("dianpufenleiService")
public class DianpufenleiServiceImpl extends ServiceImpl<DianpufenleiDao, DianpufenleiEntity> implements DianpufenleiService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianpufenleiEntity> page = this.selectPage(
                new Query<DianpufenleiEntity>(params).getPage(),
                new EntityWrapper<DianpufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianpufenleiEntity> wrapper) {
		  Page<DianpufenleiView> page =new Query<DianpufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DianpufenleiView> selectListView(Wrapper<DianpufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianpufenleiView selectView(Wrapper<DianpufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}

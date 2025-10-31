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


import com.cl.dao.CaigoujihuaDao;
import com.cl.entity.CaigoujihuaEntity;
import com.cl.service.CaigoujihuaService;
import com.cl.entity.view.CaigoujihuaView;

@Service("caigoujihuaService")
public class CaigoujihuaServiceImpl extends ServiceImpl<CaigoujihuaDao, CaigoujihuaEntity> implements CaigoujihuaService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaigoujihuaEntity> page = this.selectPage(
                new Query<CaigoujihuaEntity>(params).getPage(),
                new EntityWrapper<CaigoujihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaigoujihuaEntity> wrapper) {
		  Page<CaigoujihuaView> page =new Query<CaigoujihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CaigoujihuaView> selectListView(Wrapper<CaigoujihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaigoujihuaView selectView(Wrapper<CaigoujihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}

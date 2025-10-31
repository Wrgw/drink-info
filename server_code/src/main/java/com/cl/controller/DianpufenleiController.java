package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.DianpufenleiEntity;
import com.cl.entity.view.DianpufenleiView;

import com.cl.service.DianpufenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 店铺分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@RestController
@RequestMapping("/dianpufenlei")
public class DianpufenleiController {
    @Autowired
    private DianpufenleiService dianpufenleiService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianpufenleiEntity dianpufenlei,
                                            HttpServletRequest request){
                                    EntityWrapper<DianpufenleiEntity> ew = new EntityWrapper<DianpufenleiEntity>();
                                                        
        
        
        PageUtils page = dianpufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianpufenlei), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianpufenleiEntity dianpufenlei, 
		HttpServletRequest request){
        EntityWrapper<DianpufenleiEntity> ew = new EntityWrapper<DianpufenleiEntity>();

		PageUtils page = dianpufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianpufenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianpufenleiEntity dianpufenlei){
       	EntityWrapper<DianpufenleiEntity> ew = new EntityWrapper<DianpufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianpufenlei, "dianpufenlei")); 
        return R.ok().put("data", dianpufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianpufenleiEntity dianpufenlei){
        EntityWrapper< DianpufenleiEntity> ew = new EntityWrapper< DianpufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianpufenlei, "dianpufenlei")); 
		DianpufenleiView dianpufenleiView =  dianpufenleiService.selectView(ew);
		return R.ok("查询店铺分类成功").put("data", dianpufenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianpufenleiEntity dianpufenlei = dianpufenleiService.selectById(id);
		dianpufenlei = dianpufenleiService.selectView(new EntityWrapper<DianpufenleiEntity>().eq("id", id));
        return R.ok().put("data", dianpufenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianpufenleiEntity dianpufenlei = dianpufenleiService.selectById(id);
		dianpufenlei = dianpufenleiService.selectView(new EntityWrapper<DianpufenleiEntity>().eq("id", id));
        return R.ok().put("data", dianpufenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增店铺分类")
    public R save(@RequestBody DianpufenleiEntity dianpufenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dianpufenlei);
        dianpufenleiService.insert(dianpufenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增店铺分类")
    @RequestMapping("/add")
    public R add(@RequestBody DianpufenleiEntity dianpufenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dianpufenlei);
        dianpufenleiService.insert(dianpufenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改店铺分类")
    public R update(@RequestBody DianpufenleiEntity dianpufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianpufenlei);
        dianpufenleiService.updateById(dianpufenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除店铺分类")
    public R delete(@RequestBody Long[] ids){
        dianpufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}

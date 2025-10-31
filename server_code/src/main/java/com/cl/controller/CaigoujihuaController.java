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

import com.cl.entity.CaigoujihuaEntity;
import com.cl.entity.view.CaigoujihuaView;

import com.cl.service.CaigoujihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 采购计划
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@RestController
@RequestMapping("/caigoujihua")
public class CaigoujihuaController {
    @Autowired
    private CaigoujihuaService caigoujihuaService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaigoujihuaEntity caigoujihua,
                                                                                                                                HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                    if(tableName.equals("dianzhang")) {
                    caigoujihua.setDianzhangzhanghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                            EntityWrapper<CaigoujihuaEntity> ew = new EntityWrapper<CaigoujihuaEntity>();
                                                                                                                                                                                                    
        
        
        PageUtils page = caigoujihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caigoujihua), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaigoujihuaEntity caigoujihua, 
		HttpServletRequest request){
        EntityWrapper<CaigoujihuaEntity> ew = new EntityWrapper<CaigoujihuaEntity>();

		PageUtils page = caigoujihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caigoujihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaigoujihuaEntity caigoujihua){
       	EntityWrapper<CaigoujihuaEntity> ew = new EntityWrapper<CaigoujihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caigoujihua, "caigoujihua")); 
        return R.ok().put("data", caigoujihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaigoujihuaEntity caigoujihua){
        EntityWrapper< CaigoujihuaEntity> ew = new EntityWrapper< CaigoujihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caigoujihua, "caigoujihua")); 
		CaigoujihuaView caigoujihuaView =  caigoujihuaService.selectView(ew);
		return R.ok("查询采购计划成功").put("data", caigoujihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaigoujihuaEntity caigoujihua = caigoujihuaService.selectById(id);
		caigoujihua = caigoujihuaService.selectView(new EntityWrapper<CaigoujihuaEntity>().eq("id", id));
        return R.ok().put("data", caigoujihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaigoujihuaEntity caigoujihua = caigoujihuaService.selectById(id);
		caigoujihua = caigoujihuaService.selectView(new EntityWrapper<CaigoujihuaEntity>().eq("id", id));
        return R.ok().put("data", caigoujihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增采购计划")
    public R save(@RequestBody CaigoujihuaEntity caigoujihua, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caigoujihua);
        caigoujihuaService.insert(caigoujihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增采购计划")
    @RequestMapping("/add")
    public R add(@RequestBody CaigoujihuaEntity caigoujihua, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caigoujihua);
        caigoujihuaService.insert(caigoujihua);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改采购计划")
    public R update(@RequestBody CaigoujihuaEntity caigoujihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caigoujihua);
        caigoujihuaService.updateById(caigoujihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除采购计划")
    public R delete(@RequestBody Long[] ids){
        caigoujihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}

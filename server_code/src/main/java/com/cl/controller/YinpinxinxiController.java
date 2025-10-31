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

import com.cl.entity.YinpinxinxiEntity;
import com.cl.entity.view.YinpinxinxiView;

import com.cl.service.YinpinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 饮品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@RestController
@RequestMapping("/yinpinxinxi")
public class YinpinxinxiController {
    @Autowired
    private YinpinxinxiService yinpinxinxiService;

    @Autowired
    private StoreupService storeupService;






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinpinxinxiEntity yinpinxinxi,
                                                                                                                                                                                                                                                                                                        HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                                                                                                                                    if(tableName.equals("dianzhang")) {
                    yinpinxinxi.setDianzhangzhanghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                                                                            if(tableName.equals("yuangong")) {
                    yinpinxinxi.setYuangongzhanghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                EntityWrapper<YinpinxinxiEntity> ew = new EntityWrapper<YinpinxinxiEntity>();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        
        
        PageUtils page = yinpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinpinxinxiEntity yinpinxinxi, 
		HttpServletRequest request){
        EntityWrapper<YinpinxinxiEntity> ew = new EntityWrapper<YinpinxinxiEntity>();

		PageUtils page = yinpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinpinxinxiEntity yinpinxinxi){
       	EntityWrapper<YinpinxinxiEntity> ew = new EntityWrapper<YinpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinpinxinxi, "yinpinxinxi")); 
        return R.ok().put("data", yinpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinpinxinxiEntity yinpinxinxi){
        EntityWrapper< YinpinxinxiEntity> ew = new EntityWrapper< YinpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinpinxinxi, "yinpinxinxi")); 
		YinpinxinxiView yinpinxinxiView =  yinpinxinxiService.selectView(ew);
		return R.ok("查询饮品信息成功").put("data", yinpinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinpinxinxiEntity yinpinxinxi = yinpinxinxiService.selectById(id);
		yinpinxinxi = yinpinxinxiService.selectView(new EntityWrapper<YinpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", yinpinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinpinxinxiEntity yinpinxinxi = yinpinxinxiService.selectById(id);
		yinpinxinxi = yinpinxinxiService.selectView(new EntityWrapper<YinpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", yinpinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增饮品信息")
    public R save(@RequestBody YinpinxinxiEntity yinpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yinpinxinxi);
        yinpinxinxiService.insert(yinpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增饮品信息")
    @RequestMapping("/add")
    public R add(@RequestBody YinpinxinxiEntity yinpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yinpinxinxi);
        yinpinxinxiService.insert(yinpinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改饮品信息")
    public R update(@RequestBody YinpinxinxiEntity yinpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinpinxinxi);
        yinpinxinxiService.updateById(yinpinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除饮品信息")
    public R delete(@RequestBody Long[] ids){
        yinpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YinpinxinxiEntity> wrapper = new EntityWrapper<YinpinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(MPUtil.camelToSnake(columnName), map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(MPUtil.camelToSnake(columnName), map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("dianzhang")) {
			wrapper.eq("dianzhangzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangongzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yinpinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}

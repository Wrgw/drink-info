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

import com.cl.entity.DiscussyinpinxinxiEntity;
import com.cl.entity.view.DiscussyinpinxinxiView;

import com.cl.service.DiscussyinpinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 饮品信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@RestController
@RequestMapping("/discussyinpinxinxi")
public class DiscussyinpinxinxiController {
    @Autowired
    private DiscussyinpinxinxiService discussyinpinxinxiService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyinpinxinxiEntity discussyinpinxinxi,
                                                                                                                            HttpServletRequest request){
                                    EntityWrapper<DiscussyinpinxinxiEntity> ew = new EntityWrapper<DiscussyinpinxinxiEntity>();
                                                                                                                                                                                        
        
        
        PageUtils page = discussyinpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinpinxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyinpinxinxiEntity discussyinpinxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussyinpinxinxiEntity> ew = new EntityWrapper<DiscussyinpinxinxiEntity>();

		PageUtils page = discussyinpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyinpinxinxiEntity discussyinpinxinxi){
       	EntityWrapper<DiscussyinpinxinxiEntity> ew = new EntityWrapper<DiscussyinpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyinpinxinxi, "discussyinpinxinxi")); 
        return R.ok().put("data", discussyinpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyinpinxinxiEntity discussyinpinxinxi){
        EntityWrapper< DiscussyinpinxinxiEntity> ew = new EntityWrapper< DiscussyinpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyinpinxinxi, "discussyinpinxinxi")); 
		DiscussyinpinxinxiView discussyinpinxinxiView =  discussyinpinxinxiService.selectView(ew);
		return R.ok("查询饮品信息评论表成功").put("data", discussyinpinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyinpinxinxiEntity discussyinpinxinxi = discussyinpinxinxiService.selectById(id);
		discussyinpinxinxi = discussyinpinxinxiService.selectView(new EntityWrapper<DiscussyinpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussyinpinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyinpinxinxiEntity discussyinpinxinxi = discussyinpinxinxiService.selectById(id);
		discussyinpinxinxi = discussyinpinxinxiService.selectView(new EntityWrapper<DiscussyinpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussyinpinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增饮品信息评论表")
    public R save(@RequestBody DiscussyinpinxinxiEntity discussyinpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyinpinxinxi);
        discussyinpinxinxiService.insert(discussyinpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增饮品信息评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyinpinxinxiEntity discussyinpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyinpinxinxi);
        discussyinpinxinxiService.insert(discussyinpinxinxi);
        return R.ok();
    }

     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyinpinxinxiEntity discussyinpinxinxi = discussyinpinxinxiService.selectOne(new EntityWrapper<DiscussyinpinxinxiEntity>().eq("", username));
        return R.ok().put("data", discussyinpinxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyinpinxinxiEntity discussyinpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyinpinxinxi);
        discussyinpinxinxiService.updateById(discussyinpinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除饮品信息评论表")
    public R delete(@RequestBody Long[] ids){
        discussyinpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyinpinxinxiEntity discussyinpinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyinpinxinxiEntity> ew = new EntityWrapper<DiscussyinpinxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussyinpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinpinxinxi), params), params));
        return R.ok().put("data", page);
    }









}

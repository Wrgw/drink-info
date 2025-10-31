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

import com.cl.entity.DianzhangEntity;
import com.cl.entity.view.DianzhangView;

import com.cl.service.DianzhangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 店长
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-03 12:58:39
 */
@RestController
@RequestMapping("/dianzhang")
public class DianzhangController {
    @Autowired
    private DianzhangService dianzhangService;



	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		DianzhangEntity u = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"dianzhang",  "店长" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody DianzhangEntity dianzhang){
    	//ValidatorUtils.validateEntity(dianzhang);
                            DianzhangEntity u = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", dianzhang.getDianzhangzhanghao()));
                                                                                                		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		dianzhang.setId(uId);
        dianzhangService.insert(dianzhang);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        return R.ok().put("data", dianzhangService.selectView(new EntityWrapper<DianzhangEntity>().eq("id", id)));
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	DianzhangEntity u = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        dianzhangService.updateById(u);
        return R.ok("密码已重置为：123456");
    }




    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianzhangEntity dianzhang,
                                                                                                                                HttpServletRequest request){
                                    EntityWrapper<DianzhangEntity> ew = new EntityWrapper<DianzhangEntity>();
                                                                                                                                                                                                    
        
        
        PageUtils page = dianzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianzhang), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianzhangEntity dianzhang, 
		HttpServletRequest request){
        EntityWrapper<DianzhangEntity> ew = new EntityWrapper<DianzhangEntity>();

		PageUtils page = dianzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianzhang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianzhangEntity dianzhang){
       	EntityWrapper<DianzhangEntity> ew = new EntityWrapper<DianzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianzhang, "dianzhang")); 
        return R.ok().put("data", dianzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianzhangEntity dianzhang){
        EntityWrapper< DianzhangEntity> ew = new EntityWrapper< DianzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianzhang, "dianzhang")); 
		DianzhangView dianzhangView =  dianzhangService.selectView(ew);
		return R.ok("查询店长成功").put("data", dianzhangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianzhangEntity dianzhang = dianzhangService.selectById(id);
		dianzhang = dianzhangService.selectView(new EntityWrapper<DianzhangEntity>().eq("id", id));
        return R.ok().put("data", dianzhang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianzhangEntity dianzhang = dianzhangService.selectById(id);
		dianzhang = dianzhangService.selectView(new EntityWrapper<DianzhangEntity>().eq("id", id));
        return R.ok().put("data", dianzhang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增店长")
    public R save(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request){
        if(dianzhangService.selectCount(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", dianzhang.getDianzhangzhanghao()))>0) {
            return R.error("店长账号已存在");
        }
    	dianzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianzhang);
        DianzhangEntity u = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", dianzhang.getDianzhangzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		dianzhang.setId(new Date().getTime());
        dianzhangService.insert(dianzhang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增店长")
    @RequestMapping("/add")
    public R add(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request){
        if(dianzhangService.selectCount(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", dianzhang.getDianzhangzhanghao()))>0) {
            return R.error("店长账号已存在");
        }
    	dianzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianzhang);
        DianzhangEntity u = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("dianzhangzhanghao", dianzhang.getDianzhangzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		dianzhang.setId(new Date().getTime());
        dianzhangService.insert(dianzhang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改店长")
    public R update(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianzhang);
        dianzhangService.updateById(dianzhang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核店长")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DianzhangEntity> list = new ArrayList<DianzhangEntity>();
        for(Long id : ids) {
            DianzhangEntity dianzhang = dianzhangService.selectById(id);
            dianzhang.setSfsh(sfsh);
            dianzhang.setShhf(shhf);
            list.add(dianzhang);
        }
        dianzhangService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除店长")
    public R delete(@RequestBody Long[] ids){
        dianzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}

package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 采购计划
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@TableName("caigoujihua")
public class CaigoujihuaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaigoujihuaEntity() {
		
	}
	
	public CaigoujihuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 饮品名称
	 */
					
	private String yinpinmingcheng;
	
	/**
	 * 饮品类型
	 */
					
	private String yinpinleixing;
	
	/**
	 * 供应商
	 */
					
	private String gongyingshang;
	
	/**
	 * 采购价格
	 */
					
	private Double caigoujiage;
	
	/**
	 * 采购数量
	 */
					
	private Integer caigoushuliang;
	
	/**
	 * 计划时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jihuashijian;
	
	/**
	 * 店长账号
	 */
					
	private String dianzhangzhanghao;
	
	/**
	 * 店铺名称
	 */
					
	private String dianpumingcheng;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：饮品名称
	 */
	public void setYinpinmingcheng(String yinpinmingcheng) {
		this.yinpinmingcheng = yinpinmingcheng;
	}
	/**
	 * 获取：饮品名称
	 */
	public String getYinpinmingcheng() {
		return yinpinmingcheng;
	}
	/**
	 * 设置：饮品类型
	 */
	public void setYinpinleixing(String yinpinleixing) {
		this.yinpinleixing = yinpinleixing;
	}
	/**
	 * 获取：饮品类型
	 */
	public String getYinpinleixing() {
		return yinpinleixing;
	}
	/**
	 * 设置：供应商
	 */
	public void setGongyingshang(String gongyingshang) {
		this.gongyingshang = gongyingshang;
	}
	/**
	 * 获取：供应商
	 */
	public String getGongyingshang() {
		return gongyingshang;
	}
	/**
	 * 设置：采购价格
	 */
	public void setCaigoujiage(Double caigoujiage) {
		this.caigoujiage = caigoujiage;
	}
	/**
	 * 获取：采购价格
	 */
	public Double getCaigoujiage() {
		return caigoujiage;
	}
	/**
	 * 设置：采购数量
	 */
	public void setCaigoushuliang(Integer caigoushuliang) {
		this.caigoushuliang = caigoushuliang;
	}
	/**
	 * 获取：采购数量
	 */
	public Integer getCaigoushuliang() {
		return caigoushuliang;
	}
	/**
	 * 设置：计划时间
	 */
	public void setJihuashijian(Date jihuashijian) {
		this.jihuashijian = jihuashijian;
	}
	/**
	 * 获取：计划时间
	 */
	public Date getJihuashijian() {
		return jihuashijian;
	}
	/**
	 * 设置：店长账号
	 */
	public void setDianzhangzhanghao(String dianzhangzhanghao) {
		this.dianzhangzhanghao = dianzhangzhanghao;
	}
	/**
	 * 获取：店长账号
	 */
	public String getDianzhangzhanghao() {
		return dianzhangzhanghao;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setDianpumingcheng(String dianpumingcheng) {
		this.dianpumingcheng = dianpumingcheng;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getDianpumingcheng() {
		return dianpumingcheng;
	}

}

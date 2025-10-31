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
 * 饮品信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@TableName("yinpinxinxi")
public class YinpinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YinpinxinxiEntity() {
		
	}
	
	public YinpinxinxiEntity(T t) {
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
	 * 饮品图片
	 */
					
	private String yinpintupian;
	
	/**
	 * 饮品分类
	 */
					
	private String yinpinfenlei;
	
	/**
	 * 店铺分类
	 */
					
	private String dianpufenlei;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 冷热饮
	 */
					
	private String lengreyin;
	
	/**
	 * 甜度
	 */
					
	private String tiandu;
	
	/**
	 * 饮品详情
	 */
					
	private String yinpinxiangqing;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupNumber;
	
	/**
	 * 评论数
	 */
					
	private Integer discussNumber;
	
	/**
	 * 店长账号
	 */
					
	private String dianzhangzhanghao;
	
	/**
	 * 店铺名称
	 */
					
	private String dianpumingcheng;
	
	/**
	 * 店铺地址
	 */
					
	private String dianpudizhi;
	
	/**
	 * 单限
	 */
					
	private Integer onelimittimes;
	
	/**
	 * 库存
	 */
					
	private Integer alllimittimes;
	
	/**
	 * 价格
	 */
					
	private Double price;
	
	/**
	 * 负责员工
	 */
					
	private String yuangongzhanghao;
	

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
	 * 设置：饮品图片
	 */
	public void setYinpintupian(String yinpintupian) {
		this.yinpintupian = yinpintupian;
	}
	/**
	 * 获取：饮品图片
	 */
	public String getYinpintupian() {
		return yinpintupian;
	}
	/**
	 * 设置：饮品分类
	 */
	public void setYinpinfenlei(String yinpinfenlei) {
		this.yinpinfenlei = yinpinfenlei;
	}
	/**
	 * 获取：饮品分类
	 */
	public String getYinpinfenlei() {
		return yinpinfenlei;
	}
	/**
	 * 设置：店铺分类
	 */
	public void setDianpufenlei(String dianpufenlei) {
		this.dianpufenlei = dianpufenlei;
	}
	/**
	 * 获取：店铺分类
	 */
	public String getDianpufenlei() {
		return dianpufenlei;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：冷热饮
	 */
	public void setLengreyin(String lengreyin) {
		this.lengreyin = lengreyin;
	}
	/**
	 * 获取：冷热饮
	 */
	public String getLengreyin() {
		return lengreyin;
	}
	/**
	 * 设置：甜度
	 */
	public void setTiandu(String tiandu) {
		this.tiandu = tiandu;
	}
	/**
	 * 获取：甜度
	 */
	public String getTiandu() {
		return tiandu;
	}
	/**
	 * 设置：饮品详情
	 */
	public void setYinpinxiangqing(String yinpinxiangqing) {
		this.yinpinxiangqing = yinpinxiangqing;
	}
	/**
	 * 获取：饮品详情
	 */
	public String getYinpinxiangqing() {
		return yinpinxiangqing;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupNumber(Integer storeupNumber) {
		this.storeupNumber = storeupNumber;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupNumber() {
		return storeupNumber;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussNumber(Integer discussNumber) {
		this.discussNumber = discussNumber;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussNumber() {
		return discussNumber;
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
	/**
	 * 设置：店铺地址
	 */
	public void setDianpudizhi(String dianpudizhi) {
		this.dianpudizhi = dianpudizhi;
	}
	/**
	 * 获取：店铺地址
	 */
	public String getDianpudizhi() {
		return dianpudizhi;
	}
	/**
	 * 设置：单限
	 */
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
	/**
	 * 设置：库存
	 */
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：负责员工
	 */
	public void setYuangongzhanghao(String yuangongzhanghao) {
		this.yuangongzhanghao = yuangongzhanghao;
	}
	/**
	 * 获取：负责员工
	 */
	public String getYuangongzhanghao() {
		return yuangongzhanghao;
	}

}

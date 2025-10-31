package com.cl.entity.view;

import com.cl.entity.YinpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 饮品信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@TableName("yinpinxinxi")
public class YinpinxinxiView  extends YinpinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinpinxinxiView(){
	}
 
 	public YinpinxinxiView(YinpinxinxiEntity yinpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yinpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}

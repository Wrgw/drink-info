package com.cl.entity.view;

import com.cl.entity.CaigoujihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 采购计划
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@TableName("caigoujihua")
public class CaigoujihuaView  extends CaigoujihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CaigoujihuaView(){
	}
 
 	public CaigoujihuaView(CaigoujihuaEntity caigoujihuaEntity){
 	try {
			BeanUtils.copyProperties(this, caigoujihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}

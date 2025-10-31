package com.cl.entity.view;

import com.cl.entity.DianpufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 店铺分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@TableName("dianpufenlei")
public class DianpufenleiView  extends DianpufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DianpufenleiView(){
	}
 
 	public DianpufenleiView(DianpufenleiEntity dianpufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, dianpufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}

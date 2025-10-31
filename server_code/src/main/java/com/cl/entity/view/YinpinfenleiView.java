package com.cl.entity.view;

import com.cl.entity.YinpinfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 饮品分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-03 12:58:40
 */
@TableName("yinpinfenlei")
public class YinpinfenleiView  extends YinpinfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinpinfenleiView(){
	}
 
 	public YinpinfenleiView(YinpinfenleiEntity yinpinfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, yinpinfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}

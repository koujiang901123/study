package com.koujiang.framework.base;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/** OperObj概要说明：转换数据库对象为实体对象
 */
public class Analytic {
	
	//静态的类<类名,字段Map>
	private static Map<String,Object> OBJECT_MAP = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public String getFieldType(Object obj,String name) {
		String retValue = "";
		try {
			Class<?> clas = Class.forName(obj.getClass().getName());
			HashMap<String, Field> mapField = null;
			if(OBJECT_MAP != null){
				mapField = (HashMap<String, Field>) OBJECT_MAP.get(clas.getName());
			}
			if(mapField != null){
				Field retField = mapField.get(name);
				retValue = getFieldType(retField);
			}else{
				Field[] fieldsAll = clas.getDeclaredFields();
				mapField = new HashMap<String, Field>();
				for(Field field : fieldsAll){
					mapField.put(field.getName(), field);
				}
				OBJECT_MAP.put(clas.getName(), mapField);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return retValue;
	}
	
	/**
	 * getObjValue方法慨述:得到指定对象的指定字段的值
	 * @param obj 对象
	 * @param field 字段对象
	 * @return Object 值对象
	 * @throws Exception 
	 */
	public Object getObjValue(Object obj,Field field) throws Exception{
		Object retObj = null;
		try {
    		field.setAccessible(true);
			retObj = field.get(obj);
		} catch (IllegalArgumentException e) {
			throw new Exception("得到字段值失败!",e);
		} 
		return retObj;
	}
	
	/**
	 * setObjValue方法慨述:调用字段field的set方法，参数为value，设置该field的值
	 * @param obj 对象
	 * @param field 字段
	 * @param value 值
	 * @throws Exception 
	 */
	public void setObjValue(Object obj,Field field,String value) throws Exception{
		try {
			if(field != null){
	    		field.setAccessible(true);
	    		Object objValue = new Object();
	    		if(!field.getType().equals(String.class)){
	    			if(value == null || value.trim().length() <= 0){
	    				value = "0";
	    			}
	    		}
	    		if(field.getType().equals(Boolean.class) || field.getType().equals(boolean.class) ){
	    			objValue = Boolean.valueOf(value);
	    		}else if(field.getType().equals(Byte.class) || field.getType().equals(byte.class)){
	    			objValue = Byte.valueOf(value);
	    		}else if(field.getType().equals(Character.class) || field.getType().equals(char.class)){
	    			objValue = value.charAt(0);
	    		}else if(field.getType().equals(Double.class) || field.getType().equals(double.class)){
	    			objValue = Double.valueOf(value);
	    		}else if(field.getType().equals(Float.class) || field.getType().equals(float.class)){
	    			objValue = Float.valueOf(value);
	    		}else if(field.getType().equals(Integer.class) || field.getType().equals(int.class)){
	    			objValue = Integer.valueOf(value);
	    		}else if(field.getType().equals(Long.class) || field.getType().equals(long.class)){
	    			objValue = Long.valueOf(value);
	    		}else if(field.getType().equals(Short.class) || field.getType().equals(short.class)){
	    			objValue = Short.valueOf(value);
	    		}else{
	    			objValue = value;
	    		}
	    		field.set(obj, objValue);
			}
		} catch (Exception e) {
			throw new Exception("设置字段值失败，请检查值的合法性!",e);
		}
	}
	
	/**
	 * setObjValue方法慨述:通过对象的英文注解名称设置字段值
	 * @param obj 对象
	 * @param eName 英文注解名称
	 * @param value 值
	 * @throws Exception 
	 */
	public void setObjValue(Object obj,String name,String value) {
		try {
			Field field = obj.getClass().getDeclaredField(name);
			if(field != null) {
				this.setObjValue(obj, field, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(Object obj,String name){
		String retValue = "";
		try {
			Field field = obj.getClass().getDeclaredField(name);
			if(field == null){
				return retValue;
			}
			field.setAccessible(true);
			Object objValue = field.get(obj);
			if(null != objValue){
				retValue = objValue.toString();
				if(field.getType().getName().equals("java.lang.Double")){
					BigDecimal b = new  BigDecimal(retValue);
					retValue = b.toString();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return retValue;
	}
	
	/**
	 * description getFieldValue:获取属性的值(没有这个属性就注册进行缓存)
	 * <br>author ：koujiang
	 * <br>@param obj
	 * <br>@param fieldStr
	 * <br>@return
	 * <br>@throws Exception 
	 * <br>return :String
	 * <br>update ：2015-12-1 上午10:02:08
	 * <br>mender ：(Please add the modifier name)
	 * <br>Modified ：(Please add modification date)
	 * <br>varsion ：v1.0.0
	 */
	@SuppressWarnings("unchecked")
	public String getFieldValue(Object obj,String name) throws Exception{
		String value = "";
		try {
			Class<?> clas = Class.forName(obj.getClass().getName());
			HashMap<String, Field> mapField = null;
			if(OBJECT_MAP != null){
				mapField = (HashMap<String, Field>) OBJECT_MAP.get(clas.getName());
			}
			if(mapField != null){
				Field retField = mapField.get(name);
				retField.setAccessible(true);
				Object object = retField.get(obj);
				if(object != null) {
					return object.toString();
				} else {
					Object defvalue = getFieldDefaultValue(retField);
					if(defvalue != null) 
						return defvalue.toString();
				}
			}else{
				//获取所有成员变量
				Field[] fieldsAll = clas.getDeclaredFields();
				mapField = new HashMap<String, Field>();
				for(Field field : fieldsAll){
					mapField.put(field.getName(), field);
				}
				OBJECT_MAP.put(clas.getName(), mapField);
				value = getFieldValue(obj, name);
			}
		} catch (Exception e) {
			throw new Exception("得到数据失败!",e);
		}
		return value;
	}
	
	public Object getFieldDefaultValue(Field field) {
		field.setAccessible(true);
		Class<?> type = field.getType();
		if(type.isInstance(new Byte((byte) 0))) //Byte
			return new Byte((byte) 0);
		else if(type.isInstance(new Short((short) 0))) //Short
			return new Short((short) 0);
		else if(type.isInstance(new Float(0.0f))) //Float
			return new Float(0.0f);
		else if(type.isInstance(new Double(0.0))) //Double
			return new Double(0.0);
		else if(type.isInstance(new Integer(0))) //Integer
			return new Integer(0);
		else if(type.isInstance(new Long(0l))) //Long
			return new Long(0l);
		return null;
	}
	
	public String getValue(Object obj, Field field) throws Exception{
		String retValue = "";
		try {
			if(field != null) {
				field.setAccessible(true);
				Object objValue = field.get(obj);
				if(null != objValue){
					retValue = objValue.toString();
				}
			}
		} catch (IllegalArgumentException e) {
			throw new Exception("得到数据失败!",e);
		} 
		return retValue;
	}
	
	public Field[] getAllField(Object obj) throws Exception{
		Field[] fields = null;
		try {
			Class<?> clas = Class.forName(obj.getClass().getName());
			//获取所有成员变量
			Field[] allFields = clas.getDeclaredFields();
			fields = allFields;
		} catch (ClassNotFoundException e) {
			throw new Exception("类名不存在!",e);
		}
		return fields;
	}

	private String getFieldType(Field field){
		String dataType = "";
		if(field==null) return dataType;
		Class<?> fieldType = field.getType();
		//数据类型
		dataType = fieldType.getName();
		return dataType;
	}
}
package com.yimning.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @program: NBIOT_To_HuaWeiCloud_API
 * @description: 类型转换工具
 * @author: Yimning
 * @create: 2021-04-11 22:53
 **/
public class TypeConversionUtils {

    //Object转Map
    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value == null){
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }


    /**
          * 将对象转换成Map<String, String>格式
          *
          * @param obj
          * @return
          */
    public static HashMap<String, String> getObjectToValMap(Object obj, boolean isSort) {
        HashMap<String, String> map = new HashMap<>();


        Field[] fieldArr = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fieldArr) {
                field.setAccessible(true);
                if (field.get(obj) != null && !"".equals(field.get(obj).toString())) {
                    map.put(field.getName(), field.get(obj).toString());
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return map;
    }


    //获取Object对象中的某个List对象，并获取里面的值
    public void getObjectList(Object object) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field field = object.getClass().getDeclaredField("users");
        field.setAccessible(true);
        Class clazz = field.get(object).getClass();
        Method m= clazz.getDeclaredMethod("size");
        int size = (Integer) m.invoke(field.get(object));
        for (int i = 0; i < size; i++) {//遍历list，调用get方法，获取list中的对象实例
            Method getM= clazz.getDeclaredMethod("get", int.class);
            if(!getM.isAccessible()){
                getM.setAccessible(true);
            }
            Object invoke = getM.invoke(field.get(object), i);
            Field id = invoke.getClass().getDeclaredField("id");
            Field username = invoke.getClass().getDeclaredField("username");
            id.setAccessible(true);
            username.setAccessible(true);
            System.out.println(id.get(invoke).toString());
            System.out.println(username.get(invoke).toString());
        }
    }


    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }


}

/*
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */

package com.yimning.utils;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();

        //Setting the FAIL_ON_EMPTY_BEANS attribute. Do not throw an exception when a serialized object is empty.
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //Setting the FAIL_ON_UNKNOWN_PROPERTIES attribute.
        //When the string JSON character contains attributes that do not exist in the Java object, ignore them.
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Convert Object to JsonString
     *
     * @param jsonObj
     * @return
     */
    public static String jsonObj2String(Object jsonObj) {
        String jsonString = null;

        try {
            jsonString = objectMapper.writeValueAsString(jsonObj);
        } catch (IOException e) {
            System.out.printf("pasre json Object[{}] to string failed.", jsonString);
        }

        return jsonString;
    }

    /**
     * Convert JsonString to Simple Object
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T jsonString2SimpleObj(String jsonString, Class<T> cls) {
        T jsonObj = null;

        try {
            jsonObj = objectMapper.readValue(jsonString, cls);
        } catch (IOException e) {
            System.out.printf("pasre json Object[{}] to string failed.", jsonString);
        }

        return jsonObj;
    }

    /**
     * Method that will convert object to the ObjectNode.
     *
     * @param value the source data; if null, will return null.
     * @return the ObjectNode data after converted.
     * @throws JsonException
     */
    public static <T> ObjectNode convertObject2ObjectNode(T object)
            throws Exception {
        if (null == object) {
            return null;
        }

        ObjectNode objectNode = null;

        if (object instanceof String) {
            objectNode = convertJsonStringToObject((String) object,
                    ObjectNode.class);
        } else {
            objectNode = convertValue(object, ObjectNode.class);
        }

        return objectNode;
    }

    /**
     * Method that will convert the json string to destination by the type(cls).
     *
     * @param jsonString the source json string; if null, will return null.
     * @param cls        the destination data type.
     * @return
     * @throws JsonException
     */
    public static <T> T convertJsonStringToObject(String jsonString,
                                                  Class<T> cls) throws Exception {
        if (StringUtils.strIsNullOrEmpty(jsonString)) {
            return null;
        }

        try {
            T object = objectMapper.readValue(jsonString, cls);
            return object;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Method that will convert from given value into instance of given value
     * type.
     *
     * @param fromValue
     * @param toValueType
     * @return
     * @throws JsonException
     */
    public static <T> T convertValue(Object fromValue, Class<T> toValueType)
            throws Exception {
        try {
            return objectMapper.convertValue(fromValue, toValueType);
        } catch (IllegalArgumentException e) {
            throw new Exception(e);
        }
    }


    /**
     * 泛型返回，json字符串转对象
     *
     * @param jsonAsString
     * @param pojoClass
     * @return
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     */
    public static <T> T fromJson(String jsonAsString, Class<T> pojoClass) throws JsonMappingException,
            JsonParseException, IOException {
        return objectMapper.readValue(jsonAsString, pojoClass);
    }

    public static <T> T fromJson(FileReader fr, Class<T> pojoClass) throws JsonParseException, IOException {
        return objectMapper.readValue(fr, pojoClass);
    }


    /**
     * json字符串转Map
     *
     * @param jsonStr
     * @return
     * @throws IOException
     */
    public static Map<String, Object> parseMap(String jsonStr) throws IOException {
        Map<String, Object> map = objectMapper.readValue(jsonStr, Map.class);
        return map;
    }

    public static JsonNode parse(String jsonStr) throws IOException {
        JsonNode node = null;
        node = objectMapper.readTree(jsonStr);
        return node;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * json字符串转 List对象
     *
     * @param str   json字符串
     * @param clazz 转换的类型
     * @return
     */
    public static <T> List<T> fromListJson(String str, Class<T> clazz) {
        return JSONArray.parseArray(str, clazz);
    }
}

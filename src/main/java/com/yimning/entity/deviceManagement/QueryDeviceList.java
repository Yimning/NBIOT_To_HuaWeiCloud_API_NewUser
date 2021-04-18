package com.yimning.entity.deviceManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description: 查询设备参数
 * @author: Yimning
 * @create: 2021-04-18 15:02
 **/
@Data
public class QueryDeviceList {
    private String project_id;
    private String product_id;
    private String gateway_id;
    private Boolean is_cascade_query;
    //true：表示查询设备ID等于gateway_id参数的设备下的所有各级子设备。
    //false：表示查询设备ID等于gateway_id参数的设备下的一级子设备。

    private String node_id;//设备标识码，通常使用IMEI、MAC地址或Serial No作为node_id。
    private String device_name;
    private Integer limit;//分页查询时每页显示的记录数，默认值为10，取值范围为1-50的整数。

    private String marker;//上一次分页查询结果中最后一条记录的ID，在上一次分页查询时由物联网平台返回获得。分页查询时物联网平台是按marker也就是记录ID降序查询的，越新的数据记录ID也会越大。若填写marker，则本次只查询记录ID小于marker的数据记录。若不填写，则从记录ID最大也就是最新的一条数据开始查询。如果需要依次查询所有数据，则每次查询时必须填写上一次查询响应中的marker值。

    private Integer offset;//表示从marker后偏移offset条记录开始查询。默认为0，取值范围为0-500的整数。当offset为0时，表示从marker后第一条记录开始输出。限制offset最大值是出于API性能考虑，您可以搭配marker使用该参数实现翻页，例如每页50条记录，1-11页内都可以直接使用offset跳转到指定页，但到11页后，由于offset限制为500，您需要使用第11页返回的marker作为下次查询的marker，以实现翻页到12-22页。

    private String start_time;//查询设备注册时间在startTime之后的记录，格式：yyyyMMdd'T'HHmmss'Z'，如20151212T121212Z。

    private String end_time;//查询设备注册时间在endTime之前的记录，格式：yyyyMMdd'T'HHmmss'Z'，如20151212T121212Z。

    private String app_id;//资源空间ID。此参数为非必选参数，存在多资源空间的用户需要使用该接口时，可以携带该参数查询指定资源空间下的设备列表，不携带该参数则会查询该用户下所有设备列表。
}

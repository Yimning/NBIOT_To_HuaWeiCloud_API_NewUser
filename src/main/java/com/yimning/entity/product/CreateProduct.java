package com.yimning.entity.product;

import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 产品创建
 * @author: Yimning
 * @create: 2021-04-15 18:31
 **/
@Data
public class CreateProduct {
    private String product_id;
    private String name;
    private String device_type;
    private String protocol_type;
    private String data_format;
    private List<Service_capabilities> service_capabilities;
    private String manufacturer_name;
    private String industry;
    private String description;
    private String app_id;

    @Data
    public static class Service_capabilities {
        private String service_type;
        private String service_id;
        private String description;
        private List<Properties> properties;
        private List<ServiceCommand> commands;
        private List<Events> events;
        private String option;
    }
    @Data
    public static class Properties {
        private String unit;
        private String min;
        private String method;
        private String max;
        private String data_type;
        private String description;
        private double step;
        private Default_value default_value;
        private List<String> enum_list;
        private boolean required;
        private String property_name;
        private int max_length;
    }

    @Data
    public static class ServiceCommand {
        private String command_name;
        private List<ServiceCommandResponse> responses;
        private List<ServiceCommandPara> paras;
    }

    @Data
    public static class Events {
        private String event_type;
        private List<ServiceCommandPara> paras;
    }
    public class ServiceCommandPara {
        private String unit;
        private String min;
        private String max;
        private String para_name;
        private String data_type;
        private String description;
        private double step;
        private List<String> enum_list;
        private boolean required;
        private int max_length;
    }


    public class Default_value {

        private String color;
        private int size;
    }


    public static class ServiceCommandResponse {

        private String response_name;
        private List<ServiceCommandPara> paras;
    }
}

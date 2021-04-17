package com.yimning.entity.product;

import lombok.Data;

import java.util.List;
@Data
public class Properties {

    private String property_name;
    private boolean required;
    private String data_type;
    private List<String> enum_list;
    private int min;
    private int max;
    private int max_length;
    private double step;
    private String unit;
    private String method;
    private String description;

}

package com.yimning.entity.product;

import lombok.Data;

import java.util.List;
@Data
public class ResponseParam {
    private String para_name;
    private String data_type;
    private boolean required;
    private List<String> enum_list;
    private int min;
    private int max;
    private int max_length;
    private double step;
    private String unit;
    private String description;
}

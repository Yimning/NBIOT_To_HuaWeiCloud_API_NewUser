package com.yimning.entity.product;

import lombok.Data;

import java.util.List;
@Data
public class Responses {
    private List<ResponseParam> paras;
    private String response_name;
}

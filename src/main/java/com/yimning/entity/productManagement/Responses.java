package com.yimning.entity.productManagement;

import lombok.Data;

import java.util.List;
@Data
public class Responses {
    private List<ResponseParam> paras;
    private String response_name;
}

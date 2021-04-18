package com.yimning.entity.productManagement;

import lombok.Data;

import java.util.List;
@Data
public class Commands {
    private String command_name;
    private List<Responses> responses;
    private List<Paras> paras;
}

package com.yimning.entity.deviceMessage;

import lombok.Data;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-19 19:58
 **/
@Data
public class Test {

	private String data;
	private String test;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}

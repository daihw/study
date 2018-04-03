package com.tydic.study.rpc.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args){
		//Son son = new Son();
		//son.showName();
		JSONObject response = new JSONObject();
		JSONObject json = new JSONObject();
		JSONObject data = new JSONObject();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		data.put("occurTime", "2017-06-27T14:15:19.000Z");
		data.put("location", "39.925625,116.434949");
		data.put("msisdn", "17355110119");
		data.put("zipCode", "10");
		data.put("provId", "811");
		data.put("cityCode", "81101");
		
		dataMap.put("openRequestId", "1778_business_wzfw_current-location_1498555851281");
		dataMap.put("data", data);
		
		response.put("message", "成功");
		response.put("data", dataMap);
		response.put("code", "10000");
		
		String strData = response.get("data").toString();

		//String result = " {\"message\":\"成功\",\"data\":{\"openRequestId\":\"1778_business_wzfw_current-location_1498552086111\",\"data\":{\"occurTime\":\"2017-06-27T11:52:29.000Z\",\"location\":\"39.92939,116.429968\",\"msisdn\":\"17355110119\",\"zipCode\":\"10\",\"provId\":\"\",\"cityCode\":\"\"}},\"code\":\"10000\"}";
		//JSONObject jsonObject = (JSONObject) JSON.parse(result);
		//String data = jsonObject.get("data").toString();
		System.out.println(response);
	}
}

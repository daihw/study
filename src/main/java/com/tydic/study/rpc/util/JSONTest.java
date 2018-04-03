package com.tydic.study.rpc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONTest {
	
	public static void main(String[] args){
		String jsonStr = "{\"seqid\":\"ddd4b5a9fecd446cbd7863b70bb500a1\",\"code\":\"200\",\"message\":\"³É¹¦\",\"flag\":\"1\",\"data\":[{\"userAcct\":\"acct001\",\"crtDat\":\"2017-04-25 13:21:25\"},{\"userAcct\":\"acct002\",\"crtDat\":\"2017-04-25 13:21:25\"}]}";
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		String seqid = jsonObject.getString("seqid");
		JSONArray data = jsonObject.getJSONArray("data");
		String resutlStr = "[{\"name\":\"wangli\",\"age\":18},{\"name\":\"liyan\",\"age\":20}]";
		Object object = JSON.parse(resutlStr);
		if(object instanceof JSONArray ){
			resutlStr = "{\"result\":"+resutlStr+"}";
		}
		Object objectQ = JSON.parse(resutlStr);
		System.out.println("sss"+seqid);
		System.out.println("sss"+data.size());
		System.out.println(System.currentTimeMillis());
		System.out.println(objectQ);
		
		JSONObject jsonObject2 = (JSONObject)JSON.parse(null);
		System.out.println(jsonObject2);
		}

}

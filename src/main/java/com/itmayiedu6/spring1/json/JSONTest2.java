package com.itmayiedu6.spring1.json;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @classDesc: 功能描述:(组装json)
 * @author: 余胜军
 * @createTime: 2017年8月25日 下午9:38:17
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class JSONTest2 {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		JSONArray sitesArray = new JSONArray();
		JSONObject bean1 = new JSONObject();
		bean1.put("name", "蚂蚁课堂");
		bean1.put("url", "http://www.itmayiedu.com");
		sitesArray.add(bean1);
		JSONObject bean2 = new JSONObject();
		bean2.put("name", "蚂蚁课堂1");
		bean2.put("url", "http://www.itmayiedu.com");
		sitesArray.add(bean2);
		jsonObject.put("sites", sitesArray);
		System.out.println(jsonObject.toJSONString());
	}

}

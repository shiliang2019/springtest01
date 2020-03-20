package com.itmayiedu6.spring1.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @classDesc: 功能描述:(fastjson 解析)
 * @author: 余胜军
 * @createTime: 2017年8月25日 下午9:32:03
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class JSONTest
{

	static String JSONSTR = "{\"sites\":[{\"name\":\"蚂蚁课堂\",\"url\":\"www.itmayiedu.com\"},{\"name\":\"每特教育\",\"url\":\"http://meiteedu.com/\"}]}";

	public static void main(String[] args)
	{
		// 1.将json字符串转换为json Object
		JSONObject jsonObject = new JSONObject();
		// json對象
		JSONObject parseObject = jsonObject.parseObject(JSONSTR);
		// 获取json 数组对象
		JSONArray sitesArrays = parseObject.getJSONArray("sites");
		for (Object object : sitesArrays)
		{
			JSONObject jsonObejct = (JSONObject) object;
			String name = jsonObejct.getString("name");
			String url = jsonObejct.getString("url");

			System.out.println(name + "----" + url);
		}
	}

}

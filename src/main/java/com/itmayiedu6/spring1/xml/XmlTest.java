package com.itmayiedu6.spring1.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @classDesc: 功能描述:(使用xml进行解析)
 * @author: 余胜军
 * @createTime: 2017年8月25日 下午9:50:00
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class XmlTest
{
	static String fileName = "C:\\itmayiedujiangke\\sida.xml";

	public static void main(String[] args) throws DocumentException
	{
		// xml解析器
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(new File(fileName));
		// 拿到根节点。
		Element rootElement = read.getRootElement();
		getNodes(rootElement);
	}

	static public void getNodes(Element rootElement)
	{
		System.out.println("节点名称:" + rootElement.getName());
		// 拿到节点属性
		List<Attribute> attributes = rootElement.attributes();
		for (Attribute attribute : attributes)
		{
			System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
		}
		// 节点名称
		if (!rootElement.getTextTrim().equals(""))
		{
			System.out.println(rootElement.getName() + "---" + rootElement.getText());
		}
		// 返回下一个节点
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext())
		{
			// 获取当前节点值
			Element next = elementIterator.next();
			getNodes(next);
		}

	}

}

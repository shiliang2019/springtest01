package com.itmayiedu6.spring1.classFrom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.itmayiedu6.spring1.entity.UserEntity;

public class ClassFrom
{

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
		// // 1.出了new创建对象，还可以使用反射机制创建对象。
		// // 2.forName 必须传入 class 类的完整路径。
		// Class<?> forName = Class.forName("com.itmayiedu.entity.UserEntity");
		// // 3.newInstance使用无参构造函数 创建对象 new
		// Object newInstance = forName.newInstance();
		// UserEntity user = (UserEntity) newInstance;
		// System.out.println("user:" + user);
		// user.setUserId("123");
		// System.out.println(user.getUserId());
		// // 使用反射技术创建对象和new 那个效率高？ new 效率高。 hibe

		// Class<?> forName = Class.forName("com.itmayiedu.entity.UserEntity");
		// Constructor<?> constructor = forName.getConstructor(String.class);
		// Object newInstance = constructor.newInstance("11");
		// UserEntity user=(UserEntity) newInstance;

		Class<?> forName = Class.forName("com.itmayiedu6.spring1.entity.UserEntity");
		// 获取所有该类的所有方法
//		 Method[] declaredMethods = forName.getMethods();
//		 for (Method method : declaredMethods) {
//		 System.out.println(method.getName() + "-----" +
//		 method.getReturnType());
//		 }
		// 拿到所有成员属性
//		Field[] declaredFields = forName.getDeclaredFields();
//		for (Field field : declaredFields) {
//			System.out.println(field.getName());
//		}
		// 为什么继承里面没有
		// 可以使用Java反射技术 可以访问到私有属性。
		Field declaredField = forName.getDeclaredField("userId");
		Object obj = forName.newInstance();
		// 允许访问私有成员属性
		declaredField.setAccessible(true);
		declaredField.set(obj, "123");
		UserEntity user = (UserEntity) obj;
		System.out.println(user.getUserId());
	}

}

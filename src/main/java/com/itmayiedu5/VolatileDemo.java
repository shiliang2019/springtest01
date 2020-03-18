
package com.itmayiedu5;

class ThreadVolatileDemo extends Thread {
	public volatile boolean flag = true;

	@Override
	public void run() {
		System.out.println("子线程开始执行...");
		while (flag) {

		}
		System.out.println("子线程结束执行...");
	}
	public void isRun( boolean flag){
		 this.flag=flag;
	}
}

/**
 * 
 * @classDesc: 功能描述:(Volatile demo)
 * @author: 余胜军
 * @createTime: 2017年8月23日 下午9:39:26
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class VolatileDemo {

	 public static void main(String[] args) throws InterruptedException {
		  ThreadVolatileDemo t1 = new ThreadVolatileDemo();
		  t1.start();
		  Thread.sleep(300);//0.3
		  t1.isRun(false);
		  System.out.println("flag:"+t1.flag);
	}
	
}

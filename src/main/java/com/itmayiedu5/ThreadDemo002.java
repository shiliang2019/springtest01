
package com.itmayiedu5;

/**
 * 线程分为两种 一种是守护线程（后台线程） 一种用户线程(前台线程)
 * 主线程或jvm进程挂了，守护线程也会被停止掉。gc其实也是守护线程。
 * @classDesc: 功能描述:(守护线程)
 * @author: 余胜军
 * @createTime: 2017年8月21日 下午11:02:42
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class ThreadDemo002 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
				
					}
					System.out.println("我是子线程,哈哈哈i:" + i);
				}
			}
		});
		// 标识位 守护线程
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 30; i++) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
		
			}
			System.out.println("我是主线程,哈哈哈i:" + i);
		}
		System.out.println("主线程执行完毕~!");
	}
	

}

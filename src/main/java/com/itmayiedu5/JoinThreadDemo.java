
package com.itmayiedu5;

class JoninThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "---" + i);
		}
	}
}

public class JoinThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		JoninThread joninThread1 = new JoninThread();
		JoninThread joninThread2 = new JoninThread();
		//Priority 值从 1-10  值越大不带每次都是他执行。
//		joninThread1.setPriority(10);
		joninThread1.start();
		joninThread2.yield();
		joninThread2.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main---" + i);
		}
	}

}

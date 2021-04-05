package baseline.design.singleTon;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * 各种单例模式在多线程条件下的效率
 * 
 * @author Peter
 */
public class SingletonTest03 {

	public static void main(String[] args) throws Exception {
		
		long startTime=System.currentTimeMillis();
		
		CyclicBarrier barrier=new CyclicBarrier(11);
		
		//创建10个线程
		IntStream.rangeClosed(1, 10).forEach(i ->{
			new Thread("线程"+i){
				@Override
				public void run() {
					//每个线程中获取100万次单例对象
					IntStream.rangeClosed(1, 200_0000).forEach(j ->{
						com.powernode.designpattern.day02.part1.SingletonType1 instance = com.powernode.designpattern.day02.part1.SingletonType1.getInstance();
//						SingletonType4 instance = SingletonType4.getInstance();
//						SingletonType6 instance = SingletonType6.getInstance();
//						SingletonType7 instance = SingletonType7.getInstance();
//						SingletonType8 instance = SingletonType8.SGT;
					});
					try {
						barrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}.start();
		});
		
		barrier.await();
		
		long endTime=System.currentTimeMillis();
		System.out.println("总共耗时为："+(endTime-startTime)+" 毫秒");
		
		
	}

}

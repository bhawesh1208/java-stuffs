package com.bhawesh;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class Testing {

	@Autowired
	MessageSource source;
	
	//@Autowired
	//@Qualifier(value="cachedThreadPool")
	ExecutorService exe = Executors.newCachedThreadPool();
	
	
	

	static int c = 0;

	@Scheduled(initialDelay = 1, fixedDelay = 1)
	public void test() throws Exception  {
		
		
		
		
	// ExecutorService exe = BeanAccessor.getSingleton("cachedThreadPool", ExecutorService.class);
		c=0;
		Holder.th.set("Hello");
		System.out.println("Invocation Test ");
		StopWatch watch = new StopWatch();
		watch.start();
		CountDownLatch doneSignal = new CountDownLatch(5000);
		for (int j = 0; j < 5000; j++) {
			
			Runnable task = () -> {
				try {

					for (int i = 0; i <10; i++) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
				//	System.out.println("Thread Local Value for Thread" +Thread.currentThread().getName()+ "is: "+Holder.th.get());
					
					//System.out.println("Execution Finished");
					

				} 
				finally {
					doneSignal.countDown();
				}
			};
			c++;
			exe.submit(task);
			//Thread t  = new Thread(task, "Thread-" + j);
			//t.start();
		}
		
		doneSignal.await();
		watch.stop();
		System.out.println("Thread Count is "+c);
		System.out.println("Time taken is "+watch.getTotalTimeSeconds());
	}

	public void throwEx() throws Exception
	{
		throw new Exception();
	}
	
}

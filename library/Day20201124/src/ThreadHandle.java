
public class ThreadHandle implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			
		}
	}
	
	private Thread thisThread;
	private String threadName;
	public ThreadHandle()
	{
		this.threadName = threadName;
	}
	
	public void start()
	{
		thisThread = new Thread(this);
		if(threadName != null)
		{
			thisThread.setName(threadName);
			thisThread.start();
		}
	}
	public void resume()
	{
		
	}
	public void suspend()
	{
		
	}
	public void stop()
	{
		
	}
	public void join()
	{
		
	}

	public void test_thread_handle() throws Exception{
		ThreadHandle threadHandle = new ThreadHandle();
		threadHandle.start();
	}
	
	
}

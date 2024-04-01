package day0401;

public class Ex1_Thread extends Thread
{
	private String threadName;
	private int count;
	
	public Ex1_Thread(String threadName, int count)
	{
		this.threadName = threadName;
		this.count = count;
	}
	
	@Override
	public void run()
	{
		for(int i = 1; i <= count; i++)
		{
			System.out.println(threadName + ":" + i);
		}
		super.run();
	}

	public static void main(String[] args) 
	{
		Ex1_Thread ex1 = new Ex1_Thread("1번 쓰레드", 300);
		Ex1_Thread ex2 = new Ex1_Thread("2번 쓰레드", 300);
		Ex1_Thread ex3 = new Ex1_Thread("3번 쓰레드", 300);
		ex1.start();
		ex2.start();
		ex3.start();
	}

}

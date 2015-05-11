package InnerClass;

import java.awt.event.*;
import java.util.Date;

import javax.swing.Timer;

class BankAccout {
	private double money;
	private String name;
	public BankAccout(double money,String n)
	{
		this.name = n;
		this.money=money;
	}
	private class AddInterest implements ActionListener
	{
		public int rat;
		public AddInterest(int i)
		{
			rat = i;
		}
		public void actionPerformed(ActionEvent event)
		{
			money=money*(100+rat)/100;
			Date now = new Date();
			System.out.println(now+"\t"+"now the money is"+money);
			
		}
	}
	public void star(int lilv)
	{
		ActionListener jisuan = new AddInterest(10);
		System.out.println("this is the "+name+" accout");
		Timer t =new Timer(1000,jisuan);
		t.start();
	}

}

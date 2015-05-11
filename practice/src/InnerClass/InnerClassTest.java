package InnerClass;

import javax.swing.JOptionPane;

public class InnerClassTest {
	
	static
	{
		System.out.println("Hello,world !");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BankAccout exp = new BankAccout(1000,"Bill");
        exp.star(100);
        JOptionPane.showMessageDialog(null,"Quit");
	}

}

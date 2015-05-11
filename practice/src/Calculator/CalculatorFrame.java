package Calculator;

import java.awt.Container;

import javax.swing.*;


class CalculatorFrame extends JFrame {
	public int Frame_HEIGHT = 300;
	public int Frame_WIDTD = 300;
	
	public CalculatorFrame()
	{
		setTitle("Calculator");
		setSize(Frame_WIDTD,Frame_HEIGHT);
		
		CalculatorPanel panel = new CalculatorPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);	
		
		
	}
	
}

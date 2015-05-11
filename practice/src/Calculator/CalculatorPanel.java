package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.geom.Arc2D.Double;

import javax.swing.*;

class CalculatorPanel extends JPanel {
	
	private JLabel display; 
	private JPanel mainBody;
	private double result;
	private String lastCommand;
	private boolean start;
	
	public CalculatorPanel()
	{
		result = 0;
		lastCommand = "=";
		start = true;
		
		setLayout(new BorderLayout());
		
		display = new JLabel("0");
		add(display,BorderLayout.NORTH);
		
		mainBody = new JPanel();
		mainBody.setLayout(new GridLayout(4,4));
		
		ActionListener input = new InputAction();
		ActionListener command = new CommandAction();
		
		addButton(new JButton("7"),input);
		addButton(new JButton("8"),input);
		addButton(new JButton("9"),input);
		addButton(new JButton("/"),command);
		
		addButton(new JButton("4"),input);
		addButton(new JButton("5"),input);
		addButton(new JButton("6"),input);
		addButton(new JButton("*"),command);
		
		addButton(new JButton("1"),input);
		addButton(new JButton("2"),input);
		addButton(new JButton("3"),input);
		addButton(new JButton("-"),command);
		
		addButton(new JButton("0"),input);
		addButton(new JButton("."),input);
		addButton(new JButton("="),command);
		addButton(new JButton("+"),command);
		
		add(mainBody,BorderLayout.CENTER);

		
	}
	
	public void addButton(JButton b,ActionListener l)
	{
		mainBody.add(b);
		b.addActionListener(l);
	}
	
	private class InputAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = e.getActionCommand();
			if(start)
			{
				display.setText("");
				start = false;
			}
			display.setText(display.getText()+s);
		}
		
	}
	
	private class CommandAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = e.getActionCommand();
			if(start)
			{
				if (s.equals("-"))
				{
					display.setText("-");
					start = false;
				}
				else
					lastCommand = s;
			}
			else
			{
				calculate(Double.parseDouble(display.getText()));
				lastCommand = s;
				start = true;
			}
		}
		
	}
	public void calculate(double x)
	{
		if(lastCommand.equals("+")) result += x;
		else if(lastCommand.equals("-")) result -= x;
		else if(lastCommand.equals("*")) result *= x;
		else if(lastCommand.equals("/")) result /= x;
		else if(lastCommand.equals("=")) result = x;
		display.setText(""+result);
	}

}

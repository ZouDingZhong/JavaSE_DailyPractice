package Chapter_9;

import java.awt.event.ActionEvent;

import javax.swing.*;

class TestAction extends AbstractAction {

	public TestAction(String name)
	{
		super(name);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(getValue(Action.NAME)+" elected.");
	}

}

package ActionListener;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
//import javax.swing.*;
//import javax.swing.Timer;

class TimePrinter implements ActionListener{

	public void actionPerformed(ActionEvent event)
	{
        Date now = new Date();
        System.out.println("the time is"+now);
        Toolkit.getDefaultToolkit().beep();
	}
}

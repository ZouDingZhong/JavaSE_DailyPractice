package ActionListener;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
public class ActionListenerTese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ActionListener listener = new TimePrinter();
		Timer t = new Timer(10000,listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit");
		System.exit(0);
	}

}

package Chapter_9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AllChapter_9Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showInputDialog(null, "password","password",JOptionPane.OK_CANCEL_OPTION,null, args, JOptionPane.WARNING_MESSAGE);
        TestFrame f = new TestFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();

	}

}

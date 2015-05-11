package Chapter_9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;


class TestFrame extends JFrame {
	public int Frame_HEIGHT = 450;
	public int Frame_WIDTD = 600;

	private JPanel allPanel;
	public TestFrame()
	{
	    allPanel = new JPanel();
		add(allPanel);
		
		setTitle("AllChapter_9Test");
		setSize(Frame_WIDTD,Frame_HEIGHT);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
//		this is the fileMenu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem newItem = fileMenu.add("New");
		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("NEW TEST");
			}
		});
		
		JMenuItem openItem = fileMenu.add("Open");
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		openItem.addActionListener(new TestAction("Open"));
		
		fileMenu.addSeparator();

		JMenuItem saveItem = fileMenu.add("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));

		JMenuItem saveAsItem = fileMenu.add("Save As");
		
		fileMenu.addSeparator();
		
		JMenuItem exitItem = fileMenu.add("Exit");
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

//		this is the editMenu
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem cutItem = editMenu.add("Cut");
		JMenuItem copyItem = editMenu.add("Copy");
        JMenuItem pasteItem = editMenu.add("Paste");
		
        editMenu.addSeparator();
		
		JMenu optionMenu = new JMenu("Option");
		editMenu.add(optionMenu);
		JCheckBoxMenuItem readonlyItem = new JCheckBoxMenuItem("Read Only");
		optionMenu.add(readonlyItem);
		readonlyItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(readonlyItem.isSelected()) 
			{
				saveItem.setEnabled(false);
				saveAsItem.setEnabled(false);
			}
			if(!readonlyItem.isSelected()) 
			{
				saveItem.setEnabled(true);
				saveAsItem.setEnabled(true);
			}
			}
		});
		
		optionMenu.addSeparator();
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem blueItem = new JRadioButtonMenuItem("blue");
		blueItem.setSelected(true);
		JRadioButtonMenuItem redItem = new JRadioButtonMenuItem("red");
		group.add(blueItem);
		group.add(redItem);
		blueItem.addActionListener(new ColorAction(Color.BLUE));
		redItem.addActionListener(new ColorAction(Color.RED));
		
		
		optionMenu.add(blueItem);
		optionMenu.add(redItem);
		
//		this is the helpMenu
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
//		helpMenu.addActionListener(new TestAction("Help"));
		
		
		JMenuItem indexItem = new JMenuItem("Index",'i');
		helpMenu.add(indexItem);
		indexItem.addActionListener(new TestAction("Index"));
		
		
		JMenuItem aboutItem = new JMenuItem("About",'a');
		helpMenu.add(aboutItem);
		
//		this is the popupMenu
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem cutItem2 = popup.add("Cut");
		JMenuItem CopeItem2 = popup.add("Cope");
		JMenuItem PasteItem2 = popup.add("Paste");
		
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
				// TODO Auto-generated method stub
//				if((event.getModifiersEx()&InputEvent.BUTTON3_DOWN_MASK)!=0)
//				if(event.isPopupTrigger())
//					popup.show(event.getComponent(),event.getX(), event.getY());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.isPopupTrigger())
					popup.show(event.getComponent(),event.getX(), event.getY());

			}

			@Override
			public void mouseReleased(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.isPopupTrigger())
					popup.show(event.getComponent(),event.getX(), event.getY());
	
			}
			
		});
		
		JToolBar bar = new JToolBar();
		add(bar,BorderLayout.NORTH);
//		ColorAction blueAction = new ColorAction(Color.BLUE); 
//		blueAction.putValue(Action.NAME,"B");
		bar.add(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				blueItem.setSelected(true);
				allPanel.setBackground(Color.BLUE); 

			}
			
		});
	}
	private class ColorAction extends AbstractAction {

		private Color color;
		public ColorAction(Color c)
		{
			color = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			allPanel.setBackground(color); 
		}

	}


}

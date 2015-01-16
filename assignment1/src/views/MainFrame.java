package views;

//import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JButton addPartButton;
	private JButton deletePartButton;
	
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	
	private JLabel listTitle;
	private JList partsList;
	
	public MainFrame() {
		
		mainPanel = new JPanel();
		
		contentPanel = new JPanel();
		contentPanel.setToolTipText("Area for Jlist");
		partsList = new JList();
		listTitle = new JLabel("This is the area for jlist to go");
		contentPanel.add(partsList);
		contentPanel.add(listTitle);
		

		
		buttonPanel = new JPanel();
		buttonPanel.setToolTipText("Area for buttons");
		addPartButton = new JButton("Add");
		addPartButton.setToolTipText("Click to add a part");
		deletePartButton = new JButton("Delete");
		deletePartButton.setToolTipText("Click to delete a part");
		
		buttonPanel.add(addPartButton);
		buttonPanel.add(deletePartButton);
		mainPanel.add(buttonPanel);
		
		this.add(mainPanel);
		mainPanel.add(contentPanel);
		mainPanel.add(buttonPanel);

		pack();
		setVisible(true);
		setTitle("Inventory");
		setSize(250, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// private JButton button = new JButton("My Button");
}

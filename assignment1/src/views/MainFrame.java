package views;

//import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import controller.*;
import model.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;



public class MainFrame extends JFrame {

	private Model model;
	private JButton addPartButton;
	private JButton deletePartButton;
	
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	
	private JLabel listTitle;
	private JList partsList;
	
	private String addAction = "Add";
	private String deleteAction = "Delete";
	
	public MainFrame(Model model) {
		this.model = model;
		pack();
	
		setVisible(true);
		setTitle("Inventory");
		setSize(650, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Part[] list = new Part[2];
		list[0] = new Part("1", "screw", "Parts R Us", 4);
		list[1] = new Part("2", "bolt", "Parts R Us", 4);
		
		
		
		/*the main panel where all panels will reside */
		mainPanel = new JPanel(new BorderLayout());
		

				
		
		/*this panel will house the list of items and other useful
		 * information used on screen, that are NOT buttons
		 */
		contentPanel = new JPanel();
		contentPanel.setToolTipText("Area for Jlist");
		
		/*setting up space for the list of items and giving a 
		 * little label to the list, then adding it to content
		 * panel 
		 */
		
		//partsList = new JList((ListModel) model.partList); //data has type Object[]
		partsList = new JList(list);
		partsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		partsList.setLayoutOrientation(JList.VERTICAL);
		partsList.setVisibleRowCount(10);
		listTitle = new JLabel("This is the area for jlist to go");
		
				
		JScrollPane listScroller = new JScrollPane(partsList);
		listScroller.setPreferredSize(new Dimension(300, 350));
		contentPanel.add(listTitle);
		contentPanel.add(listScroller);
		
		/*create button panel for all buttons to be nested in then
		 * create the buttons and add them to the panel
		 */
		buttonPanel = new JPanel();
		buttonPanel.setToolTipText("Area for buttons");
		
		/*after creating buttons assign an action command
		 * that will be used to determine what to do in
		 * the controller
		 */
		addPartButton = new JButton("Add");
		addPartButton.setToolTipText("Click to add a part");
		addPartButton.setActionCommand(addAction);
		
		deletePartButton = new JButton("Delete");
		deletePartButton.setToolTipText("Click to delete a part");
		deletePartButton.setActionCommand(deleteAction);
		
		buttonPanel.add(addPartButton);
		buttonPanel.add(deletePartButton);
		mainPanel.add(buttonPanel);
		
		/*add content panel and buttons panel to main panel, all
		 * of these reside in the main 'frame'
		 */
		this.add(mainPanel);
		mainPanel.add(contentPanel);
		mainPanel.add(buttonPanel);

		/*unsure what pack does. Give title to the frame, size
		 * and location (setLocationRelativeTo(null)) gives
		 * centered location to frame on any screen when run
		 */

	}

	/* the buttons on this page will look to this
	 * listener once this method is called
	 */
	public void mainViewBtnListener(ActionListener listener1){
		addPartButton.addActionListener(listener1);
		deletePartButton.addActionListener(listener1);
		
	}
}

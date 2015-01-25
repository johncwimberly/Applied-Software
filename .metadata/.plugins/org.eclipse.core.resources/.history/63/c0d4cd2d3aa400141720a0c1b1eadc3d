package views;

//import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import controller.*;
import model.*;

import javax.swing.DefaultListModel;
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

	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JPanel labePanell;
	private JPanel bottomPanel;

	private JButton addPartButton;
	private JButton deletePartButton;
	private JButton editPartButton;
	
	private JScrollPane listScroller;
	private JLabel listTitle;
	private JLabel warnLabel;
	
	private JList partsList;
	private DefaultListModel<Part> listModel;
	
	private String addAction = "Add";
	private String deleteAction = "Delete";
	private String editAction = "Edit";
	
	public MainFrame(Model model) {
		this.model = model;
		
		/*setting up space for the list of items and giving a 
		 * little label to the list, then adding it to content
		 * panel 
		 */
		
		listModel = new DefaultListModel<Part>();
		partsList = new JList(listModel);
		partsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		partsList.setLayoutOrientation(JList.VERTICAL);
		partsList.setVisibleRowCount(10);
		
		listScroller = new JScrollPane(partsList);
		listScroller.setPreferredSize(new Dimension(400, 350));

		/*this panel will house the list of items and other useful
		 * information used on screen, that are NOT buttons
		 */
		contentPanel = new JPanel();
		contentPanel.setToolTipText("Area for Jlist");
		contentPanel.add(listScroller);
		
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
		
		editPartButton = new JButton("Edit");
		editPartButton.setToolTipText("Click to edit a part");
		editPartButton.setActionCommand(editAction);

		
		warnLabel = new JLabel();
		
		/*create button panel for all buttons to be nested in then
		 * create the buttons and add them to the panel
		 */
		buttonPanel = new JPanel();
		buttonPanel.setToolTipText("Area for buttons");
		buttonPanel.add(addPartButton);
		buttonPanel.add(deletePartButton);
		buttonPanel.add(editPartButton);

		
		listTitle = new JLabel("This is the area for jlist to go");
		
		bottomPanel = new JPanel(new GridLayout(2,1));
		
		bottomPanel.add(buttonPanel);
		bottomPanel.add(warnLabel);
		
		/* the main panel where all panels will reside
		 * 
		 * add content panel and buttons panel to main panel, all
		 * of these reside in the main  'frame'
		 */
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(listTitle, BorderLayout.PAGE_START);
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.PAGE_END);
		this.add(mainPanel);

		/*unsure what pack does. Give title to the frame, size
		 * and location (setLocationRelativeTo(null)) gives
		 * centered location to frame on any screen when run
		 */
		pack();
		setVisible(true);
		setTitle("Inventory");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

	/* the buttons on this page will look to this
	 * listener once this method is called
	 */
	public void mainViewBtnListener(ActionListener listener1){
		addPartButton.addActionListener(listener1);
		deletePartButton.addActionListener(listener1);
		editPartButton.addActionListener(listener1);
	}
	
	public void addEntry(Part part){
		listModel.addElement(part);
	}
	
	public void deleteEntry(Part part){
		listModel.removeElement(part);
	}
	
	public void createAddPartFrame(){
		AddPartFrame view = new AddPartFrame();
		new AddPartController(model, view, this, 0);
	}
	
	public AddPartFrame createEditPartFrame(Part part){
		AddPartFrame view = new AddPartFrame();
		AddPartController controller = new AddPartController(model, view, this, 1);
		view.setNameField(part.getPartName());
		view.setNumberField(part.getPartNum());
		view.setQuantityField(part.getQuantity());
		view.setVendorField(part.getVendor());
		controller.setEditPart(part);
		return view;
	}
	
	public JList<Part> getPartsList(){
		return partsList;
	}
	
	public void setWarningLabel(){
		warnLabel.setText("Must select an item");
	}

	public void removeWarningLabel(){
		warnLabel.setText("");
	}
	
	public Part getSelectedItem(){
		return (Part)partsList.getSelectedValue();

	}
	
	public void editEntry(Part oldPart, Part newPart){
		
		listModel.removeElement(oldPart);
		listModel.addElement(newPart);
		
	}
	
	public void addTestData(){
		for(int i = 0; i < model.getPartList().size(); i++){
			addEntry(model.getPartList().get(i));
		}
	}

	public void mainMouseListener(MainController mainController) {
		partsList.addMouseListener(mainController);
	}

}

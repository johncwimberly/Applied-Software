package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AddPartFrame extends JFrame{
	
	private JPanel textPanel;
	private JPanel buttonPanel;
	
	private JTextField nameField;
	private JTextField numberField;
	private JTextField vendorField;
	private JTextField quantityField;

	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel vendorLabel;	
	private JLabel quantityLabel;
	private JLabel infoLabel;
	
	private JButton confirmButton;
	private JButton cancelButton;
	
	public AddPartFrame() {
		
		textPanel = new JPanel(new SpringLayout());
		buttonPanel = new JPanel();
		
		nameField = new JTextField(20);
		numberField = new JTextField(20);
		vendorField = new JTextField(20);
		quantityField = new JTextField(20);

		nameLabel = new JLabel("Part Name");
		numberLabel = new JLabel("Part #");
		vendorLabel = new JLabel("Vendor");
		quantityLabel = new JLabel("Quantity");
		infoLabel = new JLabel("information goes here");
		
				
		confirmButton = new JButton("Confirm");
		cancelButton = new JButton("Cancel");

		confirmButton.setActionCommand("Confirm");
		cancelButton.setActionCommand("Cancel");

		this.setLayout(new GridLayout(2, 1));

		this.add(textPanel);
		
		textPanel.add(nameLabel);
		textPanel.add(nameField);

		
		textPanel.add(numberLabel);
		textPanel.add(numberField);

		textPanel.add(vendorLabel);
		textPanel.add(vendorField);

		textPanel.add(quantityLabel);		
		textPanel.add(quantityField);
		
		this.add(buttonPanel);
		
		buttonPanel.add(confirmButton);
		buttonPanel.add(cancelButton);
		
		infoLabel.setLocation(10, 5);
		this.add(infoLabel);

		SpringUtilities.makeCompactGrid(textPanel,
		                                4, 2, 		//rows, cols
		                                6, 6,       //initX, initY
		                                6, 6);      //xPad, yPad
        setTitle("Add Part");
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation((screenWidth/2 + 20),(screenHeight/2 + 20));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

	}
	
	public void addPartFrameButtonListener(ActionListener listener1){
		confirmButton.addActionListener(listener1);
		cancelButton.addActionListener(listener1);
		
	}

	public String getName(){
		
		return nameField.getText();
		
	}
	
	public String getNumber(){
		
		return numberField.getText();
		
	}

	public String getVendor(){
	
		return vendorField.getText();
	
	}
	
	public String getQuantity(){
		
		return quantityField.getText();
		
	}
	
	public String getInfoLabel(){
		return infoLabel.getText();
	}
	public void setInfoLabel(String newLabel){
		infoLabel.setText(newLabel);
	}


}

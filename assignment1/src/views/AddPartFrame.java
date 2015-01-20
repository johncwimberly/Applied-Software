package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	
	private JButton confirmButton;
	private JButton cancelButton;
	
	public AddPartFrame() {
		
		textPanel = new JPanel(new SpringLayout());
		buttonPanel = new JPanel();
		
		nameField = new JTextField(20);
		numberField = new JTextField(20);
		vendorField = new JTextField(20);
		quantityField = new JTextField(20);

		nameLabel = new JLabel("Part");
		numberLabel = new JLabel("Number");
		vendorLabel = new JLabel("Vendor");
		quantityLabel = new JLabel("Quantity");
				
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

		SpringUtilities.makeCompactGrid(textPanel,
		                                4, 2, 		//rows, cols
		                                6, 6,       //initX, initY
		                                6, 6);      //xPad, yPad
        pack();

        setVisible(true);
        setTitle("Add Part");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation((screenWidth/2 + 20),(screenHeight/2 + 20));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void addPartFrameButtonListener(ActionListener listener1){
		confirmButton.addActionListener(listener1);
		cancelButton.addActionListener(listener1);
		
	}

	public String getPartNumber(){
		return null;
	}
	


}

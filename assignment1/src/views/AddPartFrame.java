package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AddPartFrame extends JFrame{
	
	
	public AddPartFrame() {
//		//JPanel pane = (JPanel) getContentPane();
//       // GroupLayout gl = new GroupLayout(pane);
//        //pane.setLayout(gl);
//        
////        pane.setToolTipText("Content pane");
//
//		JPanel panel = new JPanel();
//		this.add(panel);
//        
//		JLabel partNumber = new JLabel("Part Number:");
//        //info.setToolTipText("maybe some additional part info?");
//        panel.add(partNumber);
//        
//       // JTextField textField = new JTextField();
//        //panel.add(textField);
//        JTextArea numberArea = new JTextArea(1, 20);
//        panel.add(numberArea);
//        
//        JLabel partName = new JLabel("Part Number:");
//        panel.add(partName);
//        
//        JTextArea nameArea = new JTextArea(1, 20);
//        panel.add(nameArea);
//        gl.setAutoCreateContainerGaps(true);
//        
//        gl.setHorizontalGroup(gl.createSequentialGroup()
//                .addComponent(info)
//                .addGap(200)
//        );
//
//        gl.setVerticalGroup(gl.createSequentialGroup()
//                .addComponent(info)
//                .addGap(200)
//        );
		this.setLayout(new GridLayout(2,1));
		String[] labels = {"Part Number: ", "Part Name: ", "Vendor: ", "Quantity: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		this.add(p);
		for (int i = 0; i < numPairs; i++) {
		    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
		    p.add(l);
		    JTextField textField = new JTextField(20);
		    l.setLabelFor(textField);
		    p.add(textField);
		}

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
		                                numPairs, 2, //rows, cols
		                                6, 6,        //initX, initY
		                                6, 6);       //xPad, yPad
		p.setOpaque(true);
		//setContentPane(p);

		JPanel buttonPanel = new JPanel();
		this.add(buttonPanel);
		JButton button1 = new JButton("Confirm");
		JButton button2 = new JButton("Cancel");

		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.setOpaque(true);
		//setContentPane(buttonPanel);
		
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

}

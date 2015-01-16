package views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailsFrame extends JFrame{
	
	
	public DetailsFrame() {
		JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        
//        pane.setToolTipText("Content pane");

        JLabel info = new JLabel("Some Info goes here!");
        info.setToolTipText("maybe some additional part info?");

        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(info)
                .addGap(200)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(info)
                .addGap(200)
        );
        
        pack();

        setVisible(true);
        setTitle("Part Info");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation((screenWidth/2 + 20),(screenHeight/2 + 20));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}

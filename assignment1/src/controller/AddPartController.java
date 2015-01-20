package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import views.AddPartFrame;
import views.MainFrame;

public class AddPartController implements ActionListener{

	private Model model;
	private AddPartFrame view;
		
	public AddPartController(Model model, AddPartFrame view) {

		this.model = model;
		this.view = view;
		
		view.addPartFrameButtonListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String viewAction = e.getActionCommand();
		
		if(viewAction.equals("Confirm")){
			String partNum = view.getName();
			String partName = view.getNumber();
			String vendor = view.getVendor();
			int quantity = Integer.parseInt(view.getQuantity());
			model.addPart(partNum, partName, vendor, quantity);
			System.out.println(model.getPartList());
		}		
	}
}

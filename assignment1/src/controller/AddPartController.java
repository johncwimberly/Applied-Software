package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.Part;
import views.AddPartFrame;
import views.MainFrame;

public class AddPartController implements ActionListener{

	private Model model;
	private AddPartFrame view;
	private MainFrame view2;

	public AddPartController(Model model, AddPartFrame view, MainFrame view2) {

		this.model = model;
		this.view = view;
		this.view2 = view2;
		
		view.addPartFrameButtonListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String viewAction = e.getActionCommand();
		
		if(viewAction.equals("Confirm")){
			
			String partName = view.getName();
			String partNum = view.getNumber();
			String vendor = view.getVendor();
			int quantity = Integer.parseInt(view.getQuantity());
			
			Part part = model.addPart(partNum, partName, vendor, quantity);
			view2.addEntry(part);
			System.out.println(model.getPartList());
		
		}		
	}
	
	private void verifyPartNum(String partNum){
		char[] nonValid = {';', ':', ' ', '[', ']', '{', '}', '\"', '\'', '?', '/', '<', '>', ',', '.'};
		for(char character: nonValid){
			if(partNum.indexOf(character) >= 0){
				//invalid string for part number
				System.out.println("PartNum contains invalid character");
				return;
			}
		}
	}
	
}

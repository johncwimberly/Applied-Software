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
	
	char[] NEVERVALID = {';', ':', ' ', '[', ']', '{', '}', '\"', '\'', '?', '/', '<', '>', ',', '.', '(', ')', '|', '\\', '!', '@',
			'#', '$', '%', '^', '&', '*', '	', '-', '_', '+', '='};
	char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public AddPartController(Model model, AddPartFrame view, MainFrame view2) {

		this.model = model;
		this.view = view;
		this.view2 = view2;
		
		view.addPartFrameButtonListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		String viewAction = e.getActionCommand();
		//clear the label on every new attempt
		view.setInfoLabel("");
		
		if(viewAction.equals("Confirm")){
			
			String partName = view.getName();
			String partNum = view.getNumber();
			String vendor = view.getVendor();
			String strQuantity = view.getQuantity();
			//@TODO
			//int intQuantity;
			int quantity = Integer.parseInt(view.getQuantity());
			
			if(!verifyPartName(partName) ){ return; }
			if(!verifyPartNum(partNum) ){ return; }
			if(!verifyVendor(partNum) ){ return; }
			//@TODO
			//if(!(intQuantity = verifyQuantity(strQuantity)) ){ return; }
			
			
			Part part = model.addPart(partNum, partName, vendor, quantity);
			view2.addEntry(part);
			System.out.println(model.getPartList());
		
		}		
	}

	/* returns false if failed, and true if successful and sets the info label
	 * for corresponding field	*/
	private boolean verifyPartNum(String partNum){
		for(char character: NEVERVALID){
			if(partNum.indexOf(character) >= 0){
				view.setInfoLabel("Part Number contains invalid characters!");
				return false; 
			}
		}
		return true;
	}
	
	private boolean verifyPartName(String partName){
		for(char character: NEVERVALID){
			if(partName.indexOf(character) >= 0){
				view.setInfoLabel("Part Name contains invalid characters!");
				return false; 
			}
		}
		for(char character: NUMBERS){
			if(partName.indexOf(character) >= 0){
				view.setInfoLabel("Part Name cannot contain numbers!");
				return false; 
			}
		}
		return true;
	}
	
	private boolean verifyVendor(String vendor) {
		for(char character: NEVERVALID){
			if(vendor.indexOf(character) >= 0){
				view.setInfoLabel("Vendor contains invalid characters!");
				return false; 
			}
		}
		return true;
	}
	
	
	private int verifyQuantity(String strQuantity) {
		//@TODO
		return 0;
	}
	
}

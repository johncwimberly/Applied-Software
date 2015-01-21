package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Model;
import model.Part;
import views.AddPartFrame;
import views.MainFrame;

public class AddPartController implements ActionListener{

	private Model model;
	private AddPartFrame view;
	private MainFrame view2;
	private ArrayList<Part> partList = null;
	
	char[] NEVERVALID = {';', ':', ' ', '[', ']', '{', '}', '\"', '\'', '?', '/', '<', '>', ',', '.', '(', ')', '|', '\\', '!', '@',
			'#', '$', '%', '^', '&', '*', '	', '-', '_', '+', '='};
	char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public AddPartController(Model model, AddPartFrame view, MainFrame view2) {

		this.model = model;
		this.view = view;
		this.view2 = view2;
		partList = model.getPartList();
		
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
			int intQuantity;
			
			if(!verifyPartName(partName) ){ return; }
			if(!verifyPartNum(partNum) ){ return; }
			if(!verifyVendor(partNum) ){ return; }
			intQuantity = verifyQuantity(strQuantity);
			if(intQuantity == -1){ return; }
			
			
			Part part = model.addPart(partNum, partName, vendor, intQuantity);
			view2.addEntry(part);
			System.out.println(model.getPartList());
		
		}
		if(viewAction.equalsIgnoreCase("Cancel")){
			view.dispose();
		}
	}

	/* returns false if failed, and true if successful and sets the info label
	 * for corresponding field	*/
	private boolean verifyPartNum(String partNum){
		for(Part part: partList){
			if(part.getPartNum().equalsIgnoreCase(partNum)){
				view.setInfoLabel("A part with this 'Part Number' already exists!");
				return false;
			}
		}
		for(char character: NEVERVALID){
			if(partNum.indexOf(character) >= 0){
				view.setInfoLabel("Part Number contains invalid characters!");
				return false; 
			}
		}
		return true;
	}
	
	private boolean verifyPartName(String partName){
		for(Part part: partList){
			if(part.getPartName().equalsIgnoreCase(partName)){
				view.setInfoLabel("A part by this name already exists!");
				return false;
			}
		}
		
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
		int val;
		try {
            val = Integer.valueOf(strQuantity);
            if(val <= 0){
            	view.setInfoLabel("Quantity must be larger than 0");
            	return -1;
            }
            return val;
		} catch(NumberFormatException e) {
			view.setInfoLabel("Quantity must contain only numbers!");;
		}
		return -1;
	}
	
}

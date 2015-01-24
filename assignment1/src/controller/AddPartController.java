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
	
	Part partToEdit;
	int editFlag = 0;


	public AddPartController(Model model, AddPartFrame view, MainFrame view2, int flag) {

		this.model = model;
		this.view = view;
		this.view2 = view2;
		partList = model.getPartList();
		this.editFlag = flag;
		
		
		
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
			partList = model.getPartList();
			
			if(editFlag == 1 && partToEdit != null){
				if(!verifyEditPartName(partName) ){ return; }
				if(!verifyEditPartNum(partNum) ){ return; }
				intQuantity = verifyEditQuantity(strQuantity);
				if(intQuantity == -1){ return; }
				
				model.editPart(partToEdit, partNum, partName, vendor, intQuantity);
				Part newPart = new Part(partNum, partName, vendor, intQuantity);
				view2.editEntry(partToEdit, newPart);
				view.dispose();
				
			}
			else{
				if(!verifyPartName(partName) ){ return; }
				if(!verifyPartNum(partNum) ){ return; }
				intQuantity = verifyQuantity(strQuantity);
				if(intQuantity == -1){ return; }
				partList = model.getPartList();
				
				
				Part part = model.addPart(partNum, partName, vendor, intQuantity);
				view2.addEntry(part);
				System.out.println(model.getPartList());
				view.dispose();

			}
		
		}
		if(viewAction.equalsIgnoreCase("Cancel")){
			view.dispose();
		}
		
	}
	
	
	public void setEditPart(Part part){
		this.partToEdit = part;
	}
	/* returns false if failed, and true if successful and sets the info label
	 * for corresponding field	*/
	private boolean verifyPartNum(String partNum){
		if(partNum.length() < 1 || partNum.length() > 20){
			view.setInfoLabel("Must enter a valid Part Number!");
			return false;
		}
		if(partList.isEmpty()){
			return true;
		}
		for(Part part: partList){
			if(part.getPartNum().equalsIgnoreCase(partNum)){
				view.setInfoLabel("A part with this 'Part Number' already exists!");
				return false;
			}
		}
		return true;
	}
	
	private boolean verifyPartName(String partName){
		if(partName.length() < 1 || partName.length() > 255){
			view.setInfoLabel("Must enter a valid Part Name!");
			return false;
		}
		if(partList.isEmpty()){
			return true;
		}
		for(Part part: partList){
			if(part.getPartName().equalsIgnoreCase(partName)){
				view.setInfoLabel("A part by this name already exists!");
				return false;
			}
		}
		return true;
	}
	
	private int verifyQuantity(String strQuantity) {
		int val;
		try {
            val = Integer.valueOf(strQuantity);
            if(val <= 0 && editFlag == 0){
            	view.setInfoLabel("Quantity must be larger than 0");
            	return -1;
            }
            else if(val < 0){
            	view.setInfoLabel("Quantity cannot be less than 0");
            	return -1;
            }
            return val;
		} catch(NumberFormatException e) {
			view.setInfoLabel("Quantity must contain only numbers!");;
		}
		return -1;
	}
	
	private boolean verifyEditPartNum(String partNum){
		if(partToEdit.getPartNum() == partNum){
			return true;
		}else{
			for(Part part: partList){
				if(part.getPartNum().equalsIgnoreCase(partNum)){
					view.setInfoLabel("A part by this part number already exists!");
					return false;
				}
			}
		}
		if(partNum.length() < 1 || partNum.length() > 20){
			view.setInfoLabel("Must enter a Part Number of valid length! (1-20 characters)");
			return false;
		}
		return true;
	}
	
	private boolean verifyEditPartName(String partName){
		if(partToEdit.getPartName() == partName){
			System.out.println("THIS IS INSIDE VERIFYEDITPARTNAME-----");
			return true;
		}else{
			for(Part part: partList){
				if(part.getPartName().equalsIgnoreCase(partName)){
					view.setInfoLabel("A part by this name already exists!");
					return false;
				}
			}
		}
		if(partName.length() < 1 || partName.length() > 255){
			view.setInfoLabel("Must enter a Part Name of valid length! (1-255 characters)");
			return false;
		}
		return true;
	}
	private int verifyEditQuantity(String strQuantity) {
		int val;
		try {
            val = Integer.valueOf(strQuantity);
            if(val < 0){
            	view.setInfoLabel("Quantity cannot be less than 0");
            	return -1;
            }
            return val;
		} catch(NumberFormatException e) {
			view.setInfoLabel("Quantity must contain only numbers!");;
		}
		return -1;
	}
	
	
}

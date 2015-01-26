package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import model.Model;
import model.Part;
import views.AddPartFrame;
import views.MainFrame;

public class AddPartController implements ActionListener, WindowListener{

	private Model model;
	private AddPartFrame view;
	private MainFrame view2;
	private ArrayList<Part> partList = null;
	private Map<Part, AddPartFrame> mapOfViews;
	
	Part partToEdit;
	int editFlag = 0;


	public AddPartController(Model model, AddPartFrame view, MainFrame view2, int flag) {

		this.model = model;
		this.view = view;
		this.view2 = view2;
		partList = model.getPartList();
		this.editFlag = flag;
		
		
		
		view.addPartFrameButtonListener(this);
		view.addWindowListener(this);
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
				
				Part newPart = null;
				
				try {
					newPart = model.editPart(partToEdit, partNum, partName, vendor, intQuantity);
				} catch (IOException e1) {
					return;
				}
				
				view2.editEntry(partToEdit, newPart);
				System.out.println(model.getPartList());
				model.getMapOfViews().remove(partToEdit, view);
				view.dispose();
				
			}
			else{
				if(!verifyPartName(partName) ){ return; }
				if(!verifyPartNum(partNum) ){ return; }
				intQuantity = verifyQuantity(strQuantity);
				if(intQuantity == -1){ return; }
				partList = model.getPartList();
				
				
				Part part = null;
				
				try {
					part = model.addPart(partNum, partName, vendor, intQuantity);
				} catch (IOException e1) {
					e1.printStackTrace();
					return;
				}
				
				view2.addEntry(part);
				System.out.println(model.getPartList());
				view.dispose();

			}
		
		}
		if(viewAction.equalsIgnoreCase("Cancel")){
			model.removeMapping(partToEdit, view);
			view.dispose();
		}
		
	}
	
	
	public void setEditPart(Part part){
		this.partToEdit = part;
	}
	/* returns false if failed, and true if successful and sets the info label
	 * for corresponding field	*/
	private boolean verifyPartNum(String partNum){
		boolean fails;
		fails = partNum.matches(".*\\s.*");
		if(fails){
			view.setInfoLabel("Part Number cannot contain spaces!");
			return false;
		}
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
		boolean fails;
		fails = partName.matches(".*\\s.*");
		if(fails){
			view.setInfoLabel("Part Name cannot contain spaces!");
			return false;
		}
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
		boolean fails;
		fails = partNum.matches(".*\\s.*");
		if(fails){
			view.setInfoLabel("Part Name cannot contain spaces!");
			return false;
		}
		if(partToEdit.getPartNum().equals(partNum)){
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
		boolean fails;
		fails = partName.matches(".*\\s.*");
		if(fails){
			view.setInfoLabel("Part Name cannot contain spaces!");
			return false;
		}
		if(partToEdit.getPartName().equals(partName)){
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

	@Override
	public void windowActivated(WindowEvent arg0) {		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent windowEvent) {
		model.getMapOfViews().remove(partToEdit, view);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}
	
	@Override
	public void windowOpened(WindowEvent arg0) {
	}
	
	
}

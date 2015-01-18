package model;

import java.util.ArrayList;

public class Model {

	private ArrayList<Part> partList = null;
	
	public Model(){
		
		partList = new ArrayList<Part>();
		
	}
	
	public void addPart(String partNum, String partName, String vendor, int quantity){
		
		Part part = new Part(partNum, partName, vendor, quantity);
		partList.add(part);
	}
	
	public void deletePart(Part part){
		partList.remove(part);
	}
	
	public void editPart(Part part, String partNum, String partName, 
			String vendor, int quantity){
		
		part.setPartName(partName);
		part.setPartNum(partNum);
		part.setQuantity(quantity);
		part.setVendor(vendor);
	}
	
	public ArrayList<Part> getPartList(){
		return partList;
	}
}

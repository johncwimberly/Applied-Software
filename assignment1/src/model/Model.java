package model;

import java.util.ArrayList;
import main.*;

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
		
	}
	
	public void editPart(Part part){
		
	}
	
	public ArrayList<Part> getPartList(){
		return partList;
	}
}

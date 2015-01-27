package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import views.AddPartFrame;

public class Model {

	private ArrayList<Part> partList = null;
	
//	Test Parts
	private Part part1 = new Part("1", "screw", "Stuff and Stuff", 4);
	private Part part2 = new Part("2", "bolt", "Parts R Us", 4);

	private Map<Part, AddPartFrame> mapOfViews = null;

	public Model(){
		
		partList = new ArrayList<Part>();
		mapOfViews = new HashMap<Part, AddPartFrame>();
		
//		Test Parts added to list
		partList.add(part1);
		partList.add(part2);
	}
	
	public Part addPart(String partNum, String partName, String vendor, int quantity) throws IOException{		
		if(partNum.length() < 1 || partNum.length() > 20 || partNum.matches(".*\\s.*")){
			System.out.println("number 1");
			throw new IOException();
		}
		else if(partName.length() < 1 || partName.length() > 255 || partName.matches(".*\\s.*") || containsName(partName)){
			System.out.println("number 2");
			throw new IOException();
		}
		else if(vendor.length() > 255){
			System.out.println("number 3");
			throw new IOException();
		}
		else if(quantity < 1){
			System.out.println("number 4");
			throw new IOException();
		}
		Part part = new Part(partNum, partName, vendor, quantity);
		partList.add(part);
		return part;
	}
	
	private boolean containsName(String partName) {
		
		for(Part part : partList){
			if(partName.equals(part.getPartName())){
				return true;
			}
		}
		
		return false;
	}

	public void deletePart(Part part){
		System.out.println(partList.contains(part));
		partList.remove(part);
	}
	
	public Part editPart(Part part, String partNum, String partName, 
			String vendor, int quantity) throws IOException{
		

		if(part.getPartName().equals(partName)){
			if(partNum.length() < 1 || partNum.length() > 20 || partNum.matches(".*\\s.*")){
				throw new IOException();
			}
			else if(vendor.length() > 255){
				throw new IOException();
			}
			else if(quantity < 0){
				throw new IOException();
			}

		}

		else{
			if(partNum.length() < 1 || partNum.length() > 20 || partNum.matches(".*\\s.*")){
				throw new IOException();
			}
			else if(partName.length() < 1 || partName.length() > 255 || partName.matches(".*\\s.*") || containsName(partName)){
				throw new IOException();
			}
			else if(vendor.length() > 255){
				throw new IOException();
			}
			else if(quantity < 0){
				throw new IOException();
			}

		}

		part.setPartName(partName);
		part.setPartNum(partNum);
		part.setQuantity(quantity);
		part.setVendor(vendor);
		
		return part;
	}
	
	public ArrayList<Part> getPartList(){
		return partList;
	}
	
	public static String listParts(ArrayList<Part> list){
		String listString = "";
		for(int i = 0; i < list.size(); i++){
			listString += list.get(i);
		}
	
		return listString;
	}

	public Map<Part, AddPartFrame> getMapOfViews(){
		return mapOfViews;
	}
	
	public void setMapOfViews(Part part, AddPartFrame view){
		mapOfViews.put(part, view);
	}
	
	public void removeMapping(Part part, AddPartFrame view){
		mapOfViews.remove(part, view);
	}

}

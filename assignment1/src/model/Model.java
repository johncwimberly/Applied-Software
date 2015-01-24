package model;

import java.util.ArrayList;

public class Model {

	private ArrayList<Part> partList = null;
	
//	Test Parts
	private Part part1 = new Part("1", "screw", "Stuff and Stuff", 4);
	private Part part2 = new Part("2", "bolt", "Parts R Us", 4);

	public Model(){
		
		partList = new ArrayList<Part>();
		
//		Test Parts added to list
		partList.add(part1);
		partList.add(part2);
	}
	
	public Part addPart(String partNum, String partName, String vendor, int quantity){
		
		Part part = new Part(partNum, partName, vendor, quantity);
		partList.add(part);
		return part;
	}
	
	public void deletePart(Part part){
		System.out.println(partList.contains(part));
		partList.remove(part);
	}
	
	public Part editPart(Part part, String partNum, String partName, 
			String vendor, int quantity){
		
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
}

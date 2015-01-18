
public class Part {
	
	private String partNum = null;
	private String partName = null;
	private String vendor = null;
	private int quantity = 0;
	
	public Part(String partNum, String partName, String vendor, int quantity){
		
		this.partNum = partNum;
		this.partName = partName;
		this.vendor = vendor;
		this.quantity = quantity;
	}
}

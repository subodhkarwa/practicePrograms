package practicePrograms;

public class BinaryNode {

	int data;
	BinaryNode left;
	BinaryNode right;
	
	public BinaryNode(int data, BinaryNode left, BinaryNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString()
	{
		return "Node data :  " + data ;
	}	
	
	public static BinaryNode createSmallTree()
	{
		
		BinaryNode n7=new BinaryNode(7,null,null);
		BinaryNode n6=new BinaryNode(6,null,null);
		BinaryNode n5=new BinaryNode(5,null,null);
		BinaryNode n4=new BinaryNode(4,null,null);
		
		BinaryNode n2=new BinaryNode(2,n4, n5);
		BinaryNode n3=new BinaryNode(3,n6, n7);
		
		BinaryNode n1=new BinaryNode(1, n2, n3);
	
		return n1;		
	}

	
	public static BinaryNode createSmallBST() {

		/*			4
		 *		2      6
		 *	1	  3  5   7
		 * */
		BinaryNode n07 = new BinaryNode(7,null, null);
		BinaryNode n06 = new BinaryNode(5,null, null);
		BinaryNode n05 = new BinaryNode(3,null, null);
		BinaryNode n04 = new BinaryNode(1,null, null);

		BinaryNode n03 = new BinaryNode(6,n06, n07);
		BinaryNode n02 = new BinaryNode(2,n04, n05);

		BinaryNode n01 = new BinaryNode(4,n02, n03);

		return n01;
	}


}
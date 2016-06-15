package practicePrograms;

import org.junit.Assert;
import org.junit.Test;

public class IsTreeBinary {

	
	private boolean checkBinary(BinaryNode root) {
		//Handling extreme case
		if(root==null)
			return true;
		else				
			return isTreeBinary(root,Integer.MIN_VALUE,Integer.MAX_VALUE);	
	}


	/**
	 * @param node 
	 * @param minValue 
	 * @param maxValue
	 * @return boolean value based on the input
	 * 
	 * As in a BinaryTree left node has to be smaller than the root while right node has to be greater than the root,
	 * we are ensuring the same using two variables minValue and maxValue
	 *  
	 */

	private boolean isTreeBinary(BinaryNode node, int minValue, int maxValue) {

		if(node==null)
			return true;
		else if ( node.data < minValue || node.data > maxValue)
			return false;
		else
			return isTreeBinary(node.left,minValue,node.data) && isTreeBinary(node.right,node.data,maxValue); 
	}
	
	
	// ************************************** TEST CASES IN PURPOSEFULLY WRITTEN IN THE SAME CLASS  ********************************* // 
	@Test
	public void checkwithNonBinaryTree(){

		BinaryNode root=BinaryNode.createSmallTree();
		Assert.assertEquals(false,checkBinary(root));
	}

	@Test
	public void checkBinaryTree(){
		BinaryNode root=BinaryNode.createSmallBST();
		Assert.assertEquals(true,checkBinary(root));
	}

	@Test
	public void checkNull()
	{
		BinaryNode root=null;
		Assert.assertNotEquals(false,checkBinary(root));
	}
	
	@Test
	public void checkSingleNode()
	{
		BinaryNode root=new BinaryNode(10,null,null);
		Assert.assertEquals(true,checkBinary(root));
	}
	
	@Test
	public void verySmallNonBST()
	{
		/*
		 * 			10
		 * 		 5	     8
		 */
		BinaryNode n1=new BinaryNode(8,null,null);
		BinaryNode n2=new BinaryNode(5, null, null);
		
		BinaryNode root=new BinaryNode(10,n2,n1);
		Assert.assertEquals(false,checkBinary(root));
	}

	
	@Test
	public void verySmallBST()
	{
		/*
		 * 			8
		 * 		 5	    10
		 */
		BinaryNode n1=new BinaryNode(10,null,null);
		BinaryNode n2=new BinaryNode(5, null, null);
		
		BinaryNode root=new BinaryNode(8,n2,n1);
		Assert.assertEquals(true,checkBinary(root));
	}

	@Test
	public void LeftSkewedBST()
	{
		/*
		 * 			10
		 * 		 8
		 * 	5	
		 */
		BinaryNode n1=new BinaryNode(5,null,null);
		BinaryNode n2=new BinaryNode(8,n1, null);		
		BinaryNode root=new BinaryNode(10,n2,null);
		Assert.assertEquals(true,checkBinary(root));
	}
	
	@Test
	public void LeftSkewedNonBST()
	{
		/*
		 * 			10
		 * 		5	
		 * 	8	
		 */
		BinaryNode n2=new BinaryNode(8,null, null);		
		BinaryNode n1=new BinaryNode(5,n2,null);
		BinaryNode root=new BinaryNode(10,n1,null);
		Assert.assertEquals(false,checkBinary(root));
	}
	
	@Test
	public void RightSkewedBST()
	{
		/*
		 * 			5
		 * 		 		8
		 * 					10	
		 */
		
		BinaryNode n1=new BinaryNode(10,null,null);
		BinaryNode n2=new BinaryNode(8,null,n1);		
		BinaryNode root=new BinaryNode(5,null,n2);
		Assert.assertEquals(true,checkBinary(root));
	}
	
	@Test
	public void RightSkewedNonBST()
	{
		/*
		 * 			8
		 * 				10		
		 * 					5
		 */
		BinaryNode n1=new BinaryNode(5,null,null);
		BinaryNode n2=new BinaryNode(10,null,n1);		
		BinaryNode root=new BinaryNode(8,null,n2);
		Assert.assertEquals(false,checkBinary(root));
	}

}
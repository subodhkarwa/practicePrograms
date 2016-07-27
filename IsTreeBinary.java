package practicePrograms.practicePrograms;

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
		
		
		//Handling the cases for INT_MIN and INT_MAX
		if(node.data==INTEGER.MIN_VALUE && node.left!=null)
			return false;

		if(node.data==INTEGER.MAX_VALUE && node.right!=null)
			return false;
			
		else if ( node.data < minValue || node.data > maxValue)
			return false;
		else
			return isTreeBinary(node.left,minValue,node.data-1) && isTreeBinary(node.right,node.data+1,maxValue); 
	}
	
	
	// ************************************** TEST CASES IN PURPOSEFULLY WRITTEN IN THE SAME CLASS  ********************************* //
	
	@Test
	public void checkBinary_nonBinaryTree_false(){

		BinaryNode root=BinaryNode.createSmallTree();
		Assert.assertFalse(checkBinary(root));
	}


	@Test
	public void checkBinary_binaryTree_true(){
		BinaryNode root=BinaryNode.createSmallBST();
		Assert.assertTrue(checkBinary(root));
	}

	@Test
	public void checkBinary_nullTree_true()
	{
		BinaryNode root=null;
		Assert.assertTrue(checkBinary(root));
	}
	
	@Test
	public void checkBinary_singleNode_true()
	{
		BinaryNode root=new BinaryNode(10,null,null);
		Assert.assertTrue(checkBinary(root));
	}
	
	@Test
	public void checkBinary_smallNonBinary_false()
	{
		/*
		 * 			10
		 * 		 5	     8
		 */
		BinaryNode n1=new BinaryNode(8,null,null);
		BinaryNode n2=new BinaryNode(5, null, null);
		
		BinaryNode root=new BinaryNode(10,n2,n1);
		Assert.assertFalse(checkBinary(root));
	}

	
	@Test
	public void checkBinary_smallBinary_true()
	{
		/*
		 * 			8
		 * 		 5	    10
		 */
		BinaryNode n1=new BinaryNode(10,null,null);
		BinaryNode n2=new BinaryNode(5, null, null);
		
		BinaryNode root=new BinaryNode(8,n2,n1);
		Assert.assertTrue(checkBinary(root));
	}

	@Test
	public void checkBinary_LeftSkewedBST_true()
	{
		/*
		 * 			10
		 * 		 8
		 * 	5	
		 */
		BinaryNode n1=new BinaryNode(5,null,null);
		BinaryNode n2=new BinaryNode(8,n1, null);		
		BinaryNode root=new BinaryNode(10,n2,null);
		Assert.assertTrue(checkBinary(root));
	}
	
	@Test
	public void checkBinary_LeftSkewedNonBST_false()
	{
		/*
		 * 			10
		 * 		5	
		 * 	8	
		 */
		BinaryNode n2=new BinaryNode(8,null, null);		
		BinaryNode n1=new BinaryNode(5,n2,null);
		BinaryNode root=new BinaryNode(10,n1,null);
		Assert.assertFalse(checkBinary(root));
	}
	
	@Test
	public void checkBinary_RightSkewedBST_true()
	{
		/*
		 * 			5
		 * 		 		8
		 * 					10	
		 */
		
		BinaryNode n1=new BinaryNode(10,null,null);
		BinaryNode n2=new BinaryNode(8,null,n1);		
		BinaryNode root=new BinaryNode(5,null,n2);
		Assert.assertTrue(checkBinary(root));
	}
	
	@Test
	public void checkBinary_RightSkewedNonBST_false()
	{
		/*
		 * 			8
		 * 				10		
		 * 					5
		 */
		BinaryNode n1=new BinaryNode(5,null,null);
		BinaryNode n2=new BinaryNode(10,null,n1);		
		BinaryNode root=new BinaryNode(8,null,n2);
		Assert.assertFalse(checkBinary(root));
	}
}

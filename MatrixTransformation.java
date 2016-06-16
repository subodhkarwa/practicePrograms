package practicePrograms.practicePrograms;

//http://techieme.in/matrix-transformation-to-make-rows-and-columns-zero/

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTransformation {

	public static int squareArrayHappyCase[][]={{0,0,0},{0,1,0},{0,0,0}};
	public static int rectArrayHappyCase[][]={{0,0},{1,1},{0,0}};

	public static int squareArrayZero[][]={{0,0,0},{0,0,0},{0,0,0}};;
	public static int rectArrayZero[][]={{0,0},{0,0},{0,0}};

	public static int squareArrayOne[][]={{1,1,1},{1,1,1},{1,1,1}};
	public static int rectArrayOne[][]={{1,1},{1,1},{1,1}};

	public int[][] transformMatrix(int input[][])
	{
		if(input==null)
			return null;

		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input[0].length;j++)
			{
				if(input[i][j]==1)
				{
					markRow(input,i);
					markColumn(input,j);
				}
			}
		}
		
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input[0].length;j++)
			{
				if(input[i][j]==2)
					input[i][j]=1;
			}
		}
		
		return input;
	}	

	private void markColumn(int[][] input, int column) {
		for(int i=0;i<input.length;i++)
		{
				input[i][column]=2;
		}
	}

	private void markRow(int[][] input, int row) {
		for(int i=0;i<input[0].length;i++)
		{
					input[row][i]=2;
		}
	}

	
	@Test
	public void test_Null_true()
	{
		Assert.assertNull(transformMatrix(null));
	}	
	
	@Test
	public void test_SquareArrayEquals_true()
	{
		int b[][]={{0,1,0},{1,1,1},{0,1,0}};
		Assert.assertArrayEquals(transformMatrix(squareArrayHappyCase),b);
	}	

	@Test 
	public void test_SquareArrayZero_true()
	{
		int b[][]={{0,0,0},{0,0,0},{0,0,0}};
		Assert.assertArrayEquals(b,transformMatrix(squareArrayZero));
	}	

	@Test
	public void test_RectArrayZero_true()
	{
		int b[][]={{0,0},{0,0},{0,0}};
		Assert.assertArrayEquals(rectArrayZero,transformMatrix(rectArrayZero));
	}	

	@Test
	public void test_SquareArrayOne_true()
	{
		int b[][]={{1,1,1},{1,1,1},{1,1,1}};
		Assert.assertArrayEquals(b,transformMatrix(squareArrayOne));
	}	

	@Test
	public void test_RectArrayOne_true()
	{
		int b[][]={{1,1},{1,1},{1,1}};
		Assert.assertArrayEquals(b,transformMatrix(rectArrayOne));
	}	

	@Test
	public void test_SquareArrayEquals_false()
	{
		int b[][]={{0,1,0},{0,1,0},{0,1,1}};
		Assert.assertFalse(Arrays.equals(squareArrayHappyCase,b));  //A different way to check inEquality of two arrays
	}

	public void test_RectArrayEquals_true()
	{
		int b[][]={{1,1},{1,1},{1,1}};	
		Assert.assertArrayEquals(rectArrayHappyCase,b);
	}	

	@Test
	public void test_RectArrayEquals_false()
	{
		int b[][]={{1,1},{1,1},{1,0}};		
		Assert.assertFalse(Arrays.equals(rectArrayHappyCase,b));  //A different way to check inEquality of two arrays
	}

}
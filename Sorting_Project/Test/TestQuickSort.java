import static org.junit.Assert.*;

import org.junit.Test;

import sortImplementations.SortExperiment;

public class TestQuickSort {

	@Test
	public void testMedianMethod() 
	{
		int first = 1;
		int middle = 5; 
		int last = 9;
		assertEquals(5, SortExperiment.findMedian(first, middle, last));
	}
	@Test
	public void testQuickSort()
	{
		int [] correct = {1, 2, 3, 4, 5};
		int [] inCorrect = {5, 4, 3, 2, 1};
		
		int [] sortedArray = SortExperiment.quickSort(inCorrect, 0, inCorrect.length-1);
		
		for(int i = 0; i < correct.length; i++)
		{
			assertEquals(correct[i], sortedArray[i]);
		}
	}
	

	
}

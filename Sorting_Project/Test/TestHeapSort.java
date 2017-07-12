import static org.junit.Assert.*;

import org.junit.Test;

import sortImplementations.SortExperiment;

public class TestHeapSort 
{

	@Test
	public void testHeapSort() 
	{
		int [] correct = {1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11};
		int [] incorrect = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int [] sortedList = SortExperiment.heapSort(incorrect);
		
		for(int i = 0; i < correct.length; i++)
		{
			assertEquals(correct[i], sortedList[i]);
		}
	}
}

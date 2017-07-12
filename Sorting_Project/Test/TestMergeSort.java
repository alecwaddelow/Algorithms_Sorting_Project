import static org.junit.Assert.*;

import org.junit.Test;

import sortImplementations.SortExperiment;

/**
 * @author Alec Waddelow
 *
 */
public class TestMergeSort
{
	@Test
	public void testCompleteMergeSort()
	{
		int [] correct = {1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11};
		int [] incorrect = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int [] sortedList = SortExperiment.mergeSort(incorrect);
		
		for(int i = 0; i < correct.length; i++)
		{
			System.out.println(sortedList[i]);
			assertEquals(correct[i], sortedList[i]);
		}
	}

	@Test
	public void testMergeMethod()
	{
		int [] correct = {1, 2, 3, 4, 5, 7, 8, 9, 10 ,11};
		int [] listA = {2, 3, 8, 9};
		int [] listB = {1, 4, 5, 7, 10, 11};
		int [] mergedList = SortExperiment.merge(listA, listB);
		
		for(int i = 0; i < mergedList.length; i++)
		{
			assertEquals(correct[i], mergedList[i]);
		}
	}
}

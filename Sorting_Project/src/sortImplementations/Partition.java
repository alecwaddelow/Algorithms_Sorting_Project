package sortImplementations;

/**
 * Partition class to hold values and perform partitioning of input array
 * Performs Dijkstra's 3-way partition 
 * @author Alec Waddelow
 *
 */
public class Partition
{
	public int [] inputArray;
	public int start;
	public int end;
	public int pivot;
	
	public Partition(int [] inputArray, int start, int end, int pivot)
	{
		this.inputArray = inputArray;
		this.start = start;
		this.end = end;
		this.pivot = pivot;
	}
	
	/**
	 * Partitions the array
	 * @return inputArray
	 * 
	 */
	public int [] partitionArray()
	{
		int i = this.start;
		int j = this.start;
		int n = this.end;
		
		while(j <= n)
		{
			if(this.inputArray[j] < this.pivot)
			{
				SortExperiment.swap(this.inputArray, i, j);
				i++;
				j++;
			}
			else if(this.inputArray[j] > this.pivot)
			{
				SortExperiment.swap(this.inputArray, j, n);
				n--;
			}
			else
			{
				j++;
			}
		}
		this.start = i;
		this.end = j;
		return this.inputArray;
	}
}
package sortImplementations;

import java.io.*;
import java.util.*;

/**
 * This class performs all three sorts (MergeSort, QuickSort, and HeapSort) and writes the result 
 * times to files within a directory called DataLog
 * 
 * @author Alec Waddelow
 *
 */
public class SortExperiment
{
	/**
	 * Main function
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		mergeSortWriteResultsToFile();
		quickSortWriteResultsToFile();
		heapSortWriteResultsToFile();
	}

	/**
	 * Writes MergeSort timing results to new files in DataLog folder 
	 * 	Creates DataLog directory if it doesn't already exist
	 * 
	 * @throws IOException
	 */
	public static void mergeSortWriteResultsToFile() throws IOException
	{
		File topDirectory = new File("TestData");
		File outputDirectory = new File("DataLog");
		if(!outputDirectory.exists())
		{
			outputDirectory.mkdir();
		}
		for(File subDir : topDirectory.listFiles())								//iterates through all of the test data directories
		{
			Map<String, Long> resultMap = new HashMap<String, Long>();			//holds file names and resulting sort times

			for(File file : subDir.listFiles())									//iterates through all of the test data files 
			{
				long runTime = 0;
				String fileName = file.getName();

				ArrayList<Integer> listOfData = new ArrayList<Integer>();		//holds data from file read in

				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String fileLine = fileReader.readLine();
				while(fileLine != null)
				{
					listOfData.add(Integer.parseInt(fileLine));					//add number from file to list
					fileLine = fileReader.readLine();
				}
				int [] readInData = new int[listOfData.size()];
				
				for(int i = 0; i < listOfData.size(); i++)						//convert arrayList to array for sorts to work with
				{
					readInData[i] = listOfData.get(i);
				}
				
				runTime = System.currentTimeMillis();
				mergeSort(readInData);											//where actual sorting occurs
				runTime = System.currentTimeMillis() - runTime;					//capture run time 
				
				resultMap.put(fileName, runTime);								//add results to map
				fileReader.close();
			}

			File targetDirectory = new File(outputDirectory, "MergeSort_"  + subDir.getName() + "_Run_Times");
			targetDirectory.mkdir();
			File targetFile = new File(targetDirectory, "Run_Times.csv");
			FileWriter fw = new FileWriter(targetFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Map.Entry<String, Long> entry : resultMap.entrySet())
			{
				bw.write(entry.getKey() + "," + String.valueOf(entry.getValue()));
				bw.newLine();
			}
			bw.close();
		}
	}

	/**
	 * Writes QuickSort timing results to new files in DataLog folder
	 * 
	 * @throws IOException
	 */
	public static void quickSortWriteResultsToFile() throws IOException
	{
		File topDirectory = new File("TestData");
		File outputDirectory = new File("DataLog");
		for(File subDir : topDirectory.listFiles())
		{
			Map<String, Long> resultMap = new HashMap<String, Long>();			//holds file names and resulting sort times

			for(File file : subDir.listFiles())
			{
				long runTime = 0;
				String fileName = file.getName();

				ArrayList<Integer> listOfData = new ArrayList<Integer>();		//holds data from file read in

				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String fileLine = fileReader.readLine();
				while(fileLine != null)
				{
					listOfData.add(Integer.parseInt(fileLine));
					fileLine = fileReader.readLine();
				}
				int [] readInData = new int[listOfData.size()];
				
				for(int i = 0; i < listOfData.size(); i++)
				{
					readInData[i] = listOfData.get(i);
				}				
				
				runTime = System.currentTimeMillis();
				quickSort(readInData, 0, readInData.length-1);
				runTime = System.currentTimeMillis() - runTime;					//capture run time 
				
				resultMap.put(fileName, runTime);								//add results to map
				fileReader.close();
			}

			File targetDirectory = new File(outputDirectory, "TestQuickSort_"  + subDir.getName() + "_Run_Times");
			targetDirectory.mkdir();
			File targetFile = new File(targetDirectory, "Run_Times.csv");
			FileWriter fw = new FileWriter(targetFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Map.Entry<String, Long> entry : resultMap.entrySet())
			{
				bw.write(entry.getKey() + "," + String.valueOf(entry.getValue()));
				bw.newLine();
			}
			bw.close();
		}
	}
	
	/**
	 * Writes HeapSort timing results to files in DataLog folder 
	 * 
	 * @throws IOException
	 */
	public static void heapSortWriteResultsToFile() throws IOException
	{
		File topDirectory = new File("TestData");
		File outputDirectory = new File("DataLog");
		for(File subDir : topDirectory.listFiles())
		{
			Map<String, Long> resultMap = new HashMap<String, Long>();			//holds file names and resulting sort times

			for(File file : subDir.listFiles())
			{
				long runTime = 0;
				String fileName = file.getName();

				ArrayList<Integer> listOfData = new ArrayList<Integer>();		//holds data from file read in

				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String fileLine = fileReader.readLine();
				while(fileLine != null)
				{
					listOfData.add(Integer.parseInt(fileLine));
					fileLine = fileReader.readLine();
				}
				int [] readInData = new int[listOfData.size()];
				
				for(int i = 0; i < listOfData.size(); i++)
				{
					readInData[i] = listOfData.get(i);
				}				
				
				runTime = System.currentTimeMillis();
				heapSort(readInData);											//where heapSort occurs
				runTime = System.currentTimeMillis() - runTime;					//capture run time 
				
				resultMap.put(fileName, runTime);								//add results to map
				fileReader.close();
			}

			File targetDirectory = new File(outputDirectory, "TestHeapSort"  + subDir.getName() + "_Run_Times");
			targetDirectory.mkdir();
			File targetFile = new File(targetDirectory, "Run_Times.csv");
			FileWriter fw = new FileWriter(targetFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Map.Entry<String, Long> entry : resultMap.entrySet())
			{
				bw.write(entry.getKey() + "," + String.valueOf(entry.getValue()));
				bw.newLine();
			}
			bw.close();
		}
	}
	
	/**
	 * Sorts array by creating heap then deleting nodes from it 
	 * 
	 * @param inputArray
	 * @return sorted outputArray
	 */
	public static int [] heapSort(int [] inputArray)
	{
		int length = inputArray.length;
		int [] outputArray = null;
		
		for(int i = (length/2)-1; i >= 0; i--)
		{
			createHeap(inputArray, length, i);
		}
		
		for(int i = length-1; i >= 0; i--)
		{
			outputArray = swap(inputArray, 0, i);
			createHeap(outputArray, i, 0);
		}
		return outputArray;
	}
	
	/**
	 * Recursive method that transforms array into heap
	 * 
	 * @param inputArray
	 * @param length
	 * @param i
	 */
	private static void createHeap(int[] inputArray, int length, int i) 
	{
		int root = i;
		int left = (2 * i) + 1;
		int right = (2* i) + 2;
		int [] outputArray = null;
		
		if((left < length) && (inputArray[left] > inputArray[root]))
		{
			root = left;
		}
		
		if((right < length) && inputArray[right] > inputArray[root])
		{
			root = right;
		}
		
		if(root != i)
		{
			outputArray = swap(inputArray, i, root);
			createHeap(outputArray, length, root);
		}
	}
	

	/**
	 * Recursive QuickSort implementation using 3-way partition and median of 3 pivot selection
	 * 
	 * @param inputList
	 * @return
	 */
	public static int [] quickSort(int[] inputList, int start, int end) 
	{
		if(start < end)
		{
			int middle = inputList[((end - start)/2) + start];
			int pivot = findMedian(inputList[start], inputList[middle], inputList[end]);

			Partition part = new Partition(inputList, start, end, pivot);
			inputList = part.partitionArray();
			
			int newStart = part.start;
			int newEnd = part.end;
			
			quickSort(inputList, start, newStart-1);
			quickSort(inputList, newEnd, end);
		}
		return inputList;
	}
	
	/**
	 * Finds median value of three integers
	 * 
	 * @param first
	 * @param middle
	 * @param last
	 * @return median value 
	 */
	public static int findMedian(int first, int middle, int last)
	{
		int median = (first + middle + last) - Math.min(Math.min(first,middle),last) - Math.max(Math.max(first,middle),last);
		return median;
	}
	
	/**
	 * Swap function to swap array indexes
	 * 
	 * @param input
	 * @param i
	 * @param j
	 * @return swapped input array
	 */
	public static int [] swap (int[] input, int i, int j)
	{
		int temp = input[i]; 
		input[i] = input[j];
		input[j] = temp;
		return input;
	}

	/**
	 * Recursive mergeSort method 
	 * 
	 * @param inputList
	 * @return sorted list
	 */
	public static int[] mergeSort(int[] inputListA)
	{
		int lengthOfArray = inputListA.length;
		int listBLength = lengthOfArray/2;
		int listCLength = lengthOfArray - listBLength;
		
		int [] listB = new int [listBLength];
		int [] listC = new int [listCLength];
		
		if(lengthOfArray <= 1)
		{
			return inputListA;
		}
		
		for(int i = 0; i < listBLength; i ++)
		{
			listB[i] = inputListA[i];
		}
		for(int i = listBLength; i < listBLength + listCLength; i++)
		{
			listC[i - listBLength] = inputListA[i];
		}
		
		listB = mergeSort(listB);
		listC = mergeSort(listC);
		return merge(listB, listC);
	}

	/**
	 * Merge method
	 * 	Merges two sorted arrays
	 * 
	 * @param listA
	 * @param listB
	 * @return sorted outputList
	 */
	public static int [] merge(int [] listA, int [] listB)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		int listALength = listA.length;
		int listBLength = listB.length;
		int [] outputList = new int [listALength + listBLength];
		
		while(i < listALength && j < listBLength)
		{
			if(listA[i] < listB[j])
			{
				outputList[k] = listA[i];
				i++;
			}
			else
			{
				outputList[k] = listB[j];
				j++;
			}
			k++;
		}
		
		if (i == listALength)
		{
			System.arraycopy(listB, j, outputList, k, listBLength - j);
		}
		else if (j == listBLength)
		{
			System.arraycopy(listA, i, outputList, k, listALength - i);
		}
		return outputList;
	}
}
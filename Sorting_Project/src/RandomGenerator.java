import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @author alec.waddelow
 *
 */
public class RandomGenerator
{
	/**
	 * Main function
	 * @param args not used
	 * @throws IOException shouldn't
	 */
	public static void main(String[] args) throws IOException
	{
		writeToFile_10000_numbers();
		sortSmallLists();
		reverseSortSmallLists();
		writeToFile_100000_numbers();
		sortMediumLists();
		reverseSortMediumLists();
		writeToFile_1000000_numbers();
		sortLargeLists();
		reverseSortLargeLists();
	}

	/**
	 * Creates large random lists 
	 * @throws IOException
	 */
	public static void writeToFile_1000000_numbers() throws IOException
	{
		File directory = new File("../largeFiles");
		directory.mkdir();
		for(int i = 0; i < 30; i++)
		{
			String fileName = "random_Large_Unsorted_list" + i;
			File endFile = new File(directory, fileName);
			FileWriter fw = new FileWriter(endFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int j = 0; j < 1000000; j++)
			{
				int randomNumber = ThreadLocalRandom.current().nextInt(10000);
				bw.write(String.valueOf(randomNumber));
				bw.newLine();
			}
			bw.close();
			fw.close();
		}
	}
	
	/**
	 * Creates medium random lists 
	 * @throws IOException
	 */
	public static void writeToFile_100000_numbers() throws IOException
	{
		File directory = new File("../mediumFiles");
		directory.mkdir();
		for(int i = 0; i < 30; i++)
		{
			String fileName = "random_Medium_Unsorted_list" + i;
			File endFile = new File(directory, fileName);
			FileWriter fw = new FileWriter(endFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int j = 0; j < 100000; j++)
			{
				int randomNumber = ThreadLocalRandom.current().nextInt(10000);
				bw.write(String.valueOf(randomNumber));
				bw.newLine();
			}
			bw.close();
			fw.close();
		}
	}
	
	/**
	 * creates small random lists 
	 * @throws IOException shouldn't
	 */
	public static void writeToFile_10000_numbers() throws IOException
	{
		File directory = new File("../smallFiles");
		directory.mkdir();
		for(int i = 0; i < 30; i++)
		{
			String fileName = "random_Small_Unsorted_List" + i;
			File endFile = new File(directory, fileName);
			FileWriter fw = new FileWriter(endFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j = 0; j < 10000; j++)
			{
				int randomNumber = ThreadLocalRandom.current().nextInt(10000);
				bw.write(String.valueOf(randomNumber));
				bw.newLine();
			}
			bw.close();
			fw.close();
		}
	}
	
	/**
	 * Sorts large random lists 
	 * @throws IOException
	 */
	public static void sortLargeLists() throws IOException
	{
		File newDirectory = new File("../sortedLargeLists");
		newDirectory.mkdir();
		
		File dir = new File("../largeFiles");
		
		for(File file : dir.listFiles())
		{
			List<Integer> largeOrderedList = new ArrayList<Integer>();
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String fileLine = fileReader.readLine();
			while(fileLine != null)
			{
				largeOrderedList.add(Integer.parseInt(fileLine));
				fileLine = fileReader.readLine();
			}
			
			Collections.sort(largeOrderedList);
			String fileName = "sorted_" + file.getName();
			File newFile = new File(newDirectory, fileName);
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Integer line : largeOrderedList)
			{
				bw.write(String.valueOf(line));
				bw.newLine();
			}
			bw.close();
			fw.close();
			fileReader.close();
		}
	}
	
	/**
	 * Creates reverse sorted large list 
	 * @throws IOException
	 */
	public static void reverseSortLargeLists() throws IOException
	{
		File newDirectory = new File("../reverseSortedLargeLists");
		newDirectory.mkdir();
		
		File targerDirectory = new File("../sortedLargeLists");
		
		for (File file : targerDirectory.listFiles())
		{
			List<Integer> largeReverseOrderedList = new ArrayList<Integer>();
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String fileLine = fileReader.readLine();
			while (fileLine != null)
			{
				largeReverseOrderedList.add(Integer.parseInt(fileLine));
				fileLine = fileReader.readLine();
			}
			Collections.reverse(largeReverseOrderedList);
			String fileName = "reverse_" + file.getName();
			File newFile = new File(newDirectory, fileName);
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Integer line : largeReverseOrderedList)
			{
				bw.write(String.valueOf(line));
				bw.newLine();
			}
			bw.close();
			fw.close();
			fileReader.close();
		}
	}
	
	/**
	 * Sorts medium lists 
	 * @throws IOException
	 */
	public static void sortMediumLists() throws IOException
	{
		File newDirectory = new File("../sortedMediumLists");
		newDirectory.mkdir();
		
		File dir = new File("../mediumFiles");
		
		for(File file : dir.listFiles())
		{
			List<Integer> mediumOrderedList = new ArrayList<Integer>();
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String fileLine = fileReader.readLine();
			while(fileLine != null)
			{
				mediumOrderedList.add(Integer.parseInt(fileLine));
				fileLine = fileReader.readLine();
			}
			
			Collections.sort(mediumOrderedList);
			String fileName = "sorted_" + file.getName();
			File newFile = new File(newDirectory, fileName);
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Integer line : mediumOrderedList)
			{
				bw.write(String.valueOf(line));
				bw.newLine();
			}
			bw.close();
			fw.close();
			fileReader.close();
		}
	}
	/**
	 * Creates ordered small lists 
	 * @throws IOException
	 */
	public static void sortSmallLists() throws IOException
	{
		File newDirectory = new File("../sortedSmallLists");
		newDirectory.mkdir();
		
		File dir = new File("../smallFiles");
			
		for(File file : dir.listFiles())
		{
			List<Integer> smallOrderedList = new ArrayList<Integer>();
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String fileLine = fileReader.readLine();  					// read first line 
			while(fileLine != null)
			{
				smallOrderedList.add(Integer.parseInt(fileLine));		//add new line to list 
				fileLine = fileReader.readLine();						//advance to next line 
			}
			
			Collections.sort(smallOrderedList);
			String fileName = "sorted_" + file.getName();
			File newFile = new File(newDirectory, fileName);
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Integer line : smallOrderedList)
			{
				bw.write(String.valueOf(line));
				bw.newLine();
			}
			bw.close();
			fw.close();
			fileReader.close();
		}
	}
	
	/**
	 * Creates reverse ordered medium lists 
	 * @throws IOException
	 */
	public static void reverseSortMediumLists() throws IOException
	{
		File newDirectory = new File("../reverseSortedMediumLists");
		newDirectory.mkdir();
		
		File targerDirectory = new File("../sortedMediumLists");
		
		for (File file : targerDirectory.listFiles())
		{
			List<Integer> mediumReverseOrderedList = new ArrayList<Integer>();
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String fileLine = fileReader.readLine();
			while (fileLine != null)
			{
				mediumReverseOrderedList.add(Integer.parseInt(fileLine));
				fileLine = fileReader.readLine();
			}
			Collections.reverse(mediumReverseOrderedList);
			String fileName = "reverse_" + file.getName();
			File newFile = new File(newDirectory, fileName);
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Integer line : mediumReverseOrderedList)
			{
				bw.write(String.valueOf(line));
				bw.newLine();
			}
			bw.close();
			fw.close();
			fileReader.close();
		}
	}
	
	/**
	 * Creates reverse ordered small lists 
	 * @throws IOException
	 */
	public static void reverseSortSmallLists() throws IOException
	{
		File newDirectory = new File("../reverseSortedSmallLists");
		newDirectory.mkdir();
		
		File targetDirectory = new File("../sortedSmallLists");
		
		for(File file : targetDirectory.listFiles())
		{
			List<Integer> smallReverseOrderedList = new ArrayList<Integer>();
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String fileLine = fileReader.readLine();
			while(fileLine != null)
			{
				smallReverseOrderedList.add(Integer.parseInt(fileLine));
				fileLine = fileReader.readLine();
			}
			Collections.reverse(smallReverseOrderedList);
			String fileName = "reverse_" + file.getName();
			File newFile = new File(newDirectory, fileName);
			FileWriter fw = new FileWriter(newFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Integer line : smallReverseOrderedList)
			{
				bw.write(String.valueOf(line));
				bw.newLine();
			}
			bw.close();
			fw.close();
			fileReader.close();
		}
	}
}

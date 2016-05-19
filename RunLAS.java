

import java.io.*;
import java.util.*;

public class RunLAS {
	public static void main(String[] args) {
		LinkedList<Integer> sourceData = new LinkedList<>();
		int runtimeCounter = 0;
		int count = 1;
		// while (count <= 1000) {
		// 	sourceData.add(randomWithRange(1, 1000));
		// 	count++;
		// }

		int[] x = {2,6,10,18,5,7,3,2,10,20,8,7,19,4,6,7,11,12,18,12,11,12};
		int[] y = {9,15,6,7,17,2,20,15,18,19,7,6,5,15,20,15,8,1,9,10};

		for(int i = 0;i<x.length;i++)
			sourceData.add(x[i]);

		/*sourceData.add(2);
		sourceData.add(6);
		sourceData.add(10);
		sourceData.add(18);
		sourceData.add(5);
		sourceData.add(7);
		sourceData.add(3);
		sourceData.add(2);
		sourceData.add(10);
		sourceData.add(20);
		sourceData.add(8);
		sourceData.add(7);
		sourceData.add(19);
		sourceData.add(4);
		sourceData.add(6);
		sourceData.add(7);
		sourceData.add(11);
		sourceData.add(12);
		sourceData.add(18);
		sourceData.add(12);*/

		/*sourceData.add(9);
		sourceData.add(15);
		sourceData.add(6);
		sourceData.add(7);
		sourceData.add(17);
		sourceData.add(2);
		sourceData.add(20);
		sourceData.add(15);
		sourceData.add(18);
		sourceData.add(19);
		sourceData.add(7);
		sourceData.add(6);
		sourceData.add(5);
		sourceData.add(15);
		sourceData.add(20);
		sourceData.add(15);
		sourceData.add(8);
		sourceData.add(1);
		sourceData.add(9);
		sourceData.add(10);*/

		
		int c = 2;

		int[] LAS = new LasProcessor(sourceData, c, runtimeCounter).generateLAS();

		PrintWriter writer;
		try {
			writer = new PrintWriter("LongestAlmostIncreasingSS.txt", "UTF-8");

			StringBuilder sb = new StringBuilder();
			for (int element : LAS) {
				sb.append(element).append(" ");
			}
			writer.print(sb);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

}

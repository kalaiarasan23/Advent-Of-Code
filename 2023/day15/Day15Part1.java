package day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day15Part1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day15.txt"));
		String s=br.readLine();
		long sum=0;
		String[] strArg = s.split(",");
		
		for(int i=0;i<strArg.length;i++)
		{
			int currentValue=0;
			for(int j=0;j<strArg[i].length();j++)
			{
				currentValue += strArg[i].charAt(j);
				currentValue *= 17;
				currentValue %= 256;
			}
			System.out.println(currentValue);
			sum +=currentValue;
		}
		
		System.out.println(sum);
	}

}

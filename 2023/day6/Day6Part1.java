package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6Part1 {
//			(7 - 1) = 6   the 6 * 1 = 6 is not greater then distance 9 
//			(7 - 2) = 5   the 5 * 2 = 10 is greater then distance 9    count=1
//			(7 - 3) = 4   the 4 * 3 = 12 is  greater then distance 9   count=2
//			(7 - 4) = 3   the 3 * 4 = 12 is  greater then distance 9   count=3
//			(7 - 5) = 2   the 2 * 5 = 12 is  greater then distance 9   count=4
//			(7 - 6) = 1   the 1 * 6 = 6 is not greater then distance 9
	
//			(speed - i)  * i is greater the distance is add as count=4
	
//			likewise do for all we got (4* 8 * 9) = 288
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day6part1.txt"));
		List<Integer> speed = new ArrayList<>(),dis = new ArrayList<>();
		
		int mul = 1;
		String s = br.readLine();
		String s1[]=s.split("\\s+");
		for(int i=1 ; i<s1.length;i++)
				speed.add(Integer.parseInt(s1[i]));
		
		s = br.readLine();
		String s2[]=s.split("\\s+");
		for(int i=1 ; i<s2.length;i++)
			dis.add(Integer.parseInt(s2[i]));
		System.out.println(speed+" "+dis);
		
		for(int i = 0 ; i< dis.size();i++)
		{
			int count= 0;
			for(int j = 1 ; j<=dis.get(i);j++)
			{
				if(((speed.get(i)-j) * j) > dis.get(i))
				{
					System.out.println(j);
					count++;
				}
			}
			mul *=count;
		}
		System.out.println("count "+mul);
		br.close();
	}

}

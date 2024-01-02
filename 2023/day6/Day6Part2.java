package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6Part2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day6part1.txt"));
		
		String s1="",s2="",s = br.readLine();
		for(int i=1 ; i<s.length();i++)
		{
			if(Character.isDigit(s.charAt(i)))
				s1+=s.charAt(i);
		}
		System.out.println(s1);
		Long speed = Long.parseLong(s1);
		s = br.readLine();
		for(int i=0 ; i<s.length();i++)
		{
			if(Character.isDigit(s.charAt(i)))
				s2+=s.charAt(i);
		}
		System.out.println(s2);
		Long dis = Long.parseLong(s2);
		int count=0;
		for(int i=1;i<speed/2;i++)
		{
			if(((speed-i) * i) > dis )
			{
				count=i;
				break;
			}
		}
		System.out.println(count+" "+(speed-(count*2)+1));
		
		// logic simple speed - (no. of beginnig and no of ending) + 1
		br.close();
	}

}

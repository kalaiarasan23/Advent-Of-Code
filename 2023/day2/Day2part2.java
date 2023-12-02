package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2part2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s ="";
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day2Part2.txt"));
		int sum=0;
		while((s=br.readLine()) != null)
			sum+=m1(s);	
		System.out.println(sum);
		br.close();
	}
	
	public static int m1(String s)
	{
		String a[] = s.split("[:,;\\s]+");	        
        int red=0,blue=0,green=0;
        
		for(int i=3; i<a.length;i+=2)
		{
			int no = Integer.parseInt(a[i-1]);
			if(a[i].equals("green") && (no > green))
				green = no;
			else if(a[i].equals("red") && (no > red))
				red = no;
			else if(a[i].equals("blue") && (no > blue)) 
				blue = no;
		}
		System.out.println(green+" "+red+" "+blue);
		return green*red*blue;
	}
}

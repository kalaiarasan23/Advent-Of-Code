package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Day2Part1 {

	public static void main(String[] args) throws IOException {
		String s ="";
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day2Part1.txt"));
		int sum=0;
		while((s=br.readLine()) != null)
			sum+=function(s);	
		System.out.println(sum);
		br.close();
	}

	private static int function(String s) {
		// split : or , or ; or \\s(whitespaces)  
		String a[] = s.split("[:,;\\s]+");	        
        int gameNo = Integer.parseInt(a[1]);
        
		for(int i=3; i<a.length;i+=2)
		{
			int no = Integer.parseInt(a[i-1]);
			if(a[i].equals("green") && (no > 13))
			{	
				System.out.println("false");
				return 0;
			}
			else if(a[i].equals("red") && (no > 12))
			{
					System.out.println("false");
					return 0;
			}
			else if(a[i].equals("blue") && (no > 14)) 
			{
					System.out.println("false");			
					return 0;
			}
		}
		
		System.out.println(gameNo);
		return gameNo;
	}

}

package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3Part1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day3Part1.txt"));
		int sum=0;
		String s1 =br.readLine(), s2 = br.readLine(),s3="";
		
		while((s3=br.readLine())!=null)
		{
		for(int i=0; i<s1.length();i++)
			if(!Character.isLetterOrDigit(s2.charAt(i)) && s2.charAt(i) != '.')
			{
				
				//up and down tracking
				if(Character.isDigit(s1.charAt(i)))
					sum += numberChanging(s1,i);
				else
				{
						sum+= numberChanging(s1,i+1);
						sum+=numberChanging(s1,i-1);
				}
				
				// string 3 check up and down and center 
				if(Character.isDigit(s3.charAt(i)))	// if center true ingore the next condition because of 
					sum += numberChanging(s3,i);
				else
				{
						sum+= numberChanging(s3,i+1);
						sum+=numberChanging(s3,i-1);
				}
				
				if(Character.isDigit(s2.charAt(i+1)))
					sum +=numberChanging(s2, i+1);
				
				if(Character.isDigit(s2.charAt(i-1)))
					sum +=numberChanging(s2, i-1);
			}
		System.out.println(sum);
		s1=s2;
		s2=s3;
		}
		System.out.println("sum "+sum);
	}
	
	public static int numberChanging(String s, int n)
	{
		String s1="";
		int i=n,j=n;
		if(!Character.isDigit(s.charAt(n)))
			return 0;
		
		
			while(i>0 && Character.isDigit(s.charAt(i)) )		i--;
			while(j<s.length() && Character.isDigit(s.charAt(j)))	 	j++;
		
		// for number starts from 0 
		if(i==0 && Character.isDigit(s.charAt(i)))	
			s1=s.substring(i,j);
		else
			s1=s.substring(i+1,j);
		
		// number en
		
		System.out.print(s1+" ");
		return Integer.parseInt(s1);
	}
}

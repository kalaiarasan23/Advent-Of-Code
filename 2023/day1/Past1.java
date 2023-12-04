package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Past1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/code1.txt"));
		int sum=0;
		String s = "";
		
		while((s =br.readLine()) !=null) // read th file from the directory
		{
			int i=0,j=s.length()-1;
			char first='\0',last='\0';
	
			while(i < s.length())					// traverse the string from 0 to n 
			{
				if(Character.isDigit(s.charAt(i)))  // the digit(0-1) comes 
				{	
					if(first == '\0')				// first time it store the value in first variable, it is one time use
						first=s.charAt(i);
					last=s.charAt(i);				
				}
				i++;
			}
	
			System.out.println(first+" "+last);
			sum+= Integer.parseInt(String.valueOf(first)+String.valueOf(last));
		}
	System.out.println(sum);
	br.close();
	}
}

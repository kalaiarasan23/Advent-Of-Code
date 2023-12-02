package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Past1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/code1.txt"));
		int sum=0;
		String s = "";
		while((s =br.readLine()) !=null)
		{
	int i=0,j=s.length()-1;
	char first='\0',last='\0',firstTemp='\0',lastTemp='\0';
	
	while(i <=j)
	{
		if(Character.isDigit(s.charAt(i))) 
		{
			if(first == '\0')
				first=s.charAt(i);
			firstTemp =s.charAt(i);
		}
		
		if(Character.isDigit(s.charAt(j))) 
		{
			if(last == '\0')
				last = s.charAt(j);
			lastTemp = s.charAt(j);
		}
		i++;
		j--;
	}
	
	if(first == '\0')
		first = lastTemp;
	
	if(last =='\0')
			last=firstTemp;

	System.out.println(first+" "+last);
	
	if(first == '\0' && last == '\0')
		sum+=0;
	else
		sum+= Integer.parseInt(String.valueOf(first)+String.valueOf(last));
	}
	System.out.println(sum);
	br.close();
	}
	
	
}

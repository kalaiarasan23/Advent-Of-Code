package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day3Part2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day3Part2.txt"));
		long sum=0;
		String s1 =br.readLine(), s2 = br.readLine(),s3="";
		while((s3=br.readLine())!=null)
		{
			for(int i=0; i<s1.length();i++)
			{
				int up=0,down=0;
				if(s2.charAt(i) == '*')
				{ 
					int a[] = new int[6],mp=1;

					//up and down tracking
					if(Character.isDigit(s1.charAt(i)))
							a[0] = numberChanging(s1,i);
					else {
						if(Character.isDigit(s1.charAt(i+1)))
							a[0] = numberChanging(s1,i+1);
						if(Character.isDigit(s1.charAt(i-1)))
							a[1] =numberChanging(s1,i-1);
					}
					// string 3 check up and down and center 
					if(Character.isDigit(s3.charAt(i)))	// if center true ingore the next condition because of 
						a[2] = numberChanging(s3,i);
					else 
					{
						if(Character.isDigit(s3.charAt(i+1)))
							a[2]= numberChanging(s3,i+1);
						if(Character.isDigit(s3.charAt(i-1)))
							a[3] =numberChanging(s3,i-1);
					}
					
					if(Character.isDigit(s2.charAt(i-1)))
						a[4]=numberChanging(s2,i-1);

					if(Character.isDigit(s2.charAt(i+1)))
						a[5] = numberChanging(s2, i+1);
					int c=0;
					for(int j=0;j<a.length ;j++) {
						if(a[j]!=0) {
							mp*=a[j];
							c++;
						}
						System.out.print(a[j]+" ");
					}
					if(c==1)
						mp=0;
					System.out.println();
					System.out.println(mp+" \n");
					sum+=mp;
				}
			}
			System.out.println();
			s1=s2;
			s2=s3;
		}
		System.out.println(sum);		
		System.out.println("sum "+sum);
	}

	public static int numberChanging(String s, int n)
	{
		String s1="";
		int i=n,j=n;
		
		while(i>0 && Character.isDigit(s.charAt(i)) )		i--;
		while(j<s.length() && Character.isDigit(s.charAt(j)))	 	j++;		
		
		
		// for number starts from 0 
		if(i==0 && Character.isDigit(s.charAt(i)))	
			s1=s.substring(i,j);
		else
			s1=s.substring(i+1,j);
		
		// number en
		
		return Integer.parseInt(s1);
	}

}

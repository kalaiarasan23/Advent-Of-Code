package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day9Part1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day9.txt"));
		String s="";
		long total=0;
		while((s=br.readLine())!=null)
		{
			String arr[]=s.split(" ");
//			System.out.println(arr.length);
			int zeros,sum=Integer.parseInt(arr[arr.length-1]),last=0;
			int temp[] = new int[arr.length];
			
			
			for(int i=arr.length-1;i>1 ;i--)
			{
				zeros=0;
				for(int j=0;j<i;j++) {
					if(i== arr.length-1)
						temp[j]=Integer.parseInt(arr[j+1])- Integer.parseInt(arr[j]);
					else
						temp[j]=temp[j+1]-temp[j];
					
					if(temp[j] == 0)
						zeros++;
					
					
				}	
				System.out.println(sum);
				sum+=temp[i-1];
				last=temp[i-1];
				if(zeros == i)
				{
					
					break;
				}
			}
			total += sum+last;
		}
		System.out.println(total);
			
	}

}

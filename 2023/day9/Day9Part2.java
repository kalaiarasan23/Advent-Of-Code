package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day9Part2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day9.txt"));
		String s="";
		long total=0;
		while((s=br.readLine()) != null)
		{
			System.out.println(s);
			String arr[]=s.split(" ");
			int sum=Integer.parseInt(arr[arr.length-1]),last=0;
			int j=0,zero=0, temp[] = new int[arr.length];
			temp[arr.length-1] = Integer.parseInt( arr[0]);
			for(int i=arr.length-1;i>1;i--)
			{
				zero=0;
				for(j=0 ;j<i;j++)
				{
					if(i==arr.length-1)
						temp[j]=Integer.parseInt(arr[j+1])-Integer.parseInt(arr[j]);
					else
						temp[j]=temp[j+1]-temp[j];
					
					if(temp[j] == 0)
						zero++;
//					System.out.print(temp[j]+" ");

				}
				temp[j-1]= temp[0];
				if(i==zero)
				{
					break;
				}
			}
			
			sum=findBefore(temp,arr);
			
			total += sum;
			System.out.println(sum+" "+total);
		}
		System.out.println(total);
	}

	private static int findBefore(int[] temp,String[] arr) {
		System.out.println("Array "+Arrays.toString(temp));
		int sum=Integer.MAX_VALUE;
		for(int i = 0 ;i<temp.length;i++)
		{
			if(temp[i] ==0 && sum == Integer.MAX_VALUE)
				continue;
			if(sum == Integer.MAX_VALUE)
				sum=temp[++i]-temp[i-1];
			else
				sum = temp[i]-sum; 
			
//			System.out.println(sum+" "+temp[i]);
		}
		return sum;
	}

}

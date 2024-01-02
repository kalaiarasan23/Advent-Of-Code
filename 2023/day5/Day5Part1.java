package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5Part1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s="";
		List<Long> seed = new ArrayList<Long>(),temp=new ArrayList<Long>();
 		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day5Part1.txt"));

 		// read the seed value
 		s=br.readLine();
 		String spl[]=s.split(" ");
 		for(int i=1;i<spl.length;i++ ) {
			seed.add(Long.parseLong(spl[i]));
			temp.add(Long.parseLong(spl[i]));
 		}
		System.out.println(" "+seed.size());

		
		while((s=br.readLine()) != null)
 		{
 			
			if(s.equals("") || !Character.isDigit(s.charAt(0))) // to eliminate newLine and letters
 			{
 				seed.clear();
 				seed.addAll(temp);
// 				System.out.println(s);
 				continue;
 			}
 			
 			
 		int i=0;
 		spl=s.split(" ");
 		long des=Long.parseLong(spl[0]),src=Long.parseLong(spl[1]),num=Long.parseLong(spl[2]);
 		
 		while(i<seed.size())
 		{
 			if(seed.get(i)>= src && seed.get(i)<(src+num)) // with in ranger or not 
 			{	
 				if(src<des)
 					temp.set(i, (seed.get(i) + Math.abs(src-des) ));
 				else
 					temp.set(i, (seed.get(i) - Math.abs(src-des) ));
 			}
 			i++;
 		}
// 		System.out.println(seed+ "    "+temp);
 		}
		
		seed.clear();
		seed.addAll(temp);
		
		// to find minimum value
		Long small=Long.MAX_VALUE;
		for(int i = 0 ;i<seed.size();i++)
			if(small > seed.get(i))
				small=seed.get(i);
		System.out.println(small);
		
		br.close();
	}
	

}

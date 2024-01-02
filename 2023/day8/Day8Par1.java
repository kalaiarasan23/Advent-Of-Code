package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8Par1 {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
//		System.out.println(startTime);
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day8part.txt"));
		
		Map<String,List<String>> mp= new HashMap<>();
		
		String s=br.readLine();
		List<String> list= Arrays.asList(s.trim().split(""));
//		System.out.println(list);
		while((s = br.readLine())!=null)
		{
			if(s.isBlank())
				continue;
			ArrayList<String> temp = new ArrayList<String>();
			String	arr[]= s.split("[=,()]");
			temp.add(arr[2].trim());
			temp.add(arr[3].trim());
			mp.put(arr[0].trim(), temp);
			
		}
		
		String choose = "AAA";
		int i=0;
		long count=0;
		while(!choose.equals("ZZZ"))
		{
		List<String> e= mp.get(choose);
			if(i>=list.size())
				i=0;

			if(list.get(i).equals("L"))
				choose=e.get(0);
			else
				choose=e.get(1);
			
			i++;
			count++;
		}
		System.out.println(count+" "+(System.currentTimeMillis()-startTime));
		br.close();
	}
}

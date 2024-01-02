package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4Part2Self {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day4Part2.txt"));
		String s="";
		Long sum=0L;
		ArrayList<Integer> total = new ArrayList<>();
		while((s=br.readLine())!= null)
		{
			// i learn trim method from this example because eg. " 3565" in first white cannot ignore bt split method("\\s+"), so we use trim
			String a[] = s.split("[|:]+[\\s]"), b[]=a[1].trim().split("\\s+"),c[]=a[2].trim().split("\\s+");
			int no=1;

			Set<Integer> set = new HashSet<>();
			List<Integer> list = new ArrayList<>();
			
			for(String temp : b)
				set.add(Integer.parseInt(temp));
			
			for(String temp : c)
				list.add(Integer.parseInt(temp));
			System.out.println(set+" "+list);
			
			for(int i = 0 ; i<c.length; i++)
			{
				if(set.contains(list.get(i)))
					no += 2;
			}
			System.out.println(no);
			
		}
	}

}

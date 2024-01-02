package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5Part2 {

	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day5Part1.txt"));
 		String s= br.readLine();
 		String spl[]=s.split(" ");
 		Long sum=0L;
 		List<Long> seed = new ArrayList<>(),temp = new ArrayList<>();
//		for(int i=1;i<spl.length;i+=2)
//		{
//			sum+=Long.parseLong(spl[i+1]);
//			System.out.println(spl[i]+" "+spl[i+1]+" "+sum);
////			System.out.println(spl[i+1] +" "+ spl[i]+" ");
////			numberAdd(Long.parseLong(spl[i+1]),Long.parseLong(spl[i]),seed);
//		}
//		System.out.println(seed.size());
 		Long tem=562444630L/100L;
 		numberAdd(919339981L, tem, seed);
 		System.out.println(seed+" "+temp);
	}

	private static void numberAdd(long long1, long long2, List<Long> seed) {
		long i=0L;
		while(i<long2)
		{
			seed.add(long1);
			i++;
			long1++;
			System.out.println(i);
		}
		
	}

}

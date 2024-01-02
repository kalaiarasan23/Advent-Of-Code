package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7Part1 {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day7part1.txt"));
		Map<String,Integer> noPair= new HashMap<>(),onePair=new HashMap<>(),twoPair=new HashMap<>(),allPair= new HashMap<>();
		Map<String,Integer> threePair= new HashMap<>(),fullHouse = new HashMap<>(),fourPair= new HashMap<>();
		String s="";
		while((s=br.readLine()) != null)
		{
			Map<Character,Integer> temp = new HashMap<>();
			String s1[]=s.split(" ");
			for(int i=0;i<s1[0].length();i++)
			{
				if(temp.containsKey(s1[0].charAt(i)))
					temp.put(s1[0].charAt(i), temp.get(s1[0].charAt(i))+1);
				else
					temp.put(s1[0].charAt(i), 1);
			}

			
			switch(temp.size()) 
			{
				case 1:
					allPair.put(s1[0],Integer.parseInt(s1[1]));
					break;
				case 2:
				{
					int a=0;
					 for (Map.Entry<Character, Integer> me : temp.entrySet()) { 
			            // Printing keys 
			            if(me.getValue()>3)
			            	a++;
					 }
			            if(a==1)
			            	fourPair.put(s1[0],Integer.parseInt(s1[1]));
			            else
			            	fullHouse.put(s1[0],Integer.parseInt(s1[1]));
			            break;
				}
				case 3:
				{
					int a=0;
					 for (Map.Entry<Character, Integer> me : temp.entrySet()) { 
			            // Printing keys 
			            if(me.getValue()>2)
			            	a++;
					 }
					 if(a==1)
			            	threePair.put(s1[0],Integer.parseInt(s1[1]));
			            else
			            	twoPair.put(s1[0],Integer.parseInt(s1[1]));
					 break;
				}
				case 4:
					onePair.put(s1[0], Integer.parseInt(s1[1]));
					break;
				case 5:
					noPair.put(s1[0], Integer.parseInt(s1[1]));
					break;
				default:
					break;
			}
		}
		
		long sum=0;
		int rank=noPair.size();
		sum=total(noPair,rank);
		
		rank +=onePair.size();
		sum+=total(onePair,rank);
		
		rank +=twoPair.size();
		sum+=total(twoPair,rank);
		
		rank +=threePair.size();
		sum+=total(threePair,rank);
		
		rank +=fullHouse.size();
		sum+=total(fullHouse,rank);
		
		rank +=fourPair.size();
		sum+=total(fourPair,rank);

		rank +=allPair.size();
		sum+=total(allPair,rank);
		
		System.out.println("sum "+sum+" rank "+rank);
System.out.println(noPair.size()+onePair.size()+twoPair.size()+threePair.size()+fourPair.size()+fullHouse.size()+allPair.size());		
	}

	private static long total(Map<String, Integer> noPair, int rank) 
	{
		long sum=0;
		List<String> two = new ArrayList<>(noPair.keySet());
		Collections.sort(two,new SortRoll());
		for(int i =0 ;i<two.size();i++) 
			sum = sum + noPair.get(two.get(i)) *(rank--);
		System.out.println(noPair);
		return sum;
	}
}

class SortRoll implements Comparator<String>
{
	@Override
	public int compare(String o1, String o2) 
	{
		List<Character> card = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
		for(int i=0;i<o1.length();i++)
		{
			if(card.indexOf(o2.charAt(i)) != card.indexOf(o1.charAt(i)))
				return Integer.compare(card.indexOf(o2.charAt(i)) , card.indexOf(o1.charAt(i)));
		}
		
		return 0;
	}
}
	


package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7Part2 {
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
			
			
			
				int a=0;
				char key='\0';
			 for (Map.Entry<Character, Integer> me : temp.entrySet()) 
			 { 
				 if(me.getKey()!='J' && a == 0)			// for initialize the value 
				 {
					 a=me.getValue();
		            	key=me.getKey();
		            	continue;
				 }
		            // Printing keys 
		            if(a<me.getValue() && me.getKey() != 'J'  )
		            {
		            	a=me.getValue();
		            	key=me.getKey();
		            }
			  }
			 
			 System.out.println(temp+" "+a+" "+key);
			 if(temp.containsKey('J') && temp.size() != 1)
			 {
				 temp.replace(key,temp.get(key),temp.get(key)+temp.get('J'));
				 temp.remove('J');
				 a=temp.get(key);
			 }
			 
			 System.out.println(temp);
			switch(temp.size()) 
			{
				case 1:
					allPair.put(s1[0],Integer.parseInt(s1[1]));
					break;
				case 2:
				{
					
			            if(a==4) {
			            		fourPair.put(s1[0],Integer.parseInt(s1[1]));
			            }
			            else
			            {
			            		fullHouse.put(s1[0],Integer.parseInt(s1[1]));
			            }
			            break;
				}
				case 3:
				{
					
					 if(a==3)
			            	threePair.put(s1[0],Integer.parseInt(s1[1]));
			            else
			            	twoPair.put(s1[0],Integer.parseInt(s1[1]));
					 break;
				}
				case 4:
						onePair.put(s1[0], Integer.parseInt(s1[1]));
					break;
				case 5:
				{
						noPair.put(s1[0], Integer.parseInt(s1[1]));
					break;
				}
				default:
					break;
			}
		}
		br.close();
		
				
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
		Collections.sort(two,new Sortroll1());
		for(int i =0 ;i<two.size();i++) 
			sum = sum + noPair.get(two.get(i)) *(rank--);

		return sum;
	}
}

class Sortroll1 implements Comparator<String>
{
	@Override
	public int compare(String o1, String o2) 
	{
		List<Character> card = Arrays.asList('J','2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A');
		for(int i=0;i<o1.length();i++)
		{
			if(card.indexOf(o2.charAt(i)) != card.indexOf(o1.charAt(i)))
				return Integer.compare(card.indexOf(o2.charAt(i)) , card.indexOf(o1.charAt(i)));
		}
		
		return 0;
	}
}
	


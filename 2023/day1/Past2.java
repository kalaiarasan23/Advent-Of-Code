package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Past2 {
	
	public static void main(String[] args) throws IOException {

		Set<Character> set = new HashSet<>();
			set.add('o');
			set.add('t');
			set.add('f');
			set.add('s');
			set.add('e');
			set.add('n');
		HashMap<String,Integer> hm = new HashMap<>();
			hm.put("one", 1);
			hm.put("two", 2);
			hm.put("three", 3);
			hm.put("four",4);
			hm.put("five", 5);
			hm.put("six", 6);
			hm.put("seven",7);
			hm.put("eight", 8);
			hm.put("nine",9);
			
		String s ="";
		BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/code2.txt"));
		int sum=0;
		while((s=br.readLine()) != null)
		{	
			int first=0,last=0;
			for(int i=0;i<s.length();i++)
			{
				if(Character.isDigit(s.charAt(i)))
				{
					if(first==0)
						first=Integer.parseInt(String.valueOf(s.charAt(i)));
					else
						last=Integer.parseInt(String.valueOf(s.charAt(i)));	
				}
				else if(set.contains(s.charAt(i)) && i<s.length()-2) 
				{
					int j=i+3,count=j+2;
					String s2= s.substring(i,i+3);
//					System.out.println(s2+" "+j);
					while(j<=count) 
					{
//						System.out.println("inner "+s2);
						if(hm.containsKey(s2))
						{
							if(first == 0)
								first = hm.get(s2);
							else
								last = hm.get(s2);
						break;
						}
						if(++j > s.length())
							break;
						s2=s.substring(i,j);
					}
				}
			}
			if(last==0)
				last=first;
			sum += first*10+last;
			System.out.println("first "+first+" last "+last+" sum "+sum);
			
		}
		System.out.println("sum ="+sum);
	br.close();
	}
	
}

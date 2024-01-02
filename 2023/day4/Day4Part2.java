package day4;


//							  start  card1(4)  card 2  card 3  card 4   |   Total
//		eg. card 1 has 4 cards    1 			(2)		(2)		(1)	    |	  1	
//			card 2 has 2 cards	  1 + 	1								|	  2
//			card 3 has 2 cards	  1 + 	1	+	2						|     4
//			card 4 has 1 cards	  1	+ 	1	+	2	+ 	4				|	  8	
//			card 5 has 0 cards	  1 + 	1	+	        4	+ 	8		|	 14	
//			card 6 has 0 cards    1										|	  1
//																		|	   = 30  
	
	
	
	

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4Part2 {
    static void copiesWon(String[] winningNums, String[] cardNums, int currCardNum, Map<Integer, Integer> cardCopies) {
        int count = 0;
        Map<String, Integer> freq = new HashMap<>();
        for (String s : winningNums) {				// first half of number
//        	System.out.print(s+" "+(freq.getOrDefault(s, 0)+1));
            freq.put(s, freq.getOrDefault(s, 0) + 1);
            
        }

        for (String s : cardNums) {				//second half of number
//        	System.out.println(s);
            if (freq.containsKey(s)) {
                freq.put(s, freq.get(s) - 1);
//                System.out.print(s);
            }
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {  // traverse the map(freq)
            if (entry.getValue() == 0) {
                count++;
            }
        }
        for (int i = 1; i <= count; i++) {
            int currCardCopies = cardCopies.get(currCardNum);
//            System.out.println("count "+count+" copy "+(cardCopies.get(currCardNum)+i)+" currCardNum "+(currCardNum+i));
            cardCopies.put(currCardNum + i, cardCopies.get(currCardNum + i) + currCardCopies);
        }
        System.out.println(count+ "  "+cardCopies);
    }

    public static void main(String[] args) {
        int res = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("/home/kalaiarasan/Music/AdventOfCode/day4Part2.txt"))) {
            String line;
            Map<Integer, List<String[]>> cardMap = new HashMap<>();
            Map<Integer, Integer> cardCopies = new HashMap<>();
            
            
            while ((line = br.readLine()) != null) {
                String[] firstSplit = line.split(":");
                String[] cardSplit = firstSplit[0].split("\\s+");
                String[] secondSplit = firstSplit[1].split("\\|");
                String[] winningNums = secondSplit[0].trim().split("\\s+");
                String[] cardNums = secondSplit[1].trim().split("\\s+");
                int currCardNum = Integer.parseInt(cardSplit[1]);
                cardCopies.put(currCardNum, 1);
                List<String[]> cardNumList = List.of(winningNums, cardNums);
                cardMap.put(currCardNum, cardNumList);
             
            }

            for (Map.Entry<Integer, List<String[]>> entry : cardMap.entrySet()) {
                List<String[]> cardList = entry.getValue();
                System.out.println(entry.getKey()+" "+cardCopies);
                copiesWon(cardList.get(0), cardList.get(1), entry.getKey(), cardCopies);
            }
            
            //add all copies
            for (Map.Entry<Integer, Integer> entry : cardCopies.entrySet()) {
//            	System.out.println(res);
                res += entry.getValue();
            }

            System.out.println("Answer: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
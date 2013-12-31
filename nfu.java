package pageReplaceAlgoTest;
import java.util.*;
/**
 * A arrayList and Hashmap data structure is used 
 * Outputs the hit rate and number of page requests
 * @author Devi
 *
 */

class nfu extends pageReplaceAlgo{
	int hitRate, pageFault, value, resultKey, min;
	int pageToFrame(){
		int count=0, index=0;
		ArrayList<Integer> frame = new ArrayList<Integer>();
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		while((count < lengthOfString)&& (pageString[count]!=-1)){
			if(frame.contains(pageString[count])){
				value = numbers.get(pageString[count]);
				numbers.put(pageString[count], value+1);
				count++; hitRate++;
			}else{
				min=9999;
				if(frame.size()== noOfFrames){
					Iterator<Integer> entries = frame.iterator();
					while (entries.hasNext()) {
						int fr, freq ; 
						fr = entries.next() ;
						freq= numbers.get(fr);
						if (freq < min) {
							min = freq;
							resultKey = fr;
						}
					} 
					index = frame.indexOf(resultKey);
					frame.remove(index);
					frame.add(pageString[count]);
					if(numbers.containsKey(pageString[count])){
						value = numbers.get(pageString[count]);
						numbers.put(pageString[count], value+1);
					}else{
						numbers.put(pageString[count], 1);
					}
					pageFault++; count++;
				}
				else{
					frame.add(pageString[count]);
					numbers.put(pageString[count], 1);
					pageFault++; count++;
				}
			}
			for(int s : frame) { 
				System.out.print(s+" "); 
			}
			System.out.println(" "); 
		}
		System.out.println("\nOUTPUT: \nHitRate: "+hitRate + "\nNo. of page requests: "+(lengthOfString-1));
		return hitRate;
	}
}
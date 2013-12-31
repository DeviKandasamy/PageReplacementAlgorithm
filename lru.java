package pageReplaceAlgoTest;
import java.util.*;

/**
 * A Stack data structure is used 
 * Outputs the hit rate and number of page requests
 * @author Devi
 */
class lru extends pageReplaceAlgo{
	int hitRate, pageFault;
	int pageToFrame(){
		int count=0;
		Stack<Integer> frame=new Stack<Integer>();
		while((count < lengthOfString)&& (pageString[count]!=-1)){
			if(frame.contains(pageString[count])){
				frame.remove(frame.indexOf(pageString[count]));
				frame.push(pageString[count]);
				hitRate++; count++;
			}else{
				if(frame.size()== noOfFrames){
					frame.remove(0);
				}
				frame.push(pageString[count]);
				pageFault++; count++;
			}
			System.out.println(frame);
		}
		System.out.println("\nOUTPUT: \nHitRate: "+hitRate + "\nNo. of page requests: "+(lengthOfString-1));
		return hitRate;
	}
}

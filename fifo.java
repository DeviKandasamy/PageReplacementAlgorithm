package pageReplaceAlgoTest;
import java.util.*;
/**
 * A Queue data structure is used 
 * Outputs the hit rate and number of page requests
 * @author Devi
 *
 */

class fifo extends pageReplaceAlgo{
	int hitRate, pageFault;
	int pageToFrame(){
		int count = 0;
		Queue<Integer> frame=new LinkedList<Integer>();
		while((count < lengthOfString) && ( pageString[count]!=-1) ){
			if(frame.contains(pageString[count])){
				hitRate++; count++;
			}else{
				if(frame.size()== noOfFrames){
					frame.remove();
				}
				frame.add(pageString[count]);
				pageFault++; count++;
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
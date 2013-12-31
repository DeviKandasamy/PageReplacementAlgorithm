package pageReplaceAlgoTest;

import java.util.*;
/**
 * A ArrayList data structure is used 
 * Outputs the hit rate and number of page requests
 * @author Devi
 *
 */

class optimal extends pageReplaceAlgo{
	int hitRate, pageFault, j, value, result;
	int[] index=new int[1024];
	int[] max=new int[1024];
	int pageToFrame(){
		int count=0;
		ArrayList<Integer> frame = new ArrayList<Integer>();
		while((count < lengthOfString)&& (pageString[count]!=-1)){
			if(frame.contains(pageString[count])){
				hitRate++; count++;
			}else{
				value=0;
				if(frame.size()== noOfFrames){
					for(int i=0; i<noOfFrames; i++){
						for(int j=count+1;j<lengthOfString;j++){
							if(frame.get(i)==pageString[j]){
								max[i] = j;
								break;
							}
							else{
								max[i]=lengthOfString+1;
							}
						}
					}
					for(int i=0;i<noOfFrames;i++){
						if(max[i]>value){
							value=max[i];
							result = i;
						}
					}
					frame.remove(result);
					frame.add(result, pageString[count]);
					pageFault++; count++;
				}
				else{
					frame.add(pageString[count]);
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
package pageReplaceAlgoTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class pageReplaceAlgo{
	int noOfPages, noOfFrames, checkEOStr, lengthOfString;
	int option; static File file; static BufferedReader br;  static boolean value=false;
	int[] pageString = new int[1024];
	Scanner input = new Scanner(System.in);
	String line;

	//Select Algorithm
	int getOption(){
		if(value){
			System.out.println("Choose the replacement algorithm that you want to simulate");
			System.out.println("1. FIFO"+ "\n" +"2. LRU"+ "\n" +"3. Optimal"+"\n" +"4. NFU"+"\n" );
			option = input.nextInt();
		}
		else{
			try{
				if ((line = br.readLine()) != null) {
					option=Integer.parseInt(line);
					System.out.println("\nChosen option is "+ option);
				}
				else{
					option = -2;
				}
			}
			catch(Exception e){
				option = -2;
			}
		}

		return option;
	}

	//Enter number of pages 
	int getPageValues(){
		if(value){
			System.out.println("Enter number of pages in logical memory: ");
			noOfPages = input.nextInt();
		}
		else{
			try{
				if ((line = br.readLine()) != null) {
					noOfPages=Integer.parseInt(line);
					System.out.println("number of pages in logical memory: "+noOfPages);
				}
			}
			catch(Exception e){
			}
		}
		return noOfPages; 
	}

	//Enter number of frames
	int getFrameValues(){
		if(value){
			System.out.println("Enter number of frames in physical memory: ");
			noOfFrames = input.nextInt();
		}else{
			try{
				if ((line = br.readLine()) != null) {
					noOfFrames=Integer.parseInt(line);
					System.out.println("number of frames in physical memory: "+noOfFrames);
				}
			}
			catch(Exception e){
			}
		}
		return noOfFrames;
	}

	//Read Page String
	int[] getPageString(){
		if(value){
			System.out.println("Enter the page-reference string: (end string with -1)");
			for(int i=0; checkEOStr!=-1; ) {
				pageString[i] = input.nextInt();
				checkEOStr = pageString[i];
				lengthOfString=++i;
			}
		}else{
			String[] strings=new String[1024]; 
			int i=0;
			try{
				line = br.readLine();
				if (line != null && line.length()!=0) {
					System.out.println("The input reference string is: "+line);
					strings=line.split(" ");
					int lengthofstr = strings.length;
					if(Integer.parseInt(strings[lengthofstr-1])==-1){
						for (String str : strings){
							pageString[i++] = Integer.parseInt(str);
							lengthOfString=i;
						}
					}
					else{
						pageString =null;
					}
				}
				else{
					pageString =null;
				}		
			}
			catch(Exception e){
				System.out.println("ERROR: Wrong number format");
				pageString=null;
			}
		}
		return pageString;
	}

	//ValidatePageString
	int validatePageString(){
		for(int i=0; i<lengthOfString && pageString[i]!=-1; i++){
			if (pageString[i] < noOfPages && pageString[i] >= 0){
				//System.out.println("page1="+ pageString[i]+ " ");
			}
			else{
				System.out.println("ERROR: Invalid input");
				lengthOfString = 0;
			}
		}
		return lengthOfString;
	}

	/**
	 * This is the Main class 
	 * Verifies if the program is executed through interactive or batch mode
	 * An option to select the page replacement algorithm
	 * @param args
	 * if no argument - interactive mode
	 * if one argument - batch mode
	 */
	public static void main(String args[]){
		boolean loop=true;
		int option = 0;
		pageReplaceAlgo objMain = new pageReplaceAlgo(); 
		String mode;
		if (args.length == 0){
			value = true;
			mode = "interactive";
			System.out.print("Interactive Mode:\n");
		}
		else{
			mode = "batch";
			System.out.print("Reading Inputs from a Batch File:\n");
			pageReplaceAlgo.file=new File(args[0]);
			try{
				br = new BufferedReader(new FileReader(file));
			}
			catch(Exception e){
				System.out.print("File Not Found Exception, Exiting..");
			}
		}

		/**
		 * Prompt/Reads number of pages in logical memory
		 * Prompt/Reads number of pages in physical memory
		 * Prompt/Reads page-ref string
		 * Validated the page string
		 */
		while(loop){
			option = objMain.getOption();
			if(option == -2){
				System.out.println("End of file");
				break;
			}
			else if(option == 1){	
				System.out.println("\nFIFO: ");
				pageReplaceAlgo fifoObject = new fifo();
				int pagevalueCheck=fifoObject.getPageValues();
				if(pagevalueCheck==0){
					System.out.println("\nERROR: Invalid Page");
					break;
				}
				int frameValueCheck=fifoObject.getFrameValues();
				if(frameValueCheck==0){
					System.out.println("\nERROR: Invalid Frame");
					break;
				}
				int[] pageStringCheck=fifoObject.getPageString();
				if(pageStringCheck == null){
					System.out.println("\nERROR: Invalid Page String");
					break;
				}
				int validateinput = fifoObject.validatePageString();
				if(validateinput == 0){
					System.out.println("\nERROR: Invalid Input");
					break;
				}
				((fifo) fifoObject).pageToFrame();
			}

			else if(option == 2){	
				System.out.println("\nLRU: ");
				pageReplaceAlgo lruObject = new lru();
				int pagevalueCheck=lruObject.getPageValues();
				if(pagevalueCheck==0){
					System.out.println("\nERROR: Invalid Page");
					break;
				}
				int frameValueCheck=lruObject.getFrameValues();
				if(frameValueCheck==0){
					System.out.println("\nERROR: Invalid Frame");
					break;
				}
				int[] pageStringCheck=lruObject.getPageString();
				if(pageStringCheck == null){
					System.out.println("\nERROR: Invalid Page String");
					break;
				}
				int validateinput = lruObject.validatePageString();
				if(validateinput == 0){
					System.out.println("\nERROR: Invalid Input");
					break;
				}
				((lru) lruObject).pageToFrame();
			}

			else if(option == 3){	
				System.out.println("\nOptimal: ");
				pageReplaceAlgo optimalObject = new optimal();
				int pagevalueCheck=optimalObject.getPageValues();
				if(pagevalueCheck==0){
					System.out.println("\nERROR: Invalid Page");
					break;
				}
				int frameValueCheck=optimalObject.getFrameValues();
				if(frameValueCheck==0){
					System.out.println("\nERROR: Invalid Frame");
					break;
				}
				int[] pageStringCheck=optimalObject.getPageString();
				if(pageStringCheck == null){
					System.out.println("\nERROR: Invalid Page String");
					break;
				}
				int validateinput = optimalObject.validatePageString();
				if(validateinput == 0){
					System.out.println("\nERROR: Invalid Input");
					break;
				}
				((optimal) optimalObject).pageToFrame();
			}

			else if(option == 4){	
				System.out.println("\nNFU: ");
				pageReplaceAlgo nfuObject = new nfu();
				int pagevalueCheck=nfuObject.getPageValues();
				if(pagevalueCheck==0){
					System.out.println("\nERROR: Invalid Page");
					break;
				}
				int frameValueCheck=nfuObject.getFrameValues();
				if(frameValueCheck==0){
					System.out.println("\nERROR: Invalid Frame");
					break;
				}
				int[] pageStringCheck=nfuObject.getPageString();
				if(pageStringCheck == null){
					System.out.println("\nERROR: Invalid Page String");
					break;
				}
				int validateinput = nfuObject.validatePageString();
				if(validateinput == 0){
					System.out.println("\nERROR: Invalid Input");
					break;
				}
				((nfu) nfuObject).pageToFrame();
			}

			else{
				System.out.println("ERROR: Unsupported option or Algorithm");
			}
			if(mode=="interactive"){
				System.out.println("Do you want to continue? Yes or No:");
				Scanner choice = new Scanner(System.in);
				if((choice.nextLine()).equals("Yes")){
					loop=true;
				}else{
					loop=false;
				}
			}
			System.out.println("***********************************************************************************************************");

		}
	}
}


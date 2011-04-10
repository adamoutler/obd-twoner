
public class Mode03or07or0A {
private static String Mode = "03";
	public static void modeSwitch(String mode){
        
        Mode=mode;
       
        //expect 2 bytes of data
            mode3TroubleCodes();
	}

	private static void mode3TroubleCodes() {

        while (Status.LineToken.countTokens() > 2 ){
            boolean [] A = BinaryConvert.getBinaryArrayFromToken(Status.LineToken.nextToken());
            boolean [] B = BinaryConvert.getBinaryArrayFromToken(Status.LineToken.nextToken());
            String DTC = firstDTCChar(A) + secondDTCChar(A) + thirdDTCChar(A) + fourthDTCChar(B)+fifthDTCChar(B);
            addDTC(DTC);
        }


        /*
        if ((Status.DTC1 == "") &&  (Status.DTC2 == "") && (Status.DTC1 == "")){
        	Log.level1("No DTCs Present");
        	return;
        }
        */
        
        Log.level1("Present DTCs: " + Status.DTCs.toString());
    	}
        
        private static void addDTC(String DTC){
            int counter = 0;

            //remove invalid data, do not enter
            if (DTC.contains("0000")){
                    return;
            //loop through and find a spot for mode 3 data
            } else if ( Mode.equals("03") ){
                while (counter < Status.DTCs.length){
                    //for mode 3 Standard DTCs
                    if ((Status.DTCs[counter] != null ) && (Status.DTCs[counter].equals(DTC)) ){
                        return;
                    } else if ( (Status.DTCs[counter] == null) || ( Status.DTCs[counter].isEmpty())) {
                        Status.DTCs[counter] = DTC;
                        counter = 9;
                    }
                ++counter;
                }
            }
        }
        
            
        
            
        
	private static String fifthDTCChar(boolean B[]){
		if ((! B[3]) && (! B[2]) && (! B[1]) && (! B[0])){return "0";}
		if ((! B[3]) && (! B[2]) && (! B[1]) && (B[0])){return "1";}
		if ((! B[3]) && (! B[2]) && (B[1]) && (! B[0])){return "2";}
		if ((! B[3]) && (! B[2]) && (B[1]) && (B[0])){return "3";}
		if ((! B[3]) && (B[2]) && (! B[1]) && (! B[0])){return "4";}
		if ((! B[3]) && (B[2]) && (! B[1]) && (B[0])){return "5";}
		if ((! B[3]) && (B[2]) && (B[1]) && (! B[0])){return "6";}
		if ((! B[3]) && (B[2]) && (B[1]) && (B[0])){return "7";}
		if ((B[3]) && (! B[2]) && (! B[1]) && (! B[0])){return "8";}
		if ((B[3]) && (! B[2]) && (! B[1]) && (B[0])){return "9";}
		return "0";
	}
	private static String fourthDTCChar(boolean B[]){
		if ((! B[7]) && (! B[6]) && (! B[5]) && (! B[4])){return "0";}
		if ((! B[7]) && (! B[6]) && (! B[5]) && (B[4])){return "1";}
		if ((! B[7]) && (! B[6]) && (B[5]) && (! B[4])){return "2";}
		if ((! B[7]) && (! B[6]) && (B[5]) && (B[4])){return "3";}
		if ((! B[7]) && (B[6]) && (! B[5]) && (! B[4])){return "4";}
		if ((! B[7]) && (B[6]) && (! B[5]) && (B[4])){return "5";}
		if ((! B[7]) && (B[6]) && (B[5]) && (! B[4])){return "6";}
		if ((! B[7]) && (B[6]) && (B[5]) && (B[4])){return "7";}
		if ((B[7]) && (! B[6]) && (! B[5]) && (! B[4])){return "8";}
		if ((B[7]) && (! B[6]) && (! B[5]) && (B[4])){return "9";}
		return "0";	
	}	
	
	private static String thirdDTCChar(boolean A[]){
		if ((! A[3]) && (! A[2]) && (! A[1]) && (! A[0])){return "0";}
		if ((! A[3]) && (! A[2]) && (! A[1]) && (A[0])){return "1";}
		if ((! A[3]) && (! A[2]) && (A[1]) && (! A[0])){return "2";}
		if ((! A[3]) && (! A[2]) && (A[1]) && (A[0])){return "3";}
		if ((!A[3]) && (A[2]) && (! A[1]) && (! A[0])){return "4";}
		if ((! A[3]) && (A[2]) && (! A[1]) && (A[0])){return "5";}
		if ((! A[3]) && (A[2]) && (A[1]) && (! A[0])){return "6";}
		if ((! A[3]) && (A[2]) && (A[1]) && (A[0])){return "7";}
		if ((A[3]) && (! A[2]) && (! A[1]) && (! A[0])){return "8";}
		if ((A[3]) && (! A[2]) && (! A[1]) && (A[0])){return "9";}
		return "0";
	}
	private static String secondDTCChar(boolean A[]){

		if ((A[5]) && (A[4])){return "3";}
		if ((! A[5]) && (A[4])){return "1"; }
		if ((A[5]) && (! A[4])){return "2";}
		return "0";
	}
	private static String firstDTCChar(boolean A[]){
		if ((A[7]) && (A[6])){return "U";}
		if ((! A[7]) && (A[6])){return "C";}
		if ((A[7]) && (! A[6])){return "B";}
		if ((! A[7]) && (! A[6])){return "P";}
        return "0";
	}  
}
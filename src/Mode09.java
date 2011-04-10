
public class Mode09 {

	public static void modeSwitch(){
        /* This is the section
         * where the response 49
         * MODE $09
         * is interperated, data
         * is extrapolated, and
         * then placed into a 
         * variable, The 43 data 
         * refers to requested 
         * trouble codes
         */
          Status.CheckToken = Status.LineToken.nextToken();
          Status.CheckToken = Status.CheckToken + Status.LineToken.nextToken();
          
          int switchToken = 0;
          switchToken = Integer.parseInt(Status.CheckToken, 16);   
      	 Log.level3(Status.CheckToken);
      	 //expect 2 bytes of data
      	 switch (switchToken) {
      		 case 0: getMode9SupportedPIDs(); break;
      		 case 2: getMode9VIN(); break;
      		 case 4: getMode9CalibrationID(); break;
      		 case 6: getMode9Calibration(); break;
      	 }
	}




    private static void getMode9SupportedPIDs() {
        Status.CheckToken = Status.LineToken.nextToken();
        Status.MODE9SupportedPIDs = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
        Log.level1("Mode9 Supported PIDs:" + Status.MODE9SupportedPIDs);
    }
    private static void getMode9VIN() {
    	Log.level0(Status.LineToken.toString());
    }
    private static void getMode9CalibrationID() {
    	Log.level0(Status.LineToken.toString());
    }
    private static void getMode9Calibration() {
       	Log.level0(Status.LineToken.toString());
    }
    
}
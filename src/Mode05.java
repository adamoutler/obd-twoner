
public class Mode05 {
        private static int ModeComp = 0;
        private static String mode = "05";
        private static String SubTest = "1";

	
	public static void modeSwitch(){
            SubTest = "1";
            mode = "05";
        Status.CheckToken = Status.LineToken.nextToken();
        int switchToken = Integer.parseInt(Status.CheckToken,16);   
    	Log.level3("Mode 5: " + Status.CheckToken);
     	switch (switchToken) {
     		case 1: richToLean(); break;
     		case 2: leanToRich(); break;
     	}
	}
	
    private static void leanToRich() {
        Status.CheckToken = Status.LineToken.nextToken();
        int switchToken = 0;
        switchToken = Integer.parseInt(Status.CheckToken,16);   
    	Log.level3("LeanToRich: " + Status.CheckToken);
    	switch (switchToken) {
        	case 1: mode5O2B1S1LeanToRichThreshold(); break;
        	case 2: mode5O2B1S2LeanToRichThreshold(); break;
        	case 3: mode5O2B1S3LeanToRichThreshold(); break;
        	case 4: mode5O2B1S4LeanToRichThreshold(); break;
        	case 5: mode5O2B2S1LeanToRichThreshold(); break;
        	case 6: mode5O2B2S2LeanToRichThreshold(); break;
        	case 7: mode5O2B2S3LeanToRichThreshold(); break;
        	case 8: mode5O2B2S4LeanToRichThreshold(); break;
        	case 9: mode5O2B3S1LeanToRichThreshold(); break;
        	case 10: mode5O2B3S2LeanToRichThreshold(); break;
        	case 11: mode5O2B3S3LeanToRichThreshold(); break;
        	case 12: mode5O2B3S4LeanToRichThreshold(); break;
        	case 13: mode5O2B4S1LeanToRichThreshold(); break;
        	case 14: mode5O2B4S2LeanToRichThreshold(); break;
        	case 15: mode5O2B4S3LeanToRichThreshold(); break;
        	case 16: mode5O2B4S4LeanToRichThreshold(); break;
        }
    
    }

	private static void richToLean() {
        Status.CheckToken = Status.LineToken.nextToken();
        int switchToken = 0;
        switchToken = Integer.parseInt(Status.CheckToken,16);   
    	Log.level3("RichToLean:" + Status.CheckToken);

		switch (switchToken){
        	case 0: getOBDMonitorSupported1to20(); break;
			case 1: mode5O2B1S1RichToLeanThreshold(); break;
			case 2: mode5O2B1S2RichToLeanThreshold(); break;
			case 3: mode5O2B1S3RichToLeanThreshold(); break;
			case 4: mode5O2B1S4RichToLeanThreshold(); break;
			case 5: mode5O2B2S1RichToLeanThreshold(); break;
			case 6: mode5O2B2S2RichToLeanThreshold(); break;
			case 7: mode5O2B2S3RichToLeanThreshold(); break;
			case 8: mode5O2B2S4RichToLeanThreshold(); break;
			case 9: mode5O2B3S1RichToLeanThreshold(); break;
			case 10: mode5O2B3S2RichToLeanThreshold(); break;
			case 11: mode5O2B3S3RichToLeanThreshold(); break;
			case 12: mode5O2B3S4RichToLeanThreshold(); break;
			case 13: mode5O2B4S1RichToLeanThreshold(); break;
			case 14: mode5O2B4S2RichToLeanThreshold(); break;
			case 15: mode5O2B4S3RichToLeanThreshold(); break;
			case 16: mode5O2B4S4RichToLeanThreshold(); break;
		}
	}

        //TODO this
	private static void getOBDMonitorSupported1to20() {

		
	}

        private static float getSensorValue(){

            float x =(float) (Integer.parseInt(Status.LineToken.nextToken(), 16) * .005);
            return x;
        }
    private static void mode5O2B1S1RichToLeanThreshold() {
        
        String TID = "0101";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B1S2RichToLeanThreshold() {
        
        String TID = "0102";
    	

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B1S3RichToLeanThreshold() {
    	
        String TID = "0103";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B1S4RichToLeanThreshold() {
    	
        String TID = "0104";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S1RichToLeanThreshold() {
    	
        String TID = "0105";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S2RichToLeanThreshold() {
        
        String TID = "0106";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S3RichToLeanThreshold() {
   	
        String TID = "0107";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S4RichToLeanThreshold() {
   	
        String TID = "0108";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S1RichToLeanThreshold() {
   	
        String TID = "0109";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S2RichToLeanThreshold() {
   	
        String TID = "010A";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S3RichToLeanThreshold() {
   	
        String TID = "010B";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S4RichToLeanThreshold() {
   	
        String TID = "010C";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S1RichToLeanThreshold() {
     	
        String TID = "010D";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S2RichToLeanThreshold() {
     	
        String TID = "010E";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S3RichToLeanThreshold() {
     	
        String TID = "010F";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S4RichToLeanThreshold() {
     	
        String TID = "0110";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    
    
    private static void mode5O2B1S1LeanToRichThreshold() {
     	
        String TID = "0201";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B1S2LeanToRichThreshold() {
     	
        String TID = "0202";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B1S3LeanToRichThreshold() {
     	
        String TID = "0203";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B1S4LeanToRichThreshold() {
     	
        String TID = "0204";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S1LeanToRichThreshold() {
     	
        String TID = "0205";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S2LeanToRichThreshold() {
     	
        String TID = "0206";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S3LeanToRichThreshold() {
     	
        String TID = "0207";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B2S4LeanToRichThreshold() {
     	
        String TID = "0208";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S1LeanToRichThreshold() {
     	
        String TID = "0209";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S2LeanToRichThreshold() {
     	
        String TID = "020A";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S3LeanToRichThreshold() {
     	
        String TID = "020B";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B3S4LeanToRichThreshold() {
     	
        String TID = "020C";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S1LeanToRichThreshold() {
     	
        String TID = "020D";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S2LeanToRichThreshold() {
     	
        String TID = "020E";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S3LeanToRichThreshold() {
     	
        String TID = "020F";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
    private static void mode5O2B4S4LeanToRichThreshold() {
     	
        String TID = "0210";

        int Line = Database.setDataValue(mode, TID, SubTest, getSensorValue());
        Log.StandardDataFromTable(Line);

    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
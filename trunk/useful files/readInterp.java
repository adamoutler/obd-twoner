import java.io.*;
import java.util.StringTokenizer;


public class readInterp {
	public static float PIDSSUPPORTED01TO20;
	public static float STATUS;
	public static float FREEZEDTC;
	public static float FUELSYSTEMSTATUS;
	public static float ENGINELOAD;
	public static float COOLANTTEMP;
	public static float STFUELTRIM1;
	public static float LTFUELTRIM1;
	public static float STFUELTRIM2;
	public static float LTFUELTRIM2;
	public static float FUELPRESSURE;
	public static float MAP;
	public static float RPM;
	public static float MPH;
	public static float TIMINGADVANCE;
	public static float TPS;
	public static float COMMANDEDSECCONDARYAIRSTATUS;
	public static float O2SENSORSPRESENT;
	public static float O2B1S1;
	public static float O2B1S2;
	public static float O2B1S3;
	public static float O2B1S4;
	public static float O2B2S1;
	public static float O2B2S2;
	public static float O2B2S3;
	public static float O2B2S4;
	public static float OBDSTANDARDS;
	public static float O2SENSORSPRESENTADDTIONAL;
	public static float AUXINPUTSTATUS;
	public static float ENGINERUNTIME;
	public static float PIDSSUPPORTED21TO40;
	public static float DISTICESINCEMIL;
	public static float FUELRAILPRESSURE;
	public static float DISELFUELRAILPRESSURE;
	public static float WBO2S1;
	public static float WBO2S2;
	public static float WBO2S3;
	public static float WBO2S4;
	public static float WBO2S5;
	public static float WBO2S6;
	public static float WBO2S7;
	public static float WBO2S8;
	public static float CATTEMPB1S1;
	public static float CATTEMPB2S1;
	public static float CATTEMPB1S2;
	public static float CATTEMPB2S2;
	public static float PIDSSUPPORTED41TO60;
	public static float MONITORSTATUSTHISDRIVECYCLE;
	public static float CONTROLMODULEVOLTS;
	public static float ABSOLUTELOADVALUE;
	public static float COMMANDEQUIVALANCERATIO;
	public static float RELATIVETHROTTLEPOSITION;
	public static float AMBIENTAIRTEMP;
	public static float ABSOLUTETHROTTLEB;
	public static float ABSOLUTETHROTTLED;
	public static float ABSOLUTETHROTTLEE;
	public static float ABSOLUTETHROTTLEF;
	public static float COMMANDEDTHROTTLEPOSITION;
	public static float TIMERUNWITHMIL;
	public static float TIMESINCETROUBLECODESCLEARED;
	public static float FUELTYPE;
	public static float ETHANOLFUELPERCENT;
	public static float ABSOLUTEEVAPSYSTEMPRESSURE;
	public static float UNKNOWNPID;
	public static float UNKNOWNPID2;
	public static float MODE2FREEZEFRAME;
	public static float MODE3TROUBLECODES;
	public static float MODE5O2B1S1RICHTOLEANTHRESHOLD;
	public static float MODE5O2B1S2RICHTOLEANTHRESHOLD;
	public static float MODE5O2B1S3RICHTOLEANTHRESHOLD;
	public static float MODE5O2B1S4RICHTOLEANTHRESHOLD;
	public static float MODE5O2B2S1RICHTOLEANTHRESHOLD;
	public static float MODE5O2B2S2RICHTOLEANTHRESHOLD;
	public static float MODE5O2B2S3RICHTOLEANTHRESHOLD;
	public static float MODE5O2B2S4RICHTOLEANTHRESHOLD;
	public static float MODE5O2B3S1RICHTOLEANTHRESHOLD;
	public static float MODE5O2B3S2RICHTOLEANTHRESHOLD;
	public static float MODE5O2B3S3RICHTOLEANTHRESHOLD;
	public static float MODE5O2B3S4RICHTOLEANTHRESHOLD;
	public static float MODE5O2B4S1RICHTOLEANTHRESHOLD;
	public static float MODE5O2B4S2RICHTOLEANTHRESHOLD;
	public static float MODE5O2B4S3RICHTOLEANTHRESHOLD;
	public static float MODE5O2B4S4RICHTOLEANTHRESHOLD;
	public static float MODE5O2B1S1LEANTORICHTHRESHOLD;
	public static float MODE5O2B1S2LEANTORICHTHRESHOLD;
	public static float MODE5O2B1S3LEANTORICHTHRESHOLD;
	public static float MODE5O2B1S4LEANTORICHTHRESHOLD;
	public static float MODE5O2B2S1LEANTORICHTHRESHOLD;
	public static float MODE5O2B2S2LEANTORICHTHRESHOLD;
	public static float MODE5O2B2S3LEANTORICHTHRESHOLD;
	public static float MODE5O2B2S4LEANTORICHTHRESHOLD;
	public static float MODE5O2B3S1LEANTORICHTHRESHOLD;
	public static float MODE5O2B3S2LEANTORICHTHRESHOLD;
	public static float MODE5O2B3S3LEANTORICHTHRESHOLD;
	public static float MODE5O2B3S4LEANTORICHTHRESHOLD;
	public static float MODE5O2B4S1LEANTORICHTHRESHOLD;
	public static float MODE5O2B4S2LEANTORICHTHRESHOLD;
	public static float MODE5O2B4S3LEANTORICHTHRESHOLD;
	public static float MODE5O2B4S4LEANTORICHTHRESHOLD;
	public static float MODE9SUPPORTEDPIDS;
	public static float MODE9VIN;
	public static float MODE9CALIBRATIONID;
	public static float MODE9CALIBRATION;
	public static StringTokenizer LINETOKEN;
	public static String CHECKTOKEN;

	
	// Stream to write file
	public static void main (String args[]) throws IOException	{
       
       
		String inputFile = "/home/adam/stream";
		readFile(inputFile);
 
	}	

    public static void readFile(String fromFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fromFile));
        
        //Loop as long as there are input lines.
        String line = null;

        while ((line=reader.readLine()) != null )  {
              if (line.length() >= 2) { 

                   LINETOKEN = new StringTokenizer (line);     
      
               	   CHECKTOKEN = LINETOKEN.nextToken();



               	   if ( CHECKTOKEN.contains("41")) {


                      /* This is the section
                       * where the response 41
                       * is interperated, data
                       * is extrapolated, and
                       * then placed into a variable
                       */
                        CHECKTOKEN = LINETOKEN.nextToken();
                        int switchToken = 0;
                        switchToken = Integer.parseInt(CHECKTOKEN,16);   
                    	System.out.println(CHECKTOKEN);
                        //check for calculated engine load
                        switch (switchToken) {
                        case 0: getPIDsSupported01to20(); break;
                        case 1: getStatus(); break;
                        case 2: freezeDTC(); break;
                        case 3: getFuelSystemStatus(); break;
                        case 4: getEngineLoad(); break;
                        case 5: getCoolantTemp(); break;
                        case 6: getSTFuelTrim1(); break;
                        case 7: getLTFuelTrim1(); break;
                        case 8: getSTFuelTrim2(); break;
                        case 9: getLTFuelTrim2(); break;
                        case 10: getfuelPressure(); break;
                        case 11: getMAP(); break;
                        case 12: getRPM(); break;
                        case 13: getMPH(); break;
                        case 14: getTimingAdvance(); break;
                        case 15: getTPS(); break;
                        case 16: getCommandedSeccondaryAirStatus(); break;
                        case 17: getO2SensorsPresent(); break;
                        case 18: getO2B1S1(); break;
                        case 19: getO2B1S2(); break;
                        case 20: getO2B1S3(); break;
                        case 21: getO2B1S4(); break;
                        case 22: getO2B2S1(); break;
                        case 23: getO2B2S2(); break;
                        case 24: getO2B2S3(); break;
                        case 25: getO2B2S4(); break;
                        case 26: getOBDStandards(); break;
                        case 27: geto2SensorsPresentAddtional(); break;
                        case 28: getAuxInputStatus(); break;
                        case 29: getEngineRunTime(); break;
                        case 30: getPIDsSupported21to40(); break;
                        case 31: getDisticeSinceMIL(); break;
                        case 32: getFuelRailPressure(); break;
                        case 33: getDiselFuelRailPressure(); break;
                        case 34: getWBO2S1(); break;
                        case 35: getWBO2S2(); break;
                        case 36: getWBO2S3(); break;
                        case 37: getWBO2S4(); break;
                        case 38: getWBO2S5(); break;
                        case 39: getWBO2S6(); break;
                        case 40: getWBO2S7(); break;
                        case 41: getWBO2S8(); break;
                        case 42: getCatTempB1S1(); break;
                        case 43: getCatTempB2S1(); break;
                        case 44: getCatTempB1S2(); break;
                        case 45: getCatTempB2S2(); break;
                        case 46: getPIDsSupported41to60(); break;
                        case 47: getMonitorStatusThisDriveCycle(); break;
                        case 48: getControlModuleVolts(); break;
                        case 49: getAbsoluteLoadValue(); break;
                        case 50: getCommandEquivalanceRatio(); break;
                        case 51: getRelativeThrottlePosition(); break;
                        case 52: getAmbientAirTemp(); break;
                        case 53: getAbsoluteThrottleB(); break;
                        case 54: getAbsoluteThrottleD(); break;
                        case 55: getAbsoluteThrottleE(); break;
                        case 56: getAbsoluteThrottleF(); break;
                        case 57: getCommandedThrottlePosition(); break;
                        case 58: getTimeRunWithMIL(); break;
                        case 59: getTimeSinceTroubleCodesCleared(); break;
                        case 60: getFuelType(); break;
                        case 61: getEthanolFuelPercent(); break;
                        case 62: getAbsoluteEvapSystemPressure(); break;
                        case 63: UnknownPID(); break;
                        case 64: UnknownPID2(); break;
                        case 65: mode2FreezeFrame(); break;
                        case 66: mode3TroubleCodes(); break;
                        case 67: mode5O2B1S1RichToLeanThreshold(); break;
                        case 68: mode5O2B1S2RichToLeanThreshold(); break;
                        case 69: mode5O2B1S3RichToLeanThreshold(); break;
                        case 70: mode5O2B1S4RichToLeanThreshold(); break;
                        case 71: mode5O2B2S1RichToLeanThreshold(); break;
                        case 72: mode5O2B2S2RichToLeanThreshold(); break;
                        case 73: mode5O2B2S3RichToLeanThreshold(); break;
                        case 74: mode5O2B2S4RichToLeanThreshold(); break;
                        case 75: mode5O2B3S1RichToLeanThreshold(); break;
                        case 76: mode5O2B3S2RichToLeanThreshold(); break;
                        case 77: mode5O2B3S3RichToLeanThreshold(); break;
                        case 78: mode5O2B3S4RichToLeanThreshold(); break;
                        case 79: mode5O2B4S1RichToLeanThreshold(); break;
                        case 80: mode5O2B4S2RichToLeanThreshold(); break;
                        case 81: mode5O2B4S3RichToLeanThreshold(); break;
                        case 82: mode5O2B4S4RichToLeanThreshold(); break;
                        case 83: mode5O2B1S1LeanToRichThreshold(); break;
                        case 84: mode5O2B1S2LeanToRichThreshold(); break;
                        case 85: mode5O2B1S3LeanToRichThreshold(); break;
                        case 86: mode5O2B1S4LeanToRichThreshold(); break;
                        case 87: mode5O2B2S1LeanToRichThreshold(); break;
                        case 88: mode5O2B2S2LeanToRichThreshold(); break;
                        case 89: mode5O2B2S3LeanToRichThreshold(); break;
                        case 90: mode5O2B2S4LeanToRichThreshold(); break;
                        case 91: mode5O2B3S1LeanToRichThreshold(); break;
                        case 92: mode5O2B3S2LeanToRichThreshold(); break;
                        case 93: mode5O2B3S3LeanToRichThreshold(); break;
                        case 94: mode5O2B3S4LeanToRichThreshold(); break;
                        case 95: mode5O2B4S1LeanToRichThreshold(); break;
                        case 96: mode5O2B4S2LeanToRichThreshold(); break;
                        case 97: mode5O2B4S3LeanToRichThreshold(); break;
                        case 98: mode5O2B4S4LeanToRichThreshold(); break;
                        case 99: getMode9SupportedPIDs(); break;
                        case 100: getMode9VIN(); break;
                        case 101: getMode9CalibrationID(); break;
                        case 102: getMode9Calibration(); break;



                        }
                        
                        
                        if (CHECKTOKEN.contains("04")) {

                        }
                   } else if (line.endsWith(">")) {
                	    //Send data to OBD unit
                   } else if (LINETOKEN != null) {
                	   //blank line catch
                   }
              }
  
        }
        reader.close();  // Close to unlock.
     
    }
    public static void getPIDsSupported01to20() {
        CHECKTOKEN = LINETOKEN.nextToken();
    	System.out.println(CHECKTOKEN);
    	
    }
    public static void getStatus() {
        CHECKTOKEN = LINETOKEN.nextToken();
    	STATUS = Integer.parseInt(CHECKTOKEN,16) ;
    	System.out.println("NumberOfCodes:" + STATUS );
    }
    public static void freezeDTC() {
        CHECKTOKEN = LINETOKEN.nextToken();
    	System.out.println(CHECKTOKEN);
    	
    }
    public static void getFuelSystemStatus() {
        CHECKTOKEN = LINETOKEN.nextToken();
    	System.out.println(CHECKTOKEN);
    	
    }
    public static void getEngineLoad() {
    	CHECKTOKEN = LINETOKEN.nextToken();    	
    	ENGINELOAD = Integer.parseInt(CHECKTOKEN,16) ;
    	ENGINELOAD = ENGINELOAD * 100/255;
    	System.out.println("EngineLoad:" + ENGINELOAD +"%" );
    }
    public static void getCoolantTemp() {
        CHECKTOKEN = LINETOKEN.nextToken();

    	COOLANTTEMP = Integer.parseInt(CHECKTOKEN)-40 ;
    	System.out.println("coolantTemp=" + COOLANTTEMP + "C");
    	
    }
    public static void getSTFuelTrim1() {
        CHECKTOKEN = LINETOKEN.nextToken();
    	System.out.println(CHECKTOKEN);
    }
    public static void getLTFuelTrim1() {
    	
    }
    public static void getSTFuelTrim2() {
    	
    }
    public static void getLTFuelTrim2() {
    	
    }
    public static void getfuelPressure() {
    	
    }
    public static void getMAP() {
    	
    }
    public static void getRPM() {
    	
    }
    public static void getMPH() {
    	
    }
    public static void getTimingAdvance() {
    	
    }
    public static void getTPS() {
    	
    }
    public static void getCommandedSeccondaryAirStatus() {
    	
    }
    public static void getO2SensorsPresent() {
    	
    }
    public static void getO2B1S1() {
    	
    }
    public static void getO2B1S2() {
    	
    }
    public static void getO2B1S3() {
    	
    }
    public static void getO2B1S4() {
    	
    }
    public static void getO2B2S1() {
    	
    }
    public static void getO2B2S2() {
    	
    }
    public static void getO2B2S3() {
    	
    }
    public static void getO2B2S4() {
    	
    }
    public static void getOBDStandards() {
    	
    }
    public static void geto2SensorsPresentAddtional() {
    	
    }
    public static void getAuxInputStatus() {
    	
    }
    public static void getEngineRunTime() {
    	
    }
    public static void getPIDsSupported21to40() {
    	
    }
    public static void getDisticeSinceMIL() {
    	
    }
    public static void getFuelRailPressure() {
    	
    }
    public static void getDiselFuelRailPressure() {
    	
    }
    public static void getWBO2S1() {
    	
    }
    public static void getWBO2S2() {
    	
    }
    public static void getWBO2S3() {
    	
    }
    public static void getWBO2S4() {
    	
    }
    public static void getWBO2S5() {
    	
    }
    public static void getWBO2S6() {
    	
    }
    public static void getWBO2S7() {
    	
    }
    public static void getWBO2S8() {
    	
    }
    public static void getCatTempB1S1() {
    	
    }
    public static void getCatTempB2S1() {
    	
    }
    public static void getCatTempB1S2() {
    	
    }
    public static void getCatTempB2S2() {
    	
    }
    public static void getPIDsSupported41to60() {
    	
    }
    public static void getMonitorStatusThisDriveCycle() {
    	
    }
    public static void getControlModuleVolts() {
    	
    }
    public static void getAbsoluteLoadValue() {
    	
    }
    public static void getCommandEquivalanceRatio() {
    	
    }
    public static void getRelativeThrottlePosition() {
    	
    }
    public static void getAmbientAirTemp() {
    	
    }
    public static void getAbsoluteThrottleB() {
    	
    }
    public static void getAbsoluteThrottleD() {
    	
    }
    public static void getAbsoluteThrottleE() {
    	
    }
    public static void getAbsoluteThrottleF() {
    	
    }
    public static void getCommandedThrottlePosition() {
    	
    }
    public static void getTimeRunWithMIL() {
    	
    }
    public static void getTimeSinceTroubleCodesCleared() {
    	
    }
    public static void getFuelType() {
    	
    }
    public static void getEthanolFuelPercent() {
    	
    }
    public static void getAbsoluteEvapSystemPressure() {
    	
    }
    public static void UnknownPID() {
    	
    }
    public static void UnknownPID2() {
    	
    }
    public static void mode2FreezeFrame() {
    	
    }
    public static void mode3TroubleCodes() {
    	
    }
    public static void mode5O2B1S1RichToLeanThreshold() {
    	
    }
    public static void mode5O2B1S2RichToLeanThreshold() {
    	
    }
    public static void mode5O2B1S3RichToLeanThreshold() {
    	
    }
    public static void mode5O2B1S4RichToLeanThreshold() {
    	
    }
    public static void mode5O2B2S1RichToLeanThreshold() {
    	
    }
    public static void mode5O2B2S2RichToLeanThreshold() {
    	
    }
    public static void mode5O2B2S3RichToLeanThreshold() {
    	
    }
    public static void mode5O2B2S4RichToLeanThreshold() {
    	
    }
    public static void mode5O2B3S1RichToLeanThreshold() {
    	
    }
    public static void mode5O2B3S2RichToLeanThreshold() {
    	
    }
    public static void mode5O2B3S3RichToLeanThreshold() {
    	
    }
    public static void mode5O2B3S4RichToLeanThreshold() {
    	
    }
    public static void mode5O2B4S1RichToLeanThreshold() {
    	
    }
    public static void mode5O2B4S2RichToLeanThreshold() {
    	
    }
    public static void mode5O2B4S3RichToLeanThreshold() {
    	
    }
    public static void mode5O2B4S4RichToLeanThreshold() {
    	
    }
    
    
    public static void mode5O2B1S1LeanToRichThreshold() {
    	
    }
    public static void mode5O2B1S2LeanToRichThreshold() {
    	
    }
    public static void mode5O2B1S3LeanToRichThreshold() {
    	
    }
    public static void mode5O2B1S4LeanToRichThreshold() {
    	
    }
    public static void mode5O2B2S1LeanToRichThreshold() {
    	
    }
    public static void mode5O2B2S2LeanToRichThreshold() {
    	
    }
    public static void mode5O2B2S3LeanToRichThreshold() {
    	
    }
    public static void mode5O2B2S4LeanToRichThreshold() {
    	
    }
    public static void mode5O2B3S1LeanToRichThreshold() {
    	
    }
    public static void mode5O2B3S2LeanToRichThreshold() {
    	
    }
    public static void mode5O2B3S3LeanToRichThreshold() {
    	
    }
    public static void mode5O2B3S4LeanToRichThreshold() {
    	
    }
    public static void mode5O2B4S1LeanToRichThreshold() {
    	
    }
    public static void mode5O2B4S2LeanToRichThreshold() {
    	
    }
    public static void mode5O2B4S3LeanToRichThreshold() {
    	
    }
    public static void mode5O2B4S4LeanToRichThreshold() {
    	
    }

    public static void getMode9SupportedPIDs() {
    	
    }
    public static void getMode9VIN() {
    	
    }
    public static void getMode9CalibrationID() {
    	
    }
    public static void getMode9Calibration() {
    	
    }
    
}

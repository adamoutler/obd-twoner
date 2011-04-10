
import java.util.StringTokenizer;

public class Mode01or02 {
    public static int ModeComp;
    private static String Mode="";

    private static String SubTest = "1";
    private static String StrValue = "";
	public static void modeSwitch(StringTokenizer Line, String mode1or2) {
            //ModeComp refactors the table reference for mode 1/2
            Mode=mode1or2;
            ModeComp=0;
            SubTest="1";
            StrValue="";
                    

		/*
		 * This is the section where the response 41 MODE $01 is interpreted,
		 * data is extrapolated, and then placed into a variable
		 */
		
		
		int switchToken = Integer.parseInt(Line.nextToken(), 16);
		Log.level2("Request: " + Status.CheckToken);
		// check for calculated engine load
		switch (switchToken) {
		case 0:
			getPIDsSupported01to20(Line);
			break;
		case 1:
			getStatus(Line);
			break;
		case 2:
			freezeDTC(Line);
			break;
		case 3:
			getFuelSystemStatus(Line);
			break;
		case 4:
			getEngineLoad(Line);
			break;
		case 5:
			getCoolantTemp(Line);
			break;
		case 6:
			getSTFuelTrim1(Line);
			break;
		case 7:
			getLTFuelTrim1(Line);
			break;
		case 8:
			getSTFuelTrim2(Line);
			break;
		case 9:
			getLTFuelTrim2(Line);
			break;
		case 10:
			getfuelPressure(Line);
			break;
		case 11:
			getMAP(Line);
			break;
		case 12:
			getRPM(Line);
			break;
		case 13:
			getMPH(Line);
			break;
		case 14:
			getTimingAdvance(Line);
			break;
		case 15:
			getIAT(Line);
			break;
		case 16:
			getMAF(Line);
			break;
		case 17:
			getTPS(Line);
			break;
		case 18:
			getCommandedSecondaryAirStatus(Line);
			break;
		case 19:
			getO2SensorsPresent(Line);
			break;
		case 20:
			getO2B1S1(Line);
			break;
		case 21:
			getO2B1S2(Line);
			break;
		case 22:
			getO2B1S3(Line);
			break;
		case 23:
			getO2B1S4(Line);
			break;
		case 24:
			getO2B2S1(Line);
			break;
		case 25:
			getO2B2S2(Line);
			break;
		case 26:
			getO2B2S3(Line);
			break;
		case 27:
			getO2B2S4(Line);
			break;
		case 28:
			getOBDStandards(Line);
			break;
		case 29:
			geto2SensorsPresentAddtional(Line);
			break;
		case 30:
			getAuxInputStatus(Line);
			break;
		case 31:
			getEngineRunTime(Line);
			break;
		case 32:
			getPIDsSupported21to40(Line);
			break;
		case 33:
			getDistanceSinceMIL(Line);
			break;
		case 34:
			getFuelRailPressure(Line);
			break;
		case 35:
			getDiselFuelRailPressure(Line);
			break;
		case 36:
			getWBO2S1Volts(Line);
			break;
		case 37:
			getWBO2S2Volts(Line);
			break;
		case 38:
			getWBO2S3Volts(Line);
			break;
		case 39:
			getWBO2S4Volts(Line);
			break;
		case 40:
			getWBO2S5Volts(Line);
			break;
		case 41:
			getWBO2S6Volts(Line);
			break;
		case 42:
			getWBO2S7Volts(Line);
			break;
		case 43:
			getWBO2S8Volts(Line);
			break;
		case 44:
			getCommandedEGR(Line);
			break;
		case 45:
			getEGRError(Line);
			break;
		case 46:
			getCommandedEvaporativePurge(Line);
			break;
		case 47:
			getFuelLevelInput(Line);
			break;
		case 48:
			getNumberOfWarmupsSinceCodesCleared(Line);
			break;
		case 49:
			getDistanceTraveledSinceCodesCeleared(Line);
			break;
		case 50:
			getEvapSystemVaporPressure(Line);
			break;
		case 51:
			getBarometricPresure(Line);
			break;
		case 52:
			getWBO2S1Current(Line);
			break;
		case 53:
			getWBO2S2Current(Line);
			break;
		case 54:
			getWBO2S3Current(Line);
			break;
		case 55:
			getWBO2S4Current(Line);
			break;
		case 56:
			getWBO2S5Current(Line);
			break;
		case 57:
			getWBO2S6Current(Line);
			break;
		case 58:
			getWBO2S7Current(Line);
			break;
		case 59:
			getWBO2S8Current(Line);
			break;
		case 60:
			getCatTempB1S1(Line);
			break;
		case 61:
			getCatTempB2S1(Line);
			break;
		case 62:
			getCatTempB1S2(Line);
			break;
		case 63:
			getCatTempB2S2(Line);
			break;
		case 64:
			getPIDsSupported41to60(Line);
			break;
		case 65:
			getMonitorStatusThisDriveCycle(Line);
			break;
		case 66:
			getControlModuleVolts(Line);
			break;
		case 67:
			getAbsoluteLoadValue(Line);
			break;
		case 68:
			getCommandEquivalenceRatio(Line);
			break;
		case 69:
			getRelativeThrottlePosition(Line);
			break;
		case 70:
			getAmbientAirTemp(Line);
			break;
		case 71:
			getAbsoluteThrottleB(Line);
			break;
		case 72:
			getAbsoluteThrottleC(Line);
			break;
		case 73:
			getAbsoluteThrottleD(Line);
			break;
		case 74:
			getAbsoluteThrottleE(Line);
			break;
		case 75:
			getAbsoluteThrottleF(Line);
			break;
		case 76:
			getCommandedThrottlePosition(Line);
			break;
		case 77:
			getTimeRunWithMIL(Line);
			break;
		case 78:
			getTimeSinceTroubleCodesCleared(Line);
			break;
		case 81:
			getFuelType(Line);
			break;
		case 82:
			getEthanolFuelPercent(Line);
			break;
		case 83:
			getAbsoluteEvapSystemPressure(Line);
			break;
		case 195:
			UnknownPID(Line);
			break;
		case 196:
			UnknownPID2(Line);
			break;
		case 200:
			Log.level0("UNKNOWN CODE" + Line);
			break;
		}
	}

	private static void getFuelLevelInput(StringTokenizer Line) {

                String TID = "2F";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}

                int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, 100 * A / 255);
                
		Log.StandardDataFromTable(LineNumber);
	}

	private static void getMAF(StringTokenizer Line) {

                String TID = "10";
                


		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken(), 16);
		int B = Integer.parseInt(Line.nextToken(), 16);
                
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, (((A * 256) + B) / 100));
		
                Log.StandardDataFromTable(LineNumber);
        }

	private static void getIAT(StringTokenizer Line) {

                String TID = "0f";
                

            if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
		Log.infoError();
            	return;
            }
            Status.CheckToken = Line.nextToken();
		

                Status.IATC=Integer.parseInt(Status.CheckToken, 16) - 40;
                Status.IATF = ((Status.IATC * (9 / 5)) + 32);

            if (Status.Celcius){

                int LineNumber = Database.setDataValue(Mode, TID, SubTest, Status.IATC);
                Database.setDataUnits(Mode, TID, SubTest, "°C");
                Log.StandardDataFromTable(LineNumber);
            } else {
               
                int LineNumber = Database.setDataValue(Mode, TID, SubTest,Status.IATF);
                
                LineNumber=Database.setDataUnits(Mode, TID, SubTest, "°F");
                Log.StandardDataFromTable(LineNumber);
            }
	}

	private static void getWBO2S8Current(StringTokenizer Line) {

                String TID = "3B";
                

		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S7Current(StringTokenizer Line) {

                String TID = "3A";
                

		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S6Current(StringTokenizer Line) {

                String TID = "39";
                
		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S5Current(StringTokenizer Line) {

                String TID = "38";
                

		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);


	}

	private static void getWBO2S4Current(StringTokenizer Line) {

                String TID = "37";
                
		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);


	}

	private static void getWBO2S3Current(StringTokenizer Line) {

                String TID = "36";
                
		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S2Current(StringTokenizer Line) {

                String TID = "35";
                
		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);


	}

	private static void getWBO2S1Current(StringTokenizer Line) {

                String TID = "34";
                

		// tokens are called from getWideBandValue() and current
                int LineNumber = Database.setDataUnits(Mode, TID, SubTest, getWideBandValue(Line));
                Log.StandardDataFromTable(LineNumber);

                LineNumber = Database.setDataUnits(Mode, TID, "2",getWideBandEQRatio(Line) );
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getBarometricPresure(StringTokenizer Line) {

                String TID = "33";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
//TODO Check for accuracy
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.parseInt(Line.nextToken() , 16));
		Log.StandardDataFromTable(LineNumber);
	}

	private static void getEvapSystemVaporPressure(StringTokenizer Line) {

                String TID = "32";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}

		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, ((A * 256) + B) / 4);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getDistanceTraveledSinceCodesCeleared(StringTokenizer Line) {

                String TID = "31";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}

                //TODO check for accuracy
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.parseInt(Line.nextToken(),16));
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getNumberOfWarmupsSinceCodesCleared(StringTokenizer Line) {

                String TID = "30";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
   //TODO Check for acccuracy
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.parseInt(Line.nextToken(),16));
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCommandedEvaporativePurge(StringTokenizer Line) {

                String TID = "2E";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,100 * A / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getEGRError(StringTokenizer Line) {

                String TID = "2D";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A - 128) * 100 / 128);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCommandedEGR(StringTokenizer Line) {

                String TID = "2C";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {Log.infoError();
			return;
		}

		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,100 * A / 255);
                Log.StandardDataFromTable(LineNumber);
	}

	private static void getPIDsSupported01to20(StringTokenizer Line) {

                String TID = "00";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 4) {
			Log.infoError();
			return;
		}

		String A = BinaryConvert.getBinaryString(Line.nextToken());
		String B = BinaryConvert.getBinaryString(Line.nextToken());
		String C = BinaryConvert.getBinaryString(Line.nextToken());
		String D = BinaryConvert.getBinaryString(Line.nextToken());
		Status.PIDsSupported01To20 = (BinaryConvert.getBinaryArrayFromBinaryString(A + B + C + D));
                
 
                int LineNumber=Database.setDataValue(Mode, TID, SubTest, A+B+C+D);
                Log.StandardDataFromTable(LineNumber);
                return;
	}

	private static void getStatus(StringTokenizer Line) {

                String TID = "01";

                int LineNumber;

		if (BinaryConvert.checkNumberOfTokensLeft() != 4) {
			Log.infoError();
			return;
		}

		Status.CheckToken = Line.nextToken();
		boolean[] StatusArray = new boolean[8];
		StatusArray = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		// Check Engine Light is on or off
                
		if (StatusArray[0]) {
			LineNumber = Database.setDataValue(Mode, TID, "2", "ON");
                        Log.StandardDataFromTable(LineNumber);
			LineNumber = Database.setDataValue(Mode, TID, "3", Integer.parseInt(Status.CheckToken) - 1);
                        Log.StandardDataFromTable(LineNumber);
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "2", "OFF");
                        Log.StandardDataFromTable(LineNumber);
			LineNumber = Database.setDataValue(Mode, TID, "3", "0");
                        Log.StandardDataFromTable(LineNumber);
		}
		// obtain next few bytes and process into binary arrays
		Status.StatusArrayA = StatusArray;
		Status.CheckToken = Line.nextToken();
		boolean[] B = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		Status.StatusArrayB = B;
		Status.CheckToken = Line.nextToken();
		boolean[] C = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		Status.StatusArrayC = C;
		Status.CheckToken = Line.nextToken();
		boolean[] D = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		Status.StatusArrayD = D;
                
		// Process bits as per specs
                
		if (B[0]) {
			if (B[4]) {
                            LineNumber = Database.setDataValue(Mode, TID, "5","Test Complete");

			} else {
				LineNumber = Database.setDataValue(Mode, TID, "4","Test Complete");
			}
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "4", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
                
		if (B[1]) {
			if (B[5]) {
				LineNumber = Database.setDataValue(Mode, TID, "5","Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "5" , "Test Complete");
			}
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "5" , "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (B[2]) {
			if (B[6]) {
				 LineNumber = Database.setDataValue(Mode, TID, "6", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "6", "Test Complete");
			}
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "6", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
                
		if (B[3]) {
			if (B[7]) {
				LineNumber = Database.setDataValue(Mode, TID, "7", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "7", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "7", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
             
		if (C[0]) {
			if (D[0]) {
				 LineNumber = Database.setDataValue(Mode, TID, "8", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "8", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "8", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);


		if (C[1]) {
			if (D[1]) {
				 LineNumber = Database.setDataValue(Mode, TID, "9", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "9", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "9", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (C[2]) {
			if (D[2]) {
				 LineNumber = Database.setDataValue(Mode, TID, "10", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "10", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "10", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[3]) {
			if (D[3]) {
				 LineNumber = Database.setDataValue(Mode, TID, "11", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "11", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "11", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[4]) {
			if (D[4]) {
				 LineNumber = Database.setDataValue(Mode, TID, "12", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "12", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "12", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[5]) {
			if (D[5]) {
				 LineNumber = Database.setDataValue(Mode, TID, "13", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "13", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "13", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[6]) {
			if (D[6]) {
				 LineNumber = Database.setDataValue(Mode, TID, "14", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "14", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "14", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[7]) {
			if (D[7]) {
				 LineNumber = Database.setDataValue(Mode, TID, "15", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "15", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "15", "Test Not Available");
		}


	}

	private static void freezeDTC(StringTokenizer Line) {

                String TID = "02";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		// not present in Mode 1, only mode 2.
		boolean[] A = BinaryConvert
				.getBinaryArrayFromToken(Line.nextToken());
		boolean[] B = BinaryConvert
				.getBinaryArrayFromToken(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, firstDTCChar(A) + secondDTCChar(A) + thirdDTCChar(A)+ fourthDTCChar(B) + fifthDTCChar(B));
		Log.StandardDataFromTable(LineNumber);
	}

	private static String fifthDTCChar(boolean B[]) {



		if ((!B[3]) && (!B[2]) && (!B[1]) && (!B[0])) {
			return "0";
		}
		if ((!B[3]) && (!B[2]) && (!B[1]) && (B[0])) {
			return "1";
		}
		if ((!B[3]) && (!B[2]) && (B[1]) && (!B[0])) {
			return "2";
		}
		if ((!B[3]) && (!B[2]) && (B[1]) && (B[0])) {
			return "3";
		}
		if ((!B[3]) && (B[2]) && (!B[1]) && (!B[0])) {
			return "4";
		}
		if ((!B[3]) && (B[2]) && (!B[1]) && (B[0])) {
			return "5";
		}
		if ((!B[3]) && (B[2]) && (B[1]) && (!B[0])) {
			return "6";
		}
		if ((!B[3]) && (B[2]) && (B[1]) && (B[0])) {
			return "7";
		}
		if ((B[3]) && (!B[2]) && (!B[1]) && (!B[0])) {
			return "8";
		}
		if ((B[3]) && (!B[2]) && (!B[1]) && (B[0])) {
			return "9";
		}
		return "0";
	}

	private static String fourthDTCChar(boolean B[]) {
		if ((!B[7]) && (!B[6]) && (!B[5]) && (!B[4])) {
			return "0";
		}
		if ((!B[7]) && (!B[6]) && (!B[5]) && (B[4])) {
			return "1";
		}
		if ((!B[7]) && (!B[6]) && (B[5]) && (!B[4])) {
			return "2";
		}
		if ((!B[7]) && (!B[6]) && (B[5]) && (B[4])) {
			return "3";
		}
		if ((!B[7]) && (B[6]) && (!B[5]) && (!B[4])) {
			return "4";
		}
		if ((!B[7]) && (B[6]) && (!B[5]) && (B[4])) {
			return "5";
		}
		if ((!B[7]) && (B[6]) && (B[5]) && (!B[4])) {
			return "6";
		}
		if ((!B[7]) && (B[6]) && (B[5]) && (B[4])) {
			return "7";
		}
		if ((B[7]) && (!B[6]) && (!B[5]) && (!B[4])) {
			return "8";
		}
		if ((B[7]) && (!B[6]) && (!B[5]) && (B[4])) {
			return "9";
		}
		return "0";
	}

	private static String thirdDTCChar(boolean A[]) {
		if ((!A[3]) && (!A[2]) && (!A[1]) && (!A[0])) {
			return "0";
		}
		if ((!A[3]) && (!A[2]) && (!A[1]) && (A[0])) {
			return "1";
		}
		if ((!A[3]) && (!A[2]) && (A[1]) && (!A[0])) {
			return "2";
		}
		if ((!A[3]) && (!A[2]) && (A[1]) && (A[0])) {
			return "3";
		}
		if ((!A[3]) && (A[2]) && (!A[1]) && (!A[0])) {
			return "4";
		}
		if ((!A[3]) && (A[2]) && (!A[1]) && (A[0])) {
			return "5";
		}
		if ((!A[3]) && (A[2]) && (A[1]) && (!A[0])) {
			return "6";
		}
		if ((!A[3]) && (A[2]) && (A[1]) && (A[0])) {
			return "7";
		}
		if ((A[3]) && (!A[2]) && (!A[1]) && (!A[0])) {
			return "8";
		}
		if ((A[3]) && (!A[2]) && (!A[1]) && (A[0])) {
			return "9";
		}
		return "0";
	}

	private static String secondDTCChar(boolean A[]) {

		if ((A[5]) && (A[4])) {
			return "3";
		}
		if ((!A[5]) && (A[4])) {
			return "1";
		}
		if ((A[5]) && (!A[4])) {
			return "2";
		}
		return "0";
	}

	private static String firstDTCChar(boolean A[]) {
		if ((A[7]) && (A[6])) {
			return "U";
		}
		if ((!A[7]) && (A[6])) {
			return "C";
		}
		if ((A[7]) && (!A[6])) {
			return "B";
		}
		if ((!A[7]) && (!A[6])) {
			return "P";
		}
		return "0";
	}

	private static void getFuelSystemStatus(StringTokenizer Line) {

                String TID = "03";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}

		
		boolean[] A = BinaryConvert.getBinaryArrayFromToken(Line.nextToken());
		boolean[] B = BinaryConvert.getBinaryArrayFromToken(Line.nextToken());


                int LineNumber = Database.setDataValue(Mode, TID, SubTest, "");
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[0]) ? "OPEN LOOP-Low engine temperature "
				+ Database.getDataValue(Mode, TID, SubTest): Database.getDataValue(Mode, TID, SubTest));

		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[1]) ? "CLOSED LOOP-Using O2 feedback for A/F Ratio "
				+ Database.getDataValue(Mode, TID, SubTest)
				:Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[2]) ? "OPEN LOOP-Using Air/Fuel tables. "
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[3]) ? "OPEN LOOP-***VEHICLE SYSTEMS FAILURE*** "
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[4]) ? "CLOSED LOOP-Warning, Fault detected in feedback system "
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		if (Database.getDataValue(Mode, TID, SubTest).equals("")) {
			LineNumber = Database.setDataValue(Mode, TID, SubTest, "Not Present");
		}
                Log.StandardDataFromTable(LineNumber);

                SubTest="2";


                 LineNumber = Database.setDataValue(Mode, TID, SubTest, "");
                 
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[0]) ? "OPEN LOOP-Low engine temperature "
				+ Database.getDataValue(Mode, TID, SubTest): Database.getDataValue(Mode, TID, SubTest));

		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[1]) ? "CLOSED LOOP-Using O2 feedback for A/F Ratio "
				+ Database.getDataValue(Mode, TID, SubTest)
				:Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[2]) ? "OPEN LOOP-Using Air/Fuel tables. "
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[3]) ? "OPEN LOOP-***VEHICLE SYSTEMS FAILURE*** "
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[4]) ? "CLOSED LOOP-Warning, Fault detected in feedback system "
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		if (Database.getDataValue(Mode, TID, SubTest).equals("")) {
			LineNumber = Database.setDataValue(Mode, TID, SubTest, "Not Present");
		}
                Log.StandardDataFromTable(LineNumber);
     


	}

	private static void getEngineLoad(StringTokenizer Line) {

                String TID = "04";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
                int A = Integer.parseInt(Line.nextToken(), 16);
		
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.toString(A* 100 / 255));
                Log.StandardDataFromTable(LineNumber);
	}

	private static void getCoolantTemp(StringTokenizer Line) {
                String TID = "05";


                if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}

                int LineNumber = 0;
                int A =  Integer.parseInt(Line.nextToken(), 16) - 40;
                if (Status.Celcius) {

                    LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.toString(A));
                    Database.setDataUnits(Mode, TID, SubTest,"°C" );
                } else {
                    LineNumber = Database.setDataValue(Mode, TID, SubTest,(A * (9 / 5)) + 32);
                    Database.setDataUnits(Mode, TID, SubTest, "°F");
                }


                 Log.StandardDataFromTable(LineNumber);

	}

	private static void getSTFuelTrim1(StringTokenizer Line) {

                String TID = "06";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		Status.CheckToken = Line.nextToken();
                int A = Integer.parseInt(Status.CheckToken, 16);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A - 128) * 100 / 128);
                
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getLTFuelTrim1(StringTokenizer Line) {

                String TID = "07";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken(),16);
                
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A - 128) * 100 / 128);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getSTFuelTrim2(StringTokenizer Line) {

                String TID = "08";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A =Integer.parseInt(Line.nextToken(),16);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A - 128) * 100 / 128);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getLTFuelTrim2(StringTokenizer Line) {

                String TID = "09";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken(),16);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A - 128) * 100 / 128);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getfuelPressure(StringTokenizer Line) {

                String TID = "0A";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
                
                //TODO Check for accuracy
		int A =  Integer.parseInt(Line.nextToken(), 16);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 3);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getMAP(StringTokenizer Line) {

                String TID = "";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken(), 16) ;
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.toString(A));
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getRPM(StringTokenizer Line) {

                String TID = "0C";
                

		// if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
		// Log.infoError();
		// return;
		// }
		int A = Integer.parseInt(Line.nextToken(), 16);
		int B = Integer.parseInt(Line.nextToken(), 16);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.toString(((A * 256) + B) / 4));
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getMPH(StringTokenizer Line) {

                String TID = "0D";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A= Integer.parseInt(Line.nextToken(), 16);
                double MPH = A * 0.621;
                float MPHf = (float) MPH;
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,  Float.toString(MPHf)) ;
                
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getTimingAdvance(StringTokenizer Line) {

                String TID = "0E";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A=Integer.parseInt(Line.nextToken(), 16) ;
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A / 2 - 64);
                
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getTPS(StringTokenizer Line) {

                String TID = "11";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A =Integer.parseInt(Line.nextToken(), 16) ;
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCommandedSecondaryAirStatus(StringTokenizer Line) {

                String TID = "12";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		Status.CheckToken = Line.nextToken();
		boolean[] A = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, "");
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[0]) ? " Upstream of catalytic converter"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[1]) ? " Downstream of catalytic converter"
				+ Database.getDataValue(Mode, TID, SubTest)
                                : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (A[2]) ? " From the outside atmosphere or off"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2SensorsPresent(StringTokenizer Line) {

                String TID = "13";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		Status.CheckToken = Line.nextToken();
		boolean[] A = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		if (A[0]) {
			Log.level1("Found O2 sensor 1 at Bank 1");
		}
		if (A[1]) {
			Log.level1("Found O2 sensor 2 at Bank 1");
		}
		if (A[2]) {
			Log.level1("Found O2 sensor 3 at Bank 1");
		}
		if (A[3]) {
			Log.level1("Found O2 sensor 4 at Bank 1");
		}
		if (A[4]) {
			Log.level1("Found O2 sensor 5 at Bank 2");
		}
		if (A[5]) {
			Log.level1("Found O2 sensor 6 at Bank 2");
		}
		if (A[6]) {
			Log.level1("Found O2 sensor 7 at Bank 2");
		}
		if (A[7]) {
			Log.level1("Found O2 sensor 8 at Bank 2");
		}
		Status.O2SensorsPresent = A;
	}

	private static float getNarrowBandO2SensorsVoltage(StringTokenizer Line) {

                String TID = "";
                

		Status.CheckToken = Line.nextToken();
		return (float) (Integer.parseInt(Status.CheckToken, 16) * .005);
	}

	private static float getNarrowBandO2SensorsPercent(StringTokenizer Line) {

                String TID = "";
                


		Status.CheckToken = Line.nextToken();
		if (!Status.CheckToken.contains("FF")) {
			return ((Integer.parseInt(Status.CheckToken, 16) - 128) * 100 / 128);
		} else {
			return 0;
		}
	}

	private static void getO2B1S1(StringTokenizer Line) {

                String TID = "14";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);


	}

	private static void getO2B1S2(StringTokenizer Line) {

                String TID = "15";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2B1S3(StringTokenizer Line) {

                String TID = "16";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));
                 
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2B1S4(StringTokenizer Line) {

                String TID = "17";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2B2S1(StringTokenizer Line) {

                String TID = "18";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2B2S2(StringTokenizer Line) {

                String TID = "19";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2B2S3(StringTokenizer Line) {

                String TID = "1A";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getO2B2S4(StringTokenizer Line) {

                String TID = "1B";
                

		int LineNumber = Database.setDataValue(Mode, TID, SubTest,getNarrowBandO2SensorsVoltage(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2" ,getNarrowBandO2SensorsPercent(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getOBDStandards(StringTokenizer Line) {

                String TID = "1C";
                

		String CheckToken = Line.nextToken();
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, "");
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("01")) ? " OBD-II as defined by the CARB"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("02")) ? " OBD as defined by the EPA"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("03")) ? " OBD and OBD-II"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("04")) ? " OBD-I"
				+ Database.getDataValue(Mode, TID, SubTest): Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("05")) ? " Not meant to comply with any OBD standard"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("06")) ? " EOBD (Europe)"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("07")) ? " EOBD and OBD-II"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("08")) ? " EOBD and OBD"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("09")) ? " EOBD, OBD and OBD II"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("0A")) ? " JOBD (Japan)"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("0B")) ? " JOBD and OBD II"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("0C")) ? " JOBD and EOBD"
				+ Database.getDataValue(Mode, TID, SubTest) : Database.getDataValue(Mode, TID, SubTest));
		 LineNumber = Database.setDataValue(Mode, TID, SubTest, (CheckToken.equals("0D")) ? " JOBD, EOBD, and OBD II"
				+ Database.getDataValue(Mode, TID, SubTest)
				: Database.getDataValue(Mode, TID, SubTest));
		                Log.StandardDataFromTable(LineNumber);

	}

	private static void geto2SensorsPresentAddtional(StringTokenizer Line) {

                String TID = "1D";
                

		Status.CheckToken = Line.nextToken();
		boolean[] A = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		if (A[0]) {
			Log.level1("Found O2 sensor 1 at Bank 1");
		}
		if (A[1]) {
			Log.level1("Found O2 sensor 2 at Bank 1");
		}
		if (A[2]) {
			Log.level1("Found O2 sensor 1 at Bank 2");
		}
		if (A[3]) {
			Log.level1("Found O2 sensor 2 at Bank 2");
		}
		if (A[4]) {
			Log.level1("Found O2 sensor 1 at Bank 3");
		}
		if (A[5]) {
			Log.level1("Found O2 sensor 2 at Bank 3");
		}
		if (A[6]) {
			Log.level1("Found O2 sensor 1 at Bank 4");
		}
		if (A[7]) {
			Log.level1("Found O2 sensor 2 at Bank 4");
		}
		Status.O2SensorsPresentAdditional = A;
	}

	private static void getAuxInputStatus(StringTokenizer Line) {

                String TID = "1E";
                

		Status.CheckToken = Line.nextToken();
                int LineNumber = 0;
		boolean A[] = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		if (A[0]) {
			LineNumber = Database.setDataValue(Mode, TID, SubTest, "Active");
		} else {
			LineNumber = Database.setDataValue(Mode, TID, SubTest, "Inactive");
		}
                Log.StandardDataFromTable(LineNumber);
	}

	private static void getEngineRunTime(StringTokenizer Line) {

                String TID = "1F";
                

		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Float.toString((A * 256) + B));
		Log.StandardDataFromTable(LineNumber);
	}

	private static void getPIDsSupported21to40(StringTokenizer Line) {

                String TID = "20";
                

		String A = BinaryConvert.getBinaryString(Line.nextToken());
		String B = BinaryConvert.getBinaryString(Line.nextToken());
		String C = BinaryConvert.getBinaryString(Line.nextToken());
		String D = BinaryConvert.getBinaryString(Line.nextToken());
		Status.PIDsSupported21To40 = (BinaryConvert.getBinaryArrayFromBinaryString(A + B + C + D));
                
                

	}

	private static void getDistanceSinceMIL(StringTokenizer Line) {

                String TID = "21";
                

		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A * 256) + B);
		                Log.StandardDataFromTable(LineNumber);

	}

	private static void getFuelRailPressure(StringTokenizer Line) {

                String TID = "22";
                

		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber=Database.setDataValue(Mode, TID, SubTest,(((A * 256) + B) * 10) / 128);
                        
		Log.StandardDataFromTable(LineNumber);
	}

	private static void getDiselFuelRailPressure(StringTokenizer Line) {

                String TID = "23";
                

		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber=Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) * 10);
		Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S1Volts(StringTokenizer Line) {

                String TID = "24";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S2Volts(StringTokenizer Line) {

                String TID = "25";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S3Volts(StringTokenizer Line) {

                String TID = "26";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                  Log.StandardDataFromTable(LineNumber);
    }

	private static void getWBO2S4Volts(StringTokenizer Line) {

                String TID = "27";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S5Volts(StringTokenizer Line) {

                String TID = "28";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S6Volts(StringTokenizer Line) {

                String TID = "29";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S7Volts(StringTokenizer Line) {

                String TID = "2A";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getWBO2S8Volts(StringTokenizer Line) {

                String TID = "2B";
                

		int LineNumber=Database.setDataValue(Mode, TID, SubTest,getWideBandValue(Line));
                LineNumber = Database.setDataValue(Mode, TID, "2", getWideBandEQRatio(Line));

                Log.StandardDataFromTable(LineNumber);

	}

	private static void getEthanolFuelPercent(StringTokenizer Line) {

                String TID = "52";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A * 256) + B);
                Log.StandardDataFromTable(LineNumber);
	}

	private static void getAbsoluteEvapSystemPressure(StringTokenizer Line) {

                String TID = "53";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		String combine = String.valueOf(A) + String.valueOf(B);
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(Integer.parseInt(combine, 16)) / 200);
                Log.StandardDataFromTable(LineNumber);
	}

	private static void UnknownPID(StringTokenizer Line) {

	}

	private static void UnknownPID2(StringTokenizer Line) {

	}

	private static String getWideBandValue(StringTokenizer Line) {

		if (BinaryConvert.checkNumberOfTokensLeft() <= 1) {
			Log.infoError();
			String x = "0";
			return x;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		String x = Float.toString(((A * 256) + B) / 32768);
		return x;
	}

	private static String getWideBandEQRatio(StringTokenizer Line) {
		if (BinaryConvert.checkNumberOfTokensLeft() <= 1) {
			Log.infoError();
			String x = "0";
			return x;
		}
		int C = Integer.parseInt(Line.nextToken());
		int D = Integer.parseInt(Line.nextToken());
		String x = Float.toString(((C * 256) + D) / 256 - 128);
		return x;
	}

	private static void getCatTempB1S1(StringTokenizer Line) {

                String TID = "3C";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) / 10 - 40);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCatTempB2S1(StringTokenizer Line) {

                String TID = "3D";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) / 10 - 40);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCatTempB1S2(StringTokenizer Line) {

                String TID = "3E";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
                int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) / 10 - 40);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCatTempB2S2(StringTokenizer Line) {

                String TID = "3F";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) / 10 - 40);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getPIDsSupported41to60(StringTokenizer Line) {

                String TID = "40";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 4) {
			Log.infoError();
			return;
		}
		String A = BinaryConvert.getBinaryString(Line.nextToken());
		String B = BinaryConvert.getBinaryString(Line.nextToken());
		String C = BinaryConvert.getBinaryString(Line.nextToken());
		String D = BinaryConvert.getBinaryString(Line.nextToken());
		Status.PIDsSupported41To60 = (BinaryConvert
				.getBinaryArrayFromBinaryString(A + B + C + D));


	}

	private static void getMonitorStatusThisDriveCycle(StringTokenizer Line) {

                String TID = "41";
                     int LineNumber;

		if (BinaryConvert.checkNumberOfTokensLeft() != 4) {
			Log.infoError();
			return;
		}

		Status.CheckToken = Line.nextToken();
		boolean[] StatusArray = new boolean[8];
		StatusArray = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		// Check Engine Light is on or off

		if (StatusArray[0]) {
			LineNumber = Database.setDataValue(Mode, TID, "2", "ON");
                        Log.StandardDataFromTable(LineNumber);
			LineNumber = Database.setDataValue(Mode, TID, "3", Integer.parseInt(Status.CheckToken) - 1);
                        Log.StandardDataFromTable(LineNumber);
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "2", "OFF");
                        Log.StandardDataFromTable(LineNumber);
			LineNumber = Database.setDataValue(Mode, TID, "3", "0");
                        Log.StandardDataFromTable(LineNumber);
		}
		// obtain next few bytes and process into binary arrays
		Status.StatusArrayA = StatusArray;
		Status.CheckToken = Line.nextToken();
		boolean[] B = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		Status.StatusArrayB = B;
		Status.CheckToken = Line.nextToken();
		boolean[] C = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		Status.StatusArrayC = C;
		Status.CheckToken = Line.nextToken();
		boolean[] D = BinaryConvert.getBinaryArrayFromToken(Status.CheckToken);
		Status.StatusArrayD = D;

		// Process bits as per specs

		if (B[0]) {
			if (B[4]) {
                            LineNumber = Database.setDataValue(Mode, TID, "5","Test Complete");

			} else {
				LineNumber = Database.setDataValue(Mode, TID, "4","Test Complete");
			}
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "4", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (B[1]) {
			if (B[5]) {
				LineNumber = Database.setDataValue(Mode, TID, "5","Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "5" , "Test Complete");
			}
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "5" , "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (B[2]) {
			if (B[6]) {
				 LineNumber = Database.setDataValue(Mode, TID, "6", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "6", "Test Complete");
			}
		} else {
			LineNumber = Database.setDataValue(Mode, TID, "6", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (B[3]) {
			if (B[7]) {
				LineNumber = Database.setDataValue(Mode, TID, "7", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "7", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "7", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (C[0]) {
			if (D[0]) {
				 LineNumber = Database.setDataValue(Mode, TID, "8", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "8", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "8", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);


		if (C[1]) {
			if (D[1]) {
				 LineNumber = Database.setDataValue(Mode, TID, "9", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "9", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "9", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);

		if (C[2]) {
			if (D[2]) {
				 LineNumber = Database.setDataValue(Mode, TID, "10", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "10", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "10", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[3]) {
			if (D[3]) {
				 LineNumber = Database.setDataValue(Mode, TID, "11", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "11", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "11", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[4]) {
			if (D[4]) {
				 LineNumber = Database.setDataValue(Mode, TID, "12", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "12", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "12", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[5]) {
			if (D[5]) {
				 LineNumber = Database.setDataValue(Mode, TID, "13", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "13", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "13", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[6]) {
			if (D[6]) {
				 LineNumber = Database.setDataValue(Mode, TID, "14", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "14", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "14", "Test Not Available");
		}
                Log.StandardDataFromTable(LineNumber);
		if (C[7]) {
			if (D[7]) {
				 LineNumber = Database.setDataValue(Mode, TID, "15", "Test Incomplete");
			} else {
				 LineNumber = Database.setDataValue(Mode, TID, "15", "Test Complete");
			}
		} else {
			 LineNumber = Database.setDataValue(Mode, TID, "15", "Test Not Available");
		}




	}

	private static void getControlModuleVolts(StringTokenizer Line) {

                String TID = "42";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) / 1000);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAbsoluteLoadValue(StringTokenizer Line) {

                String TID = "43";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) * 100 / 255);
                Log.StandardDataFromTable(LineNumber);
	}

	private static void getCommandEquivalenceRatio(StringTokenizer Line) {

                String TID = "44";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,((A * 256) + B) / 32768);
                Log.StandardDataFromTable(LineNumber);

    }
	private static void getRelativeThrottlePosition(StringTokenizer Line) {

                String TID = "45";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAmbientAirTemp(StringTokenizer Line) {

                String TID = "46";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, Integer.toString(A - 40));
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAbsoluteThrottleB(StringTokenizer Line) {

                String TID = "47";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAbsoluteThrottleC(StringTokenizer Line) {

                String TID = "48";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAbsoluteThrottleD(StringTokenizer Line) {

                String TID = "49";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAbsoluteThrottleE(StringTokenizer Line) {

                String TID = "4A";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getAbsoluteThrottleF(StringTokenizer Line) {

                String TID = "4B";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getCommandedThrottlePosition(StringTokenizer Line) {

                String TID = "4C";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,A * 100 / 255);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getTimeRunWithMIL(StringTokenizer Line) {

                String TID = "4D";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A * 256) + B);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getTimeSinceTroubleCodesCleared(StringTokenizer Line) {

                String TID = "4E";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 2) {
			Log.infoError();
			return;
		}
		int A = Integer.parseInt(Line.nextToken());
		int B = Integer.parseInt(Line.nextToken());
		int LineNumber = Database.setDataValue(Mode, TID, SubTest,(A * 256) + B);
                Log.StandardDataFromTable(LineNumber);

	}

	private static void getFuelType(StringTokenizer Line) {

                String TID = "51";
                

		if (BinaryConvert.checkNumberOfTokensLeft() != 1) {
			Log.infoError();
			return;
		}
		Status.CheckToken = Line.nextToken();
		int LineNumber = Database.setDataValue(Mode, TID, SubTest, "");
		if (Status.CheckToken.contains("01")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Gasoline" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("02")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Methanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("03")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("04")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Disel" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("05")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "LPG" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("06")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "CNG" +Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("07")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Propane" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("08")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Electric" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("09")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running Gasoline" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("0A")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running Methanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("0B")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("0C")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running LPG" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("0D")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running CNG" +Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("0E")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running Prop" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("0F")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel running Electricity" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("10")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Bifuel mixed gas/electric" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("11")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Hybrid gasoline" +Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("12")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Hybrid Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("13")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Hybrid Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("14")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Hybrid Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("15")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Hybrid Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
		if (Status.CheckToken.contains("16")) {
			 LineNumber = Database.setDataValue(Mode, TID, SubTest, "Hybrid Ethanol" + Database.getDataValue(Mode, TID, SubTest));
		}
                Log.StandardDataFromTable(LineNumber);

	}

}
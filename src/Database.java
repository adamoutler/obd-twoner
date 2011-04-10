/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adam
 */
public class Database {


	public static Object[][] getEntireTable() {
		return Data;
	}

	public static Object[][] setEntireTable(String[][] NewData) {
		Data = NewData;
		return Data;
	}

	public static int setDataUnits(String instanceMode, String instanceTID,
			String SubTest, String Value) {
		int returnValue = lookupReferenceInTable(instanceMode, instanceTID,
				SubTest);
		Data[returnValue][DataUnits] = Value;
		return returnValue;
	}

	public static int setDataValue(String instanceMode, String instanceTID,
			String SubTest, String Value) {
		int returnValue = lookupReferenceInTable(instanceMode, instanceTID,
				SubTest);
		Data[returnValue][DataValue] = Value;
		return returnValue;
	}

	public static int setDataValue(String instanceMode, String instanceTID,
			String SubTest, Float Value) {
		int returnValue = 1;
		returnValue = lookupReferenceInTable(instanceMode, instanceTID, SubTest);
		Data[returnValue][DataValue] = Float.toString(Value);
		return returnValue;
	}

	public static int setDataValue(String instanceMode, String instanceTID,
			String SubTest, int Value) {
		int returnValue = 1;
		returnValue = lookupReferenceInTable(instanceMode, instanceTID, SubTest);
		Data[returnValue][DataValue] = Integer.toString(Value);
		return returnValue;
	}

	public static int setDataValue(String instanceMode, String instanceTID,
			String SubTest, Double Value) {
		int returnValue = 1;
		returnValue = lookupReferenceInTable(instanceMode, instanceTID, SubTest);
		Data[returnValue][DataValue] = Double.toString(Value);
		return returnValue;
	}

	public static String getDataValue(String instanceMode, String instanceTID,
			String SubTest) {
		String returnValue;
		int lookupValue;
		lookupValue = lookupReferenceInTable(instanceMode, instanceTID, SubTest);
		returnValue = Data[lookupValue][DataValue];
		return returnValue;
	}

	public static String getFriendlyNameValue(String instanceMode,
			String instanceTID, String SubTest) {
		String returnValue;
		int lookupValue;
		lookupValue = lookupReferenceInTable(instanceMode, instanceTID, SubTest);
		returnValue = Data[lookupValue][DataFriendlyName];
		return returnValue;
	}

	public static String getUnitValue(String instanceMode, String instanceTID,
			String SubTest) {
		String returnValue;
		int lookupValue;
		lookupValue = lookupReferenceInTable(instanceMode, instanceTID, SubTest);
		returnValue = Data[lookupValue][DataUnits];
		return returnValue;
	}

	public static String getLogNameDataUnits(int line) {

		String returnValue = Data[line][DataFriendlyName] + " "
				+ Data[line][DataValue] + " " + Data[line][DataUnits];
		return returnValue;
	}

	private static int lookupReferenceInTable(String instanceMode,
			String instanceTID, String SubTest) {

		int ModeMatches[] = getReferencesToMode(instanceMode);
		int[] TIDMatches = getReferenceArrayFromPossibleMatches(ModeMatches,
				instanceTID);
		int lineLookup = getReferenceFromSubtestAndTIDMatches(TIDMatches,
				SubTest);
		return lineLookup;
	}

	private static int getReferenceFromSubtestAndTIDMatches(int[] TIDMatches,
			String instanceSubTest) {
		int counter = 0;
		int match = 0;
		instanceSubTest = instanceSubTest.trim();
		while (counter < TIDMatches.length) {
			int x = TIDMatches[counter];
			if (Data[x][DataSubTest].equals(instanceSubTest)) {
				return TIDMatches[counter];
			}
			counter++;
		}

		return match;

	}

	public static int lookupReferenceInTable(String instanceMode,
			String instanceTID) {
		int ModeMatches[] = getReferencesToMode(instanceMode);
		int lineLookup = getReferenceFromPossibleMatches(ModeMatches,
				instanceTID);
		return lineLookup;
	}

	private static int getReferenceFromPossibleMatches(int[] ModeMatches, String instanceTID) {

            //returns
		int counter = 0;
		int match = 0;
		instanceTID = instanceTID.trim();
		while (counter < ModeMatches.length) {
			int x = ModeMatches[counter];
			if (Data[x][DataTestID].equals(instanceTID)) {
				return ModeMatches[counter];
			}
			counter++;
		}
		return match;

	}

	private static int[] getReferenceArrayFromPossibleMatches(
			int[] ModeMatches, String instanceTID) {
		int counter = 0;
		int refCounter = 0;
		int[] references = new int[140];

		instanceTID = instanceTID.trim();
		while (counter < ModeMatches.length) {
			int x = ModeMatches[counter];
			if (Data[x][DataTestID].equals(instanceTID)) {
				references[refCounter] = x;
				refCounter++;
			}
			counter++;
		}

		return references;

	}

	private static int[] getReferencesToMode(String instanceMode) {
		// TODO initialize only once and use data length
		int[] references = new int[140];
		int counter = 0;
		int refCounter = 0;

		while (counter <= Data.length - 1) {

			if (Data[counter][DataMode].contentEquals(instanceMode)) {
				references[refCounter] = counter;
				refCounter++;
			}
			counter++;
		}

		return references;
	}

        /*
         * Sets up database for use throughout the project
         *
         */

        public static int DataFriendlyName;
	public static int DataValue;
	public static int DataUnits;
	public static int DataMin;
	public static int DataMax;
	public static int DataMode;
	public static int DataTestID;
	public static int DataSubTest;
	public static String[] Columns = { "FriendlyName", "Value", "Units",
			"Min", "Max", "Mode", "TestID", "SubTest" };

	public static void initializeColoumNames() {
		int x = 0;
		while (x < 8) {
			if (Columns[x].equals("FriendlyName")) {
				DataFriendlyName = x;
			} else if (Columns[x].equals("Value")) {
				DataValue = x;
			} else if (Columns[x].equals("Units")) {
				DataUnits = x;
			} else if (Columns[x].equals("Min")) {
				DataMin = x;
			} else if (Columns[x].equals("Max")) {
				DataMax = x;
			} else if (Columns[x].equals("Mode")) {
				DataMode = x;
			} else if (Columns[x].equals("TestID")) {
				DataTestID = x;
			} else if (Columns[x].equals("SubTest")) {
				DataSubTest = x;
			}
			x++;
		}
		x = 0;
		while (x < 8) {
			System.out.print(". " + Columns[x] + " as " + x);
			x++;

		}
		System.out.println();
	}

//initial values for database
	private static String[][] Data = {
{ "PIDs supported [01 – 20]:",null,"Binary",null,null,"1","00","1" },
{ "Online Monitors since DTCs cleared:",null,"Binary",null,null,"1","01","1" },
{ "Check Engine Light:",null,null,null,null,"1","01","2" },
{ "Number of Codes:",null,null,null,null,"1","01","3" },
{ "Misfire Test:",null,null,null,null,"1","01","4" },
{ "Fuel System Test:",null,null,null,null,"1","01","5" },
{ "Components Test:",null,null,null,null,"1","01","6" },
{ "Reserved/Special Test:",null,null,null,null,"1","01","7" },
{ "Catalyst Test:",null,null,null,null,"1","01","8" },
{ "Heated Catalyst Test:",null,null,null,null,"1","01","9" },
{ "Evaporative System Test:",null,null,null,null,"1","01","10" },
{ "Secondary Air System Test:",null,null,null,null,"1","01","11" },
{ "A/C Refrigerant Test:",null,null,null,null,"1","01","12" },
{ "O2 SensorTest:",null,null,null,null,"1","01","13" },
{ "O2 Sensor Heater Test:",null,null,null,null,"1","01","14" },
{ "EGR System Test:",null,null,null,null,"1","01","15" },
{ "Freeze DTC:",null,"NONE IN MODE 1",null,null,"1","02","1" },
{ "Fuel System Status:",null,null,null,null,"1","03","1" },
{ "Secondary Fuel System Status:",null,null,null,null,"1","03","2" },
{ "Calculated engine load value:",null," %","0","100","1","04","1" },
{ "Engine coolant temperature:",null,"°C","-40","215","1","05","1" },
{ "Short term fuel % trim—Bank 1:",null," %","-100","99.22","1","06","1" },
{ "Long term fuel % trim—Bank 1:",null," %","-100","99.22","1","07","1" },
{ "Short term fuel % trim—Bank 2:",null," %","-100","99.22","1","08","1" },
{ "Long term fuel % trim—Bank 2:",null," %","-100","99.22","1","09","1" },
{ "Fuel pressure:",null,"kPa (gauge)","0","765","1","0A","1" },
{ "Intake manifold absolute pressure:",null,"kPa (absolute)","0","255","1","0B","1" },
{ "Engine RPM:",null,"rpm","0","16383.75","1","0C","1" },
{ "Vehicle speed:",null,"km/h","0","255","1","0D","1" },
{ "Timing advance:",null,"°","-64","63.5","1","0E","1" },
{ "Intake air temperature:",null,"°C","-40","215","1","0F","1" },
{ "MAF air flow rate:",null,"g/s","0","655.35","1","10","1" },
{ "Throttle position:",null," %","0","100","1","11","1" },
{ "Commanded secondary air status:",null,null,null,null,"1","12","1" },
{ "Oxygen sensors present:",null,"Binary",null,null,"1","13","1" },
{ "Bank 1 Sensor 1 Volts:",null,"V","0","1.275","1","14","1" },
{ "Bank 1 Sensor 1:",null,"%","-100","99.2","1","14","2" },
{ "Bank 1 Sensor 2 Volts:",null,"V","0","1.275","1","15","1" },
{ "Bank 1 Sensor 2:",null,"%","-100","99.2","1","15","2" },
{ "Bank 1 Sensor 3 Volts:",null,"V","0","1.275","1","16","1" },
{ "Bank 1 Sensor 3:",null,"%","-100","99.2","1","16","2" },
{ "Bank 1 Sensor 4 Volts:",null,"V","0","1.275","1","17","1" },
{ "Bank 1 Sensor 4 Volts:",null,"%","-100","99.2","1","17","2" },
{ "Bank 2 Sensor 1 Volts:",null,"V","0","1.275","1","18","1" },
{ "Bank 2 Sensor 1:",null,"%","-100","99.2","1","18","2" },
{ "Bank 2 Sensor 2 Volts:",null,"V","0","1.275","1","19","1" },
{ "Bank 2 Sensor 2:",null,"%","-100","99.2","1","19","2" },
{ "Bank 2 Sensor 3 Volts:",null,"V","0","1.275","1","1A","1" },
{ "Bank 2 Sensor 3:",null,"%","-100","99.2","1","1A","2" },
{ "Bank 2 Sensor 4 Volts:",null,"V","0","1.275","1","1B","1" },
{ "Bank 2 Sensor 4:",null,"%","-100","99.2","1","1B","2" },
{ "OBD standards this vehicle conforms to:",null,null,null,null,"1","1C","1" },
{ "Oxygen sensors present:",null,"Binary",null,null,"1","1D","1" },
{ "Auxiliary input status:",null,null,null,null,"1","1E","1" },
{ "Run time since engine start:",null,"seconds","0","65535","1","1F","1" },
{ "PIDs supported 21-40:",null,"Binary",null,null,"1","20","1" },
{ "Distance traveled with CEL:",null,"km","0","65535","1","21","1" },
{ "Fuel Rail Pressure:",null,"kPa","0","5177.265","1","22","1" },
{ "Fuel Rail Pressure (diesel):",null,"kPa (gauge)","0","655350","1","23","1" },
{ "O2S1 lambda:",null,"EQR","0","2","1","24","1" },
{ "O2S1 Volts:",null,"V","0","8","1","24","2" },
{ "O2S2 V lambda:",null,"EQR","0","2","1","25","1" },
{ "O2S2 Volts:",null,"V","0","8","1","25","2" },
{ "O2S3 V lambda:",null,"EQR","0","2","1","26","1" },
{ "O2S3 Volts:",null,"V","0","8","1","26","2" },
{ "O2S4 lambda:",null,"EQR","0","2","1","27","1" },
{ "O2S4 Volts:",null,"V","0","8","1","27","2" },
{ "O2S5 V lambda:",null,"EQR","0","2","1","28","1" },
{ "O2S5 Volts:",null,"V","0","8","1","28","2" },
{ "O2S6 V lambda:",null,"EQR","0","2","1","29","1" },
{ "O2S6 Volts:",null,"V","0","8","1","29","2" },
{ "O2S7 V lambda:",null,"EQR","0","2","1","2A","1" },
{ "O2S7 Volts:",null,"V","0","8","1","2A","2" },
{ "O2S8 V lambda:",null,"EQR","0","2","1","2B","1" },
{ "O2S8 Volts:",null,"V","0","8","1","2B","2" },
{ "Commanded EGR:",null," %","0","100","1","2C","1" },
{ "EGR Error:",null," %","-100","99.22","1","2D","1" },
{ "Commanded evaporative purge:",null," %","0","100","1","2E","1" },
{ "Fuel Level Input:",null," %","0","100","1","2F","1" },
{ "# of warm-ups since codes cleared:",null,"N/A","0","255","1","30","1" },
{ "Distance traveled since codes cleared:",null,"km","0","65535","1","31","1" },
{ "Evap. System Vapor Pressure:",null,"Pa","-8192","8192","1","32","1" },
{ "Barometric pressure:",null,"kPa ","0","255","1","33","1" },
{ "O2S1 C lambda:",null,"EQR","0","2","1","34","1" },
{ "O2S1 Current:",null,"mA","-128","128","1","34","2" },
{ "O2S2 C lambda:",null,"EQR","0","2","1","35","1" },
{ "O2S2 Current:",null,"mA","-128","128","1","35","2" },
{ "O2S3 C lambda:",null,"EQR","0","2","1","36","1" },
{ "O2S3 Current:",null,"mA","-128","128","1","36","2" },
{ "O2S4 C lambda:",null,"EQR","0","2","1","37","1" },
{ "O2S4 Current:",null,"mA","-128","128","1","37","2" },
{ "O2S5 C lambda:",null,"EQR","0","2","1","38","1" },
{ "O2S5 Current:",null,"mA","-128","128","1","38","2" },
{ "O2S6 C lambda:",null,"EQR","0","2","1","39","1" },
{ "O2S6 Current:",null,"mA","-128","128","1","39","2" },
{ "O2S7 C lambda:",null,"EQR","0","2","1","3A","1" },
{ "O2S7 Current:",null,"mA","-128","128","1","3A","2" },
{ "O2S8 C lambda:",null,"EQR","0","2","1","3B","1" },
{ "O2S8 Current:",null,"mA","-128","128","1","3B","2" },
{ "Catalyst Temperature Bank 1 Sensor 1:",null,"°C","-40","6513.5","1","3C","1" },
{ "Catalyst Temperature Bank 2 Sensor 1:",null,"°C","-40","6513.5","1","3D","1" },
{ "Catalyst Temperature Bank 1 Sensor 2:",null,"°C","-40","6513.5","1","3E","1" },
{ "Catalyst Temperature Bank 2 Sensor 2:",null,"°C","-40","6513.5","1","3F","1" },
{ "PIDs supported 41-60:",null,"Binary",null,null,"1","40","1" },
{ "Monitor status this drive cycle:",null,"Binary",null,null,"1","41","1" },
{ "Check Engine Light:",null,null,null,null,"1","41","2" },
{ "Number of Codes:",null,null,null,null,"1","41","3" },
{ "Misfire Test:",null,null,null,null,"1","41","4" },
{ "Fuel System Test:",null,null,null,null,"1","41","5" },
{ "Components Test:",null,null,null,null,"1","41","6" },
{ "Reserved/Special Test:",null,null,null,null,"1","41","7" },
{ "Catalyst Test:",null,null,null,null,"1","41","8" },
{ "Heated Catalyst Test:",null,null,null,null,"1","41","9" },
{ "Evaporative System Test:",null,null,null,null,"1","41","10" },
{ "Secondary Air System Test:",null,null,null,null,"1","41","11" },
{ "A/C Refrigerant Test:",null,null,null,null,"1","41","12" },
{ "O2 SensorTest:",null,null,null,null,"1","41","13" },
{ "O2 Sensor Heater Test:",null,null,null,null,"1","41","14" },
{ "EGR System Test:",null,null,null,null,"1","41","15" },
{ "Control module voltage:",null,"V","0","65.535","1","42","1" },
{ "Absolute load value:",null," %","0","25700","1","43","1" },
{ "Command equivalence ratio:",null,"N/A","0","2","1","44","1" },
{ "Relative throttle position:",null," %","0","100","1","45","1" },
{ "Ambient air temperature:",null,"°C","-40","215","1","46","1" },
{ "Absolute throttle position B:",null," %","0","100","1","47","1" },
{ "Absolute throttle position C:",null," %","0","100","1","48","1" },
{ "Accelerator pedal position D:",null," %","0","100","1","49","1" },
{ "Accelerator pedal position E:",null," %","0","100","1","4A","1" },
{ "Accelerator pedal position F:",null," %","0","100","1","4B","1" },
{ "Commanded throttle actuator:",null," %","0","100","1","4C","1" },
{ "Time run with MIL on:",null,"minutes","0","65535","1","4D","1" },
{ "Time since trouble codes cleared:",null,"minutes","0","65535","1","4E","1" },
{ "Fuel Type:",null,"String",null,null,"1","51","1" },
{ "Ethanol fuel:",null," %","0","100","1","52","1" },
{ "Absoulute Evap system Vapour Pressure:",null,"kpa","0","327675","1","53","1" },
{ " ?:",null," ?"," ?"," ?","1","C3","1" },
{ " ?:",null," ?"," ?"," ?","1","C4","1" },
{ "PIDs supported 01 – 20]:",null,"Binary",null,null,"2","00","1" },
{ "Online Monitors since DTCs cleared:",null,"Binary",null,null,"2","01","1" },
{ "Check Engine Light:",null,null,null,null,"2","01","2" },
{ "Number of Codes:",null,null,null,null,"2","01","3" },
{ "Misfire Test:",null,null,null,null,"2","01","4" },
{ "Fuel System Test:",null,null,null,null,"2","01","5" },
{ "Components Test:",null,null,null,null,"2","01","6" },
{ "Reserved/Special Test:",null,null,null,null,"2","01","7" },
{ "Catalyst Test:",null,null,null,null,"2","01","8" },
{ "Heated Catalyst Test:",null,null,null,null,"2","01","9" },
{ "Evaporative System Test:",null,null,null,null,"2","01","10" },
{ "Secondary Air System Test:",null,null,null,null,"2","01","11" },
{ "A/C Refrigerant Test:",null,null,null,null,"2","01","12" },
{ "O2 SensorTest:",null,null,null,null,"2","01","13" },
{ "O2 Sensor Heater Test:",null,null,null,null,"2","01","14" },
{ "EGR System Test:",null,null,null,null,"2","01","15" },
{ "Freeze DTC:",null,"Binary",null,null,"2","02","1" },
{ "Fuel system status:",null,"String",null,null,"2","03","1" },
{ "Secondary Fuel System Status:",null,null,null,null,"2","03","2" },
{ "Calculated engine load value:",null," %","0","100","2","04","1" },
{ "Engine coolant temperature:",null,"°C","-40","215","2","05","1" },
{ "Short term fuel % trim—Bank 1:",null," %","-100","99.22","2","06","1" },
{ "Long term fuel % trim—Bank 1:",null," %","-100","99.22","2","07","1" },
{ "Short term fuel % trim—Bank 2:",null," %","-100","99.22","2","08","1" },
{ "Long term fuel % trim—Bank 2:",null," %","-100","99.22","2","09","1" },
{ "Fuel pressure:",null,"kPa (gauge)","0","765","2","0A","1" },
{ "Intake manifold absolute pressure:",null,"kPa (absolute)","0","255","2","0B","1" },
{ "Engine RPM:",null,"rpm","0","16383.75","2","0C","1" },
{ "Vehicle speed:",null,"km/h","0","255","2","0D","1" },
{ "Timing advance:",null,"°","-64","63.5","2","0E","1" },
{ "Intake air temperature:",null,"°C","-40","215","2","0F","1" },
{ "MAF air flow rate:",null,"g/s","0","655.35","2","10","1" },
{ "Throttle position:",null," %","0","100","2","11","1" },
{ "Commanded secondary air status:",null,"String",null,null,"2","12","1" },
{ "Oxygen sensors present:",null,"Binary",null,null,"2","13","1" },
{ "Bank 1 Sensor 1 Volts:",null,"V","0","1.275","2","14","1" },
{ "Bank 1 Sensor 1:",null,"%","-100","99.2","2","14","1" },
{ "Bank 1 Sensor 2 Volts:",null,"V","0","1.275","2","15","2" },
{ "Bank 1 Sensor 2:",null,"%","-100","99.2","2","15","1" },
{ "Bank 1 Sensor 3 Volts:",null,"V","0","1.275","2","16","2" },
{ "Bank 1 Sensor 3:",null,"%","-100","99.2","2","16","1" },
{ "Bank 1 Sensor 4 Volts:",null,"V","0","1.275","2","17","2" },
{ "Bank 1 Sensor 4 Volts:",null,"%","-100","99.2","2","17","1" },
{ "Bank 2 Sensor 1 Volts:",null,"V","0","1.275","2","18","2" },
{ "Bank 2 Sensor 1:",null,"%","-100","99.2","2","18","1" },
{ "Bank 2 Sensor 2 Volts:",null,"V","0","1.275","2","19","2" },
{ "Bank 2 Sensor 2:",null,"%","-100","99.2","2","19","1" },
{ "Bank 2 Sensor 3 Volts:",null,"V","0","1.275","2","1A","2" },
{ "Bank 2 Sensor 3:",null,"%","-100","99.2","2","1A","1" },
{ "Bank 2 Sensor 4 Volts:",null,"V","0","1.275","2","1B","2" },
{ "Bank 2 Sensor 4:",null,"%","-100","99.2","2","1B","1" },
{ "OBD standards this vehicle conforms to:",null,"String",null,null,"2","1C","2" },
{ "Oxygen sensors present:",null,"Binary",null,null,"2","1D","1" },
{ "Auxiliary input status:",null,"String",null,null,"2","1E","1" },
{ "Run time since engine start:",null,"seconds","0","65535","2","1F","1" },
{ "PIDs supported 21-40:",null,"Binary",null,null,"2","20","1" },
{ "Distance Traveled with CEL:",null,"km","0","65535","2","21","1" },
{ "Fuel Rail Pressure:",null,"kPa","0","5177.265","2","22","1" },
{ "Diesel Fuel Rail Pressure:",null,"kPa (gauge)","0","655350","2","23","1" },
{ "O2S1 lambda:",null,"EQR","0","2","2","24","1" },
{ "O2S1 Volts:",null,"V","0","8","2","24","1" },
{ "O2S2 V lambda:",null,"EQR","0","2","2","25","2" },
{ "O2S2 Volts:",null,"V","0","8","2","25","1" },
{ "O2S3 V lambda:",null,"EQR","0","2","2","26","2" },
{ "O2S3 Volts:",null,"V","0","8","2","26","1" },
{ "O2S4 lambda:",null,"EQR","0","2","2","27","2" },
{ "O2S4 Volts:",null,"V","0","8","2","27","1" },
{ "O2S5 V lambda:",null,"EQR","0","2","2","28","2" },
{ "O2S5 Volts:",null,"V","0","8","2","28","1" },
{ "O2S6 V lambda:",null,"EQR","0","2","2","29","2" },
{ "O2S6 Volts:",null,"V","0","8","2","29","1" },
{ "O2S7 V lambda:",null,"EQR","0","2","2","2A","2" },
{ "O2S7 Volts:",null,"V","0","8","2","2A","1" },
{ "O2S8 V lambda:",null,"EQR","0","2","2","2B","2" },
{ "O2S8 Volts:",null,"V","0","8","2","2B","1" },
{ "Commanded EGR:",null," %","0","100","2","2C","2" },
{ "EGR Error:",null," %","-100","99.22","2","2D","1" },
{ "Commanded evaporative purge:",null," %","0","100","2","2E","1" },
{ "Fuel Level Input:",null," %","0","100","2","2F","1" },
{ "warm-ups since codes cleared:",null,"N/A","0","255","2","30","1" },
{ "Distance traveled since codes cleared:",null,"km","0","65535","2","31","1" },
{ "Evap. System Vapor Pressure:",null,"Pa","-8192","8192","2","32","1" },
{ "Barometric pressure:",null,"kPa ","0","255","2","33","1" },
{ "O2S1 C lambda:",null,"EQR","0","2","2","34","1" },
{ "O2S1 Current:",null,"mA","-128","128","2","34","1" },
{ "O2S2 C lambda:",null,"EQR","0","2","2","35","2" },
{ "O2S2 Current:",null,"mA","-128","128","2","35","1" },
{ "O2S3 C lambda:",null,"EQR","0","2","2","36","2" },
{ "O2S3 Current:",null,"mA","-128","128","2","36","1" },
{ "O2S4 C lambda:",null,"EQR","0","2","2","37","2" },
{ "O2S4 Current:",null,"mA","-128","128","2","37","1" },
{ "O2S5 C lambda:",null,"EQR","0","2","2","38","2" },
{ "O2S5 Current:",null,"mA","-128","128","2","38","1" },
{ "O2S6 C lambda:",null,"EQR","0","2","2","39","2" },
{ "O2S6 Current:",null,"mA","-128","128","2","39","1" },
{ "O2S7 C lambda:",null,"EQR","0","2","2","3A","2" },
{ "O2S7 Current:",null,"mA","-128","128","2","3A","1" },
{ "O2S8 C lambda:",null,"EQR","0","2","2","3B","2" },
{ "O2S8 Current:",null,"mA","-128","128","2","3B","1" },
{ "Catalyst Temperature Bank 1 Sensor 1:",null,"°C","-40","6513.5","2","3C","2" },
{ "Catalyst Temperature Bank 2 Sensor 1:",null,"°C","-40","6513.5","2","3D","1" },
{ "Catalyst Temperature Bank 1 Sensor 2:",null,"°C","-40","6513.5","2","3E","1" },
{ "Catalyst Temperature Bank 2 Sensor 2:",null,"°C","-40","6513.5","2","3F","1" },
{ "PIDs supported 41-60:",null,"Binary",null,null,"2","40","1" },
{ "Monitor status this drive cycle:",null,"Binary",null,null,"2","41","1" },
{ "Check Engine Light:",null,null,null,null,"2","41","2" },
{ "Number of Codes:",null,null,null,null,"2","41","3" },
{ "Misfire Test:",null,null,null,null,"2","41","4" },
{ "Fuel System Test:",null,null,null,null,"2","41","5" },
{ "Components Test:",null,null,null,null,"2","41","6" },
{ "Reserved/Special Test:",null,null,null,null,"2","41","7" },
{ "Catalyst Test:",null,null,null,null,"2","41","8" },
{ "Heated Catalyst Test:",null,null,null,null,"2","41","9" },
{ "Evaporative System Test:",null,null,null,null,"2","41","10" },
{ "Secondary Air System Test:",null,null,null,null,"2","41","11" },
{ "A/C Refrigerant Test:",null,null,null,null,"2","41","12" },
{ "O2 SensorTest:",null,null,null,null,"2","41","13" },
{ "O2 Sensor Heater Test:",null,null,null,null,"2","41","14" },
{ "EGR System Test:",null,null,null,null,"2","41","15" },
{ "Control module voltage:",null,"V","0","65.535","2","42","1" },
{ "Absolute load value:",null," %","0","25700","2","43","1" },
{ "Command equivalence ratio:",null,"N/A","0","2","2","44","1" },
{ "Relative throttle position:",null," %","0","100","2","45","1" },
{ "Ambient air temperature:",null,"°C","-40","215","2","46","1" },
{ "Absolute throttle position B:",null," %","0","100","2","47","1" },
{ "Absolute throttle position C:",null," %","0","100","2","48","1" },
{ "Accelerator pedal position D:",null," %","0","100","2","49","1" },
{ "Accelerator pedal position E:",null," %","0","100","2","4A","1" },
{ "Accelerator pedal position F:",null," %","0","100","2","4B","1" },
{ "Commanded throttle actuator:",null," %","0","100","2","4C","1" },
{ "Time run with MIL on:",null,"minutes","0","65535","2","4D","1" },
{ "Time since trouble codes cleared:",null,"minutes","0","65535","2","4E","1" },
{ "Fuel Type:",null,"String",null,null,"2","51","1" },
{ "Ethanol fuel:",null," %","0","100","2","52","1" },
{ "Absoulute Evap system Vapour Pressure:",null,"kpa","0","327675","2","53","1" },
{ " ?:",null," ?"," ?"," ?","2","C3","1" },
{ " ?:",null," ?"," ?"," ?","2","C4","1" },
{ "Request trouble codes:",null,null,null,null,"3","N/A","1" },
{ "Reset ECU:",null,null,null,null,"4","N/A","1" },
{ "OBD Monitor IDs supported ($01 - $20):",null,null,null,null,"5","0100","1" },
{ "Rich to lean threshold Bank 1 Sensor 1:",null,"V","0","1.275","5","0101","1" },
{ "Rich to lean threshold Bank 1 Sensor 2:",null,"V","0","1.275","5","0102","1" },
{ "Rich to lean threshold Bank 1 Sensor 3:",null,"V","0","1.275","5","0103","1" },
{ "Rich to lean threshold Bank 1 Sensor 4:",null,"V","0","1.275","5","0104","1" },
{ "Rich to lean threshold Bank 2 Sensor 1:",null,"V","0","1.275","5","0105","1" },
{ "Rich to lean threshold Bank 2 Sensor 2:",null,"V","0","1.275","5","0106","1" },
{ "Rich to lean threshold Bank 2 Sensor 3:",null,"V","0","1.275","5","0107","1" },
{ "Rich to lean threshold Bank 2 Sensor 4:",null,"V","0","1.275","5","0108","1" },
{ "Rich to lean threshold Bank 3 Sensor 1:",null,"V","0","1.275","5","0109","1" },
{ "Rich to lean threshold Bank 3 Sensor 2:",null,"V","0","1.275","5","010A","1" },
{ "Rich to lean threshold Bank 3 Sensor 3:",null,"V","0","1.275","5","010B","1" },
{ "Rich to lean threshold Bank 3 Sensor 4:",null,"V","0","1.275","5","010C","1" },
{ "Rich to lean threshold Bank 4 Sensor 1:",null,"V","0","1.275","5","010D","1" },
{ "Rich to lean threshold Bank 4 Sensor 2:",null,"V","0","1.275","5","010E","1" },
{ "Rich to lean threshold Bank 4 Sensor 3:",null,"V","0","1.275","5","010F","1" },
{ "Rich to lean threshold Bank 4 Sensor 4:",null,"V","0","1.275","5","0110","1" },
{ "Lean to rich threshold Bank 1 Sensor 1:",null,"V","0","1.275","5","0201","1" },
{ "Lean to rich threshold Bank 1 Sensor 2:",null,"V","0","1.275","5","0202","1" },
{ "Lean to rich threshold Bank 1 Sensor 3:",null,"V","0","1.275","5","0203","1" },
{ "Lean to rich threshold Bank 1 Sensor 4:",null,"V","0","1.275","5","0204","1" },
{ "Lean to rich threshold Bank 2 Sensor 1:",null,"V","0","1.275","5","0205","1" },
{ "Lean to rich threshold Bank 2 Sensor 2:",null,"V","0","1.275","5","0206","1" },
{ "Lean to rich threshold Bank 2 Sensor 3:",null,"V","0","1.275","5","0207","1" },
{ "Lean to rich threshold Bank 2 Sensor 4:",null,"V","0","1.275","5","0208","1" },
{ "Lean to rich threshold Bank 3 Sensor 1:",null,"V","0","1.275","5","0209","1" },
{ "Lean to rich threshold Bank 3 Sensor 2:",null,"V","0","1.275","5","020A","1" },
{ "Lean to rich threshold Bank 3 Sensor 3:",null,"V","0","1.275","5","020B","1" },
{ "Lean to rich threshold Bank 3 Sensor 4:",null,"V","0","1.275","5","020C","1" },
{ "Lean to rich threshold Bank 4 Sensor 1:",null,"V","0","1.275","5","020D","1" },
{ "Lean to rich threshold Bank 4 Sensor 2:",null,"V","0","1.275","5","020E","1" },
{ "Lean to rich threshold Bank 4 Sensor 3:",null,"V","0","1.275","5","020F","1" },
{ "Lean to rich threshold Bank 4 Sensor 4:",null,"V","0","1.275","5","0210","1" },
{ "mode 9 supported PIDs 01 to 20:",null,null,null,null,"9","00","1" },
{ "Vehicle identification number (VIN):",null,null,null,null,"9","02","1" },
{ "calibration ID:",null,null,null,null,"9","04","1" },
{ "calibration:",null,null,null,null,"9","06","1" },
{ "Database","Check","Failed",null,null,"F","F","F" },


	};
}

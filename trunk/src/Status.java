import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Status {

	// user defined variables
	public static int ConsoleLevel = 3;
	public static int LogLevel = 0;
	public static String LogFile = "/tmp/obd2ner.log";
	public static String UseDevice = "/dev/obd";
	public static String ReadFile = "/home/adam/workspace/obd2ner/useful files/smartsCar";
	public static String WriteData = "atz";

	public static boolean Online = false;
	public static boolean IsBluetooth = true;
	public static List WriteList = new List();

	static int WriteCount = 0;
	public static String WriteMode = "RandomAccess";

	// setup properties


	public static SerialInterface SerialThread = null;


	static int IATC;
	static int IATF;
	static boolean[] O2SensorsPresent;
	static boolean[] O2SensorsPresentAdditional;
	static boolean[] PIDsSupported21To40;
	static boolean[] PIDsSupported41To60;


    public static OBD2nerForm form = new OBD2nerForm();
    public static MasterList MasterList = new MasterList();
    public static boolean UseFileWhenOffline=true;
    public static boolean OutputToConsole = true;
    

	// System Defined variables

        public static String DataLastSentToOBDPort = "";
	public static Timer UpdateTimer = new Timer();
	public static boolean WriterIsReady = true;
        static FileWriter FileWriterChar = null;
        static BufferedWriter LogCharOut = null;
        static Thread SerialInterfaceThread = null;

	public MasterList Form2 = new MasterList();

	public static BufferedWriter Writer = null;
	public static String Line;
	public static boolean PIDsSupported01To20[];
	public static BufferedReader ReaderFile = null;
	public static BufferedReader Reader = null;
	public static float Status;

	public static String DTCs[] = new String[10];
        public static String PendingDTCs[] = new String[10];
	public static String PermanentDTCs[] = new String[10];
        public static String LastWrittenData = "";


        public static StringTokenizer LineToken;
	public static String CheckToken;
	public static boolean StatusArrayA[];
	public static boolean StatusArrayB[];
	public static boolean StatusArrayC[];
	public static boolean StatusArrayD[];
	public static boolean DrivecycleStatusArrayA[];
	public static boolean DrivecycleStatusArrayB[];
	public static boolean DrivecycleStatusArrayC[];
	public static boolean DrivecycleStatusArrayD[];
	public static boolean MODE9SupportedPIDs[];

	public static String FuelType;
	public static boolean Celcius = false;
	public static int NumberOfCodes;
	public static boolean newDataIsAvailable;
	public static boolean ExpectMore;
	public static boolean ContinueReading;

	public static void resetAllReaders() {
		ReaderFile = null;
		Reader = null;
                if ((! WriteMode.equals("ScanMode")) && (FileWriterChar != null)){
                    try {
                         LogCharOut.close();
                        LogCharOut = null;
                        FileWriterChar.close();
                        FileWriterChar = null;
                    } catch (IOException ex) {
                        Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

	}


}

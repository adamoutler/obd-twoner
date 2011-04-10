import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerialInterface implements Runnable{
    



	// Stream from file
    @Override
	public void run(){
        try {
                startInterface();
            } catch (IOException ex) {
                Logger.getLogger(SerialInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public static void StartStop( String StartStop ){

            if ( StartStop.equals("start")){
            Status.SerialThread = new SerialInterface();
            Status.SerialInterfaceThread = new Thread (Status.SerialThread);
            Status.SerialInterfaceThread.start();
            } else {
            Status.SerialInterfaceThread=null;
            }
        }

	 private void startInterface() throws IOException {
             String fromFile=Status.UseDevice;

		// Create reader if not defined
            if (Status.Reader == null) {
		Log.level2("Opening " + Status.UseDevice + " for read");
		Status.Reader = new BufferedReader(new FileReader(fromFile));
            }

            while (Status.Online){
                //System.out.println("Online Loop");

	        if ((Status.Reader != null ) && (Status.Reader.ready())){

                        // Load up Lines with data
                        String Lines = "";

                        while ((! Lines.contains("\r")) && (! Lines.contains(">") && (! Lines.contains("\n")))) {

                            if (Status.Reader.ready()){
                                char c = (char) Status.Reader.read();
                                Lines = Lines + c;


                                //Logging for ScanMode
                                if (Status.WriteMode.equals("ScanMode")){
                                        Log.logCharToFile(c);
                                 } else if ((! Status.WriteMode.equals("ScanMode")) && (Status.FileWriterChar != null)){

                                             Status.LogCharOut.close();
                                             Status.LogCharOut = null;
                                             Status.FileWriterChar.close();
                                             Status.FileWriterChar = null;
                                 }
                            }

                        }

                 	// SEND REQUEST FOR DATA HERE
			if (Lines.endsWith(">")) {
                            Log.level1("REQUEST FOR DATA:>");
                            Status.WriterIsReady=true;
                            if (Status.WriteMode == null ? "WriteList" == null : Status.WriteMode.equals("WriteList")){
                                WriteOut.write("");
                            }
                            if (Status.WriteMode == null ? "ScanMode" == null : Status.WriteMode.equals("ScanMode")){
                                WriteOut.write("");
                            }
			}
                                 

                        // zero out the array

                          
                    
                        // fill the array if new data is available
        		if (Lines.contains("\r")) {
                           String LinesArray[] = Lines.split("\r");
            

        		// Send the data out for processing
                           if ( Lines != null && (! Lines.equals(""))) {

                                processLine(LinesArray);
                                LinesArray=null;
                                Status.Line=null;
                            }
                                
                        
                        }

                    
                }
             }
             

        }


	private static void processLine(String LinesArray[]) {

		// ... Loop as long as there are input lines.

		for (int i = 0; Array.getLength(LinesArray) - 1 >= i; i++) {
			Status.Line = LinesArray[i];
                        Status.Line.replace("\r", "");
                        if (Status.Line.equals(Status.LastWrittenData)){
                            Status.LastWrittenData = "";
                            return;
                        }

                        //blank line catch
                        if (Status.Line.equals("")){
                            return;
                        }
			if (Status.Line.contains("?")) {
				Log.level2("INVALID REQUEST RETURNED: " + Status.Line);
			} else if (Status.Line.contains("SEARCHING")) {
				Log.level2("INTERPERATER STATUS: " + Status.Line);
			} else if (Status.Line.contains("UNABLE")) {
				Log.level2("CHECK IF VEHICLE IS RUNNING: " + Status.Line);
			} else if (Status.Line.contains("NO DATA")) {
				Log.level2("ECU MESSAGE: " + Status.Line);
			} else if (Status.Line.contains("OK")) {
				Log.level2("UNIT STATUS UPDATED:" + Status.Line);
			} else if (Status.Line.contains("ELM3")) {
				Log.level2("UNIT WAS RESET:" + Status.Line);
                        } else if (Status.Line.contains("NO DATA")){
                                Log.level2("Status.Line");
                       	} else {

                            //Begin mode data here:

				if ((Status.Line.length() >= 2)) {

                                    Status.LineToken = new StringTokenizer(Status.Line);
                                    Status.CheckToken = Status.LineToken.nextToken();


					if (Status.CheckToken.startsWith("41")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode01or02.modeSwitch(Status.LineToken, "1");
					} else if (Status.CheckToken.startsWith("42")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode01or02.modeSwitch(Status.LineToken, "2");
					} else if (Status.CheckToken.startsWith("43")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode03or07or0A.modeSwitch("03");
					} else if (Status.CheckToken.startsWith("44")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode04.modeSwitch();
					} else if (Status.CheckToken.startsWith("45")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode05.modeSwitch();
					} else if (Status.CheckToken.startsWith("46")) {
						Log.level3("switching mode:" + Status.Line.toString());
						// Mode6 is manufacturer speciffic diagnostics
					} else if (Status.CheckToken.startsWith("47")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode03or07or0A.modeSwitch("07");
					} else if (Status.CheckToken.startsWith("48")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Log.level2("information on mode 8 received: "
								+ Status.Line);
						// mode 8 is for control of a vehicle. Unknown params at
						// this time.
					} else if (Status.CheckToken.startsWith("49")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode09.modeSwitch();
					} else if (Status.CheckToken.startsWith("4A")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode03or07or0A.modeSwitch("0A");

					} else {
                                                Log.level2("UNRECOGNIZED DATA: "+ Status.Line.toString());
                                        }
				}
			}
		}

		// Status.reader.close(); // Close to unlock.
		Status.newDataIsAvailable = true;
	}





}

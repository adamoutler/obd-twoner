import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadInterpreter implements Runnable{



	// Stream from file
    @Override
	public void run(){
        try {
            startInterface();
        } catch (IOException ex) {
            Logger.getLogger(SerialInterface.class.getName()).log(Level.SEVERE, null, ex);
        }


	}


        public static void main(){
            ReadInterpreter Port = new ReadInterpreter();
            Status.SerialInterfaceThread = new Thread (Port);
            Status.SerialInterfaceThread.start();


        }

	 private void startInterface() throws IOException {
             String fromFile=Status.ReadFile;

		// Create reader if not defined
            if (Status.ReaderFile == null) {
		Log.level2("Opening " + Status.ReadFile + " for read");
		Status.ReaderFile = new BufferedReader(new FileReader(fromFile));
            }

            int i = 0;

            while (! Status.Online){
            //System.out.println("Offline Loop");
            
	        if ((Status.ReaderFile != null ) && (Status.ReaderFile.ready())){
                        // Load up Lines with data
                        String Lines = "";
                        while (((! Lines.contains("\r")) && (! Lines.contains("^M")) && (! Lines.contains(">"))) ) {
                            if (Status.ReaderFile.ready()){
                                char c = (char) Status.ReaderFile.read();
                                Lines = Lines + c;
                            }

                        }
                        Lines=Lines.replace("^M", "\r");



                 	// SEND REQUEST FOR DATA HERE
			if (Lines.endsWith(">")) {
                            Log.level2("REQUEST FOR DATA:>");
                            Status.WriterIsReady=true;
                            WriteOut.write("");
			}
                        // zero out the array
                        // fill the array if new data is available
        		if (Lines.contains("\r")) {
                               String LinesArray[] = Lines.split("\r");
        		// Send the data out for processing
                            if ( Lines != null && (! Lines.equals(""))) {
                                processLine(LinesArray);
                                LinesArray=null;
                            }
                         }
                      
                } else if (i <= 100) {
                    Log.level2("Opening " + Status.ReadFile + " for read");
                    Status.ReaderFile = new BufferedReader(new FileReader(fromFile));
                    i++;
                } else {
                    i = 0;
                    Status.resetAllReaders();
                }
                         try {
             Thread.sleep(200);
             } catch (InterruptedException ex) {
             }
            
             }   

        }


	private static void processLine(String LinesArray[]) {

		// ... Loop as long as there are input lines.

		for (int i = 0; Array.getLength(LinesArray) - 1 >= i; i++) {
			Status.Line = LinesArray[i];
                        Status.Line.replace("\r", "");

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


					if (Status.CheckToken.contains("41")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode01or02.modeSwitch(Status.LineToken , "1");
					} else if (Status.CheckToken.contains("42")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode01or02.modeSwitch(Status.LineToken , "2");
					} else if (Status.CheckToken.contains("43")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode03or07or0A.modeSwitch("03");
					} else if (Status.CheckToken.contains("44")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode04.modeSwitch();
					} else if (Status.CheckToken.contains("45")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode05.modeSwitch();
					} else if (Status.CheckToken.contains("46")) {
						Log.level3("switching mode:" + Status.Line.toString());
						// Mode6 is manufacturer speciffic diagnostics
					} else if (Status.CheckToken.contains("47")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode03or07or0A.modeSwitch("07");
					} else if (Status.CheckToken.contains("48")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Log.level2("information on mode 8 received: "+ Status.Line);
						// mode 8 is for control of a vehicle. Unknown params at
						// this time.
					} else if (Status.CheckToken.contains("49")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode09.modeSwitch();
					} else if (Status.CheckToken.contains("4A")) {
						Log.level3("switching mode:" + Status.Line.toString());
						Mode03or07or0A.modeSwitch("0A");

					}
				}
			}
		}

		// Status.reader.close(); // Close to unlock.
		Status.newDataIsAvailable = true;
	
	}

}


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

	private static void consoleOut(String data) {

		System.out.println(data);
            
                //updates console output on the form
                Status.form.updateText(data);

	}

	private static void debugOut(String data) {
		// Write(data) > LogFile.

	}

	// level 0 is practically silent
	public static void level0(String data) {
		if (Status.ConsoleLevel >= 0) {
			consoleOut(data);

		}
		if (Status.LogLevel >= 0) {
			debugOut(data);

		}
	}

	// level 1 is basic cooked data
	public static void level1(String data) {
		if (Status.ConsoleLevel >= 1) {
			consoleOut(data);
		}
		if (Status.LogLevel >= 1) {
			debugOut(data);

		}

	}

	// level 2 is communications data
	public static void level2(String data) {
		if (Status.ConsoleLevel >= 2) {
			consoleOut(data);
		}
		if (Status.LogLevel >= 2) {
			debugOut(data);

		}
	}

	// level 3 is conversions and other data
	public static void level3(String data) {
		if (Status.ConsoleLevel >= 3) {
			consoleOut(data);
		}
		if (Status.LogLevel >= 3) {
			debugOut(data);

		}
	}
        public static void StandardDataFromTable(int TableRef){

            //performs logging for table data
            //Friendly name: value units of measure
                Log.level1(Database.getLogNameDataUnits(TableRef));

        }

	public static void infoError() {
            //standard unexpected token failure
		Log.level0("INFORMATION FAILURE " + Status.Line);
	}


        public static void logCharToFile(char CharToLog){
            if (Status.LogCharOut == null){
                try {
                    Status.FileWriterChar = new FileWriter(Status.LogFile);
                    Status.LogCharOut = new BufferedWriter(Status.FileWriterChar);
                } catch (IOException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String WriteString = "";
            WriteString = WriteString + CharToLog;
            WriteString = ( WriteString.equals("\r"))? "^M" :  WriteString;

       try {
            Status.FileWriterChar.write(WriteString);
            //Close the output stream
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }

  
    }
 }


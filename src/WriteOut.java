import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * This class is where all writing operations occur in the program
 * This class determines the write mode of the program.  It is called
 * when data is requested from SerialInterface or ReadInterpereter
 */
public class WriteOut {
	public static void write(String WriteData) throws IOException {


            //Online single command mode
            if ((Status.Online) && ( ! WriteData.equals(""))) {
                writeHandler(WriteData);
                return;
            }
            if ((Status.Online) && (Status.WriteMode.equals("ScanMode"))) {
                    scanMode();
            } else if ((Status.Online) && (Status.WriteMode.equals("WriteList"))) {
                    useWriteList();
            } else if( ! Status.Online) {
                    Log.level1("Offline- No write");
            }
        }



       /* WriteList is a mode where
        * data is obtained from a
        * list called Status.WriteList
        * WriteList enables cyclic
        * repetetious commands for
        * online monitoring
        */
        private static void useWriteList(){
                //Check if writeCount is greater then itemcount of list and make it equal if so
                if (Status.WriteCount > Status.WriteList.getItemCount()-1){
                    Status.WriteCount = Status.WriteList.getItemCount()-1;
                }

                //If writecount is greater or Equal to itemCount, then write the data
                if (Status.WriteCount <= Status.WriteList.getItemCount()){
                        //pick data from the write list based on writecount
                        String WriteData=Status.WriteList.getItem(Status.WriteCount);
                        writeHandler(WriteData);
                        ++ Status.WriteCount;

                        //if writecount needs to be reset, reset it
                        if (Status.WriteCount > Status.WriteList.getItemCount() -1 ){
                            Status.WriteCount = 0;
                        }
                }
        }



        /*Scan Mode takes data from
         * OBD2nerForm textboxes and
         * creates a hex string to
         * be sent.  It is incremented
         * sequentially if specified.
         */

        private static void scanMode(){
                //get write data from OBD2nerForm
                String WriteDataInstance = Status.form.getNewScannerValueRunnable();
                //send to write handler
                writeHandler(WriteDataInstance);

        }


        //main writer all data goes through here to be written to obd port
        private static void writeHandler(String data){

                try {
                    java.io.FileWriter Writer = new java.io.FileWriter(Status.UseDevice);
                    Log.level2("writing " + data + " to " + Status.UseDevice);
                    Writer.write(data + "\r");
                    Writer.close();
                    Status.LastWrittenData=data;
                    Status.WriterIsReady=false;
		} catch (FileNotFoundException ex) {
                    //TODO killall obd2ner && rfcomm release 0 && ./obd2ner
                    //todo ./obd2ner
                    ex.printStackTrace();
		} catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
}

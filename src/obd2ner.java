import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class obd2ner {

	public obd2ner() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws IOException {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(obd2ner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(obd2ner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(obd2ner.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(obd2ner.class.getName()).log(Level.SEVERE, null, ex);
        }


            Database.initializeColoumNames();
            Log.StandardDataFromTable(Database.setDataUnits("F", "F", "F", "Complete"));
            Status.form.setVisible(true);
                //startRead();
                


	}

	public static void startRead() {

            /* This loop is forever
             *
             */
            while (true) {

                Status.resetAllReaders();



                /* This is the online
                 * status reader. While
                 * Status.Online is true
                 * this loop is used
                 */

		while (Status.Online) {
		//InitializeBluetooth.initalize();
		// Log.level3("reading...");
                //  try {
                //	SerialInterface.getNewData();
                //  } catch (IOException e) {
		//	Status.resetAllReaders();
                //  }
                }
                /* This is the offline
                 * status reader. While
                 * ! Status.Online
                 * this loop is used
                 */
		//while (! Status.Online) {
                //    try {
//			ReadInterpreter.getNewData();
 //                   } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//                  }
//		}
		// TODO Auto-generated method stub
            }

    }
}


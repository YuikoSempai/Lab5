package utility;

import commands.Execute_script;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    static public Scanner scannerIn = new Scanner(System.in);
    static public boolean readFromFileStatus = false;

    /**
     * Read next line in Scanner
     * @return next line in scanner
     */
    public static String nextLine() {
        if (readFromFileStatus) {
            if (!scannerIn.hasNextLine()) {
                Console.scannerIn = new Scanner(System.in);
            }
        }
        return scannerIn.nextLine();
    }

    /**
     * Read next element in scanner
     * @return next String in scanner
     */
    static public String next() throws NoSuchElementException,IllegalArgumentException {
        if (readFromFileStatus) {
            if (!scannerIn.hasNextLine()) {
                Console.scannerIn = new Scanner(System.in);
                Execute_script.deleteLastPath();
            }
        }
        return scannerIn.next();

    }

    public static boolean getReadFromFileStatus() {
        return readFromFileStatus;
    }

    public static void setReadFromFileStatus(boolean status) {
        readFromFileStatus = status;
    }

    /**
     * Close scanner
     */
    public static void close() {
        scannerIn.close();
    }


}

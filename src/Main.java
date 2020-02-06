import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * Task Prerequisites:
         *
         * If there is no -mode, default to enc.
         * If there is no -key, default to 0
         * If there is no -data AND no -in, default to an empty string
         * If there is BOTH -data AND -in, default to -data
         * If there is no -out, default to printing to terminal
         *
         * If exceptions are thrown, display a message containing "Error"
         */

        // Defaults
        String mode = "enc";
        String message = "";
        int key = 0;
        String in = "";
        String out = "";

        File fileIn;
        File fileOut;

        for ( int i = 0; i < args.length; i++) {

            switch( args[i] ) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt( args[i + 1] );
                    break;
                case "-data":
                    message =  args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                case "-out":
                    out = args[i + 1];
            }

        }


        // set message to contents of file
        if ( message.equals("") && !in.equals("") ) {

            fileIn = new File(in);

            try {
                Scanner s = new Scanner(fileIn);
                message = s.nextLine();
                s.close();
            } catch ( FileNotFoundException e ) {
                System.out.println("Error: " + e.getClass().getSimpleName());
            }

        }

        encDec tool = new encDec();

        if ( out.equals("") ) {

            System.out.println( tool.convert( mode, message, key ) );

        } else {

            // Write to a file
            fileOut = new File(out);
            String write = tool.convert( mode, message, key );

            try {
                FileWriter filewrite = new FileWriter(fileOut);
                filewrite.write(write);
                filewrite.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getClass().getSimpleName());
            }

        }



    }
}

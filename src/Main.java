import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String mode = "";
        String message = "";
        int shift = 0;


        for ( int i = 0; i < args.length; i++) {

            switch( args[i] ) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    shift = Integer.parseInt( args[i + 1] );
                    break;
                case "-data":
                    message =  args[i + 1];
                    break;
            }

        }

        char[] convert = message.toCharArray();


        if ( mode.equals("dec") ) {
            System.out.println(dec(convert, shift));
        } else if ( mode.equals("enc") ) {
            System.out.println(enc(convert, shift));
        }

    }





    // return types didn't match
    static char[] enc( char[] toConvert, int shift) {

        int beg = 32; // ASCII lowercase a
        int limit = 126; // ASCII lowercase z

        char[] message = new char[toConvert.length];

        for ( int i = 0; i < toConvert.length; i++) {

            int letter = toConvert[i];

            // being shifted by its own distance from the end of the alphabet
            int shiftUp = letter + shift;

            if ( shiftUp > limit ) {
                int diff = shiftUp - limit;
                shiftUp = ( beg - 1 ) + diff;
            }

            message[i] = (char) shiftUp;


        }

        return message;

    }



    // rewrite this to decode. Invert the logic
    static char[] dec( char[] toConvert, int shift) {

        int beg = 32; // ASCII lowercase a
        int limit = 126; // ASCII lowercase z

        char[] message = new char[toConvert.length];

        for ( int i = 0; i < toConvert.length; i++) {

            int letter = toConvert[i];

            // being shifted by its own distance from the end of the alphabet
            int shiftDown = letter - shift;

            if ( shiftDown < beg ) {
                int diff = shiftDown + limit;

                shiftDown = ( limit + 1 ) - diff;
            }

            message[i] = (char) shiftDown;

        }



        return message;

    }





}

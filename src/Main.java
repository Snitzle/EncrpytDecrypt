import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Mode Type
        String mode = s.nextLine().toLowerCase();
        // System.out.println(mode);

        // input message
        char[] convert = s.nextLine().toCharArray();
        // System.out.println(convert);

        // Shift amount Key
        int shift = s.nextInt();
        // System.out.println(shift);


        if ( mode.equals("dec") ) {

            // Decrpyt Method
            // System.out.println("Dec Hit");
            System.out.println(dec(convert, shift));

        } else if ( mode.equals("enc") ) {

            // Encrytp Method
            // System.out.println("Enc Hit");
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

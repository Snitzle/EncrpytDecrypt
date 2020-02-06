import java.util.Arrays;

public class encDec {

    static final int beg = 32; // ASCII lowercase a
    static final int limit = 126; // ASCII lowercase z


    public String convert ( String mode, String message, int shift ) {

        char[] toConvertArr = message.toCharArray();
        String returnMessage = "";

        if ( mode.equals("dec") ) {
            returnMessage = dec(toConvertArr, shift);
        } else if ( mode.equals("") || mode.equals("enc") ) {
            returnMessage = enc(toConvertArr, shift);
        }

        return returnMessage;

    }


     String enc( char[] toConvert, int shift) {

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

         return new String(message);

    }




     String dec( char[] toConvert, int shift) {

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

         return new String(message);

    }

}
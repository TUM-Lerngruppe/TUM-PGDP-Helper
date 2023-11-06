public class intArrayHelp {
    /** Methode, die ein Array kürzt und das gekürzte wieder zurückgibt.
     *
     * @param a Array of Integers
     * @param by Length to be shortened
     * @return Das gekürzte Array
     */
    public static int[] shortArray(int[] a, int by){
        int[] b = new int[a.length - by];
        System.arraycopy(a, 0, b, 0, b.length);
        return b;
    }

    /** Methode, die ein Array kopiert und das kopierte wieder zurückgibt.
     *
     * @param array Array of Integers
     * @return Das kopierte Array
     */
    public static int[] copyArray(int[] array){
        int[] new_array = new int[array.length];
        System.arraycopy(array, 0, new_array, 0, new_array.length);
        return new_array;
    }

    /** Methode, die zwei Arrays zu einem einzigen Array verbindet,
     *  indem sie abwechselnd starting with a von jedem Array einen Eintrag nimmt,
     *  bis alle aufgebraucht sind.
     *  (W03 H01 Reisverschluss)
     *
     * @param a Array of Integers
     * @param b Array of Integers
     * @return The zipped Array
     */
    public static int[] zip(int[] a, int[] b) {
        // get the longer length for the iteration
        int longer = a.length;
        if(a.length< b.length){
            longer = b.length;
        }
        int[] ret = new int[a.length+b.length]; // form the new Array
        int counter = 0;
        for(int i = 0; i<longer; i++){
            if(i<a.length){ // check if all Values of a are already in the new Array
                ret[counter++] = a[i]; // put the value of a[i] in and increase the counter
            }
            if(i<b.length){
                ret[counter++] = b[i];
            }
        }
        return ret;
    }

    /** Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
     *  indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
     *  (W03 H01)
     *
     * @param arrays Array von Integer-Arrays
     * @return Die Arrays in 'arrays' zusammengezipped
     */
    public static int[] zipMany(int[][] arrays) {
        int longest = 0;
        int length = 0;
        for(int[] j: arrays){
            if(j.length > longest){
                longest = j.length; // get the length of the longest Array for iteration
            }
            length += j.length; // get the total length for the new Array
        }
        int[] ret = new int[length];
        int counter = 0;
        for(int i = 0; i<longest; i++){ // like in zip just with more Arrays
            for (int[] array : arrays) {
                if (i < array.length) {
                    ret[counter++] = array[i];
                }
            }
        }
        return ret;
    }

    /** Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
     *  Gibt das Ergebnis als neues Array zurück.
     *
     * @param array Ein beliebiges Integer-Array
     * @param min Ein beliebiger Integer
     * @param max Ein beliebiger Integer
     * @return Das gefilterte Array
     */
    public static int[] filter(int[] array,int min,int max) {
        int counter = 0;
        for (int j : array) A:{
            if (min <= j && max >= j) {
                array[counter++] = j;
            }
        }
        return shortArray(array, array.length - counter);
    }

    /** Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     *  Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        if(array.length == 0){return;} // if array empty return
        //get the rotation amount in the range od [0,array.length-1]
        if(amount< 0){
            amount = amount % array.length;
            amount += array.length;
        }
        if(amount>= array.length){
            amount = amount % array.length;
        }
        if(amount == 0){return;} // if no rotation return
        int[] save = copyArray(array);
        for(int i = 0; i<array.length; i++) {
            if (i + amount < array.length) {
                array[i + amount] = save[i];
            } else {
                array[i + amount - array.length] = save[i];
            }
        }
    }


}

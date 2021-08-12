public class StringExample {
    public boolean compareFirstAndLastCharactersAreSane(String str){
        if (str.length() <=1)
            return false;
        if (str.length() == 2)
            return false;

        String first2Char = str.substring(0,2);
        String last2char = str.substring(str.length()-2);
        return first2Char.equals(last2char);
    }
}

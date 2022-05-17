package sum;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testt {
    public static class ArrayList<T> {
        private T[] array;
        private int size;
    }

    ArrayList<String> strList = new ArrayList<String>();

    public static String LETTER_REGEX = "[a-zA-Z]+";

    public static void main(String[] args) {
        String name = "VALUES";
        int nameLenght = name.length(); // length of the string used for the lo
        int sum = 0;
        String LETTER_REGEX = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(LETTER_REGEX);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            for (int i = 0; i < nameLenght; i++) {
                char character = name.toLowerCase().charAt(i);
                int ascii = (int) character - 96;
                sum += ascii;
//                    System.out.println(character + " = " + ascii);
            }
            System.out.println("總和 = " + sum);
        } else {
            int ascii = 0;
            sum += ascii;
            System.out.println("總和 = " + sum);
        }
    }
}

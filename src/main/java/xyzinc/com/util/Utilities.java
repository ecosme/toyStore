package xyzinc.com.util;

public class Utilities {

    public String vowelReorderer(String str1){
        String input = "this test is an easy one";
        String result ="";
        char[] reverse = input.toCharArray();
        int strlen = input.length();
        int pos = 0;
        char fv = '\0';
        for (int i =0; i<reverse.length; i++){
            pos = strlen - i;
            if (reverse[pos] == 'a' || reverse[pos] == 'e' ||
                    reverse[pos] == 'i' || reverse[pos] == 'o' ||
                    reverse[pos] == 'u') {
                fv = reverse[pos];
            }
            //sorry this is not the best sol but thgis is the one that I have in mind so far
            if (reverse[i] == 'a' || reverse[i] == 'e' ||
                    reverse[i] == 'i' || reverse[i] == 'o' ||
                    reverse[i] == 'u') {
                char swdv = reverse[i];
                reverse[i] = fv;
                reverse[pos] = swdv;
            }

        }
        return "Result "  + reverse;
    }

}

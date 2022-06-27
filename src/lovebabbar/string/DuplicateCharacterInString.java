package lovebabbar.string;

import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCharacterInString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int []counter = new int[256];
        for(int i=0;i<str.length();i++){
            counter[str.charAt(i)]++;
        }
        for(int i=0;i<256;i++){
            if(counter[i]>1){
                System.out.print(((char)i) +" ");
            }
        }
    }

}

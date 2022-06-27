package lovebabbar.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicString {

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        if(str1.length()!=str2.length()){
            System.out.println("False");
            return;
        }

        int []mapped = new int[256];

        Map<Character,Character> counter = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            if(counter.containsKey(str1.charAt(i))){
                char av = counter.get(str1.charAt(i));
                if(av!=str2.charAt(i)){
                    System.out.println("False");
                    return;
                }
            }
            else{
                if(mapped[str2.charAt(i)]==1){
                    System.out.println("False");
                    return;
                }
                counter.put(str1.charAt(i),str2.charAt(i));
                mapped[str2.charAt(i)]=1;
            }
        }

        System.out.println("True");

    }

}

package lovebabbar.string;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        int j = str.length()-1;
        char []inp = str.toCharArray();
        while(i<j){
            char t = inp[i];
            inp[i]=inp[j];
            inp[j]=t;
            i++;
            j--;
        }

        System.out.println(new String(inp));

    }

}

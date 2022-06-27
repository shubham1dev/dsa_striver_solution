package lovebabbar.string;

import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        int j = str.length() - 1;
        int invalid = 0;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else{
                invalid = 1;
                break;
            }
        }
        if(invalid==1){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }

    }
}

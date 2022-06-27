package lovebabbar.string;

import java.util.Scanner;

public class CheckRotation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int m = str2.length();
        int n = str1.length();

        if(n!=m){
            System.out.println("No");
        }

        int i=0;
        boolean fp = false;
        while(i<n){
            if(str1.equals(str2)){
                fp = true;
                System.out.println("Yes");
                break;
            }
            str2 = str2.substring(1)+str2.charAt(0);
            i++;
        }
        if(!fp)
        System.out.println("No");
    }

    }

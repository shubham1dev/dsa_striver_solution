package striver.day4array;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {

        int []counter = new int[256];
        Arrays.fill(counter,-1);
        int len = s.length();
        int ptr = -1;
        int ans = 0;
        for(int i=0;i<len;i++){
            int ascii = (int)s.charAt(i);
            if(counter[ascii]==-1){
                counter[ascii]=i;
            }
            else {
                ptr++;
                while(ptr<counter[ascii]){
                    counter[s.charAt(ptr)]=-1;
                    ptr++;
                }
                counter[ascii]=i;
            }

            ans = Math.max(ans, i-ptr);

        }

        return ans;

    }

    public static void main(String []args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ans = new LongestSubstringWithoutRepeating().lengthOfLongestSubstring(str);
        System.out.println(ans);


    }

}

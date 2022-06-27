package striver.day2array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MissingAndRepeating {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {


        int n  = A.size();
        int s1 = (n*(n+1))/2;
        int s2 = A.stream().mapToInt(i->Integer.parseInt(String.valueOf(i))).sum();
        long ss1 = (n*(n+1)*(2*n+1))/6;
        long ss2 = A.stream().map(i->i*i).mapToLong(i-> Long.parseLong(String.valueOf(i))).sum();

        long a = s2-s1;
        long b = ss2 - ss1;
        b = b/a;

        ArrayList<Integer> ans = new ArrayList<>();
        int x = (int)(b+a)/2;
        int y = (int)b-x;
        ans.add(x);
        ans.add(y);
        return ans;

    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        IntStream.range(0,n).forEach(i-> arr.add(sc.nextInt()));
        ArrayList<Integer> ans = new MissingAndRepeating().repeatedNumber(arr);
        System.out.println(ans.toString());
    }

}

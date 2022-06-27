package striver.day4array;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SubarrayWithXorK {
    public static int solve(ArrayList<Integer> A, int B) {

        int xor=0;
        int ans = 0;
        for(int i=0;i<A.size();i++){

            xor = xor^A.get(i);
            int temp = xor;
            for(int j=0;j<=i;j++){

                if(temp==B){
                    ans++;
                }
                temp = temp^A.get(j);

            }

        }
        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> inp = new ArrayList<>();
        IntStream.range(0,n).forEach(i-> inp.add(sc.nextInt()));
        int b = sc.nextInt();
        int ans = solve(inp, b);
        System.out.println(ans);

    }
}

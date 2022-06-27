package striver.day11binarysearch;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AllocateBooks {

    public void solve(ArrayList<Integer> A, int B,  int i, int cm, ArrayList<Integer> min) {

        if(i==A.size()) {

            if(B==0){
                min.add(cm);
                return;
            }
            else
                return;

        }

        else {

            int val = 0;
            for(int j=i;j<A.size();j++){
                val+=A.get(j);
                solve(A, B-1, j+1, Math.max(val, cm), min);
            }

        }


    }

    public int books(ArrayList<Integer> A, int B) {

        if(B>A.size()){
            return -1;
        }

        int r = 0;
        for(int i=0;i<A.size();i++)
            r+=A.get(i);
        int l = Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++)
            l = Math.min(l,A.get(i));

        int ans = Integer.MAX_VALUE;
        while(l<=r){

            int mid = l + (r-l)/2;

            int cs = 0;
            int count = 0;
            int cm = 0;
            for(int i=0;i<A.size();i++) {

                if((cs+A.get(i))<=mid) {
                    cs+=A.get(i);
                }

                else {
                    cm = Math.max(cm, cs);
                    count++;
                    cs = A.get(i);
                }

            }

            if(cs<=mid) {
                count++;
                cm = Math.max(cm, cs);
            }

            if(count==B){
                ans = Math.min(ans, cm);
                r = mid-1;
            }
            else  if(count>B){
                l = mid+1;
            }
            else{
                r = mid-1;
            }

        }

        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr= new ArrayList<>();
        IntStream.range(0,n).forEach(i->arr.add(sc.nextInt()));
        int b = sc.nextInt();
        int ans = new AllocateBooks().books(arr, b);
        System.out.println(ans);

    }


}

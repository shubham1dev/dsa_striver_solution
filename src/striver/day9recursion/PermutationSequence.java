package striver.day9recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PermutationSequence {

    public int[] getfac(int n){

        int []ans = new int[n+1];
        int i = 1;
        for(int j=1;j<=n;j++){
            ans[j]=i;
            i*=j+1;
        }

        return ans;
    }

    public String getPermutation(int n, int k) {

        String inp = "";
        List<Integer> arr = new ArrayList<>();
        IntStream.range(0,n).forEach(i-> arr.add(i+1));
        int []fac = getfac(n);

        int lim = n-1;
        for(int i=0;i<n;i++){

            int pos = fac[lim];
            if(k<pos){
                inp+=arr.get(0);
                arr.remove(0);
            }
            else {

                if(k%pos==0){

                    int in = k/pos;
                    in--;
                    inp+=arr.get(in);
                    arr.remove(in);
                    for(int p=0;p<arr.size();p++){
                        inp+=arr.get(arr.size()-p-1);

                    }
                    break;

                }
                else {

                    int in = (int)Math.floor((double)k/(double)pos);
                    inp+=arr.get(in);
                    arr.remove(in);
                    k-=(in*pos);

                }

            }
            lim--;

        }


        return inp;

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String ans = new PermutationSequence().getPermutation(n,k);
        System.out.println(ans);
    }

}

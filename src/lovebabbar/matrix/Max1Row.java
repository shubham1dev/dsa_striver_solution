package lovebabbar.matrix;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Max1Row {
    public static int search(int []arr, int l, int r, int val){
        int index = -1;
        while(l<=r){

            int mid = (l+r)/2;
            if(arr[mid]==val){
                index = mid;
                r = mid-1;
            }
            else if(arr[mid]>val){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return index;

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]arr = new int[n][m];
        IntStream.range(0,n).forEach(i->{
            IntStream.range(0,m).forEach(j-> arr[i][j] = sc.nextInt());
        });

        int max1 = -1;
        int rowindex = -1;
        int p = -1;
        for(int i=0;i<n;i++){
            if(p==-1) {
                int index = search(arr[i], 0, m - 1, 1);
                if (index != -1) {
                    int tot = m - index;
                    if (tot>max1){
                        max1=tot;
                        p = index;
                        rowindex=i;
                    }
                }
            }
            else{
                if(arr[i][p]==1){
                    int index = search(arr[i],0,p,1);
                    int tot = m-index;
                    if(tot>max1){
                        max1 = tot;
                        p = index;
                        rowindex = i;
                    }
                }
            }
        }

        System.out.println(rowindex);

    }

}

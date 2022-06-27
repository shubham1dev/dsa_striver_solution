package lovebabbar.matrix;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SearchElementInMatrix {


    public static int search(int []arr, int l, int r, int val){

        while(l<=r){

            int mid = (l+r)/2;
            if(arr[mid]==val){
                return mid;
            }
            else if(arr[mid]>val){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]matrix = new int[n][m];
        IntStream.range(0,n).forEach(i->{
            IntStream.range(0,m).forEach(j-> matrix[i][j] = sc.nextInt());
        });
        int k = sc.nextInt();

        boolean ans = true;
        for(int i=0;i<n;i++){
            if(i==0 && matrix[i][0]>k){
                ans = false;
                break;
            }
            else if(i==(n-1)){

                if(matrix[i][0]>k){
                    int index = search(matrix[i-1], 0, m-1, k);
                    if(index==-1){
                        ans=false;
                        break;
                    }
                    else{
                        break;
                    }

                }

                else if(matrix[i][m-1]<k){
                    ans = false;
                    break;
                }
                else{
                    int index = search(matrix[i], 0, m-1, k);
                    if(index==-1){
                        ans=false;
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
            else if(matrix[i][0]>k){
               int index = search(matrix[i-1], 0, m-1,k);
               if(index==-1){
                   ans=false;
                   break;
               }
               else{
                   break;
               }

            }
        }

        System.out.println(ans);

    }

}

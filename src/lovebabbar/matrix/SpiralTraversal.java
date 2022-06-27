package lovebabbar.matrix;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SpiralTraversal {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]matrix = new int[n][m];
        IntStream.range(0,n).forEach(i->{
            IntStream.range(0,m).forEach(j-> matrix[i][j] = sc.nextInt());
        });

        int rt = 0;
        int rb = n-1;
        int cl = 0;
        int cr = m-1;

        ArrayList<Integer> ans = new ArrayList<>();
        while(rt<=rb && cl<=cr){

            if(rt>rb || cl>cr)
                break;
            for(int i=cl;i<=cr;i++){
                ans.add(matrix[rt][i]);
            }
            rt++;

            if(rt>rb || cl>cr)
                break;
            for(int i=rt;i<=rb;i++){
                ans.add(matrix[i][cr]);
            }
            cr--;

            if(rt>rb || cl>cr)
                break;
            for(int i=cr;i>=cl;i--){
                ans.add(matrix[rb][i]);
            }
            rb--;

            if(rt>rb || cl>cr)
                break;
            for(int i=rb;i>=rt;i--){
                ans.add(matrix[i][cl]);
            }
            cl++;

        }
        IntStream.range(0,ans.size()).forEach(i->System.out.print(ans.get(i)+" "));

    }

}

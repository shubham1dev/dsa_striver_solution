package codeforces.CR784;

import java.util.ArrayList;
import java.util.Scanner;

public class D {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(-1);
            for(int i=0;i<str.length();i++){

                if(str.charAt(i)=='W')
                    pos.add(i);

            }
            pos.add(n);

            boolean fp = true;
            for(int i=0;i<(pos.size()-1);i++){
                int p = pos.get(i);
                int q = pos.get(i+1);

                int r = 0;
                int b = 0;

                if((q-p)>1){
                    for(int j=p+1;j<q;j++){

                        if(str.charAt(j)=='R'){
                            r++;
                        }
                        else {
                            b++;
                        }

                    }

                    if(r==0 || b==0){
                        fp = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }

            if(fp){
                System.out.println("YES");
            }



        }

    }

}

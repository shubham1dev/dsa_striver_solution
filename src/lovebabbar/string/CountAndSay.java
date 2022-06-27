package lovebabbar.string;

import java.util.Scanner;

public class CountAndSay {

    public static String say(int n, int i, String inp){

        if(i==n){
            return inp;
        }
        else{

            String newinp = "";
            int count = 0;

            if(inp.length()==1){
                return say(n, i+1, "1"+inp.charAt(0));
            }

            for(int j=0;j<inp.length()-1;j++){
                count++;
                if(inp.charAt(j)!=inp.charAt(j+1)){

                    newinp += count+""+inp.charAt(j);
                    count = 0;
                }


            }
            if(inp.charAt(inp.length()-1)==inp.charAt(inp.length()-2)){
                count++;
                newinp += count+""+inp.charAt(inp.length()-1);
            }
            else{
                 newinp+="1"+inp.charAt(inp.length()-1);
            }

            return say(n,i+1, newinp);

        }

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String inp = "1";
        System.out.println(say(n,1, inp));

    }

}

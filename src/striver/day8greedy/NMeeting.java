package striver.day8greedy;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class NMeeting {

    private static class Pair {

        public int start;
        public int end;

        public Pair(int s, int e) {
            start = s;
            end = e;
        }
        public String toString(){
            return start+" "+end;
        }

    }

    public static int maxMeetings(int start[], int end[], int n)
    {

        List<Pair> pairs = new ArrayList<>();
        IntStream.range(0, n).forEach(i-> pairs.add(new Pair(start[i], end[i])));
        Collections.sort(pairs, (a, b) -> {
            if(a.end<b.end)
                return -1;
            else
                return 1;
        });

        int ls = -1;
        int le = -1;

        int ans = 0;
        for(Pair p: pairs){

            if(ls==-1){
                ls = p.start;
                le = p.end;
                ans++;
            }
            else {

                if(p.start>le){
                    ans++;
                    ls = p.start;
                    le = p.end;
                }

            }
        }

        return ans;
    }

    public static void main(String []args) {

        int []start = CommonUtil.getArrayInput();
        int []end = CommonUtil.getArrayInput();
        int ans = maxMeetings(start, end, start.length);
        System.out.println(ans);

    }

}

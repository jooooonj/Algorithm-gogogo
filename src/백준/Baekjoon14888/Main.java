package 백준.Baekjoon14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14888
 * 백준 14888
 * 문제풀이 : 브루투포스, 백트래킹
 */
public class Main {
    static int N ;
    static int[] arr;
    static int[] calc = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static void math(int n, int sum) {

        if(n==N-1) {
            if(max<sum) {
                max = sum;
            }
            if(min>sum) {
                min = sum;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            if(calc[i]>0) {
                if(i==0) {
                    calc[i]--;
                    math(n+1, sum+arr[n+1]);
                    calc[i]++;
                } else if(i==1) {
                    calc[i]--;
                    math(n+1, sum - arr[n+1]);
                    calc[i]++;
                } else if(i==2) {
                    calc[i]--;
                    math(n+1, sum * arr[n+1]);
                    calc[i]++;
                } else if(i==3) {
                    calc[i]--;
                    math(n+1, sum / arr[n+1]);
                    calc[i]++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        math(0,arr[0]);

        System.out.println(max);
        System.out.println(min);

    }
}

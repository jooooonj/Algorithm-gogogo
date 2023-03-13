package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9465
 * 백준 9465
 * 문제풀이 : dp
 */
public class Baekjoon9465 {
    static int[][]dp;
    static int[][] arr;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T ; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            dp = new int[2][n];

            for(int i=0; i<2; i++) {
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    arr[i][j] = x;
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for(int j=1; j<n; j++) {
                for(int i=0; i<2; i++) {
                    int c;
                    if(i==0) {
                        c = i+1;
                    } else {
                        c = i-1;
                    }
                    dp[i][j] = Math.max(dp[i][j-1], dp[c][j-1]+arr[i][j]);
                }
            }
            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}

package 백준.Baekjoon2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2133
 * 백준 2133
 * 문제풀이 : dp
 */

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        if(n>=2) {
            dp[2] = 3;
        }
        dp[0] = 1;
        for(int i=4; i<=n; i++) {
            if(i%2==1) {
                continue;
            }
            dp[i] = (3*dp[i-2] );
            for(int j=4; j<=i; j++) {
                dp[i]+= dp[i-j]*2;
            }

        }
        System.out.println(dp[n]);
    }
}

package 백준.Baekjoon2579;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2579
 * 백준 2579
 * 문제풀이 : dp
 */
public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        arr = new int[n+1] ;
        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(n>1) {
            dp[2] = arr[1] + arr[2];
        }

        if(n>2) {
            for(int i=3; i<n+1; i++) {
                dp[i] = Math.max(dp[i-3] + arr[i-1] , dp[i-2]) + arr[i];
            }
        }
        System.out.println(dp[n]);

    }
}


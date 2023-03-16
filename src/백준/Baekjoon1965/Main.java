package 백준.Baekjoon1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1965
 * 백준 1965
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

        arr = new int[n];
        dp = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        int max = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);

                }
            }
        }
        for(int i = 0; i<n ; i++) {
            if(max<dp[i]) {
                max = dp[i] ;
            }
        }
        System.out.println(max);


    }
}

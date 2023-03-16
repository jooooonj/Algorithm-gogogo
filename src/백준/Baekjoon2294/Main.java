package 백준.Baekjoon2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

//		System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        Arrays.fill(dp, 10001);
        for(int i=0; i<n; i++) {
            for(int j=arr[i]; j<k+1; j++) {
                if(j%arr[i]==0) {
                    dp[j] = j/arr[i];
                } else {
                    int x =1;
                    while(arr[i]*x < j) {

                        dp[j] = Math.min(dp[j] , x + dp[j-arr[i]*x] );
                        x++;
                        if(arr[i]*x > j)
                            break;
                    }
                }
            }
        }

        if(dp[k] == 10001)
            System.out.println(-1);
        else {
            System.out.println(dp[k]);
        }
    }
}
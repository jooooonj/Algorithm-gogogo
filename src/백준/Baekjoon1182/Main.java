package 백준.Baekjoon1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1182
 * 백준 1182
 * 문제풀이 : 백트래킹, 브루트포스
 */
public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int result = 0;

    static void cal(int n, int sum){
        if(n==N){
            if(S==sum)
                result++;
            return;
        }
        cal(n+1, sum);
        cal(n+1, sum+arr[n]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cal(0,0);

        if(S==0){
            System.out.println(result-1);
        } else
            System.out.println(result);
    }
}
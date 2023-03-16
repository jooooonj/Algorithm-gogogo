package 백준.Baekjoon9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/9663
 * 백준 9663
 * 문제풀이 : 백트래킹
 */
public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] dp1; //열
    static boolean[] dp2; // 대각선1
    static boolean[] dp3; // 대각선2
    static int result = 0;

    static void queen(int row){ //처음에 0,1 이 들어옴
        //n번째 퀸 배치
        if(row==N){
            result++;
            return;
        }

        for(int i=0; i<N; i++){
            if(dp1[i]==false && dp2[row+i]==false && dp3[row-i+N-1]==false){
                dp1[i] = true;
                dp2[row+i] = true;
                dp3[row-i+N-1] = true;
                queen(row+1);
                dp1[i] = false;
                dp2[row+i] = false;
                dp3[row-i+N-1] = false;
            }
        }




    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp1 = new boolean[N]; //x
        dp2 = new boolean[N*2-1]; //x+y
        dp3 = new boolean[N*2-1]; //x-y+n-1

        queen(0);
        System.out.println(result);
    }
}
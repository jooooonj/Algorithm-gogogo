package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1890
 * 백준 1890
 * 문제풀이 : 그리디
 */
public class Baekjoon1890 {
    static int N;
    static long[][] dp;
    static int[][] graph;


    static void dfs() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(graph[i][j]==0)continue;
                if(dp[i][j]==0) continue;

                int num = graph[i][j];
                int[] dx = {num,0};
                int[] dy = {0,num};

                for(int n=0; n<2; n++) {
                    int nx = i+dx[n];
                    int ny = j+dy[n];
                    if(nx>=N || ny>= N) continue;

                    dp[nx][ny] += dp[i][j];
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new long[N][N];
        dp[0][0] = 1;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs();

        System.out.println(dp[N-1][N-1]);

    }
}


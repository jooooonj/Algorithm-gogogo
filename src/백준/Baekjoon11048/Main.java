package 백준.Baekjoon11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11048
 * 백준 11048
 * 문제풀이 : dp
 */
public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] note;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //N,M 까지

        map = new int[N + 1][M + 1];
        note = new int[N + 1][M + 1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                note[i][j] = map[i][j] + Math.max(note[i-1][j], note[i][j-1]);
            }
        }
        System.out.println(note[N][M]);

    }
}

package 백준;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7576
 * 백준 7576
 * 문제풀이 : 기본 bfs
 */
public class Baekjoon7576 {
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static Queue<Tomato> q = new LinkedList<>();
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int day = Integer.MAX_VALUE;
    static int result = 0;

    static class Tomato {
        int r;
        int c;
        int dist;

        public Tomato(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static void dfs() {

        while (!q.isEmpty()) {
            Tomato curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    map[nr][nc] = 1;
                    q.add(new Tomato(nr, nc, curr.dist + 1));
                    dp[nr][nc] = curr.dist + 1;
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
                if (map[i][j] == 0) {
                    result = -1;
                    return;
                }
            }
        }
        result = max;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        dfs();
        System.out.println(result);
    }
}
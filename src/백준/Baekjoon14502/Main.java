package 백준.Baekjoon14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14502
 * 백준 14502
 * 문제풀이 : dfs + bfs
 */
public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    static int count = 0;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static class Point{
        int pr;
        int pc;
        public Point(int pr, int pc){
            this.pr = pr;
            this.pc = pc;
        }
    }
    static void dfs(){
        Queue<Point> q = new LinkedList<>();
        int[][] clone = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                clone[i][j] = map[i][j];
                if(clone[i][j]==2){
                    q.add(new Point(i,j));
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        while(!q.isEmpty()){
            Point curr = q.poll();
            int cr = curr.pr;
            int cc = curr.pc;


            for(int i=0; i<4; i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nr<0||nr>=N||nc<0||nc>=M)continue;
                if(visited[nr][nc])continue;
                if(clone[nr][nc]==1)continue;
                visited[nr][nc] = true;
                clone[nr][nc] = 2;
                q.add(new Point(nr, nc));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(clone[i][j]==0){
                    count++;
                }
            }
        }
        if(result<count){
            result = count;
        }
        count = 0;
    }

    static void bfs(int n) {
        if(n==3){
            dfs();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    bfs(n+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        bfs(0);
        System.out.println(result);
    }
}
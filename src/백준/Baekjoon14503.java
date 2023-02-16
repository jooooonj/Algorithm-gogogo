package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14503
 * 백준 14503
 * 문제풀이 : dfs로 문제에서 제시한 조건으로 인해 종료될때까지 반복
 */
public class Baekjoon14503 {
    static int N;
    static int M;
    static int[][] graph;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count = 0;

    static void dfs(int cr, int cc, int cd){
//        System.out.println(cr+","+cc+" (현재좌표)");
        //1.

        if(graph[cr][cc]==0){
//            System.out.println("청소 !");
            graph[cr][cc] = 2;
            count++;

//            for(int i=0; i<N; i++){
//                for(int j=0; j<M; j++){
//                    System.out.print(graph[i][j]+" ");
//                }
//                System.out.println();
//            }
        }

        //2. 왼쪽 방향으로 탐색
        int nd = cd;

        for(int i=0; i<4; i++){
            nd--;
            if(nd == -1){
                nd = 3;
            }
//            System.out.println(nd+" (왼쪽방향)");
            int nr = cr + dr[nd];
            int nc = cc + dc[nd];

//            System.out.println(nr+","+nc+" (다음좌표)");
            if(nr<0||nc<0||nr>=N||nc>=M) continue;
            if(graph[nr][nc]==1)continue;
            if(graph[nr][nc]==2)continue;
            dfs(nr,nc,nd);
        }
//        System.out.println("4방향 모두 벽또는 이미 청소완료");

        nd -= 2;
        if(nd<0){
            nd += 4;
        }

        int nr = cr+dr[nd];
        int nc = cc + dc[nd];
        if(graph[nr][nc]==1){
//            System.out.println(nr+","+nc+" (반대방향) 벽");
            System.out.println(count);
            System.exit(0);
            return;
        }
        dfs(nr, nc, cd);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int cr = Integer.parseInt(st.nextToken());
        int cc = Integer.parseInt(st.nextToken());
        int cd = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(cr, cc, cd);
    }
}
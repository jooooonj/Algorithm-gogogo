package 백준.Baekjoon16236F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16236
 * 백준 16236
 * 문제풀이 : 시뮬레이션
 * 시간 복잡도 :
 * 실패
 */
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int sr;
    static int sc;
    static int sharkSize = 2;
    static int count = 0;
    static int result =0;
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,1,-1};
    static class Shark{
        int r;
        int c;
        int d;
        public Shark(int r,int c,int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static void bfs(){


        while(true){

            int minDist = Integer.MAX_VALUE;
            Queue<Shark> q = new LinkedList<>();
//            System.out.println("상어 좌표 = " + sr+","+sc);

            q.add(new Shark(sr, sc, 0));
            visited = new boolean[N][N];
            visited[sr][sc] = true;

            Shark bestShark = new Shark(sr,sc, Integer.MAX_VALUE);

            while(!q.isEmpty()){

                Shark s = q.poll();

                //1. 거리 2. 위 3. 왼쪽 우선순위 따져서 bestShark 초기화
                if(s.d > bestShark.d){
                    continue;
                }
                if(map[s.r][s.c]!=0){
                    if(map[s.r][s.c]<sharkSize){
                        if(s.d < bestShark.d){
                            bestShark = s;
//                            eat(bestShark, s);
                            minDist = bestShark.d;
//                            System.out.println("minDist = " + minDist);
//                            print();
//                            System.out.println();

                        } else if(s.d == bestShark.d){
                            if(s.r < bestShark.r){
                                bestShark = s;
//                                eat(bestShark, s);
                                minDist = bestShark.d;
//                                System.out.println("minDist = " + minDist);
//                                print();
//                                System.out.println();


                            } else if(s.r == bestShark.r && s.c < bestShark.c){
                                    bestShark =s;
//                                    eat(bestShark, s);
                                    minDist = bestShark.d;
//                                    System.out.println("minDist = " + minDist);
//                                    print();
//                                    System.out.println();
                            }
                        } else{
                            continue;
                        }
                    }
                }
                if(count==sharkSize){
                    count=0;
                    sharkSize++;
                }
                for(int i=0; i<4; i++){
                    int nr = s.r+dr[i];
                    int nc = s.c+dc[i];
                    if(nr<0||nc<0||nr>=N||nc>=N)continue;
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc] > sharkSize) continue;
                    visited[nr][nc] = true;
                    q.add(new Shark(nr, nc, s.d + 1));

                }
            }
            if(minDist == Integer.MAX_VALUE){
                return;
            }

            sr = bestShark.r;
            sc = bestShark.c;
            map[sr][sc] = 0;
            count++;
            result+=minDist;
        }
    }

//    private static void eat(Shark bestShark, Shark s) {
//        System.out.println("먹이 좌표 "+s.r+","+s.c+"까지");
//        System.out.println("도달 거리 : " + bestShark.d);
//        System.out.println("result = " + result);
//        System.out.println("count = " + count);
//        System.out.println("sharkSize = " + sharkSize);
//        if(count==sharkSize){
//            System.out.println("상어진화");
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    sr = i;
                    sc = j;
                    map[i][j] = 0;
                }
            }
        }
        bfs();
        System.out.println(result);
    }

    private static void print() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
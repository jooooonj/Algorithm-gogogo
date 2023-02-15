package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon3190 {

    static int N;
    static int[][] graph;
    static int appleCount;
    static int L;
    static int time = 0;
    static int[] change = new int[10001];

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0, 1, 0, -1};

    static class Point{
        int r;
        int c;
        int d;
        int l;
        public Point(int r, int c, int d, int l){
            this.r = r;
            this.c = c;
            this.d = d;
            this.l = l;
        }
    }
    static void dfs(){
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0,0, 1, 1));
        graph[0][0] = 1;
        int cr = 0;
        int cc = 0;
        int nd = 1;
        int cl = 1;

        while(!q.isEmpty()){
            if(time<=10000){

                if(change[time]==1){
//                System.out.println("오른쪽");
                    nd += 1;
                }
                else if(change[time]==-1) {
//                System.out.println("왼쪽");
                    nd -= 1;
                }

                if(nd==4) {
                    nd = 0;
                }
                else if(nd==-1) {
                    nd = 3;
                }
            }

            int nr = 0;
            int nc = 0;
            nr += cr + dr[nd];
            nc += cc + dc[nd];

            if(nr<0||nc<0||nr>=N||nc>=N){
                break;
            }
            if(graph[nr][nc]==1){
                break;
            }

            boolean isApple = false;
            if(graph[nr][nc]==2){
                isApple = true;
                cl++;
            }

            Point nPoint = new Point(nr, nc, nd, cl);
            q.add(nPoint);
            graph[nr][nc] = 1;

            cr = nr;
            cc = nc;

//            System.out.println(nr+","+nc+" 이동완료");
            time++;
//            System.out.println(time+"초");

            if(!isApple){
                Point removePoint = q.poll();
                int remove_r = removePoint.r;
                int remove_c = removePoint.c;
                graph[remove_r][remove_c] = 0;
            }

//            for(int i =0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(graph[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        appleCount = Integer.parseInt(br.readLine());

        for(int i=0; i<appleCount; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a-1][b-1] = 2; //사과
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            if (str.equals("D")) {
                change[index] = 1;
            } else
                change[index] = -1; //왼쪽
        }

        dfs();
        System.out.println(time+1);
    }
}
package 백준.Baekjoon16509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int R = 10;
    static final int C = 9;

    static int[][] map = new int[R][C];
    static Queue<Point> q = new LinkedList<>();

    static int dist_r;
    static int dist_c;
    static int[] dr = {-3, -2, 2, 3, -3, -2, 2, 3};
    static int[] dc = {-2,-3,-3,-2,2,3,3,2};

    static int[] ddr = {1,-1,0,0};
    static int[] ddc = {0,0,1,-1};

    static int minCount = Integer.MAX_VALUE;
    static void dfs(){

        while(!q.isEmpty()){
            Point curr = q.poll();

            int cr = curr.r;
            int cc = curr.c;
            int cC = curr.moveCount;
            if(cC > minCount)
                continue;

            if(cr==dist_r && cc==dist_c){
                if(minCount > cC){
                    minCount = cC;
                }
            }

            for(int i=0; i<8; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0||nc<0||nr>=R||nc>=C) continue;

                int xr = nr;
                int xc = nc;
                boolean isKing = false;
                if(i<2){
                    for(int x=0; x<2; x++){
                        xr+=1;
                        xc+=1;
                        if(xr==dist_r&&xc==dist_c){
                            isKing = true;
                            break;
                        }
                    }
                } else if(i>=2 &&i<4){
                    for(int x=0; x<2; x++){
                        xr-=1;
                        xc+=1;
                        if(xr==dist_r&&xc==dist_c){
                            isKing = true;
                            break;
                        }
                    }
                } else if(i>=4 && i<6){
                    for(int x=0; x<2; x++){
                        xr+=1;
                        xc-=1;
                        if(xr==dist_r&&xc==dist_c){
                            isKing = true;
                            break;
                        }
                    }
                } else if(i>=6 && i<8){
                    for(int x=0; x<2; x++){
                        xr-=1;
                        xc-=1;
                        if(xr==dist_r&&xc==dist_c){
                            isKing = true;
                            break;
                        }
                    }
                }

                if(isKing) continue;
                q.add(new Point(nr,nc,cC+1));
            }

        }

    }
    static class Point{
        int r;
        int c;
        int moveCount;
        public Point(int r, int c, int moveCount){
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int cr = Integer.parseInt(st.nextToken());
        int cc = Integer.parseInt(st.nextToken());
        q.add(new Point(cr, cc, 0));

        st = new StringTokenizer(br.readLine());
        dist_r = Integer.parseInt(st.nextToken());
        dist_c = Integer.parseInt(st.nextToken());

        dfs();

        System.out.println(minCount);
    }
}


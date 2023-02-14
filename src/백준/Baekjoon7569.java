package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7569 {
    static int C;
    static int R;
    static int H;
    static int[][][] box;
    static int dh[] = {1,-1,0,0,0,0};
    static int dr[] = {0,0,1,-1,0,0};
    static int dc[] = {0,0,0,0,1,-1};
    static Queue<MyPoint> q = new LinkedList<>();

    static class MyPoint{
        int h;
        int r;
        int c;
        MyPoint(int h, int r, int c){
            this.h =h;
            this.r =r;
            this.c =c;
        }
    }

    static void bfs() {

        while(!q.isEmpty()) {
            MyPoint tmp = q.poll();
            int ch = tmp.h;
            int cr = tmp.r;
            int cc = tmp.c;

            for(int i=0; i<6; i++) {
                int nh = ch+dh[i];
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nh<0||nr<0||nc<0||nh>=H||nc>=C||nr>=R)continue;
                if(box[nh][nr][nc]!=0) continue;
                q.add(new MyPoint(nh,nr,nc));
                box[nh][nr][nc] = box[ch][cr][cc] +1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][R][C];

        for(int h = 0; h<H; h++) {
            for(int r=0; r<R; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<C; c++) {
                    box[h][r][c] = Integer.parseInt(st.nextToken());
                    if(box[h][r][c]==1) {
                        q.add(new MyPoint(h,r,c));
                    }
                }
            }
        }

        bfs();
        int day = Integer.MIN_VALUE;
        boolean success = true;
        for(int h = 0; h<H; h++) {
            for(int r=0; r<R; r++) {
                for(int c=0; c<C; c++) {
                    if(box[h][r][c] > day) {
                        day = box[h][r][c];
                    }
                    if(box[h][r][c]==0) {
                        success = false;
                    }
                }
            }
        }

        if(!success)
            System.out.println(-1);
        else
            System.out.println(day-1);


    }
}
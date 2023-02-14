package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20922
 * 백준 3055
 * 문제풀이 : bfs
 * 시간 복잡도 :
 */
public class Beakjoon3055_2 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int dist_r;
    static int dist_c;
    static int R;
    static int C;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Animal> q_Animal = new LinkedList<>();
    static ArrayList<Water> q_Water = new ArrayList<>();
    static int p1 = 0;
    static int p2 = 0;
    static int result = 0;
    static class Animal{
        int r;
        int c;
        int count;
        public Animal(int r, int c, int count){
            this.r = r;
            this.c = c;
            this.count =count;
        }

    }
    static class Water{
        int r;
        int c;
        public Water(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int bfs(){
        while (!q_Animal.isEmpty()) {
            Animal animal = q_Animal.poll();

            int a_cr = animal.r;
            int a_cc = animal.c;
            int count = animal.count;

            int point1 = p1;

            while(p2<point1){
                Water water = q_Water.get(p2++);
                int w_cr = water.r;
                int w_cc = water.c;
//                System.out.println("비 현재 위치" + w_cr+","+w_cc);
                for(int i=0; i<4; i++){
                    int w_nr = w_cr + dr[i];
                    int w_nc = w_cc + dc[i];
//                    System.out.println("비 다음  위치후보" + w_nr+","+w_nc);
                    if(w_nr<0||w_nc<0||w_nr>=R||w_nc>=C) continue;
                    if(map[w_nr][w_nc]>=2) continue;
//                    System.out.println("비 이동" + w_nr+","+w_nc);
                    map[w_nr][w_nc] = 2;
                    q_Water.add(new Water(w_nr, w_nc));
                    p1++;
                }
            }
            for(int i=0; i<4; i++){
                int a_nr = a_cr + dr[i];
                int a_nc = a_cc + dc[i];
                if(a_nr<0||a_nc<0||a_nr>=R||a_nc>=C) continue;
                if(a_nr==dist_r && a_nc==dist_c){
                    return count+1; //성공시
                }
                if(map[a_nr][a_nc]>=1) continue;
                map[a_nr][a_nc] = 1;
                q_Animal.add(new Animal(a_nr, a_nc, count+1));

//                System.out.println();

            }
//            print();
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                char c = str.charAt(j);
                if(c=='D'){
                    map[i][j] = 4; //비버있는곳(목적지)
                    dist_r = i;
                    dist_c = j;
                } else if(c=='*'){
                    map[i][j]=2; //물
                    q_Water.add(new Water(i,j));
                    p1++;
                } else if(c=='S'){
                    map[i][j]=1; //고슴도치(주인공)
                    q_Animal.add(new Animal(i,j,0));
                } else if(c=='X'){
                    map[i][j]=3; //돌
                }
            }
        }
//        print();

        int result = bfs();
        if(result==0)
            System.out.println("KAKTUS");
        else{
            System.out.println(result);
        }
    }

//    private static void print() {
//        for(int i=0; i<R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
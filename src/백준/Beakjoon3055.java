package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20922
 * 백준 3055
 * 문제풀이 : bfs (물부터 움직이며 카운트 체크해놓은 이후, 고슴도치를 움직여서 해당 위치에 물보다 수가 낮으면 이동 가능)
 * 시간 복잡도 :
 */
public class Beakjoon3055 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int R;
    static int C;
    static int[][] map;
    static Queue<Point> q_Animal = new LinkedList<>();
    static Queue<Point> q_Water = new LinkedList<>();

    static class Point {
        int r;
        int c;
        int count;

        public Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    static int bfs() {
        int[][] clone = new int[R][C];
        while (!q_Water.isEmpty()) {
            Point water = q_Water.poll();
            int cr = water.r;
            int cc = water.c;
            int count = water.count;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (clone[nr][nc] > 0) continue;
                if (map[nr][nc] >= 2) continue;
                clone[nr][nc] = count + 1;
                q_Water.add(new Point(nr, nc, count + 1));
            }
        }
        while (!q_Animal.isEmpty()) {
            Point animal = q_Animal.poll();
            int cr = animal.r;
            int cc = animal.c;
            int count = animal.count;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (map[nr][nc] == 4) {
                    return count + 1;
                }
                if (map[nr][nc] > 0) continue;
                if (count + 1 >= clone[nr][nc]) continue;
                q_Animal.add(new Point(nr, nc, count + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (c == 'D') {
                    map[i][j] = 4; //비버있는곳(목적지)
                } else if (c == '*') {
                    map[i][j] = 2; //물
                    q_Water.add(new Point(i, j, 0));
                } else if (c == 'S') {
                    map[i][j] = 1; //고슴도치(주인공)
                    q_Animal.add(new Point(i, j, 0));
                } else if (c == 'X') {
                    map[i][j] = 3; //돌
                }
            }
        }
        int result = bfs();
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }
}
package 백준.Baekjoon4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int R;
    static int C;
    static char map[][];
    static boolean[][] visited1;
    static boolean[][] visited2;
    static Queue<Point> jjj = new LinkedList();
    static Queue<Point> fire = new LinkedList();

    static class Point {
        int r;
        int c;
        int count;

        Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    static int bfs() {

        while (!jjj.isEmpty() || !fire.isEmpty()) {
            Point jh = jjj.poll();


            Point fi = fire.poll();

            //불부터 시작
            for (int i = 0; i < 4; i++) {
                int nr = fi.r + dr[i];
                int nc = fi.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (visited2[nr][nc]) continue;
                if (map[nr][nc] == '#') continue;
                visited2[nr][nc] = true;
                map[nr][nc] = 'F';
                fire.add(new Point(nr, nc, 0));
            }


            for (int i = 0; i < 4; i++) {
                int nr = jh.r + dr[i];
                int nc = jh.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    return jh.count;
                }
                if (visited1[nr][nc]) continue;
                if (map[nr][nc] == '#') continue;
                if (map[nr][nc] == 'F') continue;
                visited1[nr][nc] = true;
                jjj.add(new Point(nr, nc, jh.count + 1));
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

        map = new char[R][C];
        visited1 = new boolean[R][C];
        visited2 = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') {
                    jjj.add(new Point(i, j, 1));
                    visited1[i][j] = true;
                }
                if (map[i][j] == 'F') {
                    fire.add(new Point(i, j, 1));
                    visited2[i][j] = true;
                }
            }
        }

        int result = bfs();
        if (result > -1)
            System.out.println(result);
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
}


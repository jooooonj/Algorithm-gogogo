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
    static int[][] arr;
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

            while(!fire.isEmpty()) {

                Point f = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = f.r + dr[i];
                    int nc = f.c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if (map[nr][nc] != '#') {
                        if (!visited2[nr][nc]) {
                            visited2[nr][nc] = true;
                            arr[nr][nc] = f.count + 1;
                            fire.add(new Point(nr, nc, f.count + 1));
                        }
                    }
                }
            }

            while(!jjj.isEmpty()) {

                Point jh = jjj.poll();
                if (jh.r == 0 || jh.r == R - 1 || jh.c == 0 || jh.c == C - 1) {
                    return jh.count;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = jh.r + dr[i];
                    int nc = jh.c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if (map[nr][nc] == '.') {
                        if (!visited1[nr][nc]) {
                            if(arr[nr][nc] > jh.count + 1 || arr[nr][nc] == 0){
                                visited1[nr][nc] = true;
                                map[nr][nc] = 'J';
                                jjj.add(new Point(nr, nc, jh.count + 1));

                            }
                        }
                    }

                }
            }
        }

        return-1;
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
        arr = new int[R][C];

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
                    arr[i][j] = 1;
                    visited2[i][j] = true;
                }
            }
        }


        int result = bfs();
        if (result == -1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(result);

    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}


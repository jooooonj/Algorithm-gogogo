package 백준.Baekjoon16236S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16236
 * 백준 16236
 * 문제풀이 : 백트래킹
 * 시간 복잡도 :
 * 성공
 */
public class Main {
    static int M;
    static int N;
    static List<Point> hList = new ArrayList<>();
    static List<Point> cList = new ArrayList<>();
    static List<Point> mList = new ArrayList<>();
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static boolean[] visited;
    static int[] houseNote;
    static int result = Integer.MAX_VALUE;
    static int calDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void bfs(int count, int index){
        if(count==M){
            houseNote = new int[hList.size()];
            Arrays.fill(houseNote, Integer.MAX_VALUE);
            int sum = 0;

            for(int i=0; i<hList.size(); i++){
                Point hPoint = hList.get(i);
                int hr = hPoint.r;
                int hc = hPoint.c;
                for(int j=0; j<mList.size(); j++){
                    Point curr = mList.get(j);
                    int dist = calDist(curr.r, curr.c, hr, hc);
                    if(houseNote[i]>dist){
                        houseNote[i] = dist;
                    }
                }
            }

            for(int d : houseNote){
                sum += d;
            }

            if(sum<result){
                result = sum;
            }

            return;
        }


        for(int i=index; i<cList.size(); i++){
            if(!visited[i]){
                mList.add(cList.get(i));

                bfs(count+1, i+1);

                mList.remove(cList.get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    hList.add(new Point(i,j));
                } else if(x==2){
                    cList.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[cList.size()];
        bfs(0,0);
        System.out.println(result);
    }
}
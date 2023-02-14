package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20922
 * 백준 20922
 * 문제풀이 : 투 포인트 - 몇 개 나왔는지 배열 인덱스를 이용해서 기록한 후 K개 이하라면 p1이 전진 K 이상이라면 p2가 전진
 * 시간 복잡도 : o(N)
 */
public class Baekjoon20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>max)
                max = arr[i];
        }
        //기록용
        int[] note = new int[max + 1];
        //포인터
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int result = 0;
        while(true){
            int point1 = arr[p1];
            if(note[point1]<k){
                note[point1]++;
                count++;
                p1++;
            } else{
                int point2 = arr[p2];
                note[point2]--;
                count--;
                p2++;
            }
            if(result<count)
                result = count;
            if(p1>=N || p2>p1)
                break;
        }
        System.out.println(result);
    }
}
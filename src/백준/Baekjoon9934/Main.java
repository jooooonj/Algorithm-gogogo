package 백준.Baekjoon9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static String[] result;
    static int[] arr;
    static void root(int s, int e, int floor){
        if(floor==k)
            return;

        int m = (s+e)/2;
        result[floor] += Integer.toString(arr[m])+" ";
//        System.out.print(" m = " + m);
//        System.out.print(" floor = " + floor);
//        System.out.println(" result["+floor+"] = " + result[floor]);

        root(s, m-1, floor+1);
        root(m+1, e, floor+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        result = new String[k];
        int n = (int) Math.pow(2, k);
        arr = new int[n-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<result.length; i++){
            result[i]="";
        }
        root(0,arr.length,0);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
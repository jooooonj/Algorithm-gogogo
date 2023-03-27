package 백준.Baekjoon16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;

        while(A < B){
            count++;
            if(B%10 == 1)
                B /= 10 ;
            else if(B%2==0){
                B /= 2;
            } else{
                B = 0;
            }

        }

        if(B < A){
            count = -2;
        }
        System.out.println(count + 1);
    }
}


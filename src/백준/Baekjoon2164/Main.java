package 백준.Baekjoon2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            q.add(i + 1);
        }

        while(q.size()>1){
            q.poll();
            q.add(q.poll());
        }

        int result = q.poll();

        System.out.println(result);
    }
}

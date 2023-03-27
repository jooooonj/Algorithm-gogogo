package 백준.Baekjoon9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            String result = "NO";
            String str = br.readLine();
            q.clear();

            for(int j=0; j<str.length(); j++){
                char ch = str.charAt(j);
                if(q.isEmpty()){
                    if(ch == ')'){
                        q.add(' ');
                        break;
                    }
                    q.add(ch);
                } else {
                    if(q.peek() != ch){
                        q.poll();
                    } else {
                        q.add(ch);
                    }
                }
            }

            if(q.isEmpty())
                result = "YES";
            else
                result = "NO";

            System.out.println(result);
        }
    }
}



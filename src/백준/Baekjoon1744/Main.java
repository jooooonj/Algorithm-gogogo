package 백준.Baekjoon1744;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    static int result = Integer.MIN_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();
        int oneCount = 0;
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==1){
                oneCount++;
            } else if(x>1){
                plusList.add(x);
            } else if(x<1){
                minusList.add(x);
            }
        }

        sum += oneCount;

        Collections.sort(plusList, Collections.reverseOrder());
        Collections.sort(minusList);

//        for(int i=0; i< minusList.size(); i++){
//            System.out.print(minusList.get(i)+" ");
//        }
//        System.out.println();
//        for(int i=0; i< plusList.size(); i++){
//            System.out.print(plusList.get(i)+" ");
//        }
//        System.out.println();

//        System.out.println("음수==========================");
        for(int i=0; i<minusList.size(); i+=2){
//            System.out.println("i : " + i);
            if(i==minusList.size()-1){
                sum += minusList.get(i);
            } else{
                sum += (minusList.get(i) * minusList.get(i + 1));
            }
//            System.out.println("sum : " + sum);
        }

//        System.out.println("양수==========================");


        for(int i=0; i<plusList.size(); i+=2){
//            System.out.println("i : " + i);
            if(i== plusList.size()-1){
                sum += plusList.get(i);
            } else{
                sum += (plusList.get(i) * plusList.get(i+1));
            }
//            System.out.println("sum : " + sum);

        }

        System.out.println(sum);
    }
}

package 백준.Baekjoon1339;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon1339 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] count = {0,1,10,100,1000,10000,100000,1000000,10000000};
        HashMap<Character, String> map = new HashMap<>();
        String[] strArr;
        int N = Integer.parseInt(br.readLine());
        strArr = new String[N];
        Integer[] alpha = new Integer[26];
        Arrays.fill(alpha, 0);
        String[] numArr = new String[N];
        int s = 9;
        for(int i=0; i<N; i++){
            strArr[i] = br.readLine();
            int size = strArr[i].length();
            int p = size;
            for(int j=0; j<size; j++){
                int index = strArr[i].charAt(j)-'A';
                alpha[index] += count[p];
                p--;
            }
        }

        Arrays.sort(alpha, Collections.reverseOrder());
        int sum = 0;
        int point = 9;
        for(int i=0; i<alpha.length; i++){
            if(alpha[i]<=0)
                break;
            sum += alpha[i]*point;
            point--;
        }

        System.out.println(sum);






//        Arrays.sort(strArr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
//
////        System.out.println(Arrays.toString(strArr));
//        int sum = 0;
//
////        System.out.println(numArr[0] + "9");
//        int size = strArr[0].length();
//        int p = size;
//        for(int i=0; i<size; i++){
////            System.out.println("i가 " + i+"일 때");
//            for(int j=0; j<N; j++){
////                System.out.println("j가 "+j+"일 때");
////                System.out.println(strArr[j].length()+" >= " + p +" ?");
//                if(strArr[j].length()<p) continue;
//                int cal = size - strArr[j].length();
//                char ch = ' ';
//                if(strArr[j].length()==size){
//                    ch = strArr[j].charAt(i);
//                } else{
////                    System.out.println("J ?" +j);
////                    System.out.println(i);
//                    ch = strArr[j].charAt(i-cal);
//                }
////                System.out.println(ch);
//
//                if(map.containsKey(ch)){
//                    numArr[j] += map.get(ch);
////                    System.out.println("map에 있네 ?");
////                    System.out.println(numArr[j]);
//                } else{
////                    System.out.println("map에 없네");
//                    map.put(ch, Integer.toString(s));
//                    numArr[j] += Integer.toString(s--);
////                    System.out.println(numArr[j]);
//                }
//            }
//            p--;
//        }
//
//        for(int i=0; i<N; i++){
//            sum += Integer.parseInt(numArr[i]);
//        }
//        System.out.println(sum);
    }
}

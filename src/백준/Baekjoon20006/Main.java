package 백준.Baekjoon20006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken()); //플레이어의 수
        M = Integer.parseInt(st.nextToken()); // 방의 정원

        ArrayList<Room> roomList = new ArrayList<>();

        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String id = st.nextToken();

            Player player = new Player(l, id);

            boolean enter = false;
            for(Room r : roomList){
                if(r.host.lv-10 <= l && r.host.lv+10 >= l && !r.isStart){
                    r.addPlayer(player);
                    enter = true;
                    break;
                }
            }

            if(!enter){
                Room room = new Room(player, M);
                roomList.add(room);
            }
        }

        for (Room r : roomList) {
            if(!r.isStart){
                r.systemOut("Waiting!");
            } else{
                r.systemOut("Started!");
            }

        }
    }
}

class Player implements Comparable<Player>{
    int lv;
    String id;

    public Player(int lv, String id) {
        this.lv = lv;
        this.id = id;
    }

    @Override
    public int compareTo(Player o) {
        return this.id.compareTo(o.id);
    }
}
class Room{
    boolean isStart = false;
    int M;
    Player host; //만든사람
    int n; //인원수
    ArrayList<Player> playerList = new ArrayList<>();

    public Room(Player host, int M){
        this.host = host;
        this.M = M; //최대인원수 설정
        addPlayer(host);
    }
    public void addPlayer(Player player){
        playerList.add(player);
        n++;
        if(n==M){
            isStart = true;
        }
    }

    public void systemOut(String cmd){
        System.out.println(cmd);
        Collections.sort(playerList);
        for(Player p : playerList){
            System.out.println(p.lv+" "+p.id);
        }
    }
}

import java.io.*;
import java.util.*;

class Egg {
    int durability;
    int weight;

    public Egg(int d, int w) {
        this.durability = d;
        this.weight = w;
    }

    public boolean isBroken() {
        return this.durability <= 0;
    }
}

public class Main {
    static int n, answer = 0;
    static Egg[] eggs;

    private static void backTrack(int idx) {
        if(idx == n) {
            int broken = 0;
            for(Egg e : eggs) {
                if(e.isBroken()) broken++;
            }
            answer = Math.max(answer, broken);
            return;
        }

        if(eggs[idx].isBroken()) {
            backTrack(idx+1);
            return;
        }

        boolean hasHit = false;

        for(int i=0; i<n; i++) {
            if(i == idx || eggs[i].isBroken()) continue;

            hasHit = true;

            eggs[idx].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[idx].weight;

            backTrack(idx + 1);

            eggs[idx].durability += eggs[i].weight;
            eggs[i].durability += eggs[idx].weight;
        }

        if(!hasHit) backTrack(idx+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(d, w);
        }

        backTrack(0);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

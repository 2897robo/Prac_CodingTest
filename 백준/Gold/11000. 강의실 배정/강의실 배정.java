import java.util.*;
import java.io.*;

class Meeting {
    private int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        List<Meeting> list = new ArrayList<> ();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        int count = 0;
        Collections.sort(list, (m1, m2) -> {
            return m1.getStart() - m2.getStart();
        });

        Queue<Integer> pq = new PriorityQueue<> ();
        pq.add(list.get(0).getEnd());

        for(int i=1; i<n; i++) {
            Meeting m = list.get(i);
            if(pq.peek() <= m.getStart()) {
                pq.poll();
            }
            pq.add(m.getEnd());
        }

        System.out.println(pq.size());
    }
}

import java.util.*;
import java.io.*;

class Meeting {
    private int start;
    private int end;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        List<Meeting> list = new ArrayList<> ();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        Collections.sort(list, (m1, m2) -> {
            if(m1.getEnd() == m2.getEnd()) {
                return m1.getStart() - m2.getStart();
            }
            return m1.getEnd() - m2.getEnd();
        });

        int count = 0;
        int endTime = 0;
        for(Meeting m : list) {
            if(m.getStart() >= endTime) {
                endTime = m.getEnd();
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close(); bw.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        LinkedList<Character> ll = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            ll.add(c);
        }

        ListIterator<Character> it = ll.listIterator(ll.size()); // 커서를 문자열 끝으로 이동

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            switch (cmd) {
                case "L": // 커서를 왼쪽으로 이동
                    if (it.hasPrevious()) it.previous();
                    break;
                case "D": // 커서를 오른쪽으로 이동
                    if (it.hasNext()) it.next();
                    break;
                case "B": // 커서 앞의 문자 삭제
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case "P": // 커서 위치에 문자 추가
                    it.add(st.nextToken().charAt(0));
                    break;
            }
        }

        for (char c : ll) {
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] tmp = new int[n];
        Map<Integer, Integer> rankMap = new HashMap<> ();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {
            tmp[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tmp);

        int rank = 0;
        for(int i=0; i<n; i++) {
            if(!rankMap.containsKey(tmp[i])) {
                rankMap.put(tmp[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(rankMap.get(arr[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
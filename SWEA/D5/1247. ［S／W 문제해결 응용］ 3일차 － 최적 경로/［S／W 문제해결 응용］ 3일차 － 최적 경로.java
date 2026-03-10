// SWEA 1247 최적 경로

import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int minDistance;
    static Point company, home;
    static Point[] customers;
    static boolean[] visited;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            customers = new Point[N];
            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < N; i++) {
                customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            findPath(0, company, 0);
            System.out.println("#" + t + " " + minDistance);
        }
    }

    static void findPath(int count, Point current, int sumDist) {
        if (sumDist >= minDistance) return;

        if (count == N) {
            int finalDist = sumDist + getDist(current, home);
            minDistance = Math.min(minDistance, finalDist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findPath(count + 1, customers[i], sumDist + getDist(current, customers[i]));
                visited[i] = false;
            }
        }
    }

    static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
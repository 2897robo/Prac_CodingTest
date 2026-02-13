// SWEA - 1861 정사각형 방

import java.util.*;
import java.io.*;

public class Solution {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxCount = 0;
			int startRoomNum = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int count = move(i, j);
					
					if(count > maxCount) {
						maxCount = count;
						startRoomNum = arr[i][j];
					} else if(count == maxCount) {
						if(startRoomNum > arr[i][j]) startRoomNum = arr[i][j];
					}
				}
			}
			
			sb.append(startRoomNum).append(" ").append(maxCount).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int move(int i, int j) {
		int cnt=1;
		int curI = i;
		int curJ = j;
		
		while(true) {
			boolean moved = false;
			
			for(int d=0; d<4; d++) {
				int ni = curI + dy[d];
				int nj = curJ + dx[d];
				
				if(nj >= 0 && nj<N && ni>=0 && ni<N) {
					if(arr[ni][nj] == arr[curI][curJ] + 1) {
						curI = ni;
						curJ = nj;
						cnt++;
						moved = true;
						break;
					}
				}
			}
			
			if(!moved) break;
		}
		
		return cnt;
	}

}

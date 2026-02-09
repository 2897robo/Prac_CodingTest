import java.io.*;
import java.util.*;

// SWEA #4130 - 자석 문제
// 4개의 자석이 있고, 각 자석은 8개의 칸으로 이루어짐
// 회전 명령에 따라 자석이 회전하고, 인접한 자석과의 상호작용을 처리
public class Solution {
	static int[][] magnets;      // 4개 행, 각 자석마다 8개 칸
	static int[][] rotate;       // 회전 명령: [회전할 자석 번호, 회전 방향]
	static boolean[] visited;    // 회전 처리 중 이미 방문한 자석 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {

			int K = Integer.parseInt(br.readLine());  // 회전할 자석의 개수 (명령의 수)
			magnets = new int[4][8];   // 4개의 자석, 각각 8칸
			rotate = new int[K][2];    // K개의 회전 명령 저장
			
			// 4개의 자석 정보 입력받기 (각 자석마다 8개의 숫자)
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = (byte) Integer.parseInt(st.nextToken());
				}
			}
			
			// K개의 회전 명령 입력받기 (자석 번호, 회전 방향)
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rotate[i][0] = Integer.parseInt(st.nextToken())-1;  // 자석 번호 (1번부터 시작하므로 -1)
				rotate[i][1] = Integer.parseInt(st.nextToken());    // 회전 방향 (1: 시계방향, -1: 반시계방향)
			}

			// 각 회전 명령을 순서대로 처리
			for (int i = 0; i < K; i++) {
				visited = new boolean[4];  // 각 명령마다 방문 여부 초기화
				rotateMagnets(rotate[i][0], rotate[i][1]);  // 자석 회전 (인접 자석도 영향)
			}
			
			// 점수 계산: 각 자석의 첫 번째 위치(0번 인덱스)의 값에 가중치 부여
			// 자석0: 1점, 자석1: 2점, 자석2: 4점, 자석3: 8점
			System.out.println("#" + tc + " " + (magnets[0][0] + magnets[1][0]*2 + magnets[2][0]*4 + magnets[3][0]*8));
		}
	}

	private static void rotateMagnets(int magnetNum, int dir) {
		// 이미 처리한 자석이면 더이상 진행하지 않음 (무한 재귀 방지)
		if (visited[magnetNum])
			return;
		visited[magnetNum] = true;  // 현재 자석을 방문 처리

		// 왼쪽 자석과 현재 자석의 상호작용 확인
		// 왼쪽 자석의 오른쪽 끝(인덱스 2)과 현재 자석의 왼쪽 끝(인덱스 6)이 다르면
		// 왼쪽 자석도 반대 방향으로 회전
		if (magnetNum - 1 >= 0 && magnets[magnetNum][6] != magnets[magnetNum - 1][2]) {
			rotateMagnets(magnetNum - 1, dir*-1);
		}
		
		// 오른쪽 자석과 현재 자석의 상호작용 확인
		// 현재 자석의 오른쪽 끝(인덱스 2)과 오른쪽 자석의 왼쪽 끝(인덱스 6)이 다르면
		// 오른쪽 자석도 반대 방향으로 회전
		if (magnetNum + 1 < 4 && magnets[magnetNum][2] != magnets[magnetNum + 1][6]) {
			rotateMagnets(magnetNum + 1, dir*-1);
		}
		
		// 현재 자석 회전 처리
		// 배열을 시계방향(+dir) 또는 반시계방향(-dir)으로 회전
		int[] temp = new int[8];
		for (int i = 0; i < 8; i++) {
			// (i - dir + 8) % 8: 회전 방향에 따라 새로운 인덱스 계산
			temp[i] = magnets[magnetNum][(i - dir + 8) % 8];
		}
		magnets[magnetNum] = temp;  // 회전된 배열로 업데이트
	}

}

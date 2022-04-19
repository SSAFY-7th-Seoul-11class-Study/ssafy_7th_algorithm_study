package 분할정복;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_G4_1493_박스채우기 {
	static int length, width, height;		// 박스 크기
	static int n;							// 큐브 종류 개수
	static int[] cubes;						// 큐브 종류 별 보유 개수
	static int minCount;					// 필요한 큐브 최소 개수
	static boolean flag;					// 박스를 채우지 못하는 경우

	/* 크기 l x w x h 영역을 채움 */
	static void solution(int l, int w, int h) {
		if (l == 0 || w == 0 || h == 0)
			return;

		flag = false;
		int cubeLen = 0;

		// 채울 수 있는 가장 큰 큐브 찾음
		for (int i = 19; i >= 0; i--) {
			if (cubes[i] == 0)			// 큐브 개수 == 0 (큐브가 없는 경우)
				continue;

			cubeLen = 1 << i;			// 큐브 한변의 길이: 2^i
			if (l >= cubeLen && w >= cubeLen && h >= cubeLen) {
				cubes[i]--;				// 영역을 채움
				minCount++;
				flag = true;
				break;
			}
		}

		if (!flag)			// 채울 수 있는 큐브가 없으면, -1
			return;

		// 남은 영역들에 대해 분할 정복
		solution(cubeLen, w - cubeLen, cubeLen);
		solution(l - cubeLen, w, cubeLen);
		solution(l, w, h - cubeLen);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());

		length = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(br.readLine());
		cubes = new int[20];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			cubes[idx] = count;
		}

		solution(length, width, height);

		if (flag)
			System.out.println(minCount);
		else
			System.out.println(-1);
	}
}
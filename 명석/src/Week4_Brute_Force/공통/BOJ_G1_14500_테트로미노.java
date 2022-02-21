/*
BOJ G1 14500 테트로미노
1. DFS인건 생각해냄
2. ㅗ 모양 생각해내기가 좀 골아팠음
3. 시간 초과
-> call by value => call by refernce로 변경
why? visited 배열을 반복 돌릴때마다 생성해준게 잘못됨.
*/package Week4_Brute_Force.공통;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G1_14500_테트로미노 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DFS(i, j, 0, 0);
                cross(i, j);
            }
        }
        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }

    static void DFS(int x, int y, int count, int sum) {
        if (count == 4) {
            max = max > sum ? max : sum;
            return;

        }
        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= M) {
                continue;
            }
            if (visited[moveX][moveY]) {
                continue;
            }
            visited[moveX][moveY] = true;
            DFS(moveX, moveY, count + 1, sum + arr[moveX][moveY]);
            visited[moveX][moveY] = false;
        }
    }

    // ㅗ 모양
    static void cross(int x, int y) {
        int temp[] = new int[5];
        temp[4] = arr[x][y];
        int min = Integer.MAX_VALUE;
        int count = 0;
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= M)
                continue;
            temp[i] = arr[moveX][moveY];
            count++;
        }
        if (count == 4) {
            for (int i = 0; i < 4; i++) {
                sum += temp[i];
                min = min < temp[i] ? min : temp[i];
            }
            sum = sum + temp[4] - min;
            max = max > sum ? max : sum;
        } else if (count == 3) {
            for (int i = 0; i < 5; i++) {
                sum += temp[i];
            }
            max = max > sum ? max : sum;
        } else return;
    }
}
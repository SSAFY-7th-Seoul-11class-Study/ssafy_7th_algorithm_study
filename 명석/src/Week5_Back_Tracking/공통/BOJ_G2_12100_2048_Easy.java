package Week5_Back_Tracking.공통;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G2_12100_2048_Easy {
    static int N;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }

    static void dfs(int count) {
        if (count == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = max > arr[i][j] ? max : arr[i][j];
                }
            }
            return;
        }
        int[][] temp = new int[N][N];
        copy(temp,arr);
        for (int i = 1; i <= 4; i++) {
            move(i);
            dfs(count + 1);
            copy(arr, temp);
        }
    }

    static void copy(int[][] temp, int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }
    }

    static void move(int mv) {
        Queue<Integer> queue = new LinkedList<>();
        switch (mv) {
            //상
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[j][i] != 0)
                            queue.add(arr[j][i]);
                        arr[j][i] = 0;
                    }
                    int k = 0;
                    int value = 0;
                    while (!queue.isEmpty()) {
                        value = queue.poll();
                        if (arr[k][i] == value) {
                            arr[k++][i] = value * 2;
                        } else if (arr[k][i] == 0) {
                            arr[k][i] = value;
                        } else {
                            arr[++k][i] = value;
                        }
                    }
                }
                break;
            //하
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        if (arr[j][i] != 0)
                            queue.add(arr[j][i]);
                        arr[j][i] = 0;
                    }
                    int k = N - 1;
                    int value = 0;
                    while (!queue.isEmpty()) {
                        value = queue.poll();
                        if (arr[k][i] == value) {
                            arr[k--][i] = value * 2;
                        } else if (arr[k][i] == 0) {
                            arr[k][i] = value;
                        } else {
                            arr[--k][i] = value;
                        }
                    }
                }
                break;
            // 우
            case 3:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        if (arr[i][j] != 0)
                            queue.add(arr[i][j]);
                        arr[i][j] = 0;
                    }
                    int k = N - 1;
                    int value = 0;
                    while (!queue.isEmpty()) {
                        value = queue.poll();
                        if (arr[i][k] == value) {
                            arr[i][k--] = value * 2;
                        } else if (arr[i][k] == 0) {
                            arr[i][k] = value;
                        } else {
                            arr[i][--k] = value;
                        }
                    }
                }
                break;
            // 좌
            case 4:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] != 0)
                            queue.add(arr[i][j]);
                        arr[i][j] = 0;
                    }
                    int k = 0;
                    int value = 0;
                    while (!queue.isEmpty()) {
                        value = queue.poll();
                        if (arr[i][k] == value) {
                            arr[i][k++] = value * 2;
                        } else if (arr[i][k] == 0) {
                            arr[i][k] = value;
                        } else {
                            arr[i][++k] = value;
                        }
                    }
                }
                break;
        }
//        print(arr);
    }

    static void print(int[][] map) {
        for (int ns[] : map) {
            for (int n : ns) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
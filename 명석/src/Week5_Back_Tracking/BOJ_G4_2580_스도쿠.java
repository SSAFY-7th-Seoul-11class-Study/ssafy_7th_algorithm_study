package Week5_Back_Tracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_2580_스도쿠 {
    static int[][] arr;
    static ArrayList<int[]> chk;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        chk = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0)
                    chk.add(new int[]{i, j});
            }
        }
        calc(0);

        bw.close();
        br.close();
    }

    static void calc(int count) throws IOException {
        if (count == chk.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    bw.write(arr[i][j] + " ");
                bw.newLine();
            }
            bw.flush();
            System.exit(0);
        }
        for (int i = 1; i <= 9; i++) {
            int x = chk.get(count)[0];
            int y = chk.get(count)[1];
            if (check(x, y, i)) {
                arr[x][y] = i;
                calc(count + 1);
                arr[x][y] = 0;
            }
        }

    }

    static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++)
            if (arr[x][i] == num) return false;
        for (int i = 0; i < 9; i++)
            if (arr[i][y] == num) return false;
        int row = (x / 3) * 3;
        int cal = (y / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = cal; j < cal + 3; j++) {
                if (arr[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}

/*
BOJ 9934 완전 이진 트리
중위 순회 -> 배열에 넣고 각 레벨 별 노드 출력하기
완전 이진 트리이므로 각 레벨 단위로 쪼개 지면서 중간이 해당 레벨이 됨.
* */
package Week2_Tree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9934 {

    static StringBuilder[] sbs;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        int range = (int) Math.pow(2, K) - 1;
        arr = new int[range];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < range; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sbs = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            sbs[i] = new StringBuilder();
        }
        inOrderCheck(0, range - 1, 0);
        for (StringBuilder sb : sbs)
            bw.write(sb.append("\n").toString());

        br.close();
        bw.close();
    }

    static void inOrderCheck(int pre, int post, int level) {
        if (level == K) return;
        int mid = (pre + post) / 2;
        sbs[level].append(arr[mid] + " ");
        inOrderCheck(pre, mid - 1, level + 1);
        inOrderCheck(mid + 1, post, level + 1);
//        inOrderCheck(pre, (mid - 1) / 2, mid - 1, level + 1);
//        inOrderCheck(mid + 1, (mid + post + 1) / 2, post, level + 1);
//        System.out.println(level + " : " + arr[mid] + " /  " + pre + " " + mid + " " + post);

    }
}

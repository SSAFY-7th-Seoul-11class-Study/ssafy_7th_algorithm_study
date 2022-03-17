package Week6_Sort.공통;

import java.io.*;

public class BOJ_S5_10989_수_정렬하기_3 {
    static int N;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[100001];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            arr[Integer.parseInt(br.readLine())]++;
        countingSort();
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
    static void countingSort(){
        for(int i = 0 ; i< arr.length; i++){
            if(arr[i] >0){
                for(int j = 0 ; j<arr[i];j++)
                    sb.append(i).append("\n");
            }
        }

    }

    static void bubbleSort() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

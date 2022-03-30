package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_S4_10825번_국영수 {
	static int N;

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N=Integer.parseInt(br.readLine());
        
        Student[] students =new Student[N];
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	students[i]=new Student(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        	
        	
        }
        Comparator<Student> myComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.korean < o2.korean) {
                    return 1;
                }else if(o1.korean == o2.korean) {
                    if(o1.english > o2.english) {
                        return 1;
                    }else if(o1.english == o2.english) {
                        if(o1.math < o2.math) {
                            return 1;
                        }else if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1;
			}
        	
        
	};
	
	Arrays.sort(students, myComparator);
    for (int i = 0; i < N; i++) {
        bw.write(students[i].name + "\n");
    }


    bw.flush();
    bw.close();
	}

}

class Student {
	String name;
	int korean;
	int english;
	int math;

	Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}
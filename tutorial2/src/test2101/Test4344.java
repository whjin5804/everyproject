/*
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
예제
3
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
>>
40.000%
57.143%
33.333%
 */
package test2101;

import java.util.Scanner; 

public class Test4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stuNum;
		double avg[] = null;
		int over;
		int[] sumHop;
		
		System.out.println("테스트 케이스 수를 입력하시오");
		int testCase = sc.nextInt();					//테스트 케이스 수
		sumHop = new int[testCase];
		avg = new double[testCase];
		for (int i = 0; i < testCase; i++) {
			over = 0;
			int sum = 0;
			stuNum = sc.nextInt();				//학생수
			int[] score = new int[stuNum];		
			for (int j = 0; j < stuNum; j++) {
				score[j] = sc.nextInt();			//점수받기
				sum += score[j];
			}
			sumHop[i] = sum / stuNum;			//점수의 평균 30
			for (int k = 0; k < stuNum; k++) {
				if(score[k] > sumHop[i]) {		//평균보다 점수가 높다면
					over++;
				}
			}
			avg[i] = (double) over / (double) stuNum * 100;		//비율로 받기
		}
		
		for (int i = 0; i < testCase; i++) {
			System.out.println(String.format("%.3f", avg[i]) + "%");
		}
		
	
		
	}
}

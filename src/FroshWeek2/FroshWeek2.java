package FroshWeek2;

import java.util.Scanner;

public class FroshWeek2 {
	static int min = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfStudent = sc.nextInt();
		int[] students = new int[noOfStudent];
		for(int i=0;i<noOfStudent;i++){
			students[i] = sc.nextInt();
		}
		sort(students, noOfStudent);
		System.out.println(min);
		sc.close();
	}
	
	static void sort(int[] students, int noOfStudent){
		boolean done = false;
		int mid = noOfStudent/2;
		int[] tilesOutOfPlace = new int[noOfStudent];
		int largest = 0;
		for(int i=0;i<noOfStudent;i++){
			tilesOutOfPlace[i] = students[i] - i - 1;
			if(Math.abs(tilesOutOfPlace[i]) > Math.abs(tilesOutOfPlace[largest])){
				largest = i;
			}
			if(i == noOfStudent-1){
				if(tilesOutOfPlace[largest] < 0){
					int temp = 0;
					temp = students[largest];
					students[largest] = students[largest-1];
					students[largest-1] = temp;
					min++;
				}
				else if(tilesOutOfPlace[largest] > 0){
					int temp = 0;
					temp = students[largest];
					students[largest] = students[largest+1];
					students[largest+1] = temp;
					min++;
				}
				else{
					done = true;
					break;
				}
			}
		}
		if(!done){
			sort(students, noOfStudent);
		}
	}
}


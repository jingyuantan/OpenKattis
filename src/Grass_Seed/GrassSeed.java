package Grass_Seed;

import java.util.Scanner;

public class GrassSeed {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		double cost = sc.nextDouble();
		int num = sc.nextInt();
		double total = 0;
		
		for(int i=1;i<=num;i++){
			double width = sc.nextDouble();
			double length = sc.nextDouble();
			
			double product =  width * length;
			total += product;
		}
		
		System.out.println(total*cost);
		sc.close();
	}
	
}

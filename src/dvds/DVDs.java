package dvds;

import java.util.Scanner;

public class DVDs {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int time = sc.nextInt();
		try{
			for(int i=0;i<time;i++){
				int num = sc.nextInt();
				
				String line = sc1.nextLine();
				
				String[] data = line.split(" ");
				int[] dvd = new int[data.length];
				
				for(int j=0;j<data.length;j++){
					dvd[j] = Integer.parseInt(data[j]);
				}
				
				int sort = 1;
				for(int j=0;j<data.length;j++){
					if(dvd[j] == sort){
						sort++;
					}
				}
				int res = num - sort + 1;
				System.out.println(res);
			}
		}catch(Exception e){
			
		}
		sc.close();
		sc1.close();
	}

}

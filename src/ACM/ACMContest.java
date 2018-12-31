package ACM;

import java.util.ArrayList;
import java.util.Scanner;

public class ACMContest {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = 0;
		ArrayList<Question> all = new ArrayList<Question>();
		
		while(time != -1){
			time = sc.nextInt();
			if(time == -1){
				break;
			}
			String question = sc.next();
			String status = sc.next();
			boolean found = false;
			for(int i=0;i<all.size();i++){
				if(all.get(i).getQ().equalsIgnoreCase(question)){
					found = true;
					all.get(i).setStatus(status);
					if(status.equalsIgnoreCase("wrong")){
						all.get(i).setTotalTime(20);
					}
					else{
						all.get(i).setTotalTime(time);
					}
				}
			}
			if(!found){
				if(status.equalsIgnoreCase("wrong")){
					Question qu = new Question(20,question,status);
					all.add(qu);
				}
				else{
					Question qu = new Question(time,question,status);
					all.add(qu);
				}
				
			}
		}
		
		int noOfRight = 0;
		int totalTime = 0;
		for(int i=0;i<all.size();i++){
			if(all.get(i).getStatus().equalsIgnoreCase("right")){
				noOfRight++;
				totalTime += all.get(i).getTotalTime();
			}
		}
		
		System.out.println(noOfRight + " " + totalTime);
		sc.close();
	}
}

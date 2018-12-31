package Natjecanje;

import java.util.Scanner;

public class Natjecanje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String firstLine = sc.nextLine();
		String secondLine = sc.nextLine();
		String thirdLine = sc.nextLine();
		
		String[] f = firstLine.split("\\s+");
		String[] s = secondLine.split("\\s+");
		String[] t = thirdLine.split("\\s+");
		
		int numOfTeam = Integer.parseInt(f[0]);
		int numOfDamaged = Integer.parseInt(f[1]);
		int numOfReserved = Integer.parseInt(f[2]);
		
		int[] team = new int[numOfTeam];
		int[] damagedTeamNo = new int[numOfDamaged];
		int[] reservedTeamNo = new int[numOfReserved];
		
		int check = 0;
		for(int i=0;i<numOfDamaged;i++){
			damagedTeamNo[i] = Integer.parseInt(s[check]);
			check++;
		}
		
		check = 0;
		for(int i=0;i<numOfReserved;i++){
			reservedTeamNo[i] = Integer.parseInt(t[check]);
			check++;
		}
		
		for(int i=0;i<numOfTeam;i++){
			team[i] = 1;
		}
		for(int i=0;i<numOfDamaged;i++){
			team[damagedTeamNo[i]-1] -=1;
		}
		for(int i=0;i<numOfReserved;i++){
			team[reservedTeamNo[i]-1] +=1;
		}
		int occurence = 0;
		for(int i=0;i<numOfTeam;i++){
			if(i==0 && team[i] == 0){
				if(team[i+1] == 2){
					team[i] +=1;
					team[i+1] -=1;
				}
				else{
					occurence++;
				}
			}
			else if(i==numOfTeam-1 && team[i] == 0){
				if(team[i-1] == 2){
					team[i] +=1;
					team[i-1] -=1;
				}
				else{
					occurence++;
				}
			}
			else if(team[i] == 0){
				if(team[i-1] == 2){
					team[i] +=1;
					team[i-1] -=1;
				}
				else if(team[i+1] == 2){
					team[i] +=1;
					team[i+1] -=1;
				}
				else{
					occurence++;
				}
			}
		}
		System.out.println(occurence);
		sc.close();
	}

}

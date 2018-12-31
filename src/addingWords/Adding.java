package addingWords;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Adding {
	public static void main(String[] args)throws IOException{
		String input = "";
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		do{
			input = sc.nextLine();
			String [] data = input.split(" ");
			if(input.equals("clear")){
				hm.clear();
			}
			else if(data[0].equals("def")){
				hm.put(data[1], Integer.parseInt(data[2]));
			}
			else if(data[0].equals("calc")){
				String output = input.replace("calc ", "");
				boolean found = false;
				int result = 0;
				for(int j=1;j<data.length-1;j=j+2){
					found = false;
			        if(hm.containsKey(data[j])){
						found = true;
						if(j==1){
							result += hm.get(data[j]);
						}
						else if(data[j-1].equals("+")){
							result += hm.get(data[j]);
						}
						else if(data[j-1].equals("-")) {
							result -= hm.get(data[j]);
						}
					}
			        else{
						System.out.println(output + " unknown");
						break;
					}
				}
				if(found){
					String resKey = "unknown";
					for(Map.Entry<String, Integer> entry: hm.entrySet()){
						if(entry.getValue() == result){
							resKey = entry.getKey();
							break;
						}
					}
			        System.out.println(output + " " + resKey);				
				}
			}
		}while(!input.equals(""));
		sc.close();
	}
}

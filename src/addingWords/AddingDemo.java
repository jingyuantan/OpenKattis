package addingWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AddingDemo {
	private static final Map<String, Integer> hm = new HashMap<String, Integer>();
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = reader.readLine()) != null){
				String [] data = input.split(" ");
				switch(data[0]){
					case "clear":hm.clear();break;
					case "def":hm.put(data[1], Integer.parseInt(data[2]));break;
					case "calc":calculate(input);break;
				}
		}
	}

	private static void calculate(String input){
		try{
			String output = input.replace("calc ", "");
			input = cleanUp(input);
			
			String[] data = input.split(" ");
			
			boolean unknown = false;
			int result = 0;
			
			for(String datas:data){
				String key = datas.replaceAll("(\\+|\\-)","");
		        if(!hm.containsKey(key)){
					unknown = true;break;
				}
		        
		        boolean arithmetics = datas.startsWith("-");
				int value = hm.get(key);
				result += arithmetics ? -value : value;
			}
			if(!hm.containsValue(result)){
				unknown = true;
			}
			if(unknown){
				System.out.println(output + " unknown");	
			}
			else{
				String resKey = "unknown";
				for(Map.Entry<String, Integer> entry: hm.entrySet()){
					if(entry.getValue() == result){
						resKey = entry.getKey();
						break;
					}
				}
		        System.out.println(output + " " + resKey);				
			}
		}catch(Exception e){
			
		}
	}
	
	private static String cleanUp(String input) {
		input = input.split("calc ")[1].replaceAll("=", "");
		input = input.replaceAll(" \\+ ", " +");
		input = input.replaceAll(" \\- ", " -");
		return input;
	}
}

package aDifferentProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADifferentProblem {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = reader.readLine()) != null){
			String[] data = input.split(" ");
			long a = Long.parseLong(data[0]);
			long b = Long.parseLong(data[0]);
			System.out.println(Math.abs(a-b));
		}
	}
}

package com.caps.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Fungame {

	public static void main(String[] args)throws Exception 
	{
		String fileName = "C:/Users/QSP/Desktop/Caps_Training/25marchStudent.txt";
		ArrayList<String> allNames = new ArrayList<String>();
		Random r = new Random();

		BufferedReader in = new BufferedReader(new FileReader(fileName)); 
		while (in.ready()) { 
			allNames.add( in.readLine() );
		}
		in.close();
		
		String randomName = allNames.get(r.nextInt(allNames.size()));

		System.out.print("Lucky name :"+randomName);		


	}
}

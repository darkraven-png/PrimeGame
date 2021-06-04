package com.demo.PrimeGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrimeGame {

	public static void main(String[] args) {
		PrimeGame primeGame = new PrimeGame();
		String line=null;
		int counter=0;
		int numberOfRecords = 0;
		ArrayList<String[]> rangeList = new ArrayList<String[]>();
		try {
			File file = new File("C:\\Users\\Ronnie\\eclipse-workspace\\PrimeGame\\src\\input.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				if(counter ==0) {
					numberOfRecords=Integer.parseInt(line);
//					System.out.println(numberOfRecords);
				}
				else {
					String [] rangeArr = line.split("\\s+");
					rangeList.add(rangeArr);
//					System.out.println(Arrays.toString(rangeArr));
				}
				counter++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String[] range:rangeList) {
			ArrayList<Integer> primeList = new ArrayList<Integer>();
			for(int i = Integer.parseInt(range[0]);i<=Integer.parseInt(range[1]);i++) {
//				System.out.println(i);
				if(primeGame.isPrime(i)) {
					primeList.add(i);
				}
			}
			int primeListLength = primeList.size();
			if (primeListLength == 0) {
				System.out.println(-1);
			}
			else if(primeListLength == 1) {
				System.out.println(0);
			}
			else {
				System.out.println(Collections.max(primeList) - Collections.min(primeList));
			}
		}
	}

	public boolean isPrime(int n) {
		// TODO Auto-generated method stub
		int i,m=0,flag=0;      
		m=n/2;      
		if(n==0||n==1){  
		   return false;      
		}else{  
		   for(i=2;i<=m;i++){      
			   if(n%i==0){      
				   return false;      
			   }
		   }
		}
		return true;
	}
}

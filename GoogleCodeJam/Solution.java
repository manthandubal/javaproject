package GoogleCodeJam;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static Scanner bReader = new Scanner(System.in);
	public static void main(String[] args) {
		int numberOfTestCases;		
		try {
			numberOfTestCases = bReader.nextInt();
			iterateTestCases(numberOfTestCases);			
		}  catch (NumberFormatException ne) {
			System.out.println("Looks like invalid number !!! Please input valid number and try again");
		}
		
	}
	
	
	public static void iterateTestCases(int no) {
		long inputNumber;
		ArrayList<Long> inputList = new ArrayList<>(); 
		for (int i = 1; i <= no; i++) {	
			try {
			    if(bReader.hasNext()){
    				inputNumber = bReader.nextInt();
    				inputList.add(inputNumber);		
			    }
			}  catch (NumberFormatException ne) {
				System.out.println("Looks like invalid number !!! Please input valid number and try again");
			}
		}
		int i = 1;
		for (Long integer : inputList) {
			ArrayList<Long> aList = getValuesOfAnB(integer);
			System.out.println();
			System.out.flush();			
			System.out.print("Case #"+i+":");
			for (Long num : aList) {
				System.out.print(" "+num);				
			}
			i++;
			System.out.flush();
		}
			
	}
	
	
	public static ArrayList<Long> getValuesOfAnB(long number) {
        	    
		ArrayList<Long> list = new ArrayList<>();
		long number1=number;
		long number2=number;
		int i = 2;
		while ((checkNumberContain4(number1) || checkNumberContain4(number2)) && (i < number)) {
			number1 = number - i;
			number2 = number - number1;		
			i++;
		}
		if (i != number) {
			list.add(number1);
			list.add(number2);
		} else {
			System.out.println("Could not find appropriate A & B ..!! :-(");
		}
		return list;		
	}
	
	public static boolean checkNumberContain4(long no4) {
		String str = ""+no4;
		if (str.contains("4")) {
			return true;
		} else {
			return false;
		}
	}
}

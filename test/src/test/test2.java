package test;
import java.io.PrintStream;
import java.util.Scanner;


public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String P = "nmfb";
		String T = "jfcmn5mmnnmbmbbmmbm";
       	int m = P.length();
        int i = m -1;
        int j = m -1;
		int Temp = -1;
   		for (int I = 5; I >5-P.length(); I=I-1) {
   			if(Temp <last(T.charAt(I), P)) {	
   				Temp =last(T.charAt(I), P);
   			}
   			
   		} System.out.print(Temp);
	}
	public static int last(char c, String P){
    	// Bonus: Implement last occurence function
    	int count = -1;
    	for (int i = 0; i < P.length(); i++) {
    		if(P.charAt(i)==c) {
    			count = i;
    		}	
    	}
    	return count;
    }	
	public static int min(int a, int b){
        if (a < b)
            return a;
        else if (b < a)
            return b;
        else 
            return a;
    }
}

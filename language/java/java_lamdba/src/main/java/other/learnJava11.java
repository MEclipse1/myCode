package other;

import java.util.Arrays;
import java.util.List;

public class learnJava11 {
public static void main(String[] args) {
	String[] atp = {"Rafael Nadal", "Novak Djokovic",  
		       "Stanislas Wawrinka",  
		       "David Ferrer","Roger Federer",  
		       "Andy Murray","Tomas Berdych",  
		       "Juan Martin Del Potro"};  
		List<String> players =  Arrays.asList(atp);  
		
//		for (String player : players) {   //用for each重新循环
//			if (player.equals("Novak Djokovic")) {
//				System.out.println("hello world");
//			}
//		     System.out.print(player + "; ");  
//		} 
		players.forEach(System.out::println); 
		
		
		players.forEach((player) -> System.out.print(player + "; ")); //lambda表达式  
		 
		
	
}
}

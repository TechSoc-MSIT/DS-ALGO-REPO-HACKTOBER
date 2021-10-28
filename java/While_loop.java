import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	     Scanner scn = new Scanner(System.in);
	     System.out.println("Enter the Number You want to Count:-");
	     int n = scn.nextInt();
		System.out.println("Hello,We are going to count Number");
		int counter = 1;
		
		while (counter<=n){
		     System.out.println(counter);
		     counter++;
		}
		
		System.out.println("Ding Ding Your Counting Is ready");
	}
}


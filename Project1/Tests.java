/**
*	Tests.java
*	Junghoo Kim (Andy)
*	kimj0@sewanee.edu
*	Professor Stephen Carl
*	CS257
*
*	This class tests Polynomial program with different values for coefficient and x values.
*
*/
import java.util.Scanner;
public class Tests{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	

		System.out.print("Test for 1. Polynomial 2. Logistic > ");
		int ans = sc.nextInt();


		if(ans == 1){
			System.out.print("Enter the Polynomial (Ex. 5x^3 + 2x -3 => '3 5 0 2 -3' ) >");
			int degree = sc.nextInt();
			double[] p = new double[degree+1];
			System.out.println(degree);
			for (int i = degree; i >= 0; i--){
				p[i] = sc.nextDouble();
				System.out.println(p[i]);
			}

			Polynomial p1 = new Polynomial(degree);
			for(int i = degree; i >= 0; i--){
				p1.setCoefficient(i, p[i]);
			}
			System.out.println(p1.toString());
		
			String s = "";
			while(!s.equals("No")){
				System.out.print("Enter a value > ");
				double x = sc.nextDouble();
				System.out.println("The result is " + p1.evaluate(x));
				System.out.print("Continue? > ");
				s = sc.next();
			}
		}
		else if(ans == 2){
			System.out.print("Enter the r value for Logistic > ");
			int r = sc.nextInt();
			LogisticMap log = new LogisticMap(r);
			System.out.println(log);
			String s = "";
			while(!s.equals("No")){
				System.out.print("Enter a value > ");
				double x = sc.nextDouble();
				System.out.println("The result is " + log.evaluate(x));
				System.out.print("Continue? > ");
				s = sc.next();
			}
		}
	}
}
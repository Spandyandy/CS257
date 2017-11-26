/**
*	Quadratic.java
*	Junghoo Kim (Andy)
*	kimj0@sewanee.edu
*	Professor Stephen Carl
*	CS257
*
*	This class includes many different methods using quadratic equations
*
*/
public class Quadratic{
	private int[] coef = new int[3];

	/** Quadratic: assign coefficient to an int array
	*
	*	@param a,b,c
	*	@precondition a,b,c must be integer
	*	@postcondition 
	*	@throws 
	*/
	public Quadratic(int a,int b,int c){
		coef[0] = c;
		coef[1] = b;
		coef[2] = a;
	}

	/** getCoef: return an array of coefficient of quadratic formula
	*
	*	@param 
	*	@precondition 
	*	@postcondition return an array of coefficient of quadratic formula
	*	@throws 
	*/
	public int[] getCoef(){
		return coef;
	}
	
	/** roots: compute two roots of Quadratic formula
	*
	*	@param 
	*	@precondition coef[2]!=0 && coef[2]^2 >= 4*coef[2]*coef[0]
	*	@postcondition returns two roots of Quadratic formula
	*	@throws IllegalArgumentException
	*/
	public double[] roots(){
		if (coef[1]*coef[1] < 4*coef[2]*coef[0]) 
			throw new IllegalArgumentException("b^2-4ac must be greater or equal to zero!");
		if (coef[2] == 0) 
			throw new IllegalArgumentException("a should be nonzero!");

		double[] root = new double[2];
		root[0] = (-coef[1]+Math.sqrt(coef[1]*coef[1]-4*coef[2]*coef[0]))/(2*coef[2]);
		root[1] = (-coef[1]-Math.sqrt(coef[1]*coef[1]-4*coef[2]*coef[0]))/(2*coef[2]);
		return root;
	}

	/** evaluate: compute the value of quadratic formula with number x
	*
	*	@param x
	*	@precondition x must be real number
	*	@postcondition the value of quadratic formula
	*	@throws 
	*/
	public double evaluate(double x){
		return (coef[0]+coef[1]*x+coef[2]*x*x);
	}

	/** toString: turn the quadratic formula into String value
	*
	*	@param 
	*	@precondition 
	*	@postcondition string of quadratic formula
	*	@throws 
	*/
	public String toString(){
		String[] signCoef = new String[2];
		for(int i =0; i< 2; i++){
			if(coef[i]>0) signCoef[i] = "+";
			else signCoef[i] = "";
		}

		String s0, s1, s2;
		
		if(coef[2]==1) s2 = "x^2";
		else if(coef[2]==-1) s2 = "-x^2";
		else{s2 = coef[2]+"x^2";}

		if(coef[1]==1) s1 = signCoef[1] + "x";
		else{s1 = signCoef[1] + coef[1] + "x";} 

		s0 = signCoef[0] + coef[0]; 

		return s2 + s1 + s0;
	}

	public static void main(String[] args){
		Quadratic q1 = new Quadratic(1, 3, 2);
		Quadratic q2 = new Quadratic(-1, -2, 3);
		Quadratic q3 = new Quadratic(1, 4, -4);

		System.out.println("getCoef:");
		System.out.println(q1.getCoef()[2] + ", " + q1.getCoef()[1] + ", " + q1.getCoef()[0]);
		System.out.println(q2.getCoef()[2] + ", " + q2.getCoef()[1] + ", " + q2.getCoef()[0]);
		System.out.println(q3.getCoef()[2] + ", " + q3.getCoef()[1] + ", " + q3.getCoef()[0]);


		System.out.println("Roots:");
		System.out.println(q1.roots()[0]);
		System.out.println(q1.roots()[1]);
		System.out.println(q2.roots()[0]);
		System.out.println(q2.roots()[1]);
		System.out.println(q3.roots()[0]);
		System.out.println(q3.roots()[1]);

		System.out.println("Evaluate:");
		System.out.println(q1.evaluate(2));
		System.out.println(q2.evaluate(1));
		System.out.println(q3.evaluate(-1));

		System.out.println("toString:");
		System.out.println(q1.toString());
		System.out.println(q2.toString());
		System.out.println(q3.toString());
	}
}
/**
*	Polynomial.java
*	Junghoo Kim (Andy)
*	kimj0@sewanee.edu
*	Professor Stephen Carl
*	CS257
*
*	This class includes many different methods using polynomial equations
*
*/
public class Polynomial{
	public double[] coef;

	/** Polynomial: assign coefficient to an int array
	*
	*	@param degree
	*	@precondition degree must be integer
	*	@postcondition 
	*	@throws 
	*/
	public Polynomial(int degree){
		 coef = new double[degree+1];
	}

	/** setCoefficient: give coefficient to each element in coef array
	*
	*	@param k, c
	*	@precondition k must be integer, c must be double
	*	@postcondition 
	*	@throws 
	*/
	public void setCoefficient(int k, double c){
		coef[k] = c;
	}

	/** getCoefficient: get coef array
	*
	*	@param
	*	@precondition 
	*	@postcondition double array with same elements as coef array
	*	@throws 
	*/
	public double[] getCoefficient(){
		double[] d = new double[coef.length];
		for(int i = 0; i < coef.length; i++){
			d[i] = coef[i];
		}
		return d;
	}

	/** evaluate: compute the value of polynomial formula with number x
	*
	*	@param x
	*	@precondition x must be real number
	*	@postcondition the value of polynomial formula
	*	@throws 
	*/
	public double evaluate(double x){
		double value = 0;
		for(int i = coef.length-1; i >= 0; i--){
			value += coef[i] * Math.pow(x, i);
		}
		return value;
	}

	/** toString: turn the polynomial formula into String value
	*
	*	@param 
	*	@precondition 
	*	@postcondition string of polynomial formula
	*	@throws 
	*/
	@Override
	public String toString(){
		String s = "";

		//first term
		if (coef.length != 2){
		if (coef[coef.length-1] == 1) 
			s += "x^" + (coef.length-1) + " ";
		else if (coef[coef.length-1] == -1)
			s += "-x^" + (coef.length-1) + " ";
		else	
			s += coef[coef.length-1] + "x^" + (coef.length-1) + " ";
		}
		//second term to two before last term
		for(int i =coef.length-2; i > 1; i--){
			if (coef[i] == 1) 
				s += "+ x^" + i + " ";
			else if (coef[i] == -1) 
				s += "- x^" + i + " ";
			else if (coef[i] > 1)
				s += "+ " + coef[i] + "x^" + i + " ";
			else if (coef[i] < 0)
				s += "- " + -1*coef[i] + "x^" + i + " ";
			else
				s += "";
		}

		//term with degree 1
		if (coef[1] == 1) 
			s += "+ x ";
		else if (coef[1] == -1) 
			s += "- x ";
		else if (coef[1] > 1)
			s += "+ " + coef[1] + "x ";
		else if (coef[1] < 0)
			s += "- " + -1*coef[1] + "x ";
		else
			s += "";

		//last term
		if (coef[0] > 0)
			s += "+ " + coef[0];
		else if (coef[0] < 0)
			s += "- " + -1*coef[0];
		else
			s += "";

		return s;
	}

	/** equals: compare two polynomials and return true if they are the same
	*
	*	@param p
	*	@precondition p must be Polynomial object
	*	@postcondition boolean value whether two polynomials are the same
	*	@throws 
	*/
	public boolean equals(Polynomial p){
		double coef2[] = p.getCoefficient();
		if(coef.length != coef2.length) return false;
		for(int i = 0; i < coef.length; i++){
			if(coef[i] != coef2[i]){
				return false;
			}
		}
		return true;
	}
}
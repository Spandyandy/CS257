/**
*	LogisticMap.java
*	Junghoo Kim (Andy)
*	kimj0@sewanee.edu
*	Professor Stephen Carl
*	CS257
*
*	This program inherits Polynomial class.
*	This program specifically represents Logistic Map
*
*/
public class LogisticMap extends Polynomial {
	/** LogisticMap: assign coefficient to an int array
	*
	*	@param r
	*	@precondition r must be double
	*	@postcondition 
	*	@throws 
	*/
	public LogisticMap(double r){
		super(2);
		super.setCoefficient(1,r);
		super.setCoefficient(2,-r);
	}  
}
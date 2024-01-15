
// Arithmetic Expression Computation
// Writen in Java on 3/15/2023
// Updated on 11/25/2023
// runner.java

import java.io.*;
import java.util.*;

// -------------------------------  //
// runner.java is a runner script which creates an input from either a declared variable
// or through an input given to a scanner. This variable is an arithmetic expression which is then
// used to create an expression object and then compute the postfix and result of the expression.
// -------------------------------  //

// Runner Script which takes an Arithmetic Expression as an Input
public class runner {
	public static void main(String[] args) {
		// Create a Scanner to take in Arithmetic Expressions
		Scanner scanner = new Scanner(System.in);

		// Obtain Expression from Scanner Input
		System.out.println("Input an Arithemtic Expression");
		String expression = scanner.nextLine();  // Read user input
		// Obtain Expression from Inputs
		// String expression = "(6 * 4) + 5 * (5 + 9 * 2)"; // 6 4 * 5 5 9 2 * + * + 

		// Create an Object with the Expression   
		expression expressobj = new expression(expression);
		// Compute the Expression and Display Postfix with Answer
		int expressans = expressobj.compute();
		// Print
		System.out.printf("The Postfix of the Expression %s is %s\n", expressobj.getExpression() ,expressobj.getPostfix());
		System.out.printf("The Computed Answer of the Expression is %d\n", expressans);
	}
}

// -------------------------------  //
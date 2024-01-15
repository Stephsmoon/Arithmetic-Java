
// Arithmetic Expression Computation
// Writen in Java on 3/15/2023
// Updated on 11/25/2023
// expression.java

import java.io.*;
import java.util.*;

// -------------------------------  //
// expression.java holds a object which holds the expressions and functions which
// turns the given expression attribute into postfix and computing the attribute.
// Constuctors Modifiers and Accessors are all enabled for this object.
// Postfix is automatically created based on the expression.
// -------------------------------  //

// Object which Holds the Expression and Functions to Postfix and Compute
public class expression{
	// -------------------------------  //
	// Attributes
	private String expression;
	private String postfix;
	// -------------------------------  //
	// Constructor
	public expression() {}
	// Constructor Calls Postfix Function to Transform expression into Postfix
	public expression(String expression){
		this.expression = expression;
		this.postfix = this.postfix(expression);
	}
	// -------------------------------  //
	// Modifiers
	public void setExpression(String expression) {
		// Setting New Expression Creates new Postfix
		this.expression = expression;
		this.postfix = this.postfix(expression);
	}
	// ------------------------------- // 
	// Accessors
	public String getExpression() {
		return this.expression;
	}
	public String getPostfix() {
		return this.postfix;
	}
	// -------------------------------  //
	// Functions 
	// Computes the Postfix using a Stack
	public String postfix(String expression) {
		// String of Postfix Form which will be Modified
		String postfix_form = "";
		// Enclose the Expression with Brackets 
		expression = "(" + expression + ")";
		// Stack for Each Character of the Expression
		Stack<Character> stack = new Stack<Character>();
		// Traverse the Expression
		for (int index = 0; index < expression.length(); index++) {
			if (expression.charAt(index) == ' '){
				continue;
			}
			// Check Next Expression Character
			if (Character.isDigit(expression.charAt(index))) { 
				// Add Values to Postfix
				postfix_form = postfix_form + expression.charAt(index) + " ";
			} else if (Character.toString(expression.charAt(index)).matches("[(*+-]")) { 
				// Add Symbols to Stack
				stack.push(expression.charAt(index));
			} else if (Character.toString(expression.charAt(index)).matches("[)]")) { 
				// Add Symbols to Postfix
				while (stack.peek().compareTo('(') != 0){
					postfix_form = postfix_form + stack.pop() + " ";
				}
			stack.pop();
			}
		}
		return postfix_form;
	}
	// Computes the Expression using a Stack
	public int compute(){
		// Stack for Each Operation of the Expression
		Stack<Integer> stack = new Stack<Integer>();
		// Traverse the Expression
		for (int index = 0; index < this.postfix.length(); index++){
			if (Character.isDigit(this.postfix.charAt(index))){
				stack.push(Character.getNumericValue(this.postfix.charAt(index)));
			} else if (Character.toString(this.postfix.charAt(index)).matches("[*+-]")) {
				int a = stack.pop(); 
				int b = stack.pop(); 
				int c = 0;
				// Switch Statement for Each Operation
				switch (this.postfix.charAt(index)) {
					case '*': 
						c = a * b; 
						break;
					case '+': 
						c = a + b; 
						break;
					case '-': 
						c = a * b; 
						break;
				}
			stack.push(c);
			}
		}
		return stack.pop();
	}
}

// -------------------------------  //

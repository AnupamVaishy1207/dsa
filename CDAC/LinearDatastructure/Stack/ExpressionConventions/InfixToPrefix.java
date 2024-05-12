package CDAC.LinearDatastructure.Stack.ExpressionConventions;


class Stack {
	private char arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new char[SIZE];
		top = -1;
	}
	
	public void push(char value) {
		//1. reposition top
		top++;
		//2. add value at top index
		arr[top] = value;
	}
	
	public char pop() {
		//1. reposition top and return value of top index
		return arr[top--];
	}
	
	public char peek() {
		//1. read and return value of top index
		return arr[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE - 1;
	}


}
public class InfixToPrefix {
    
	public static int prio(char opr) {
		switch(opr) {
		case '$': return 11;
		case '/': return 10;
		case '*': return 10;
		case '%': return 10;
		case '+': return 9;
		case '-': return 9;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		//1. create stack to store operators
		Stack st = new Stack(10);
		//2. create string to store postfix expression
		StringBuilder postfix = new StringBuilder();
		//3. process infix expression from left to right
		for(int i = 0 ; i < infix.length() ; i++) {
			//4. extract element from string (index i)
			char ele = infix.charAt(i);
			//5. if element is operand
			if(Character.isDigit(ele))
				// append element into postfix expr
				postfix.append(ele);
			//6. if element is '('
			else if(ele == '(')
				st.push(ele);
			//7. if elememt is ')'
			else if(ele == ')') {
				// pop elements from stack and append into postfix one by one till '('
				while(st.peek() != '(') {
					postfix.append(st.pop());
				}
				// discard '('
				st.pop();
			}
			//8. if element is operator
			else {
				//9. check priority with topmost element
				while(!st.isEmpty() && prio(st.peek()) >= prio(ele)) {
					postfix.append(st.pop());
				}
				//10. push operator on stack
				st.push(ele);
			}
		}
		//11. pop remaining operators from stack and append into postfix one by one
		while(!st.isEmpty())
			postfix.append(st.pop());
		//12. return postfix expression
		return postfix.toString();
	}
	public static String infixToPrefix(String infix) {
		//1. create stack to store operators
		Stack st = new Stack(10);
		//2. create string to store prefix expression
		StringBuilder prefix = new StringBuilder();
		//3. process infix expression from right to left
		for(int i = infix.length() - 1 ; i >= 0 ; i--) {
			//4. extract element from string (index i)
			char ele = infix.charAt(i);
			//5. if element is operand
			if(Character.isDigit(ele))
				// append element into prefix expr
				prefix.append(ele);
			//6. if element is ')'
			else if(ele == ')')
				st.push(ele);
			//7. if elememt is '('
			else if(ele == '('){
				// pop elements from stack and append into prefix one by one till '('
				while(st.peek() != ')') {
					prefix.append(st.pop());
				}
				// discard '('
				st.pop();
			}
			//8. if element is operator
			else {
				//9. check priority with topmost element
				while(!st.isEmpty() && prio(st.peek()) > prio(ele)) {
					prefix.append(st.pop());
				}
				//10. push operator on stack
				st.push(ele);
			}
		}
		//11. pop remaining operators from stack and append into prefix one by one
		while(!st.isEmpty())
			prefix.append(st.pop());
		//11.1 reversee the expression
		prefix.reverse();
		//12. return prefix expression
		return prefix.toString();
	}
	public static void main(String[] args) {
		String infix = "1$9+3*4-(6+8/2)+7";
		
		String postfix  = infixToPostfix(infix);
		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + postfix);
		
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix : " + prefix);

	}
}

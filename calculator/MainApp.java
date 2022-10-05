package io.github.vartikasingh.project.calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainApp {

	public static void main(String[] args) {
		final String inputExp = ReadInput.read(); // reading the expression provided as as input from the user

		Queue<String> operations;
		Queue<String> numbers;

		/*
		 * split is used to split the numbers and operations apart. result will be
		 * numbers here
		 */
		String numberArr[] = inputExp.split("[-+*/]");

		/*
		 * split is used to split the numbers and operations apart. result will be
		 * operations here
		 */
		String operArr[] = inputExp.split("[0-9]+");

		/*
		 * here, queue is converted into list using Array.asList and then it will again
		 * be converted into linkedlist , then stored into the queue of numbers.
		 */
		numbers = new LinkedList<String>(Arrays.asList(numberArr));
		operations = new LinkedList<String>(Arrays.asList(operArr));

		// poll() retrieves and removes the head (first element) of this list.
		Double res = Double.parseDouble(numbers.poll());

		// running a loop on numbers queue till no numbers are left in the queue
		while (!numbers.isEmpty()) {
			// retrieves the first operation from the queue and stored in opr
			String opr = operations.poll();

			Operate operate;
			switch (opr) {
			case "+":
				/*
				 * new add() - object and defined a reference of operate here assigning the
				 * object to interface(operate) , using dynamic binding
				 */
				operate = new Add();
				break;

			case "-":
				operate = new Subtract();
				break;

			case "*":
				operate = new Multiply();
				break;
			case "/":
				operate = new Divide();
				break;
			default:
				continue;
			}
			// taking the next number
			Double num = Double.parseDouble(numbers.poll());

			res = operate.getResult(res, num);

		}

		System.out.println(res);
	}

}

package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.LinkedStack;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {


    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param postfix A string representing an postfix notation expression where
     *                each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix) {
        LinkedStack<String> messageStack = new LinkedStack<>();

        // Check for string empty or null
        if (infix == null || infix.trim().isEmpty()) {
            return 0;
        }

        // Turn String input into an array, then add it to the stack
        String[] tempChars = infix.split(" ");
        for (int i = 0; i < tempChars.length; i++) {
            messageStack.push(tempChars[i]);
        }

        // Stack is backwards, reversing...
        messageStack.reverse();

        boolean firstRound = true;
        while (messageStack.size() > 1) {
            String a = messageStack.pop();
            // Verify a is an int
            if (tryParseInt(a)) {
                int num1 = Integer.parseInt(a);
                String b = messageStack.pop();
                // Verify b is an int
                if (tryParseInt(b)) {
                    int num2 = Integer.parseInt(b);
                    String c = messageStack.pop();
                    // Check if c is an int
                    if (tryParseInt(c)) {
                        // This is to ensure we aren't evaluating a second set of parentheses on the first round
                        if (!firstRound) {
                            int num3 = Integer.parseInt(c);
                            String d = messageStack.pop();
                            messageStack.push(evaluate(num2, num3, d) + "");
                            messageStack.push(a);

                        } else throw new IllegalArgumentException("Too many numbers in a row.");
                        // Not an int, we can evaluate using num1, num2, and c
                    } else {
                        messageStack.push(evaluate(num1, num2, c) + "");
                        firstRound = false;
                    }
                } else throw new IllegalArgumentException("Not enough numbers to evaluate!");
            } else throw new IllegalArgumentException("Not enough numbers to evaluate!");
        }
        return Integer.parseInt(messageStack.pop());
    }

    /**
     * Source: https://stackoverflow.com/questions/8391979/does-java-have-a-int-tryparse-that-doesnt-throw-an-exception-for-bad-data
     * This tries to parse the string to an int
     *
     * @param value string to try to parse to an int
     * @return true if parsable, false otherwise
     */
    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Used to evaluate the postfix
     *
     * @param num1 - first number to evaluate
     * @param num2 - second number to evaluate
     * @param op - operator to use to evaluate
     * @return - result of the arithmetic operation
     */
    private static int evaluate(int num1, int num2, String op) {
        int result = 0;
        if (op.equals("+")) {
            result = num1 + num2;
        } else if (op.equals("-")) {
            result = num1 - num2;
        } else if (op.equals("*")) {
            result = num1 * num2;
        } else if (op.equals("/")) {
            result = num1 / num2;
        } else if (op.equals("%")) {
            result = num1 % num2;
        }
        return result;
    }
}

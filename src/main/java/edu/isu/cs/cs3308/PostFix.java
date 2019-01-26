package edu.isu.cs.cs3308;

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
     * each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix) {
        // Verify string is not null or empty
        // Work through the string in a loop, pulling out numbers and stopping at the operators
        // When an operator has been found, evaluate based on the operator and push to a stack
        // When an operator has been found before numbers, pop 2 off the stack and evaluate
        // Error check to ensure there are 2 numbers in the stack to evaluate. Break otherwise (throw exception)
        // In the end, there should be only one value in the stack, this is our answer to return


        throw new UnsupportedOperationException("Not supported yet.");
    }
}

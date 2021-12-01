import util.Stack;

import java.util.EmptyStackException;

/**
 * Test stack implementation
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
public class TestStack {

    public static void main(String[] args){
        uninitializedStackShouldBeEmpty();
        stackWithElementShouldNotBeEmpty();
        stackShouldBeEmptyAfterElementsAreRemoved();
        copyingStackFromAnotherShouldWork();
        copyingStackFromNullShouldThrowException();
        modifyValuesOfCopiedStackShouldNotModifyOriginalStack();
        uninitializedStackShouldHaveSize0();
        stackSizeShouldBeCorrect();
        pushingAndPoppingObjectsShouldReturnThemInReverseOrder();
        popOnEmptyListShouldThrowException();
        peekShouldReturnTopOfTheStack();
        emptyStackToArrayShouldReturnEmptyArray();
        filledStackToArrayShouldReturnNoEmptyArray();
        changingToArrayElementShouldNotModifyStack();
    }

    public static void uninitializedStackShouldBeEmpty(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        if(!stack.empty()){
            testStatus = false;
        }
        printTestResult("Test - uninitialized stacks should be empty : ", testStatus);
    }

    public static void stackWithElementShouldNotBeEmpty(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            if (stack.empty()) {
                testStatus = false;
            }
        }
        printTestResult("Test - stack with elements should not be empty : ", testStatus);
    }

    public static void copyingStackFromAnotherShouldWork(){
        boolean testStatus = true;
        Stack<Integer> stack1 = new Stack<>();
        try{
            new Stack<>(stack1);
        }
        catch (IllegalArgumentException illegalArgumentException){
            testStatus = false;
        }

        printTestResult("Test - Copying stack from another stack should work : ", testStatus);
    }

    public static void copyingStackFromNullShouldThrowException(){
        boolean testStatus = false;
        try{
            new Stack<>(null);
        }
        catch (IllegalArgumentException illegalArgumentException){
            testStatus = true;
        }

        printTestResult("Test - Copying stack from another stack should work : ", testStatus);
    }

    public static void modifyValuesOfCopiedStackShouldNotModifyOriginalStack(){
        boolean testStatus = false;

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);

        try{
            Stack<Integer> stack2 = new Stack<>(stack1);
            try{
                stack2.pop();

                if(!stack1.empty()){
                    testStatus = true;
                }
            }
            catch (EmptyStackException emptyStackException){
                emptyStackException.printStackTrace();
            }
        }
        catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException.printStackTrace();
        }

        printTestResult("Test - Modify value in a copied Stack should not modify original Stack : ", testStatus);
    }

    public static void stackShouldBeEmptyAfterElementsAreRemoved(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for(int i = 0; i < 5; i++){
            stack.pop();
        }
        if(!stack.empty()){
            testStatus = false;
        }
        printTestResult("Test - stack should be empty after removing all it's elements : ", testStatus);
    }

    public static void uninitializedStackShouldHaveSize0(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        if(stack.getSize() != 0){
            testStatus = false;
        }
        printTestResult("Test - unintialized stack should have size 0 : ", testStatus);
    }

    public static void stackSizeShouldBeCorrect(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            if (stack.getSize() != i) {
                testStatus = false;
                break;
            }
        }
        for (int i = 4; i >= 0; i--) {
            stack.pop();
            if (stack.getSize() != i) {
                testStatus = false;
                break;
            }
        }
        printTestResult("Test - stack size should be correct : ", testStatus);
    }

    public static void pushingAndPoppingObjectsShouldReturnThemInReverseOrder(){
        boolean testStatus = true;
        int input[] = new int[]{1, 2, 3, 4, 5};
        int expected[] = new int[]{5, 4, 3, 2, 1};
        int result[] = new int[5];

        Stack<Integer> stack = new Stack<>();
        for (int i: input) {
            stack.push(i);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        for (int i = 0; i < result.length; i++) {
            if(expected[i] != result[i]){
                testStatus = false;
                break;
            }
        }
        printTestResult("Test - pushing and popping objects should return them in reverse order : ", testStatus);
    }

    public static void popOnEmptyListShouldThrowException(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        try{
            stack.pop();
            testStatus = false;
        } catch (EmptyStackException ignored) {
        }
        printTestResult("Test - pop on empty list throws an exception : ", testStatus);
    }

    public static void peekShouldReturnTopOfTheStack(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            if (stack.peek() != i) {
                testStatus = false;
                break;
            }
        }
        for (int i = 4; i > 0; i--) {
            stack.pop();
            if (stack.peek() != i) {
                testStatus = false;
                break;
            }
        }
        printTestResult("Test - peek should return the top of the stack : ", testStatus);
    }

    public static void emptyStackToArrayShouldReturnEmptyArray(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        Object[] returnVal = stack.toArray();
        if(returnVal.length != 0){
            testStatus = false;
        }
        printTestResult("Test - array conversion of an empty stack should return an empty array : ", testStatus);
    }

    public static void filledStackToArrayShouldReturnNoEmptyArray(){
        boolean testStatus = true;
        Stack<Integer> stack = new Stack<>();
        Integer input[] = new Integer[]{1,2,3,4,5,6,7};
        Integer expected[] = new Integer[]{7,6,5,4,3,2,1};
        for (Integer i: input) {
            stack.push(i);
        }
        Object returnVal[] = stack.toArray();
        try{
            for (int i = 0; i < expected.length; i++) {
                if(expected[i].compareTo((Integer)returnVal[i]) != 0){
                    testStatus = false;
                    break;
                }
            }
        } catch(Exception ex){
            testStatus = false;
        }
        printTestResult("Test - array conversion should be correct : ", testStatus);

    }

    public static void changingToArrayElementShouldNotModifyStack(){
        boolean testStatus = true;

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);

        Object[] arrayStack = stack1.toArray();
        arrayStack[0] = 1;

        try{
            if(stack1.peek() != 0){
                testStatus = false;
            }
        }
        catch (EmptyStackException emptyStackException){
            emptyStackException.printStackTrace();
        }

        printTestResult("Test - Changing Stack.toArray() element should not modify the original stack : ", testStatus);
    }

    /**
     * Display the result of a test in the console
     * @param message message to display in the console
     * @param result true if the test succeded
     */
    private static void printTestResult(String message, boolean result){
        System.out.println((result ? "\033[0;32m" : "\033[0;31m") + message + result);
    }
}

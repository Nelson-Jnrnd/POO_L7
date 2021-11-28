package hanoi;

import util.Stack;

/**
 * Create and solve Hanoi towers puzzle
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
public class Hanoi {

    private final Stack<Integer> stackA = new Stack<>();
    private final Stack<Integer> stackB = new Stack<>();
    private final Stack<Integer> stackC = new Stack<>();

    private final int nbDisks;

    private int counter = 0;

    private HanoiDisplayer displayer;

    /**
     * Create Hanoi tower with the numbers of disks and a displayer
     * @param disks Number of disks
     * @param displayer Display to user either to display in console or graphic mode
     */
    public Hanoi(int disks, HanoiDisplayer displayer){
        this(disks);
        this.displayer = displayer;
    }

    /**
     * Create Hanoi towers with the numbers of disks and push disks to the first needle (stack)
     * @param disks Number of disks
     */
    public Hanoi(int disks){
        nbDisks = disks;
        for(int i = disks; i > 0; --i){
            stackA.push(i);
        }
    }

    /**
     * Begin the transfer of disks to solve the puzzle
     */
    public void solve(){
        transfert(stackA, stackB, stackC, nbDisks);
    }

    /**
     * Recursive fucntion used to move disks from a stack to another using an intermediate stack
     * @param from Stack which will the disk be moved from
     * @param via Stock used as an intermediate
     * @param to Stack which will disk be moved to
     * @param n Number of disks to move
     */
    public void transfert(Stack<Integer> from, Stack<Integer> via, Stack<Integer> to, int n){
        if(n != 0){
            transfert(from, to, via, n - 1);
            to.push(from.peek());
            from.pop();
            ++counter;
            if(displayer != null){
                displayer.display(this);
            }
            transfert(via, from, to, n - 1);
        }
    }

    /**
     * Returns a bidimmensional array that contains current stacks states
     * @return Array with current stacks states
     */
    public int[][] status(){
        return new int[][] {
                objectArrayToIntArray(stackA.toArray()),
                objectArrayToIntArray(stackB.toArray()),
                objectArrayToIntArray(stackC.toArray())
        };
    }

    /**
     * Transoform Object array to int array
     * @param objects Array of Objects
     * @return Array of ints
     */
    private int[] objectArrayToIntArray(Object[] objects){
        int[] ints = new int[objects.length];
        for (int i = 0; i < objects.length; i++){
            ints[i] = (Integer)(objects[i]);
        }
        return ints;
    }

    /**
     * Checks if game is either finished or not
     * A game is finished if the first two stacks are empty. This means that all disks are on the third stack
     * and with the rules set, it is guaranteed that the disks are in the correct order.
     * @return Either if the game is finished or not
     */
    public boolean finished(){
        return stackA.empty() && stackB.empty();
    }

    /**
     * Return the number of moved disks
     * @return Number of moved disks
     */
    public int turn(){
        return counter;
    }

    // TODO Askip faut faire par copie
    /**
     * Get elements of the first needle
     * @return The first stack
     */
    public Stack<Integer> getStackA() {
        return stackA;
    }

    /**
     * Get elements of the second needle
     * @return The second stack
     */
    public Stack<Integer> getStackB() {
        return stackB;
    }

    /**
     * Get elements of the third needle
     * @return The third stack
     */
    public Stack<Integer> getStackC() {
        return stackC;
    }
}

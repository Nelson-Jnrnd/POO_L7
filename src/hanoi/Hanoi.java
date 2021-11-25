package hanoi;

import util.Stack;

import java.util.Arrays;

public class Hanoi {
    // TODO Askip faut faire par copie
    public Stack<Integer> getStackA() {
        return stackA;
    }

    public Stack<Integer> getStackB() {
        return stackB;
    }

    public Stack<Integer> getStackC() {
        return stackC;
    }

    public int getNbDisks() {
        return nbDisks;
    }

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();
    private Stack<Integer> stackC = new Stack<>();

    private int nbDisks;

    private int counter = 0;

    private HanoiDisplayer displayer;

    public Hanoi(int disks, HanoiDisplayer displayer){
        this(disks);
        this.displayer = displayer;
    }

    public Hanoi(int disks){
        nbDisks = disks;
        for(int i = disks; i > 0; --i){
            stackA.push(i);
        }
    }

    public void solve(){
        transfert(stackA, stackB, stackC, nbDisks);
    }

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

    public int[][] status(){
        return new int[][] {
                objectArrayToIntArray(stackA.toArray()),
                objectArrayToIntArray(stackB.toArray()),
                objectArrayToIntArray(stackC.toArray())
        };
    }

    private int[] objectArrayToIntArray(Object[] objects){
        int[] ints = new int[objects.length];
        for (int i = 0; i < objects.length; i++){
            ints[i] = (Integer)(objects[i]);
        }
        return ints;
    }

    public boolean finished(){
        return stackA.empty() && stackB.empty();
    }

    public int turn(){
        return counter;
    }
}

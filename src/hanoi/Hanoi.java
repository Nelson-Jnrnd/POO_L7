package hanoi;

import util.Stack;

import java.util.Arrays;

public class Hanoi {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();
    private Stack<Integer> stackC = new Stack<>();

    private int nbDisks;

    private int counter = 0;
    private int movedDisks = 0;

    public Hanoi(int disks, HanoiDisplayer displayer){
        this(disks);
        //HanoiDisplayer
    }

    public Hanoi(Integer disks){
        nbDisks = disks;
        for(Integer i = disks; i > 0; --i){
            stackA.push(i);
        }
    }

    public void solve(){
        transfert(stackA, stackB, stackC, nbDisks);
    }

    public void transfert(Stack<Integer> from, Stack<Integer> via, Stack<Integer> to, int n){
        if(n != 0){
            ++movedDisks;
            transfert(from, to, via, n - 1);
            to.push(from.peek());
            from.pop();
            ++counter;
            display();
            ++movedDisks;
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
            ints[i] = (int)objects[i];
        }
        return ints;
    }

    public boolean finished(){
        return stackA.empty() && stackB.empty() && !stackC.empty();
    }

    public int turn(){

    }

    private void display(){
        System.out.println("-- Turn " + counter);
        System.out.println(stackA);
        System.out.println(stackB);
        System.out.println(stackC + "\n");
    }


    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("No enough args");
            return;
        }

        int disks = Integer.parseInt(args[0]);

        Hanoi hanoi = new Hanoi(disks);

        for(int i = disks; i > 0; --i){
            hanoi.stackA.push(i);
        }


    }
}

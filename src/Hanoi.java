import util.Stack;

public class Hanoi<T> {
    private Stack<T> stackA = new Stack<>();
    private Stack<T> stackB = new Stack<>();
    private Stack<T> stackC = new Stack<>();

    private int counter = 0;

    public void transfert(Stack<T> from, Stack<T> via, Stack<T> to, int n){
        if(n != 0){
            transfert(from, to, via, n - 1);
            to.push(from.peek());
            from.pop();
            ++counter;
            display();
            transfert(via, from, to, n - 1);
        }
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

        int n = Integer.parseInt(args[0]);

        Hanoi<Integer> hanoi = new Hanoi<>();

        for(int i = n; i > 0; --i){
            hanoi.stackA.push(i);
        }

        hanoi.display();
        hanoi.transfert(hanoi.stackA, hanoi.stackB, hanoi.stackC, n);
    }
}

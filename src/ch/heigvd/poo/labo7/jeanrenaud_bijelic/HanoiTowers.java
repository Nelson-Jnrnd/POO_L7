package ch.heigvd.poo.labo7.jeanrenaud_bijelic;

public class HanoiTowers {
    Stack stackA = new Stack();
    Stack stackB = new Stack();
    Stack stackC = new Stack();


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 10; ++i){
            stack.push(i);
        }

        Object array[] = stack.toArray();

        for(Object value : array){
            System.out.println(value);
        }

        System.out.println("Peek = " + stack.peek());


        System.out.println(stack);

        /*Examinator<Integer> iterator = stack.front();
        while(iterator.hasNext()){
            System.out.println("Custom ite : " + iterator.next());
        }*/
        /*do {

        }while (iterator.hasNext());*/
    }
}

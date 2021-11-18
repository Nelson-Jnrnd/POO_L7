package ch.heigvd.poo.labo7.jeanrenaud_bijelic;

import EX_ObjectList.src.Examinator;

import java.util.Iterator;

public class HanoiTowers {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Integer monInt = 5;
        String monString = "string";
        Integer monInt2 = 8;
        Integer monInt3 = 31;
        stack.push(monInt);
        //stack.push(monString);
        stack.push(monInt2);
        stack.push(monInt3);

        System.out.println("Peek = " + stack.peek());


        System.out.println(stack);
        Examinator<Integer> iterator = stack.front();
        while(iterator.hasNext()){
            System.out.println("Custom ite : " + iterator.next());
        }
        /*do {

        }while (iterator.hasNext());*/
    }
}

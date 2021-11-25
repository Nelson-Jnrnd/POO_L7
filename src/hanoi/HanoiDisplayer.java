package hanoi;

public class HanoiDisplayer {

    public void display(Hanoi h){
        System.out.println("-- Turn " + h.turn());
        System.out.println(h.getStackA());
        System.out.println(h.getStackB());
        System.out.println(h.getStackC() + "\n");
    }
}

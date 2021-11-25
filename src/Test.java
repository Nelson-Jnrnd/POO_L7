import hanoi.Hanoi;
import hanoi.HanoiDisplayer;
import hanoi.gui.JHanoi;

public class Test {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("No enough args");
            return;
        }
        testGui();
        int disks = Integer.parseInt(args[0]);

        testConsole(disks);
    }

    public static void testConsole(int disks){
        HanoiDisplayer displayer = new HanoiDisplayer();
        Hanoi hanoi = new Hanoi(disks, displayer);

        displayer.display(hanoi);
        hanoi.solve();
    }
    public static void testGui(){
        JHanoi monJhanoi = new JHanoi();
    }
}

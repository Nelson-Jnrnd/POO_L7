import hanoi.Hanoi;
import hanoi.HanoiDisplayer;

public class Test {
    public static void main(String[] args) {
        switch (args.length) {
            case 0: testGui();
                    break;
            case 1:
                int disks = Integer.parseInt(args[0]);
                testConsole(disks);
                break;
            default: System.out.println("Too much args");
        }
    }

    public static void testConsole(int disks){
        HanoiDisplayer displayer = new HanoiDisplayer();
        Hanoi hanoi = new Hanoi(disks, displayer);

        displayer.display(hanoi);
        hanoi.solve();
    }

    public static void testGui(){
        new hanoi.gui.JHanoi();
    }
}

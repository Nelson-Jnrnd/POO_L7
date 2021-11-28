import hanoi.Hanoi;
import hanoi.HanoiDisplayer;

/**
 * Tests graphic and console mode of Hanoi tower program
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
public class TestHanoi {
    public static void main(String[] args) {
        switch (args.length) {
            case 0:
                new hanoi.gui.JHanoi();
                break;
            case 1:
                int disks = Integer.parseInt(args[0]);
                testConsole(disks);
                break;
            default: System.out.println("Too much args");
        }
    }

    /**
     * Launch console mode solver
     * @param disks Number of disks
     */
    public static void testConsole(int disks){
        HanoiDisplayer displayer = new HanoiDisplayer();
        Hanoi hanoi = new Hanoi(disks, displayer);

        hanoi.solve();
    }
}

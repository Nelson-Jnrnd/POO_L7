package hanoi;

/**
 * Displayer for Hanoi Towers puzzle
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
public class HanoiDisplayer {

    /**
     * Display in console current turn and needles status
     * @param h Hanoi tower to display
     */
    public void display(Hanoi h){
        System.out.println("-- Turn " + h.turn());
        System.out.println(h.getStackA());
        System.out.println(h.getStackB());
        System.out.println(h.getStackC() + "\n");
    }
}

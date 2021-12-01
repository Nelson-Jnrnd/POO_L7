package util;

/**
 * Generic Examinator (Iterator) used for Element
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
class Examinator<T> {

    private Element<T> current;

    /**
     * Examinator constructor
     * @param current Current Element
     */
    public Examinator(Element<T> current) {
        this.current = current;
    }

    /**
     * Check if current Element has a reference to the next Element
     * @return If next Element exists
     */
    public boolean hasNext(){
        return current.next != null;
    }

    /**
     * Return the next element
     * @return Next element
     */
    public Element<T> next(){
        if(!hasNext()){
            return null;
        }
        current = current.next;
        return current;
    }
}
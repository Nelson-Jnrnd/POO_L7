package util;

/**
 * Generic Element containing data and a reference to the next element
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
public class Element<T> {

    protected T data;
    protected Element<T> next;

    /**
     * Create new element with data and reference to the next element
     * @param data Element data
     * @param next Reference to the next element
     */
    public Element(T data, Element<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Return data to string format
     * @return Data to string format
     */
    @Override
    public String toString() {
        return data.toString();
    }
}

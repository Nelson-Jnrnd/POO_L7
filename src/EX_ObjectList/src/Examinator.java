package EX_ObjectList.src;

import java.util.Iterator;

public class Examinator<T> implements Iterator<Element<T>> {
    private Element<T> current;

    public Examinator(Element<T> current) {
        this.current = current;
    }

    public boolean hasNext(){
        return current != null;
    }
    public Element<T> next(){
        Element<T> returnval = current;
        current = current.next;
        return returnval;
    }
}

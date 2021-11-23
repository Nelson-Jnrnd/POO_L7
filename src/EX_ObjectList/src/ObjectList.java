package EX_ObjectList.src;

public class ObjectList<T> {

    private Element<T> head;
    private Examinator<T> iterator;
    private Examinator<T> beforeBegin;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int counter = 0;
        Examinator<T> currentElement = new Examinator<>(head);
        while (currentElement.hasNext()) {
            counter++;
            currentElement.next();
        }
        return counter;
    }

    public void insert(T o) {
        Element<T> oldHead = head;
        head = new Element<>(o);
        head.next = oldHead;
    }

    public void append(T o) {
        if(iterator == null){
            head = new Element<>(o);
            iterator = new Examinator<>(head);
            beforeBegin = new Examinator<>(head);
        }
        Element<T> last = iterator.next();
        if(last != null){
            boolean wasNull = last.next == null;
            last.next = new Element<>(o);
            if(wasNull)
                iterator = new Examinator<>(last.next);
        }
    }

    public void remove(T o) {
        Examinator<T> currentElement = new Examinator<>(head);
        Examinator<T> prevElement = new Examinator<>(head);
        currentElement.next();
        Element<T> curr;
        while (currentElement.hasNext()) {
            curr = currentElement.next();
            if(curr.data == o){
                prevElement.next().next = curr.next;
            }else{
                prevElement.next();
            }
        }
    }
    public void remove(Examinator<T> iterator){
        Examinator<T> prevIterator = iterator;
        Element<T> toRemove = iterator.next();
        if(toRemove != null){
            prevIterator.next().next = toRemove.next;
        }
    }

    public Object get(int index) {
        if(index == 0)
            return head;
        int counter = 0;
        Examinator<T> currentElement = new Examinator<>(head);

        while (currentElement.next() != null) {
            if (++counter == index) {
                return currentElement.next();
            }
        }
        throw new RuntimeException("Index is out of bounds");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if(head == null){
            return "";
        }
        for(Examinator<T> currentElement = new Examinator<>(head);currentElement.hasNext();) {
            s.append(currentElement.next());
            if (currentElement.hasNext()) {
                s.append("-");
            }
        }
        return s.toString();
    }
    public Examinator<T> front(){
        return new Examinator<>(head);
    }
    public Examinator<T> end(){
        return iterator;
    }
}


class Main {
    public static void main(String[] args) {
        ObjectList<Integer> lst = new ObjectList<>();

        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                lst.insert(i);
            }else{
                lst.append(i);
            }
            if(i == 5){
                lst.remove(0);
                lst.remove(1);
                lst.remove(9);
            }
            System.out.println("Iteration " + i + ": " + lst);
        }

    }
}


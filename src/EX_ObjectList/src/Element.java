package EX_ObjectList.src;

public class Element<T> {
    public T getData() {
        return data;
    }

    protected T data;
    protected Element<T> next;

    public Element(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

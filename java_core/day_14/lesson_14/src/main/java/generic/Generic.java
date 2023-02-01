package generic;

interface IGenericDao<T> {
    void insert(T obj);
    void update(T obj);
}
public class Generic<T> implements IGenericDao<T> {
    @Override
    public void insert(T obj) {
        // do something
    }
    @Override
    public void update(T obj) {
        // do something
    }
}

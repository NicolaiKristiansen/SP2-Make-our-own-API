package app.dao;

public interface IDAO<T, F> {

    public T create(F f);

    public T findById(int id);

    public T update(F f, Integer id);

    public void delete(int id);
}

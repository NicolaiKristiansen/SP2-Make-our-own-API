package app.dao;

public interface IDAO<E, I> {

    public E create(I e);

    public E findById(int id);

    public E update(I e, Integer id);

    public void delete(int id);
}

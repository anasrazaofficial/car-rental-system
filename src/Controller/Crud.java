package Controller;

import java.util.List;

public interface Crud<Model> {
    void post(Model obj);

    List<Model> getAll();

    void update(Model obj, Integer id);

    boolean delete(Integer id);
}
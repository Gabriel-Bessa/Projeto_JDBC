
package Model.DAO;

import Model.entities.Departamento;
import java.util.List;

public interface Department_dao {
    void insert(Departamento obj);
    void update(Departamento obj);
    void deleteById(Integer id);
    Departamento findById(Integer id);
    List<Departamento> findAll();
}

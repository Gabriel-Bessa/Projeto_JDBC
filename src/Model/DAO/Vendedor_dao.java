package Model.DAO;

import Model.entities.Vendedor;
import java.util.List;

public interface Vendedor_dao {
    
    void insert(Vendedor obj);
    void update(Vendedor obj);
    void deleteById(Integer id);
    Vendedor findById(Integer id);
    List<Vendedor> findAll();
    
}

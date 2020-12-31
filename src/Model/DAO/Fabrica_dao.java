package Model.DAO;

import Model.DAO.impl.Departamento_dao_JDBC;
import java.sql.Connection;
import Model.DAO.impl.Vendedor_dao_JDBC;

public class Fabrica_dao {
    public static Vendedor_dao_JDBC createVendedorDao(Connection con){
        return new Vendedor_dao_JDBC(con) ;
    }
    public static Departamento_dao_JDBC createDepartmentDao(Connection con){
        return new Departamento_dao_JDBC(con);
    }
}

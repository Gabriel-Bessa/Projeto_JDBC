package Model.DAO;

import java.sql.Connection;
import Model.DAO.impl.Vendedor_dao_JDBC;

public class Fabrica_dao {
    public static Vendedor_dao_JDBC createVendedorDao(Connection con){
        return new Vendedor_dao_JDBC(con) ;
    }
}

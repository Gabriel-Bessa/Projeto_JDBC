package Model.DAO;

import Model.DAO.impl.Vendedor_dao_JDBC;

public class Fabricado_dao {
    public static Vendedor_dao_JDBC createVendedorDao(){
        return new Vendedor_dao_JDBC() ;
    }
}

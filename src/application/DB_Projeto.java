package application;

import Model.DAO.Fabrica_dao;
import Model.DAO.impl.Vendedor_dao_JDBC;
import Model.entities.Departamento;
import Model.entities.Vendedor;
import db.DB;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DB_Projeto {
    public static void main(String[] args) {
        
        Connection con = DB.getConnection();
        
        
        System.out.println("--- Teste 1 ---");
        Vendedor_dao_JDBC vendedor = Fabrica_dao.createVendedorDao(con);
        System.out.println(vendedor.findById(3));
        
        System.out.println("--- Teste 2 ---");
        Departamento dep = new Departamento(4, null);
        List<Vendedor> list = vendedor.findByDepartamento(dep);
        
        for (Vendedor v : list) {
            System.out.println(v);
        }
    }

}

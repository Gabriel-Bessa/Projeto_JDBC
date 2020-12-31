package application;

import Model.DAO.Fabrica_dao;
import Model.DAO.Vendedor_dao;
import Model.entities.Departamento;
import Model.entities.Vendedor;
import db.DB;
import java.sql.Connection;
import java.util.List;

public class DB_Projeto {

    public static void main(String[] args) {

        Connection con = DB.getConnection();

        System.out.println("--- Teste 1 ---");
        Vendedor_dao vendedor_dao = Fabrica_dao.createVendedorDao(con);
        System.out.println(vendedor_dao.findById(3));

        System.out.println("--- Teste 2 ---");
        Departamento dep = new Departamento(4, null);
        List<Vendedor> list = vendedor_dao.findByDepartamento(dep);
        for (Vendedor v : list) {
            System.out.println(v);
        }
        
        System.out.println("--- Teste 3 ---");
        List<Vendedor> listAll = vendedor_dao.findAll();
        for (Vendedor v : listAll) {
            System.out.println(v);
        }
    }

}

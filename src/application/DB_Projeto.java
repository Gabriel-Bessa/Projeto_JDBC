package application;

import Model.DAO.Fabrica_dao;
import Model.DAO.Vendedor_dao;
import Model.entities.Departamento;
import Model.entities.Vendedor;
import db.DB;
import java.sql.Connection;
import java.util.Date;
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
        
        System.out.println("--- Teste 4 ---");
        Vendedor novovend = new Vendedor(null, "Greg", "Greg@gmail.com", new Date(), 2000.00, new Departamento(2, null));
        vendedor_dao.insert(novovend);
        System.out.println("Novo Vendedor! ID: " +novovend.getId());
<<<<<<< HEAD
        
        System.out.println("--- Teste 5 ---");
        Vendedor v3 = vendedor_dao.findById(1);
        v3.setNome("Cristiano Ronaldo");
        vendedor_dao.update(v3);
        System.out.println("Atualizado");
=======
>>>>>>> 167ad38f54f40d06039ccd2644abdd1bac0662be
    }

}

package application;

import Model.DAO.Departamento_dao;
import Model.DAO.Fabrica_dao;
import Model.entities.Departamento;
import db.DB;
import java.sql.Connection;
import java.util.Scanner;

public class DB_Projeto {

    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        Connection con = DB.getConnection();

        System.out.println("--- Teste 1 ---");
        Departamento_dao dep = Fabrica_dao.createDepartmentDao(con);
        Departamento depart = new Departamento();
        depart.setNome("Comida");
        dep.insert(depart);
        System.out.println("ID: "  + depart.getId());
        System.out.println("Inserido com sucesso!");
        sc.close();
    }

}

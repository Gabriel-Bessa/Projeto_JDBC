package application;

import Model.entities.Departamento;
import Model.entities.Vendedor;
import java.util.Date;

public class DB_Projeto {
    public static void main(String[] args) {
        
        Departamento dp = new Departamento(1, "Books");
        
        Vendedor sl = new Vendedor(1, "Gabriel", "bessagabriel490@gmai.com", new Date(), 3000.00, dp);
        
        System.out.println(dp);
        System.out.println(sl);
    }

}

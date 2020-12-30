package Model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private String email;
    private Date DataNacimento;
    private Double SalarioBase;
    private Departamento depart;

    public Vendedor() {
    }

    public Vendedor(Integer id, String nome, String email, Date DataNacimento, Double SalarioBase, Departamento depart) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.DataNacimento = DataNacimento;
        this.SalarioBase = SalarioBase;
        this.depart = depart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNacimento() {
        return DataNacimento;
    }

    public void setDataNacimento(Date DataNacimento) {
        this.DataNacimento = DataNacimento;
    }

    public Double getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(Double SalarioBase) {
        this.SalarioBase = SalarioBase;
    }

    public Departamento getDepart() {
        return depart;
    }

    public void setDepart(Departamento depart) {
        this.depart = depart;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.DataNacimento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendedor other = (Vendedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.DataNacimento, other.DataNacimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seller{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", DataNacimento=" + DataNacimento + ", SalarioBase=" + SalarioBase + ", depart=" + depart + '}';
    }
    
    
    
    
}

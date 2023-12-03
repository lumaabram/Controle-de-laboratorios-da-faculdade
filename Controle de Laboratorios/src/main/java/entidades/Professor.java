package entidades;

import java.util.List;

public class Professor {

   
    private long id;
    private String nome;
    private boolean status;
    private Departamento departamento;
    private List<Disciplina> pdisciplinas;

    public Professor(boolean ativo, long id, String nome, Departamento departamento, List<Disciplina> pdisciplinas) {
        this.status = ativo;
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.pdisciplinas = pdisciplinas;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Disciplina> getPdisciplinas() {
        return pdisciplinas;
    }

    public void setPdisciplinas(List<Disciplina> pdisciplinas) {
        this.pdisciplinas = pdisciplinas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean ativo) {
        this.status = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 // Sobrescrita do método toString para fornecer uma representação de string da classe
    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", departamento=" + departamento +
                ", pdisciplinas=" + pdisciplinas +
                '}';
    }
}
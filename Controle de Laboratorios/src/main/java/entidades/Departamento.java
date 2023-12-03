package entidades;

public class Departamento {                                     
    private long id;
    private String sigla;
    private String descricao;
    private boolean status;


    public Departamento(long id, String sigla, String descricao, boolean status) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
        this.status = status;
    }

 // Método para verificar o status do departamento
    public boolean isStatus() {
        return status;
    }

 // Método para definir o status do departamento
    public void setStatus(boolean status) {
        this.status = status;
    }

 // Método para obter a descrição do departamento
    public String getDescricao() {
        return descricao;
    }

 // Método para definir a descrição do departamento
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

 // Método para obter o ID do departamento
    public long getId() {
        return id;
    }
    
 // Método para definir o ID do departamento
    public void setId(long id) {
        this.id = id;
    }

 // Método para obter a sigla do departamento
    public String getSigla() {
        return sigla;
    }
    
    // Método para definir a sigla do departamento
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
   
   // Sobrescrita do método toString para fornecer uma representação de string da classe
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }
}
package entidades;

public class Laboratorio {                                
	private int id;
    private String descricao;
    private int capacidade;
    private boolean status;                             


    public Laboratorio(int id, String descricao, int capacidade, boolean status) {  
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.status = status;
    }

    public int getCapacidade() {              
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
 // Sobrescrita do método toString para fornecer uma representação de string da classe
    public String toString() {                         
        return "Laboratorio[id=" + id + ", descricao=" + descricao + ", capacidade=" + capacidade + ", status=" + status + "]";
    }
}



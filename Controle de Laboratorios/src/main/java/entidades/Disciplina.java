package entidades;
public class Disciplina {

    

    private String sigla;
    private String descricao;
    private long id;
    private boolean status;

    
    public Disciplina(String sigla, String descricao, long id, boolean status) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.id = id;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setAtiva(boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    // Sobrescrita do método toString para fornecer uma representação de string da classe
    @Override
    public String toString() {
        return "Disciplina{" +
                " sigla='" + sigla + '\'' +
                "}";
    }
}

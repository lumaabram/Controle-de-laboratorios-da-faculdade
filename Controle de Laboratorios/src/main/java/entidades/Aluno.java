package entidades;


public class Aluno {
	
    
    private long id;
    private String nome;
    private String matricula;
    private boolean status;

    public Aluno(long id, String nome, String matricula, boolean status) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.status = status;
    }

 // Método para obter o status do aluno
    public boolean getStatus() {
        return status;
    }

 // Método para definir o status do aluno
    public void setStatus(boolean status) {
        this.status = status;
    }

 // Método para obter o ID do aluno
    public long getId() {
        return id;
    }

 // Método para definir o ID do aluno
    public void setId(long id) {
        this.id = id;
    }

 // Método para obter a matrícula do aluno
    public String getMatricula() {
        return matricula;
    }

 // Método para definir a matrícula do aluno
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

 // Método para obter o nome do aluno
    public String getNome() {
        return nome;
    }
 // Método para definir o nome do aluno
    public void setNome(String nome) {
        this.nome = nome;
    }

   // Sobrescrita do método toString para fornecer uma representação de string da classe
    @Override
    public String toString() {
        return "Aluno{" +
                " nome='" + nome + '\'' +
                '}';
    }
}

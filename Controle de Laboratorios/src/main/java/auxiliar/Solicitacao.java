package auxiliar;

import java.time.*;
import java.util.Set;

import entidades.*;

import java.util.HashSet;
import java.util.Random;
public class Solicitacao {

	
// Armazena IDs já utilizados, garantindo IDs unicos  
private static Set<Integer> idsUtilizados = new HashSet<>();
    
    private int id;
    private Laboratorio laboratorio;
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private LocalDateTime dataHora;
    private Duration tempo;

    //criação de uma nova Solicitacao
    public Solicitacao(Laboratorio laboratorio, Professor professor, Disciplina disciplina,
                       Set<Aluno> alunos, LocalDateTime dataHora, Duration tempo) {
        this.id = gerarIdUnico();
        this.laboratorio = laboratorio;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new HashSet<>(alunos);
        this.dataHora = dataHora;
        this.tempo = tempo;
    }

    //inicializar a lista de alunos
    public Solicitacao() {
        this.alunos = new HashSet<>();
    }

 //Gerar um ID único
    private int gerarIdUnico() {
        Random random = new Random();
        int id;

        do {
            id = 10000 + random.nextInt(90000);
        } while (idsUtilizados.contains(id));

        idsUtilizados.add(id);
        return id;
    }

    public int getId() {
        return id;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Set<Aluno> getAlunos() {
        return new HashSet<>(alunos);
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = new HashSet<>(alunos);
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Duration getTempo() {
        return tempo;
    }

    public void setTempo(Duration tempo) {
        this.tempo = tempo;
    }

    //Formatar a duração em horas e minutos
    private String formatarDuracao(Duration duration) {
        long horas = duration.toHours();
        long minutos = duration.toMinutesPart();

        return String.format("%d horas e %d minutos", horas, minutos);
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", laboratorio=" + laboratorio +
                ", professor=" + professor +
                ", disciplina=" + disciplina +
                ", alunos=" + alunos +
                ", data='" + dataHora + '\'' +
                ", tempo=" + formatarDuracao(tempo) +
                '}';
    }
}
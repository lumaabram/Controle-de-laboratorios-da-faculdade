package auxiliar;


import BaseDeDados.Base;
import entidades.*;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SolicitarLaboratorio {

    private Scanner scanner;
    private List<Laboratorio> laboratorios;
    private List<Disciplina> disciplinas;
    private List<Departamento> departamentos;
    private List<Professor> professores;

    public SolicitarLaboratorio(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas,
                                List<Departamento> departamentos, List<Professor> professores) {
        this.scanner = scanner;
        this.laboratorios = laboratorios;
        this.disciplinas = disciplinas;
        this.departamentos = departamentos;
        this.professores = professores;
    }

    //solicitar uma reserva de laboratório
    public Solicitacao solicitarLab() throws ParseException {
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setLaboratorio(obterLaboratorioPorDescricao());

        System.out.println("Informe o nome do professor responsavel:");
        solicitacao.setProfessor(obterProfessorPorNome());

        System.out.println("Informe a sigla da disciplina:");
        String siglaDisciplina = scanner.next();
        solicitacao.setDisciplina(obterDisciplinaPorSigla(siglaDisciplina));

        System.out.println("Informe a partir de qual posicao (id) na lista de alunos voce quer a lista:");
        int inicio = scanner.nextInt();
        solicitarAlunos(solicitacao, inicio);

        solicitarDataHora(solicitacao);

        System.out.println("Informe por quanto tempo (minutos) deseja reservar o laboratorio:");
        long minutos = scanner.nextLong();
        solicitarTempo(solicitacao, minutos);

        exibirRevisao(solicitacao);
        return solicitacao;
    }

    //obter um laboratório por descrição
    private Laboratorio obterLaboratorioPorDescricao() {
        System.out.print("Informe qual laboratorio deseja reservar (ex: lami1):");
        String descricao = scanner.next();
        return laboratorios.stream()
                .filter(lab -> lab.getDescricao().equalsIgnoreCase(descricao))
                .findFirst()
                .orElse(null);
    }

    //obter um professor por nome
    private Professor obterProfessorPorNome() {
        String nome = scanner.next();
        return professores.stream()
                .filter(professor -> professor.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    //obter uma disciplina por sigla
    public Disciplina obterDisciplinaPorSigla(String sigla) {
        for (Professor professor : professores) {
            for (Disciplina disciplina : professor.getPdisciplinas()) {
                if (disciplina.getSigla().equals(sigla)) {
                    return disciplina;
                }
            }
        }
        return null;
    }

    //solicitar a lista de alunos
    private void solicitarAlunos(Solicitacao solicitacao, int inicio) {
    	Base bd = new Base();
        List<Aluno> alunos = bd.getAlunos(solicitacao.getLaboratorio().getCapacidade(), inicio);
        alunos.sort(Comparator.comparing(Aluno::getNome));
        Set<Aluno> turma = new LinkedHashSet<>(alunos);
        solicitacao.setAlunos(turma);
        System.out.println(turma);
        System.out.println();
    }

    //solicitar data e hora
    private void solicitarDataHora(Solicitacao solicitacao) {
    	scanner.nextLine();
    	
    	System.out.print("Informe a data (dd/MM/yy): ");
        String dataString = scanner.next();
        LocalDate data = obterDataValida(dataString);

        System.out.print("Informe a hora (HH:mm): ");
        String horaString = scanner.next();
        LocalTime hora = obterHoraValida(horaString);

        LocalDateTime dataHora = LocalDateTime.of(data, hora);
        solicitacao.setDataHora(dataHora);
        System.out.println("Data e hora definidas com sucesso: " + dataHora);
    }

    private LocalDate obterDataValida(String dataString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        try {
            return LocalDate.parse(dataString, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data invalido. Certifique-se de usar o formato dd/MM/yy.");
            return obterDataValida(scanner.next());  
        }
    }

    //obter uma hora válida
    private LocalTime obterHoraValida(String horaString) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            return LocalTime.parse(horaString, timeFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora invalido. Certifique-se de usar o formato HH:mm.");
            return obterHoraValida(scanner.next());  	
        }
    }

    //solicitar a duração da reserva
    private void solicitarTempo(Solicitacao solicitacao, long minutos) {
        Duration duration = Duration.ofMinutes(minutos);
        solicitacao.setTempo(duration);
    }

    //exibir uma revisão da solicitação
    private void exibirRevisao(Solicitacao solicitacao) {
        System.out.println("Aqui esta a revisao da sua solicitacao:");
        System.out.println(solicitacao);
    }
}
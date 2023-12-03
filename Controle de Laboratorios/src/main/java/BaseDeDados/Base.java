package BaseDeDados;

import auxiliar.Reserva;
import entidades.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Base implements IBase {

	 // Constantes para definir a quantidade de professores, departamentos e laboratórios
	private final int QTDE_PROFESSORES = 15;
    private final int QTDE_DEPARTAMENTOS = 3;
    private final int QTDE_LABORATORIOS = 15;

 // Listas para armazenar informações sobre laboratórios, departamentos, professores, disciplinas e alunos
    private List<Laboratorio> laboratorios = new ArrayList<>();
    private List<Departamento> departamentos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public Base() { // Construtor que inicializa os dados
        
        inicializarLaboratorios();
        inicializarDepartamentos();
        inicializarDisciplinas();
        inicializarProfessores();
        inicializarAlunos();
    }

 // ... (código para inicializar laboratórios)
    private void inicializarLaboratorios() {
        for (int i = 1; i <= QTDE_LABORATORIOS; i++) {
            int capacidade = (i == 1 || i == 10) ? 30 : (i >= 2 && i <= 7) ? 20 : 15;
            laboratorios.add(new Laboratorio(i, "LAMI" + i, capacidade, true));
        }
    }

 // ... (código para inicializar laboratórios)
    private void inicializarDepartamentos() {
        departamentos.add(new Departamento(1, "ES", "Engenharia de Software", true));
        departamentos.add(new Departamento(2, "CAD", "Computação de Alto Desempenho", true));
        departamentos.add(new Departamento(3, "IC", "Infraestrutura Computacional", true));
    }

 // ... (código para inicializar disciplinas)
    private void inicializarDisciplinas() {
        disciplinas.add(new Disciplina("BES005", "LÓGICA DE PROGRAMAÇÃO E ALGORITMOS", 1, true));
        disciplinas.add(new Disciplina("BES006", "ESTRUTURA DE DADOS", 2, true));
        disciplinas.add(new Disciplina("BES008", "PROGRAMAÇÃO ORIENTADA A OBJETOS", 3, true));
        disciplinas.add(new Disciplina("BES011", "BANCOS DE DADOS", 4, true));
        disciplinas.add(new Disciplina("BES012", "ENGENHARIA DE REQUISITOS", 5, true));
        disciplinas.add(new Disciplina("BES020", "PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS", 6, true));
        disciplinas.add(new Disciplina("BES026", "SISTEMAS DISTRIBUÍDOS", 7, true));
        disciplinas.add(new Disciplina("BES038", "INTELIGÊNCIA ARTIFICIAL", 8, true));
        disciplinas.add(new Disciplina("BES049", "PROGRAMAÇÃO WEB", 9, true));
        disciplinas.add(new Disciplina("BES048", "PROGRAMAÇÃO FRONT END", 10, true));
        
    }
 
 // ... (código para inicializar professores)
    private void inicializarProfessores() {
        for (int i = 1; i <= QTDE_PROFESSORES; i++) {
            Departamento dep = (i >= 1 && i <= 10) ? departamentos.get(0) :
                    (i >= 11 && i <= 14) ? departamentos.get(1) :
                            departamentos.get(2);

            ArrayList<Disciplina> pdisciplinas = obterPdisciplinasParaProfessor(i);

            Professor prof = new Professor(true, i + 0, "Professor" + i, dep, pdisciplinas);
            professores.add(prof);
        }
    }
    
    // ... (Lista para obter disciplinas para professores)
    private ArrayList<Disciplina> obterPdisciplinasParaProfessor(int i) {
        ArrayList<Disciplina> pdisciplinas = new ArrayList<>();
        if (i >= 1 && i <= 10) {
            if (disciplinas.size() > 0) pdisciplinas.add(disciplinas.get(0));
            if (disciplinas.size() > 5) pdisciplinas.add(disciplinas.get(5));
            if (disciplinas.size() > 3) pdisciplinas.add(disciplinas.get(3));
        } else if (i >= 11 && i <= 14) {
            if (disciplinas.size() > 2) pdisciplinas.add(disciplinas.get(2));
            if (disciplinas.size() > 4) pdisciplinas.add(disciplinas.get(4));
            if (disciplinas.size() > 1) pdisciplinas.add(disciplinas.get(1));
            if (disciplinas.size() > 8) pdisciplinas.add(disciplinas.get(8));
        } else {
            if (disciplinas.size() > 10) pdisciplinas.add(disciplinas.get(10));
            if (disciplinas.size() > 9) pdisciplinas.add(disciplinas.get(9));
            if (disciplinas.size() > 7) pdisciplinas.add(disciplinas.get(7));
        }
        
        return pdisciplinas;
    }

    private void inicializarAlunos() {
        alunos.addAll(getAlunos(100, 0));
    }

    @Override // Implementação do método da interface para obter laboratórios
    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    @Override // Implementação do método da interface para obter departamentos
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    
    @Override  // Implementação do método da interface para obter professores
    public List<Professor> getProfessores() {
        return professores;
    }

    
    @Override // Implementação do método da interface para obter disciplinas
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override // Implementação do método da interface para obter alunos com base em quantidade e início
    public List<Aluno> getAlunos(int qtde, int inicio) {
    	List<Aluno> alunos = new ArrayList<>();
        for (int i = inicio; i < inicio + qtde; i++) {
            alunos.add(new Aluno(i + 1, "Aluno" + (i + 1), "202320" + i, true));
        }
        Collections.sort(alunos, Comparator.comparing(Aluno::getId));

        return alunos;
    }

 // Método específico para obter uma lista padrão de alunos
    public List<Aluno> Alunos() {
        return getAlunos(100, 0);
    }

 // Método para imprimir informações da base de dados
    public void BasePrint() {
        System.out.println("Disciplinas: " + disciplinas);
        System.out.println("Professores: " + professores);
        System.out.println("Departamentos: " + departamentos);
    }
}

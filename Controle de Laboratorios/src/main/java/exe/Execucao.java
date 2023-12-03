package exe;

import BaseDeDados.Base;
import auxiliar.*;
import entidades.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Execucao {

    public static void main(String[] args) throws ParseException {
    	
    	Base bd = new Base(); // Instância da classe Base para acessar os dados da universidade
       
    	// Listas para armazenar informações sobre laboratórios, disciplinas, departamentos, professores e alunos
    	List<Laboratorio> laboratorios = bd.getLaboratorios();
        List<Disciplina> disciplinas = bd.getDisciplinas();
        List<Departamento> departamentos = bd.getDepartamentos();
        List<Professor> professores = bd.getProfessores();
        List<Aluno> alunos = bd.Alunos();

     // Scanner para entrada de dados pelo usuário
        Scanner ler = new Scanner(System.in);

     // Mensagem de boas-vindas
        System.out.println("Seja bem-vindo ao servico de reservas de laboratorios.");
        System.out.println();
        String answer;
        
     // Instância da classe Reservas para gerenciar as reservas
        Reservas reservas = new Reservas();
        List<Reserva> listaReservas = reservas.getListaReservas();
        List<Reserva> listaAprovadas = reservas.getListaAprovadas();
        int reservaID = gerarIdUnico(); // Geração de um ID único para cada reserva

     // Loop para interação com o usuário
        do { // Menu de opções
            System.out.println("O que voce gostaria de fazer?");
            System.out.println("- Solicitar laboratorio");
            System.out.println("- Exibir base de dados da universidade");
            System.out.println("- Finalizar atendimento");

         // Leitura da escolha do usuário
            String escolha = ler.nextLine().toLowerCase(); 

         // Estrutura de switch para lidar com as diferentes opções
            switch (escolha) {
                case "solicitar laboratorio": // Solicitação de laboratório
                    SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(ler, laboratorios, disciplinas, departamentos, professores);
                    Solicitacao solicitacao = solicitarLaboratorio.solicitarLab();
                    System.out.println("Gostaria de continuar com a reserva? (sim/nao)");
                    String res1 = ler.next();

                    if (res1.equalsIgnoreCase("sim")) { // Validação da solicitação e criação da reserva
                        ValidarSolicitacao validacao = new ValidarSolicitacao();
                        boolean aprovacao = validacao.existenciaDeConflitos(solicitacao, listaAprovadas);
                        LocalDateTime hojeAgora = LocalDateTime.now();
                        Reserva novaReserva = new Reserva(solicitacao, aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(), solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);
                        novaReserva.setId(reservaID);
                        novaReserva.processarReserva(novaReserva, listaReservas, listaAprovadas);
                        System.out.println("Lista geral de reservas: " + listaReservas);
                        reservaID++;
                    } else {
                        System.out.println();
                    }
                    break;

                case "exibir base de dados da universidade":
                	// Exibição da base de dados da universidade
                    System.out.println("Base de dados da UCSAL: ");
                    bd.BasePrint();
                    break;

                case "finalizar atendimento":
                	// Mensagem de finalização do atendimento
                    System.out.println("Atendimento finalizado");
                    break;

                default:
                	// Mensagem para escolha inválida
                    System.out.println("Opção invalida. Por favor, escolha novamente.");
            }

         // Pergunta se o usuário deseja realizar uma nova solicitação e reserva
            System.out.println("Deseja realizar uma nova solicitacao e reserva? (sim/nao)");
            answer = ler.next();
            ler.nextLine(); 

        } while (answer.equalsIgnoreCase("sim"));

     // Mensagem de encerramento do atendimento
        System.out.println("Fim do atendimento");

     // Fechamento do objeto Scanner para evitar vazamentos de recursos
        ler.close();
    }

 // Método para processar uma solicitação e criar uma reserva
    private static void processarSolicitacao(Scanner scanner, List<Laboratorio> laboratorios, List<Disciplina> disciplinas,
                                             List<Departamento> departamentos, List<Professor> professores,
                                             List<Reserva> listaAprovadas, List<Reserva> listaReservas, int reservaID) throws ParseException {
        SolicitarLaboratorio solicitarLaboratorio = new SolicitarLaboratorio(scanner, laboratorios, disciplinas, departamentos, professores);
        Solicitacao solicitacao = solicitarLaboratorio.solicitarLab();
        System.out.println("Deseja prosseguir com a reserva? (sim/nao)");
        String res1 = scanner.next();

        if (res1.equalsIgnoreCase("sim")) {
            ValidarSolicitacao validacao = new ValidarSolicitacao();
            boolean aprovacao = validacao.existenciaDeConflitos(solicitacao, listaAprovadas);
            LocalDate hoje = LocalDate.now();
            LocalDateTime hojeAgora = hoje.atTime(LocalTime.now());
            Reserva novaReserva = new Reserva(solicitacao, aprovacao, solicitacao.getDataHora(), solicitacao.getTempo(),
                    solicitacao.getProfessor(), solicitacao.getDisciplina(), hojeAgora);
            novaReserva.setId(reservaID);
            novaReserva.processarReserva(novaReserva, listaReservas, listaAprovadas);
            System.out.println("Lista de Reservas Geral: " + listaReservas);
            reservaID++;
        } else {
            System.out.println();
        }
    }
    
    // Método para gerar um ID único para cada reserva
    private static int gerarIdUnico() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }
    
}
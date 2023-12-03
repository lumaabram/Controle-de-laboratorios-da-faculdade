package auxiliar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import entidades.Disciplina;
import entidades.Professor;
public class Reserva implements IReserva {

	private static int contadorId = 0;

    private int id;
    private Solicitacao solicitacao;
    private SituacaoReserva situacaoReserva;
    private LocalDateTime diaHoraReserva;
    private Duration duracao;
    private Professor professor;
    private Disciplina disciplina;
    private LocalDateTime dataLiberacao;

    public Reserva(Solicitacao solicitacao, boolean valido, LocalDateTime diaHora, Duration duracao,
                   Professor professor, Disciplina disciplina, LocalDateTime dataLiberacao) {
        this.id = gerarIdUnico();
        this.solicitacao = solicitacao;
        this.situacaoReserva = (valido) ? SituacaoReserva.APROVADA : SituacaoReserva.REPROVADA;
        this.diaHoraReserva = diaHora;
        this.duracao = duracao;
        this.professor = professor;
        this.disciplina = disciplina;
        this.dataLiberacao = dataLiberacao;
    }

    public static int getContadorId() {
		return contadorId;
	}

	public static void setContadorId(int contadorId) {
		Reserva.contadorId = contadorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public SituacaoReserva getSituacaoReserva() {
		return situacaoReserva;
	}

	public void setSituacaoReserva(SituacaoReserva situacaoReserva) {
		this.situacaoReserva = situacaoReserva;
	}

	public LocalDateTime getDiaHoraReserva() {
		return diaHoraReserva;
	}

	public void setDiaHoraReserva(LocalDateTime diaHoraReserva) {
		this.diaHoraReserva = diaHoraReserva;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
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
	
	public LocalDateTime getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDateTime dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	//Gerar IDs únicos
	private static int gerarIdUnico() {
        Random random = new Random();
        return random.nextInt(90000);
    }
	
	// Implementação do método processarReserva da interface IReserva
    @Override
    public void processarReserva(Reserva reserva, List<Reserva> listaReservas, List<Reserva> listaAprovadas) {
        listaReservas.add(reserva);
        if (reserva.getSituacaoReserva() == SituacaoReserva.APROVADA) {
            listaAprovadas.add(reserva);
        }
    }

    // Sobrescrita do método toString para obter uma representação textual da reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", situacao=" + situacaoReserva +
                ", solicitacao=" + solicitacao +
                ", diaDaReserva='" + diaHoraReserva + '\'' +
                ", duracao=" + duracao +
                '}';
    }
}

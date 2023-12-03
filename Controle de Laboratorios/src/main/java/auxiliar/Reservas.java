package auxiliar;
import java.util.ArrayList;
import java.util.List;

public class Reservas {

	private List<Reserva> listaReservas = new ArrayList<>();
    private List<Reserva> listaAprovadas = new ArrayList<>();

    //obter uma cópia da lista de reservas aprovadas
    public List<Reserva> getListaAprovadas() {
        return new ArrayList<>(listaAprovadas);
    }

    //obter uma cópia da lista de todas as reservas
    public List<Reserva> getListaReservas() {
        return new ArrayList<>(listaReservas);
    }

    //adicionar uma reserva à lista
    public void adicionarReserva(Reserva reserva) {
        listaReservas.add(reserva);
        if (reserva.getSituacaoReserva() == SituacaoReserva.APROVADA) {
            listaAprovadas.add(reserva);
        }
    }
}

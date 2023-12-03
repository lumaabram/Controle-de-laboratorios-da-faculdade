package auxiliar;

import java.util.List;

public interface IReserva {

	//Processar uma reserva
    void processarReserva(Reserva reserva, List<Reserva> listaReservas, List<Reserva> listaAprovadas);
}

package auxiliar;

import java.time.LocalDateTime;
import java.util.List;

public class ValidarSolicitacao {

    private boolean validado = true;

    //verificar se a nova solicitação possui conflitos com reservas existentes
    public boolean existenciaDeConflitos(Solicitacao novaSolicitacao, List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (checarConflitoEntreSolicitacoes(novaSolicitacao, reserva.getSolicitacao())) {
                validado = false;
                break;  
            }
        }

        showResults();
        return validado;
    }

    //verificar se há conflito entre duas solicitações
    private boolean checarConflitoEntreSolicitacoes(Solicitacao novaSolicitacao, Solicitacao existente) {
        LocalDateTime inicioNovaSolicitacao = novaSolicitacao.getDataHora();
        LocalDateTime fimNovaSolicitacao = inicioNovaSolicitacao.plus(novaSolicitacao.getTempo());

        LocalDateTime inicioReservaExistente = existente.getDataHora();
        LocalDateTime fimReservaExistente = inicioReservaExistente.plus(existente.getTempo());

     // Verificar se há sobreposição de tempo entre as duas solicitações
        return !fimNovaSolicitacao.isBefore(inicioReservaExistente) && !inicioNovaSolicitacao.isAfter(fimReservaExistente);
    }

    //exibir os resultados da validação
    private void showResults() {
        if (validado) {
            System.out.println("Solicitacao aprovada.");
        } else {
            System.out.println("Solicitacao recusada devido a conflitos.");
        }
    }

    //verificar se a solicitação foi permitida
    public boolean isPermitido() {
        return validado;
    }
}
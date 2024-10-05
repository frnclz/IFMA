package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Aluguel;
import ifma.edu.imobiliaria.model.Locacao;
import ifma.edu.imobiliaria.repository.AluguelRepository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class PagamentoService {
    public BigDecimal calcularValorPago(Locacao locacao, Date dataPagamento) {
        BigDecimal valorAluguel = locacao.getValorAluguel();
        int diaVencimento = locacao.getDiaVencimento();
        Date dataInicio = locacao.getDataInicio();

        // Calcular a data de vencimento do aluguel no mês corrente
        Date dataVencimento = calcularDataVencimento(dataInicio, diaVencimento);

        if (dataPagamento.before(dataVencimento)) {
            return valorAluguel;
        }

        long diasAtraso = (dataPagamento.getTime() - dataVencimento.getTime()) / (1000 * 60 * 60 * 24);
        BigDecimal percentualMulta = locacao.getPercentualMulta();
        BigDecimal multa = valorAluguel.multiply(percentualMulta).multiply(BigDecimal.valueOf(diasAtraso)).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP);
        multa = multa.min(valorAluguel.multiply(BigDecimal.valueOf(0.20))); // Limita a 20%

        return valorAluguel.add(multa);
    }

    private Date calcularDataVencimento(Date dataInicio, int diaVencimento) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicio);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, diaVencimento);

        if (calendar.getTime().before(dataInicio)) {
            calendar.add(Calendar.MONTH, 1);
        }

        return calendar.getTime();
    }
}

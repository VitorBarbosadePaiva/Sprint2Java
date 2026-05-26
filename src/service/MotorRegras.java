package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class MotorRegras {

    public List<RelatorioPrioridade> gerarRelatorioPrioridade(List<TrechoRodovia> trechos) {
        List<RelatorioPrioridade> relatorio = new ArrayList<>();

        for (TrechoRodovia trecho : trechos) {
            if (trecho.isTemIoT()) {
                trecho.transmitirDadosSensor();
            }

            String prioridade = calcularPrioridade(trecho);
            String tipoIntervencao = decidirTipoIntervencao(trecho);

            relatorio.add(new RelatorioPrioridade(trecho, prioridade, tipoIntervencao));
        }
        return relatorio;
    }

    private String calcularPrioridade(TrechoRodovia trecho) {
        if (trecho.getNivelVegetacao() >= 80) return "ALTA";
        if (trecho.getNivelVegetacao() >= 50) return "MÉDIA";
        return "BAIXA";
    }

    private String decidirTipoIntervencao(TrechoRodovia trecho) {
        if (trecho.getNivelVegetacao() >= 75) return "ROCADA MECÂNICA";
        if (trecho.getNivelVegetacao() >= 45) return "PULVERIZAÇÃO";
        return "MONITORAMENTO";
    }
}
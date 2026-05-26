package service;

import model.TrechoRodovia;

public record RelatorioPrioridade(
        TrechoRodovia trecho,
        String prioridade,
        String tipoRecomendado
) {
    @Override
    public String toString() {
        return String.format("🚩 %s | Prioridade: %s | Intervenção: %s", 
                trecho, prioridade, tipoRecomendado);
    }
}
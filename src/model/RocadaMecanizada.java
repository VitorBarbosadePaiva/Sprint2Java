package model;

public class RocadaMecanizada extends IntervencaoOperacional {
    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("🚜 Realizando roçada MECÂNICA...");
        trecho.nivelVegetacao = Math.max(5, trecho.getNivelVegetacao() - 70);
        registrarIntervencao(trecho, "ROCADA MECÂNICA");
    }
}
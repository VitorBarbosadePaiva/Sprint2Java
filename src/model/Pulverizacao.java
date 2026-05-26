package model;

public class Pulverizacao extends IntervencaoOperacional {
    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("🧪 Realizando PULVERIZAÇÃO...");
        trecho.nivelVegetacao = Math.max(10, trecho.getNivelVegetacao() - 45);
        registrarIntervencao(trecho, "PULVERIZAÇÃO");
    }
}
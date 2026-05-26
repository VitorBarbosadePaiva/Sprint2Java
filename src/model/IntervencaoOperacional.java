package model;

public abstract class IntervencaoOperacional {

    public abstract void executarServico(TrechoRodovia trecho);

    protected void registrarIntervencao(TrechoRodovia trecho, String tipo) {
        System.out.printf("✅ [%s] executada no trecho KM %.1f-%.1f%n", 
                tipo, trecho.getKmInicial(), trecho.getKmFinal());
    }
}
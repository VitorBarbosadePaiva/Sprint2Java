package model;

public class TrechoRodovia implements MonitoravelViaIoT {

    private final double kmInicial;
    private final double kmFinal;
    private String condicaoUmidade;
    private int nivelVegetacao;
    private final boolean temIoT;

    public TrechoRodovia(double kmInicial, double kmFinal, String condicaoUmidade, 
                        int nivelVegetacao, boolean temIoT) {
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.condicaoUmidade = condicaoUmidade;
        this.nivelVegetacao = nivelVegetacao;
        this.temIoT = temIoT;
    }

    public void crescerVegetacao() {
        int taxa = switch (condicaoUmidade.toLowerCase()) {
            case "molhado" -> 25;
            case "umido" -> 18;
            case "seco" -> 10;
            default -> 12;
        };
        this.nivelVegetacao = Math.min(100, this.nivelVegetacao + taxa);
    }

    @Override
    public void transmitirDadosSensor() {
        if (temIoT) {
            System.out.printf("📡 IoT - KM %.1f-%.1f | Umidade: %s | Vegetação: %d%%%n",
                    kmInicial, kmFinal, condicaoUmidade, nivelVegetacao);
        }
    }

    public double getKmInicial() { return kmInicial; }
    public double getKmFinal() { return kmFinal; }
    public String getCondicaoUmidade() { return condicaoUmidade; }
    public int getNivelVegetacao() { return nivelVegetacao; }
    public boolean isTemIoT() { return temIoT; }

    @Override
    public String toString() {
        return String.format("KM %.1f-%.1f | %s | Vegetação: %d%%", 
                kmInicial, kmFinal, condicaoUmidade, nivelVegetacao);
    }
}
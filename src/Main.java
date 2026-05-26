import model.*;
import service.MotorRegras;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE MONITORAMENTO DE RODOVIAS - SPRINT 2 ===\n");

        List<TrechoRodovia> trechos = new ArrayList<>();
        trechos.add(new TrechoRodovia(10.0, 15.0, "umido", 65, true));
        trechos.add(new TrechoRodovia(25.0, 32.0, "seco", 85, false));
        trechos.add(new TrechoRodovia(45.0, 48.0, "molhado", 92, true));
        trechos.add(new TrechoRodovia(60.0, 65.0, "seco", 35, false));

        System.out.println("📈 Simulando crescimento da vegetação:");
        trechos.forEach(TrechoRodovia::crescerVegetacao);

        MotorRegras motor = new MotorRegras();
        var relatorio = motor.gerarRelatorioPrioridade(trechos);

        System.out.println("\n📋 RELATÓRIO DE PRIORIDADE:\n");
        relatorio.forEach(System.out::println);
    }
}
package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class ProcessarBoletos {
    protected static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public final void processar(final URI caminhoArquivo) {
        imprimirBoletos(lerArquivo(caminhoArquivo));
    }

    public final void imprimirBoletos(final List<Boleto> boletos) {
        System.out.println("Boletos");
        System.out.println("----------------------------------------------------------------------------------");
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }

    public abstract List<Boleto> lerArquivo(final URI caminhoArquivo);
}

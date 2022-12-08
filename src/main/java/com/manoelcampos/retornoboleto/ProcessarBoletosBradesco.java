package com.manoelcampos.retornoboleto;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProcessarBoletosBradesco extends ProcessarBoletos {

    @Override
    public List<Boleto> lerArquivo(final URI caminhoArquivo) {
        try (var reader = Files.newBufferedReader(Paths.get(caminhoArquivo.getPath()))) {
            String linha;
            final var listaBoleto = new ArrayList<Boleto>();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            while ((linha = reader.readLine()) != null) {
                var vetor = linha.split(";");
                var boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], dateFormatter));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], dateTimeFormatter));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setMulta(Double.parseDouble(vetor[9]));

                listaBoleto.add(boleto);
            }

            return listaBoleto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

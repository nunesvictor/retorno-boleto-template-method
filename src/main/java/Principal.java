import com.manoelcampos.retornoboleto.ProcessarBoletos;
import com.manoelcampos.retornoboleto.ProcessarBoletosBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessarBoletosBradesco;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        ProcessarBoletos processador = new ProcessarBoletosBancoBrasil();
        URI caminhoArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("Lendo arquivo " + caminhoArquivo + "\n");
        processador.processar(caminhoArquivo);

        System.out.println();
        System.out.println();

        processador = new ProcessarBoletosBradesco();
        caminhoArquivo = Principal.class.getResource("bradesco-1.csv").toURI();
        System.out.println("Lendo arquivo " + caminhoArquivo + "\n");
        processador.processar(caminhoArquivo);
    }
}

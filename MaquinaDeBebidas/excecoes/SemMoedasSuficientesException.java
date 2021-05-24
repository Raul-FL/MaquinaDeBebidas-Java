package excecoes;

public class SemMoedasSuficientesException
extends Exception {
    public SemMoedasSuficientesException() {
    }

    public SemMoedasSuficientesException(String mensagem) {
        super(mensagem);
    }
}


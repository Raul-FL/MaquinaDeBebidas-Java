package excecoes;

public class SinalInvalidoNoTecladoException
extends Exception {
    public SinalInvalidoNoTecladoException() {
    }

    public SinalInvalidoNoTecladoException(String mensagem) {
        super(mensagem);
    }
}


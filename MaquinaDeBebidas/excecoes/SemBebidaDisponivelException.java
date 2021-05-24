package excecoes;

public class SemBebidaDisponivelException
extends Exception {
    public SemBebidaDisponivelException() {
    }

    public SemBebidaDisponivelException(String mensagem) {
        super(mensagem);
    }
}


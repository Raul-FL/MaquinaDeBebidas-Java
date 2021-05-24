package interfaceComUsuario;

import excecoes.SinalInvalidoNoTecladoException;
import interfaceComUsuario.ITeclado;

public class Teclado
implements ITeclado {
    private Integer ultimoBotaoApertado = null;

    public void sinalBotaoCocaCola() {
        this.ultimoBotaoApertado = 0;
    }

    public void sinalBotaoCocaZero() {
        this.ultimoBotaoApertado = 1;
    }

    public void sinalBotaoCocaLight() {
        this.ultimoBotaoApertado = 2;
    }

    public void sinalBotaoSprite() {
        this.ultimoBotaoApertado = 3;
    }

    public void sinalBotaoSpriteZero() {
        this.ultimoBotaoApertado = 4;
    }

    public void sinalBotaoFantaLaranja() {
        this.ultimoBotaoApertado = 5;
    }

    public void sinalBotaoFantaUva() {
        this.ultimoBotaoApertado = 6;
    }

    public void sinalBotaoKuatGuarana() {
        this.ultimoBotaoApertado = 7;
    }

    public void sinalBotaoSchweppes() {
        this.ultimoBotaoApertado = 8;
    }

    public void sinalBotaoSchweppesCitrus() {
        this.ultimoBotaoApertado = 9;
    }

    public void sinalBotaoDevolverDinheiro() {
        this.ultimoBotaoApertado = 100;
    }

    public Integer sinalGetBotaoPressionado() throws SinalInvalidoNoTecladoException {
        if (this.ultimoBotaoApertado == null) {
            return this.ultimoBotaoApertado;
        }
        switch (this.ultimoBotaoApertado) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 100: {
                return this.ultimoBotaoApertado;
            }
        }
        throw new SinalInvalidoNoTecladoException();
    }

    public void sinalSetValorEspecifico(int sinal) {
        this.ultimoBotaoApertado = sinal;
    }
}


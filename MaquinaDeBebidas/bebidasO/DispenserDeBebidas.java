package bebidasO;

import bebidasO.IDispenserDeBebidas;
import excecoes.DispenserDeBebidasEmperradoException;
import excecoes.SemBebidaDisponivelException;
import excecoes.SinalInvalidoNoDispenserDeBebidasException;
import java.util.HashMap;

public class DispenserDeBebidas
implements IDispenserDeBebidas {
    public static final int NENHUMA_BEBIDA = -1;
    private HashMap<Integer, Integer> bebidas = new HashMap();
    private boolean travado = true;
    private boolean aberto = false;
    private boolean emperrado = false;
    private int bebidaLiberada = -1;

    public DispenserDeBebidas(int quantidadeCocaCola, int quantidadeCocaLight, int quantidadeCocaZero, int quantidadeFantaLaranja, int quantidadeFantaUva, int quantidadeKuatGuarana, int quantidadeSchweppes, int quantidadeSchweppesCitrus, int quantidadeSprite, int quantidadeSpriteZero) {
        if (quantidadeCocaCola < 0 || quantidadeCocaLight < 0 || quantidadeCocaZero < 0 || quantidadeFantaLaranja < 0 || quantidadeFantaUva < 0 || quantidadeSpriteZero < 0 || quantidadeSchweppes < 0 || quantidadeSchweppesCitrus < 0 || quantidadeSprite < 0) {
            throw new IllegalArgumentException();
        }
        if (quantidadeCocaCola > 100 || quantidadeCocaLight > 100 || quantidadeCocaZero > 100 || quantidadeFantaLaranja > 100 || quantidadeFantaUva > 100 || quantidadeSpriteZero > 100 || quantidadeSchweppes > 100 || quantidadeSchweppesCitrus > 100 || quantidadeSprite > 100 || quantidadeKuatGuarana > 100) {
            throw new IllegalArgumentException();
        }
        this.bebidas.put(99, quantidadeCocaCola);
        this.bebidas.put(2, quantidadeCocaLight);
        this.bebidas.put(1, quantidadeCocaZero);
        this.bebidas.put(5, quantidadeFantaLaranja);
        this.bebidas.put(6, quantidadeFantaUva);
        this.bebidas.put(7, quantidadeKuatGuarana);
        this.bebidas.put(8, quantidadeSchweppes);
        this.bebidas.put(9, quantidadeSchweppesCitrus);
        this.bebidas.put(3, quantidadeSprite);
        this.bebidas.put(4, quantidadeSpriteZero);
    }

    @Override
    public boolean isDispenserAberto() {
        return this.aberto;
    }

    @Override
    public boolean isDispenserTravado() {
        return this.travado;
    }

    @Override
    public void travarDispenser() throws DispenserDeBebidasEmperradoException {
        if (!this.isDispenserAberto()) {
            this.travado = true;
        }
    }

    @Override
    public void destravarDispenser() throws DispenserDeBebidasEmperradoException {
        if (this.emperrado) {
            throw new DispenserDeBebidasEmperradoException();
        }
        this.travado = false;
    }

    @Override
    public void liberarBebida(int bebida) throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        if (!this.bebidas.containsKey(bebida)) {
            this.bebidaLiberada = -1;
            throw new SinalInvalidoNoDispenserDeBebidasException();
        }
        if (this.bebidas.get(bebida) <= 0) {
            this.bebidaLiberada = -1;
            throw new SemBebidaDisponivelException();
        }
        this.bebidas.put(bebida, this.bebidas.get(bebida) - 1);
        this.bebidaLiberada = bebida;
    }

    public int sinalGetBebidaLiberada() {
        return this.bebidaLiberada;
    }

    public void sinalAbrirPortinha() {
        if (!this.travado) {
            this.aberto = true;
        }
    }

    public void sinalFecharPortinha() {
        this.aberto = false;
    }

    public void sinalEmperrarPortinha() {
        this.emperrado = true;
    }
}


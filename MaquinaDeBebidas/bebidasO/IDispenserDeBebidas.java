package bebidasO;

import excecoes.DispenserDeBebidasEmperradoException;
import excecoes.SemBebidaDisponivelException;
import excecoes.SinalInvalidoNoDispenserDeBebidasException;

public interface IDispenserDeBebidas {
    public static final int COCA_COLA = 99;
    public static final int COCA_ZERO = 1;
    public static final int COCA_LIGHT = 2;
    public static final int SPRITE = 3;
    public static final int SPRITE_ZERO = 4;
    public static final int FANTA_LARANJA = 5;
    public static final int FANTA_UVA = 6;
    public static final int KUAT_GUARANA = 7;
    public static final int SCHWEPPES = 8;
    public static final int SCHWEPPES_CITRUS = 9;

    public boolean isDispenserAberto();

    public boolean isDispenserTravado();

    public void travarDispenser() throws DispenserDeBebidasEmperradoException;

    public void destravarDispenser() throws DispenserDeBebidasEmperradoException;

    public void liberarBebida(int var1) throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException;
}


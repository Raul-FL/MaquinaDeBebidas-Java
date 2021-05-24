package dinheiroIO;

import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemMoedasSuficientesException;

public interface IEntradaEDispenserDeDinheiro {
    public static final int CINCO_CENTAVOS = 5;
    public static final int DEZ_CENTAVOS = 10;
    public static final int VINTE_E_CINCO_CENTAVOS = 25;
    public static final int CINQUENTA_CENTAVOS = 50;
    public static final int UM_REAL = 100;

    public int contarMoedasDeCincoCentavosColocadas();

    public int contarMoedasDeDezCentavosColocadas();

    public int contarMoedasDeVinteECincoCentavosColocadas();

    public int contarMoedasDeCinquentaCentavosColocadas();

    public int contarMoedasDeUmRealColocadas();

    public boolean hasDinheiroColocado();

    public void engolirTodoODinheiroColocado() throws EntradaDeDinheiroEntupidaException;

    public void devolverTodoODinheiroColocado() throws EntradaDeDinheiroEntupidaException;

    public void devolverMoedasDeCincoCentavosComoTroco(int var1) throws SemMoedasSuficientesException, IllegalArgumentException;

    public void devolverMoedasDeDezCentavosComoTroco(int var1) throws SemMoedasSuficientesException, IllegalArgumentException;

    public void devolverMoedasDeVinteECincoCentavosComoTroco(int var1) throws SemMoedasSuficientesException, IllegalArgumentException;

    public void devolverMoedasDeCinquentaCentavosComoTroco(int var1) throws SemMoedasSuficientesException, IllegalArgumentException;

    public void devolverMoedasDeUmRealComoTroco(int var1) throws SemMoedasSuficientesException, IllegalArgumentException;

    public boolean hasMoedasDevolvidasNoDispenser();

    public int contarMoedasDeCincoCentavosNoCofre();

    public int contarMoedasDeDezCentavosNoCofre();

    public int contarMoedasDeVinteECincoCentavosNoCofre();

    public int contarMoedasDeCinquentaCentavosNoCofre();

    public int contarMoedasDeUmRealNoCofre();
}


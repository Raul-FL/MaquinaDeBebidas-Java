package TestesMaquinaBebidas;

import bebidasO.DispenserDeBebidas;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemBebidaDisponivelException;
import excecoes.SemMoedasSuficientesException;
import excecoes.SinalInvalidoNoDispenserDeBebidasException;
import interfaceComUsuario.Teclado;
import org.junit.Test;
import static org.junit.Assert.*;

public class DinheiroJUnitTest {

    public DinheiroJUnitTest() {
    }


@Test
    public void n√£odeveriaDevolverMoedasDispenserAbaixoLimiteMini() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(0);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(0);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(0);
        dinheiro.devolverMoedasDeUmRealComoTroco(0);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(0);
        assertTrue(dinheiro.hasMoedasDevolvidasNoDispenser());
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test
    public void deveriaDevolverMoedasDispenserLimiteMini() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(1, 1, 1, 1, 1);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(1);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(1);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(1);
        dinheiro.devolverMoedasDeUmRealComoTroco(1);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(1);
        assertTrue(dinheiro.hasMoedasDevolvidasNoDispenser());
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test
    public void deveriaDevolverMoedasDispenserLimiteMax() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(30, 30, 30, 30, 30);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(30);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(30);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(30);
        dinheiro.devolverMoedasDeUmRealComoTroco(30);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(30);
        assertTrue(dinheiro.hasMoedasDevolvidasNoDispenser());
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test
    public void naoDeveriaDevolverMoedasDispenserAcimaLimiteMax() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(31, 31, 31, 31, 31);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(31);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(31);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(31);
        dinheiro.devolverMoedasDeUmRealComoTroco(31);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(31);
        assertTrue(dinheiro.hasMoedasDevolvidasNoDispenser());
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test
    public void naoDeveriaDevolverMoedasDispenserLimiteMaxCofre() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(10000, 2000, 2000, 2000, 2000);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(2000);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(2000);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(2000);
        dinheiro.devolverMoedasDeUmRealComoTroco(2000);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(2000);
        assertTrue(dinheiro.hasMoedasDevolvidasNoDispenser());
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test
    public void naoDeveriaDevolverMoedasDispenserAcimaLimiteMaxCofre() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(2001, 2001, 2001, 2001, 2001);
        assertEquals(2000, dinheiro.contarMoedasDeCincoCentavosNoCofre());
       
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test(expected = SemMoedasSuficientesException.class)
    public void semMoedasDisponiveis5Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(1);
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test(expected = SemMoedasSuficientesException.class)
    public void semMoedasDisponiveis10Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(1);
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test(expected = SemMoedasSuficientesException.class)
    public void semMoedasDisponiveis25Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(1);

    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test(expected = SemMoedasSuficientesException.class)
    public void semMoedasDisponiveis50Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(1);
    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test(expected = SemMoedasSuficientesException.class)
    public void semMoedasDisponiveis1Real() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        dinheiro.devolverMoedasDeUmRealComoTroco(1);

    }

    /**
     * @throws SemMoedasSuficientesException
     */
    @Test
    public void deveriaPegarMoedasDispenser() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(1, 1, 1, 1, 1);
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(1);
        dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(1);
        dinheiro.devolverMoedasDeDezCentavosComoTroco(1);
        dinheiro.devolverMoedasDeUmRealComoTroco(1);
        dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(1);
        dinheiro.sinalPegarMoedasDeCincoCentavos();
        dinheiro.sinalPegarMoedasDeDezCentavos();
        dinheiro.sinalPegarMoedasDeVinteECincoCentavos();
        dinheiro.sinalPegarMoedasDeCinquentaCentavos();
        dinheiro.sinalPegarMoedasDeUmReal();
        assertFalse(dinheiro.hasMoedasDevolvidasNoDispenser());
    }

    /**
     * @throws EntradaDeDinheiroEntupidaException
     */
    @Test
    public void deveriaEngolirTodoODinheiroColocado25Moedas() throws EntradaDeDinheiroEntupidaException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        for (int i = 0; i < 5; i++) {
            dinheiro.sinalColocarMoedaDeCincoCentavos();
            dinheiro.sinalColocarMoedaDeDezCentavos();
            dinheiro.sinalColocarMoedaDeVinteECincoCentavos();
            dinheiro.sinalColocarMoedaDeCinquentaCentavos();
            dinheiro.sinalColocarMoedaDeUmReal();
        }
        dinheiro.engolirTodoODinheiroColocado();

    }

    /**
     * @throws EntradaDeDinheiroEntupidaException
     */
    @Test
    public void deveriaEngolirTodoODinheiroColocado30Moedas() throws EntradaDeDinheiroEntupidaException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        for (int i = 0; i < 6; i++) {
            dinheiro.sinalColocarMoedaDeCincoCentavos();
            dinheiro.sinalColocarMoedaDeDezCentavos();
            dinheiro.sinalColocarMoedaDeVinteECincoCentavos();
            dinheiro.sinalColocarMoedaDeCinquentaCentavos();
            dinheiro.sinalColocarMoedaDeUmReal();
        }
        dinheiro.engolirTodoODinheiroColocado();

    }

    /**
     * @throws EntradaDeDinheiroEntupidaException
     */
    @Test
    public void deveriaDevolverTodoODinheiroColocado30Moedas() throws EntradaDeDinheiroEntupidaException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        for (int i = 0; i < 6; i++) {
            dinheiro.sinalColocarMoedaDeCincoCentavos();
            dinheiro.sinalColocarMoedaDeDezCentavos();
            dinheiro.sinalColocarMoedaDeVinteECincoCentavos();
            dinheiro.sinalColocarMoedaDeCinquentaCentavos();
            dinheiro.sinalColocarMoedaDeUmReal();
        }
        dinheiro.devolverTodoODinheiroColocado();

    }

    /**
     * @throws EntradaDeDinheiroEntupidaException
     */
    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void DeveriaLancarExcecaoEntradaDinheiroEntupida() throws EntradaDeDinheiroEntupidaException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        for (int i = 0; i < 7; i++) {
            dinheiro.sinalColocarMoedaDeCincoCentavos();
            dinheiro.sinalColocarMoedaDeDezCentavos();
            dinheiro.sinalColocarMoedaDeVinteECincoCentavos();
            dinheiro.sinalColocarMoedaDeCinquentaCentavos();
            dinheiro.sinalColocarMoedaDeUmReal();
        }
        dinheiro.devolverTodoODinheiroColocado();

    }


    @Test
    public void DeveriaSimularCompraCom5Centavos() throws EntradaDeDinheiroEntupidaException, SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, SemMoedasSuficientesException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(100, 0, 0, 0, 0);
        DispenserDeBebidas bebidas = new DispenserDeBebidas(100, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();
        dinheiro.sinalColocarMoedaDeCincoCentavos();
        dinheiro.contarMoedasDeCincoCentavosColocadas();
        teclado.sinalBotaoCocaCola();
        bebidas.liberarBebida(bebidas.COCA_COLA);
        dinheiro.engolirTodoODinheiroColocado();
        bebidas.sinalAbrirPortinha();
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(90);
        bebidas.sinalFecharPortinha();
        assertEquals(bebidas.COCA_COLA, bebidas.sinalGetBebidaLiberada());

    }
/**
 * estava passando na vers„o 1.2
 * @throws EntradaDeDinheiroEntupidaException
 * @throws SemBebidaDisponivelException
 * @throws SinalInvalidoNoDispenserDeBebidasException
 * @throws SemMoedasSuficientesException 
 */
    @Test
    public void DeveriaSimularDesistirDaCompra() throws EntradaDeDinheiroEntupidaException, SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, SemMoedasSuficientesException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(100, 0, 0, 0, 0);
        DispenserDeBebidas bebidas = new DispenserDeBebidas(100, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();
        dinheiro.sinalColocarMoedaDeCincoCentavos();
        dinheiro.contarMoedasDeCincoCentavosColocadas();
        teclado.sinalBotaoDevolverDinheiro();
        bebidas.liberarBebida(bebidas.COCA_COLA);
        dinheiro.engolirTodoODinheiroColocado();
        bebidas.sinalAbrirPortinha();
        dinheiro.devolverMoedasDeCincoCentavosComoTroco(90);
        bebidas.sinalFecharPortinha();
        assertEquals(bebidas.COCA_COLA, bebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void deveriaSomarValores5CentavosAte10Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);

        assertEquals(dinheiro.DEZ_CENTAVOS, dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS);
    }

    @Test
    public void deveriaSomarValores5CentavosAte25Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);

        assertEquals(dinheiro.VINTE_E_CINCO_CENTAVOS, dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS);
    }

    @Test
    public void deveriaSomarValores5CentavosAte50Centavos() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);

        assertEquals(dinheiro.CINQUENTA_CENTAVOS, dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS);
    }

    @Test
    public void deveriaSomarValores5CentavosAte1Real() throws SemMoedasSuficientesException {

        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);

        assertEquals(dinheiro.UM_REAL, dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS + dinheiro.CINCO_CENTAVOS);
    }
@Test
    public void deveriaSomarValores10CentavosAte50Centavo() throws SemMoedasSuficientesException {
    
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);

        assertEquals(dinheiro.CINQUENTA_CENTAVOS, dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS);
    }
@Test
    public void deveriaSomarValores10CentavosAte1Real() throws SemMoedasSuficientesException {
    
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);

        assertEquals(dinheiro.UM_REAL, dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS+dinheiro.DEZ_CENTAVOS);
    }
    @Test
    public void deveriaSomar25CentavosAte50Centavos() {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        assertEquals(dinheiro.CINQUENTA_CENTAVOS, dinheiro.VINTE_E_CINCO_CENTAVOS + dinheiro.VINTE_E_CINCO_CENTAVOS);
    }

    @Test
    public void deveriaSomar25CentavosAte1Real() {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        assertEquals(dinheiro.UM_REAL, dinheiro.VINTE_E_CINCO_CENTAVOS + dinheiro.VINTE_E_CINCO_CENTAVOS + dinheiro.VINTE_E_CINCO_CENTAVOS + dinheiro.VINTE_E_CINCO_CENTAVOS);
    }

    @Test
    public void deveriaSomar50CentavosAte1Real() {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        assertEquals(dinheiro.UM_REAL, dinheiro.CINQUENTA_CENTAVOS + dinheiro.CINQUENTA_CENTAVOS);
    }

    @Test
    public void deveriaSubtrair80CentavosDe1Real() {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        assertEquals(dinheiro.DEZ_CENTAVOS, dinheiro.UM_REAL - dinheiro.CINQUENTA_CENTAVOS - dinheiro.VINTE_E_CINCO_CENTAVOS - dinheiro.DEZ_CENTAVOS - dinheiro.CINCO_CENTAVOS);
    }
    @Test
    public void contarMoedasDe5Centavos() {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        for (int i = 0; i < 2; i++) {
          dinheiro.sinalColocarMoedaDeCincoCentavos();
        }
        assertTrue(dinheiro.hasDinheiroColocado());
    }
}

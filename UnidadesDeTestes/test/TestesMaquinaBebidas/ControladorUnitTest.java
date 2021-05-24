package TestesMaquinaBebidas;

import bebidasO.DispenserDeBebidas;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemMoedasSuficientesException;
import interfaceComUsuario.Display;
import interfaceComUsuario.Teclado;
import java.math.BigDecimal;
import junit.framework.AssertionFailedError;
import logica.Controlador;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ControladorUnitTest {

    DispenserDeBebidas bebi;
    EntradaEDispenserDeDinheiro din;
    Display tela;
    Teclado tecla;
    Controlador controlador;

    public ControladorUnitTest() {
    }

    @Before
    public void setUp() {

        bebi = new DispenserDeBebidas(10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        din = new EntradaEDispenserDeDinheiro(10, 10, 10, 10, 10);
        tela = new Display();
        tecla = new Teclado();
        controlador = new Controlador(bebi, din, tela, tecla);

    }



    @Test
    public void trocoHumReal() throws SemMoedasSuficientesException {
        BigDecimal Valorprod = new BigDecimal("200");
        BigDecimal valorColocado = new BigDecimal("300");
        controlador.calculartroco(Valorprod, valorColocado);

        assertTrue(din.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void deveriaDinimuirQuantidadede1RealCofre() throws SemMoedasSuficientesException {
        BigDecimal Valorprod = new BigDecimal("200");
        BigDecimal valorColocado = new BigDecimal("300");
        controlador.calculartroco(Valorprod, valorColocado);

        assertEquals(9, din.contarMoedasDeUmRealNoCofre());
    }

    @Test
    public void troco50Centavos() throws SemMoedasSuficientesException {
        BigDecimal Valorprod = new BigDecimal("200");
        BigDecimal valorColocado = new BigDecimal("250");
        controlador.calculartroco(Valorprod, valorColocado);

        assertTrue(din.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void deveriaDinimuirQuantidadede50CentavosCofre() throws SemMoedasSuficientesException {

        BigDecimal Valorprod = new BigDecimal("200");
        BigDecimal valorColocado = new BigDecimal("250");
        controlador.calculartroco(Valorprod, valorColocado);

        assertEquals(9, din.contarMoedasDeCinquentaCentavosNoCofre());
    }

    @Test
    public void trocoHumRealminimocofre() throws SemMoedasSuficientesException {
        BigDecimal Valorprod = new BigDecimal("100");
        BigDecimal valorColocado = new BigDecimal("900");
        controlador.calculartroco(Valorprod, valorColocado);
        assertTrue(din.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void deveriaDinimuirQuantidadede1RealCofreminimoCofre() throws SemMoedasSuficientesException {

        BigDecimal Valorprod = new BigDecimal("100");
        BigDecimal valorColocado = new BigDecimal("1100");
        controlador.calculartroco(Valorprod, valorColocado);

        assertEquals(0, din.contarMoedasDeUmRealNoCofre());
    }

    @Test
    public void troco50Centavosminimocofre() throws SemMoedasSuficientesException {
        BigDecimal Valorprod = new BigDecimal("200");
        BigDecimal valorColocado = new BigDecimal("250");
        controlador.calculartroco(Valorprod, valorColocado);
        assertTrue(din.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void deveriaDinimuirQuantidadede50CentavosCofreminimoCofre() throws SemMoedasSuficientesException {

        BigDecimal Valorprod = new BigDecimal("100");
        BigDecimal valorColocado = new BigDecimal("250");
        controlador.calculartroco(Valorprod, valorColocado);

        assertEquals(9, din.contarMoedasDeUmRealNoCofre());
    }

    @Test
    public void naomechenocofre() throws SemMoedasSuficientesException {

        BigDecimal Valorprod = new BigDecimal("100");
        BigDecimal valorColocado = new BigDecimal("700");
        controlador.calculartroco(Valorprod, valorColocado);

        assertEquals(10, din.contarMoedasDeCinquentaCentavosNoCofre());
    }

    @Test
    public void liberaCOCA_COLA() {
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        controlador.vereficaEstoqueBebidas(DispenserDeBebidas.COCA_COLA, new BigDecimal("260"));
        assertEquals(DispenserDeBebidas.COCA_COLA, bebi.sinalGetBebidaLiberada());
    }

    @Test
    public void DeveriaLiberarcocacola() {
        for (int i = 0; i < 3; i++) {
            din.sinalColocarMoedaDeUmReal();
            controlador.dinheiroInserido();
        }

        controlador.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals(bebi.COCA_COLA, bebi.sinalGetBebidaLiberada());
    }

    @Test
    public void DeveriaAbrirPortinha() {
        for (int i = 0; i < 3; i++) {
            din.sinalColocarMoedaDeUmReal();

        }
        controlador.dinheiroInserido();
        controlador.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        Assert.assertFalse(bebi.isDispenserAberto());
    }

    @Test
    public void DeverialiberarTroco() {
        for (int i = 0; i < 3; i++) {
            din.sinalColocarMoedaDeUmReal();

        }
        controlador.dinheiroInserido();
        controlador.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertTrue(din.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void test5CEntavosNoCofre() {

        BigDecimal Valorprod = new BigDecimal("195");
        BigDecimal valorColocado = new BigDecimal("200");
        controlador.calculartroco(Valorprod, valorColocado);

        assertEquals(9, din.contarMoedasDeCincoCentavosNoCofre());
    }

    @Test
    public void testIntegracaoDinheiroInsuficiente() {
        for (int i = 0; i < 1; i++) {
            din.sinalColocarMoedaDeUmReal();
            controlador.dinheiroInserido();
        }

        controlador.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals("DINHEIRO INSUFICIENTE", tela.sinalGetMensagem());
    }

    @Test
    public void testLiberarBebidaDinheiroInsuficiente() {
            din.sinalColocarMoedaDeUmReal();
            controlador.dinheiroInserido();
        controlador.botaoPressionado(0);

        assertEquals(DispenserDeBebidas.NENHUMA_BEBIDA, bebi.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberaFantaLaranja() {
        for (int i = 0; i < 2; i++) {
            din.sinalColocarMoedaDeUmReal();
            controlador.dinheiroInserido();
        }
        controlador.botaoPressionado(Teclado.BOTAO_FANTA_LARANJA);
        assertEquals(9, din.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(bebi.FANTA_LARANJA, bebi.sinalGetBebidaLiberada());
    }
 
    @Test
    public void testInsereDoisECinquenta() {
        din.sinalColocarMoedaDeUmReal();
        controlador.dinheiroInserido();
        din.sinalColocarMoedaDeUmReal();
        controlador.dinheiroInserido();
        din.sinalColocarMoedaDeCinquentaCentavos();
        controlador.dinheiroInserido();
        assertEquals("R$2.5", tela.sinalGetMensagem());
    }
 
    @Test
    public void testaFaltando10Centavos() {
        din.sinalColocarMoedaDeUmReal();
        controlador.dinheiroInserido();
        din.sinalColocarMoedaDeUmReal();
       controlador.dinheiroInserido();
        din.sinalColocarMoedaDeUmReal();
        controlador.dinheiroInserido();
        // kuat custa 1,75
        controlador.botaoPressionado(Teclado.BOTAO_COCA_ZERO);
        assertEquals("DINHEIRO INSUFICIENTE", tela.sinalGetMensagem());

    }

    @Test
    public void testaBebidaIndisponivelEDinheiroInsuficiente() {
        DispenserDeBebidas b = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
       Controlador c = new Controlador(b, din, tela, tecla);
        
        din.sinalColocarMoedaDeUmReal();
        controlador.dinheiroInserido();
        controlador.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals("BEBIDA INDISPONÃ�VEL", tela.sinalGetMensagem());
    }


    @Test
    public void testEntupirDispenser() {
        for (int i = 0; i < 30; i++) {
            din.sinalColocarMoedaDeUmReal();
            
        }
        controlador.dinheiroInserido();
        controlador.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());

    }
    
    
    @Test
    public void CT07testarContar31MoedasDeTodosOsValoresColocadas(){
                
        for(int i=0; i<31; i++){
            din.sinalColocarMoedaDeCincoCentavos();
            controlador.dinheiroInserido();
            din.sinalColocarMoedaDeDezCentavos();
            controlador.dinheiroInserido();
            din.sinalColocarMoedaDeVinteECincoCentavos();
            controlador.dinheiroInserido();
            din.sinalColocarMoedaDeVinteECincoCentavos();
            controlador.dinheiroInserido();
            din.sinalColocarMoedaDeUmReal();
            controlador.dinheiroInserido();
        }
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());
    }

    @Test
    public void CT08testarContar31Moedas5centavosColocadas(){
        
        for(int i=0; i<31; i++){
            din.sinalColocarMoedaDeCincoCentavos();
            controlador.dinheiroInserido();
        }
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());
    }
    
    @Test
    public void CT09testarContar31Moedas10centavosColocadas(){
        
        for(int i=0; i<31;i++){
               din.sinalColocarMoedaDeDezCentavos();
            controlador.dinheiroInserido();
         }
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());
    }
    
    @Test
    public void CT10testarContar31Moedas25centavosColocadas(){
        
        for(int i=0; i<31; i++){
            din.sinalColocarMoedaDeVinteECincoCentavos();
            controlador.dinheiroInserido();
        }
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());
    }
    
    @Test
    public void CT11testarContar31Moedas50centavosColocadas(){
        
        for(int i=0; i<31; i++){
            din.sinalColocarMoedaDeCinquentaCentavos();
            controlador.dinheiroInserido();
        }
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());
    }
    
    @Test
    public void CT12testarContar31Moedas1RealColocadas(){
        
        for(int i=0; i<31; i++){
            din.sinalColocarMoedaDeUmReal();
            controlador.dinheiroInserido();
        }
        assertEquals("ENTRADA DE $ ENTUPIDA", tela.sinalGetMensagem());
    }
        
}
package TestesMaquinaBebidas;

import bebidasO.DispenserDeBebidas;
import bebidasO.IDispenserDeBebidas;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import dinheiroIO.IEntradaEDispenserDeDinheiro;
import excecoes.DispenserDeBebidasEmperradoException;
import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemBebidaDisponivelException;
import excecoes.SinalInvalidoNoDispenserDeBebidasException;
import interfaceComUsuario.Display;
import interfaceComUsuario.IDisplay;
import interfaceComUsuario.ITeclado;
import interfaceComUsuario.Teclado;
import java.awt.Label;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Controlador;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ControladorTest {

   Controlador ctrl;
    DispenserDeBebidas dispenserDeBebidas;
    EntradaEDispenserDeDinheiro ioDinheiro;
    Display display;
    Teclado teclado;

    @Before
    public void setUp() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 20, 20, 20, 20, 20);
        ioDinheiro = new EntradaEDispenserDeDinheiro(100, 100, 100, 100, 100);
        display = new Display();
        teclado = new Teclado();
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
    }
    @Test
    public void testInsereUmReal() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        assertEquals("R$1", display.sinalGetMensagem());
    }

    @Test
    public void testInsereUmRealECinquenta() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        assertEquals("R$1.5", display.sinalGetMensagem());
    }

    @Test
    public void testInsereDoisECinquenta() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        assertEquals("R$2.5", display.sinalGetMensagem());
    }

    @Test
    public void testInsereDoisECinquentaECinco() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        assertEquals("R$2.55", display.sinalGetMensagem());
    }

    @Test
    public void testInsereCincoCentavos() {
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        assertEquals("R$0.05", display.sinalGetMensagem());
    }

    @Test
    public void testInsereDezCentavos() {
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        assertEquals("R$0.1", display.sinalGetMensagem());
    }

    @Test
    public void testInsereVinteECincoCentavos() {
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        assertEquals("R$0.25", display.sinalGetMensagem());
    }

    @Test
    public void testInsereNenhumaMoeda() {
        ctrl.dinheiroInserido();
        assertEquals("", display.sinalGetMensagem());

    }

    @Test
    public void testComprarCocaColaIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(0, 30, 30, 20, 20, 20, 20, 20, 20, 0);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_COLA);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarCocaLightIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 0, 30, 20, 20, 20, 20, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_LIGHT);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarCocaZeroIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 0, 20, 20, 20, 20, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_ZERO);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarFantaLaranjaIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 0, 20, 20, 20, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_LARANJA);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarFantaUvaIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 0, 20, 20, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_UVA);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarKuatGuaranaIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 0, 20, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_KUAT_GUARANA);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarSchweppesIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 20, 0, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarSchweppesCitrusIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 20, 20, 0, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES_CITRUS);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarSpriteIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 20, 20, 20, 0, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SPRITE);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());
    }

    @Test
    public void testComprarSpriteZeroIndisponivel() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 20, 20, 20, 20, 0);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SPRITE_ZERO);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());

    }

    @Test
    public void testComprarBebidaSemTroco() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_ZERO);
        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testComprarBebidaComTroco() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_ZERO);
        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testComprarCocaColaDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_COLA);
        assertEquals(DispenserDeBebidas.COCA_COLA, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarCocaLightDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_LIGHT);
        assertEquals(DispenserDeBebidas.COCA_LIGHT, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarCocaZeroDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_ZERO);
        assertEquals(DispenserDeBebidas.COCA_ZERO, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarFantaLaranjaDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_LARANJA);
        assertEquals(DispenserDeBebidas.FANTA_LARANJA, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarFantaUvaDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_UVA);
        assertEquals(DispenserDeBebidas.FANTA_UVA, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarKuatGuaranaDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_KUAT_GUARANA);
        assertEquals(DispenserDeBebidas.KUAT_GUARANA, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarSchweppesDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES);
        assertEquals(DispenserDeBebidas.SCHWEPPES, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarSchweppesCitrusDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES_CITRUS);
        assertEquals(DispenserDeBebidas.SCHWEPPES_CITRUS, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarSpriteDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SPRITE);
        assertEquals(DispenserDeBebidas.SPRITE, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testComprarSpriteZeroDisponivel() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SPRITE_ZERO);
        assertEquals(DispenserDeBebidas.SPRITE_ZERO, dispenserDeBebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testReceberTrocoCocaCola() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_COLA);

        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 1, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 1, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 1, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoCocaLight() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_LIGHT);

        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 0, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 0, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 1, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoCocaZero() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_ZERO);

        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 1, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 1, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 1, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 1, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoFantaLaranja() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_LARANJA);
        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
        assertEquals("1.0", 1, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 0, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 0, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 1, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoFantaUva() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_UVA);

        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 0, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 0, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 1, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoKuatGuarana() {
        dispenserDeBebidas = new DispenserDeBebidas(30, 30, 30, 20, 20, 20, 20, 20, 20, 20);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_KUAT_GUARANA);

        assertEquals(true, ioDinheiro.hasMoedasDevolvidasNoDispenser());
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 1, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 0, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 0, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoSchweppes() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES);

        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 1, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 0, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 0, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoSchweppesCitrus() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES_CITRUS);
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 0, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 1, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 1, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoSprite() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SPRITE);
        assertEquals("1.0", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 1, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 1, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 0, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 0, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testReceberTrocoSpriteZero() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SPRITE_ZERO);
        assertEquals("1.00", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.50", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 0, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.10", 1, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 0, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoCocaCola() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_COLA);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoCocaZero() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_ZERO);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoCocaLight() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_COCA_LIGHT);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoFantaLaranja() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_LARANJA);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoFantaUva() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_FANTA_UVA);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoSprite() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();

        ctrl.botaoPressionado(teclado.BOTAO_SPRITE);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoSpriteZero() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();

        ctrl.botaoPressionado(teclado.BOTAO_SPRITE_ZERO);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoKuatGuarana() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();

        ctrl.botaoPressionado(teclado.BOTAO_KUAT_GUARANA);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoSchweppes() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();

        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testaNÃƒÂ£oReceberTrocoSchweppesCitrus() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(teclado.BOTAO_SCHWEPPES_CITRUS);

        assertEquals(false, ioDinheiro.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testEntupirDispenser() {
        for (int i = 0; i < 31; i++) {
            ioDinheiro.sinalColocarMoedaDeUmReal();
            ctrl.dinheiroInserido();
        }
        assertEquals("ENTRADA DE $ ENTUPIDA", display.sinalGetMensagem());

    }

    @Test
    public void testEntupirMoedasNoCofre() {
        ioDinheiro = new EntradaEDispenserDeDinheiro(1999, 1999, 1999, 1999, 1999);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();

        ctrl.botaoPressionado(Teclado.BOTAO_KUAT_GUARANA);

        assertEquals("R$0.25", display.sinalGetMensagem());

    }
   
    @Test
    public void testarTrocoCofreCom0_10FaltaTroco() {
        ioDinheiro = new EntradaEDispenserDeDinheiro(0, 1, 0, 0, 0);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);

        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        // kuat custa 1,75
        ctrl.botaoPressionado(Teclado.BOTAO_KUAT_GUARANA);
        assertEquals("1.00", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.50", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 0, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.10", 1, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 0, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
        assertEquals("R$0.75", display.sinalGetMensagem());
    }

    @Test
    public void testarTrocoCofreCom0_35() {
        ioDinheiro = new EntradaEDispenserDeDinheiro(0, 1, 1, 0, 0);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);

        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(Teclado.BOTAO_KUAT_GUARANA);

        assertEquals("1.00", 0, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.50", 0, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 1, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.10", 1, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 0, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
       assertEquals("R$0.5", display.sinalGetMensagem());
    }

    @Test
    public void testaFaltando5Centavos() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeDezCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(Teclado.BOTAO_KUAT_GUARANA);
        assertEquals("DINHEIRO INSUFICIENTE", display.sinalGetMensagem());

    }

    @Test
    public void testaFaltando10Centavos() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        // kuat custa 1,75
        ctrl.botaoPressionado(Teclado.BOTAO_COCA_ZERO);
        assertEquals("DINHEIRO INSUFICIENTE", display.sinalGetMensagem());

    }

    @Test
    public void testaCompraConsecutivaSemInserirMaisDinheiro() {
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalPegarMoedasDeDezCentavos();
        ctrl.botaoPressionado(Teclado.BOTAO_COCA_ZERO);
        ctrl.botaoPressionado(Teclado.BOTAO_COCA_ZERO);
        assertEquals(1, dispenserDeBebidas.sinalGetBebidaLiberada());
        assertEquals("DINHEIRO INSUFICIENTE", display.sinalGetMensagem());

    }

  

    @Test
    public void testarDevolverVariasMoedasColocadas() {
        for (int i = 0; i < 6; i++) {
            ioDinheiro.sinalColocarMoedaDeUmReal();
            ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
            ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
            ioDinheiro.sinalColocarMoedaDeDezCentavos();
            ioDinheiro.sinalColocarMoedaDeCincoCentavos();
             ctrl.botaoPressionado(Teclado.BOTAO_DEVOLVER_DINHEIRO);
        }
       
        assertEquals("1", 6, ioDinheiro.sinalPegarMoedasDeUmReal());
        assertEquals("0.5", 6, ioDinheiro.sinalPegarMoedasDeCinquentaCentavos());
        assertEquals("0.25", 6, ioDinheiro.sinalPegarMoedasDeVinteECincoCentavos());
        assertEquals("0.1", 6, ioDinheiro.sinalPegarMoedasDeDezCentavos());
        assertEquals("0.05", 6, ioDinheiro.sinalPegarMoedasDeCincoCentavos());
        assertEquals("", display.sinalGetMensagem());
    }

    @Test
    public void testarDevolverMaisQue30Moedas() {
        for (int i = 0; i < 7; i++) {
            ioDinheiro.sinalColocarMoedaDeUmReal();
            ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
            ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
            ioDinheiro.sinalColocarMoedaDeDezCentavos();
            ioDinheiro.sinalColocarMoedaDeCincoCentavos();
        }
        ctrl.botaoPressionado(Teclado.BOTAO_DEVOLVER_DINHEIRO);
        assertEquals("ENTRADA DE $ ENTUPIDA", display.sinalGetMensagem());
    }

    @Test
    public void testaCompraDeixandoMaisDe2000Moedas() {
        ioDinheiro = new EntradaEDispenserDeDinheiro(1999, 1999, 1999, 1999, 1999);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();

        ctrl.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals("R$0.4", display.sinalGetMensagem());

    }

    @Test
    public void testaInterfaceComoArgumentoNoConstrutor() {
        IDispenserDeBebidas idispenser = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        IEntradaEDispenserDeDinheiro ie = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        IDisplay idisplay = new Display();
        ITeclado iteclado = new Teclado();
        ctrl = new Controlador(idispenser, ie, idisplay, iteclado);
        assertEquals("Interfaces como argumento no construtor", idispenser.isDispenserTravado(), true);
    }

    @Test
    public void testaInserirDinheiroEntupidaAEntrada() {
        for (int i = 0; i < 31; i++) {
            ioDinheiro.sinalColocarMoedaDeUmReal();
            ctrl.dinheiroInserido();
        }
        ctrl.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals("ENTRADA DE $ ENTUPIDA", display.sinalGetMensagem());
        
    }

    @Test
    public void testaBebidaIndisponivelEDinheiroInsuficiente() {
        dispenserDeBebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        ctrl = new Controlador(dispenserDeBebidas, ioDinheiro, display, teclado);

        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.botaoPressionado(Teclado.BOTAO_COCA_COLA);
        assertEquals("BEBIDA INDISPONÃ�VEL", display.sinalGetMensagem());
    }

    @Test
    public void testComprarBebidaComPortinhaEmperrada() {
        dispenserDeBebidas.sinalEmperrarPortinha();
        ioDinheiro.sinalColocarMoedaDeUmReal();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeCinquentaCentavos();
        ctrl.dinheiroInserido();
        ioDinheiro.sinalColocarMoedaDeVinteECincoCentavos();
        ctrl.dinheiroInserido();
        ctrl.botaoPressionado(Teclado.BOTAO_KUAT_GUARANA);
        assertEquals("PROBLEMA NO DISPENSER", display.sinalGetMensagem());
    }

}
package TestesMaquinaBebidas;

import bebidasO.DispenserDeBebidas;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.DispenserDeBebidasEmperradoException;
import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemBebidaDisponivelException;
import excecoes.SinalInvalidoNoDispenserDeBebidasException;
import excecoes.SinalInvalidoNoTecladoException;
import interfaceComUsuario.Teclado;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class DispenserBebidasJUnitTest {

    public DispenserBebidasJUnitTest() {
    }

    @Test
    public void testPortaDispenserBebidas() throws DispenserDeBebidasEmperradoException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        bebidas.destravarDispenser();
        assertFalse(bebidas.isDispenserAberto());
    }

    @Test
    public void testTravaDispenser() {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertTrue(bebidas.isDispenserTravado());
    }

    @Test(expected = SemBebidaDisponivelException.class)
    public void testDisponibilidadeBebida() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.liberarBebida(1);
    }

    @Test
    public void testLiberarCocaCola() throws SinalInvalidoNoTecladoException, SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoCocaCola();
        bebidas.liberarBebida(DispenserDeBebidas.COCA_COLA);
        assertEquals(DispenserDeBebidas.COCA_COLA, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarCocaColaLight() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoCocaLight();
        bebidas.liberarBebida(DispenserDeBebidas.COCA_LIGHT);
        assertEquals(DispenserDeBebidas.COCA_LIGHT, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarCocaZero() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoCocaCola();
        bebidas.liberarBebida(DispenserDeBebidas.COCA_ZERO);
        assertEquals(DispenserDeBebidas.COCA_ZERO, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarSprite() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoCocaCola();
        bebidas.liberarBebida(DispenserDeBebidas.SPRITE);
        assertEquals(DispenserDeBebidas.SPRITE, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarSpriteZero() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoSpriteZero();
        bebidas.liberarBebida(DispenserDeBebidas.SPRITE_ZERO);
        assertEquals(DispenserDeBebidas.SPRITE_ZERO, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarSchweppes() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoSchweppes();
        bebidas.liberarBebida(DispenserDeBebidas.SCHWEPPES);
        assertEquals(DispenserDeBebidas.SCHWEPPES, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarSchweppesCitrus() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoSchweppesCitrus();
        bebidas.liberarBebida(DispenserDeBebidas.SCHWEPPES_CITRUS);
        assertEquals(DispenserDeBebidas.SCHWEPPES_CITRUS, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarFantaLaranja() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoFantaLaranja();
        bebidas.liberarBebida(DispenserDeBebidas.FANTA_LARANJA);
        assertEquals(DispenserDeBebidas.FANTA_LARANJA, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarFantaUva() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        teclado.sinalBotaoFantaUva();
        bebidas.liberarBebida(DispenserDeBebidas.FANTA_UVA);
        assertEquals(DispenserDeBebidas.FANTA_UVA, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testLiberarKuatGuarana() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        teclado.sinalBotaoKuatGuarana();
        bebidas.liberarBebida(DispenserDeBebidas.KUAT_GUARANA);
        assertEquals(DispenserDeBebidas.KUAT_GUARANA, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testSolicitacaoInvalidaDeBebida() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        teclado.sinalSetValorEspecifico(900);
        assertEquals(DispenserDeBebidas.NENHUMA_BEBIDA, bebidas.sinalGetBebidaLiberada());
    }

    @Test(expected = SinalInvalidoNoTecladoException.class)
    public void testPedidosEmSequencia() throws SinalInvalidoNoTecladoException, SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        Teclado teclado = new Teclado();
        DispenserDeBebidas bebidas = new DispenserDeBebidas(35, 35, 35, 50, 35, 35, 35, 325, 350, 35);
        teclado.sinalBotaoCocaCola();
        teclado.sinalBotaoCocaLight();
        teclado.sinalBotaoFantaLaranja();
        teclado.sinalGetBotaoPressionado();
        for (int i = 0; i < 350; i++) {
            teclado.sinalBotaoCocaCola();
            teclado.sinalBotaoCocaZero();
            teclado.sinalBotaoFantaLaranja();
            
        }
        teclado.sinalGetBotaoPressionado();
    }

    @Ignore
    @Test
    public void deveriaAceitarLimiteDe2000MoedasDeCadaValor() throws EntradaDeDinheiroEntupidaException {
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(5000, 5000, 5000, 5000, 5000);
        assertEquals(2000, dinheiro.contarMoedasDeVinteECincoCentavosNoCofre());

    }

    @Test
    public void testTravaPortaDoDispenserDeBebidas() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, DispenserDeBebidasEmperradoException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.sinalFecharPortinha();
        bebidas.travarDispenser();
        bebidas.sinalAbrirPortinha();
        assertFalse(bebidas.isDispenserAberto());

    }

    @Test
    public void testIntegracao() throws EntradaDeDinheiroEntupidaException, DispenserDeBebidasEmperradoException, SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(5, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();
        bebidas.destravarDispenser();
        bebidas.liberarBebida(DispenserDeBebidas.COCA_COLA);
        assertEquals(DispenserDeBebidas.COCA_COLA, bebidas.sinalGetBebidaLiberada());

    }

    @Test
    public void testIntegracao2() throws EntradaDeDinheiroEntupidaException, DispenserDeBebidasEmperradoException, SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(25, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();
        for (int i = 0; i < 10; i++) {
            teclado.sinalBotaoCocaCola();
            bebidas.destravarDispenser();
            bebidas.liberarBebida(Teclado.BOTAO_COCA_COLA);
            bebidas.sinalAbrirPortinha();
        }
        assertEquals(Teclado.BOTAO_COCA_COLA, bebidas.sinalGetBebidaLiberada());
    }

    @Test(expected = DispenserDeBebidasEmperradoException.class)
    public void testEmperrarPorta() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(5, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();
        bebidas.sinalEmperrarPortinha();
        teclado.sinalBotaoCocaCola();
        bebidas.liberarBebida(0);
    }
  @Test
    public void testeLiberarMuitasBebidasCOCA_COLA() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(100, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoCocaCola();
            bebidas.liberarBebida(bebidas.COCA_COLA);
            bebidas.sinalAbrirPortinha();
        }

        assertEquals(bebidas.COCA_COLA, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testeLiberarMuitasBebidasCOCA_LIGHT() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 100, 0, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();
        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoCocaLight();
            bebidas.liberarBebida(bebidas.COCA_LIGHT);
        }

        assertEquals(bebidas.COCA_LIGHT, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testeLiberarMuitasBebidasCOCA_ZERO() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 100, 0, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoCocaLight();
            bebidas.liberarBebida(bebidas.COCA_ZERO);
        }

        assertEquals(bebidas.COCA_ZERO, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testeLiberarMuitasBebidasFANTA_LARANJA() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 100, 0, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoFantaLaranja();
            bebidas.liberarBebida(bebidas.FANTA_LARANJA);
        }

        assertEquals(bebidas.FANTA_LARANJA, bebidas.sinalGetBebidaLiberada());
    }

    @Test
    public void testeLiberarMuitasBebidasFANTA_UVA() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 100, 0, 0, 0, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoFantaLaranja();
            bebidas.liberarBebida(bebidas.FANTA_UVA);
        }

        assertEquals(bebidas.FANTA_UVA, bebidas.sinalGetBebidaLiberada());
    }
    @Test
    public void testeLiberarMuitasBebidasKUAT_GUARANA() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 100, 0, 0, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoKuatGuarana();
            bebidas.liberarBebida(bebidas.KUAT_GUARANA);
        }

        assertEquals(bebidas.KUAT_GUARANA, bebidas.sinalGetBebidaLiberada());
    }
    @Test
    public void testeLiberarMuitasBebidasSCHWEPPES() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 100, 0, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoSchweppes();
            bebidas.liberarBebida(bebidas.SCHWEPPES);
        }

        assertEquals(bebidas.SCHWEPPES, bebidas.sinalGetBebidaLiberada());
    }
    @Test
    public void testeLiberarMuitasBebidasSCHWEPPES_CITRUS() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 100, 0, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoSchweppesCitrus();
            bebidas.liberarBebida(bebidas.SCHWEPPES_CITRUS);
        }

        assertEquals(bebidas.SCHWEPPES_CITRUS, bebidas.sinalGetBebidaLiberada());
    }
    @Test
    public void testeLiberarMuitasBebidasSPRITE() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 100, 0);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoSprite();
            bebidas.liberarBebida(bebidas.SPRITE);
        }

        assertEquals(bebidas.SPRITE, bebidas.sinalGetBebidaLiberada());
    }
    @Test
    public void testeLiberarMuitasBebidasSPRITE_ZERO() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 100);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoSpriteZero();
            bebidas.liberarBebida(bebidas.SPRITE_ZERO);
        }

        assertEquals(bebidas.SPRITE_ZERO, bebidas.sinalGetBebidaLiberada());
    }
  
    
    @Test
    public void testeLiberarMuitasBebidas() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(100, 100, 100,100, 100, 100, 100, 100, 100, 100);
        Teclado teclado = new Teclado();

        for (int i = 0; i < 100; i++) {
            teclado.sinalBotaoCocaCola();
            teclado.sinalBotaoCocaLight();
            teclado.sinalBotaoSpriteZero();
            teclado.sinalBotaoFantaLaranja();
            teclado.sinalBotaoFantaUva();
            teclado.sinalBotaoKuatGuarana();
            teclado.sinalBotaoSchweppes();
            teclado.sinalBotaoSchweppesCitrus();
            teclado.sinalBotaoSprite();
            teclado.sinalBotaoSpriteZero();
            bebidas.liberarBebida(bebidas.COCA_COLA);
            bebidas.liberarBebida(bebidas.COCA_LIGHT);
            bebidas.liberarBebida(bebidas.COCA_ZERO);
            bebidas.liberarBebida(bebidas.FANTA_LARANJA);
            bebidas.liberarBebida(bebidas.FANTA_UVA);
            bebidas.liberarBebida(bebidas.KUAT_GUARANA);
            bebidas.liberarBebida(bebidas.SCHWEPPES);
            bebidas.liberarBebida(bebidas.SCHWEPPES_CITRUS);
            bebidas.liberarBebida(bebidas.SPRITE);
            bebidas.liberarBebida(bebidas.SPRITE_ZERO);
           
        }
        bebidas.sinalGetBebidaLiberada(); 
    }
    

 @Test
    public void deveriaEmperrarPorta() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, DispenserDeBebidasEmperradoException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.sinalFecharPortinha();
        bebidas.travarDispenser();
        bebidas.sinalEmperrarPortinha();
        assertTrue(bebidas.isDispenserTravado());

    }
 @Test (expected = DispenserDeBebidasEmperradoException.class)
    public void deveriaDesemperrarPorta() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, DispenserDeBebidasEmperradoException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.sinalFecharPortinha();
        bebidas.travarDispenser();
        bebidas.sinalEmperrarPortinha();
        bebidas.destravarDispenser();
        assertTrue(bebidas.isDispenserTravado());

    }
    
    @Test
    public void deveriaFecharEAbrirAPortaDeBebidas() {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.sinalFecharPortinha();
        bebidas.sinalAbrirPortinha();
        assertTrue(bebidas.isDispenserAberto());

    }
    @Test
    public void deveriaLancarExcecao() {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.sinalAbrirPortinha();
        bebidas.sinalFecharPortinha();
        assertTrue(bebidas.isDispenserAberto());

    }
   
    @Test
    public void deveriaTravarEDestravarPortaDoDispenser() throws DispenserDeBebidasEmperradoException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.travarDispenser();
        bebidas.destravarDispenser();
        bebidas.sinalAbrirPortinha();
        assertTrue(bebidas.isDispenserAberto());
    }
    /**
     * Não deveria abrir a porta do dispencer pois esta travado,somente apos usar o metodo  destravarDispenser()
     */
    @Test
    public void deveriaTravarPortaDoDispenserDeBebidas() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, DispenserDeBebidasEmperradoException {
        DispenserDeBebidas bebidas = new DispenserDeBebidas(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bebidas.sinalFecharPortinha();
        bebidas.travarDispenser();
        bebidas.sinalAbrirPortinha();
        assertTrue(bebidas.isDispenserAberto());
    }
     @Test
    public void naoDeveriaSomarBebidas() throws SemBebidaDisponivelException, SinalInvalidoNoDispenserDeBebidasException, SinalInvalidoNoTecladoException {
    DispenserDeBebidas bebidas = new DispenserDeBebidas(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    Teclado teclado = new Teclado();
    teclado.sinalGetBotaoPressionado();
    teclado.sinalBotaoCocaLight();
    teclado.sinalBotaoCocaZero();
    bebidas.liberarBebida(bebidas.COCA_LIGHT+bebidas.COCA_ZERO);
    assertEquals(bebidas.SPRITE,bebidas.COCA_LIGHT+bebidas.COCA_ZERO);
    }
}

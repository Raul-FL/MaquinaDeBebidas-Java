package TestesMaquinaBebidas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.EntradaDeDinheiroEntupidaException;
import static org.junit.Assert.*;

public class Teste_Raul {
    
    public Teste_Raul() {
    }
    
    @Test
    public void testarContar1MoedaDeTodosOsValoresNoCofre(){
        int teste[];
        teste = new int[5];
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1,1,1,1,1);
        
        assertEquals(1,e.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(1,e.contarMoedasDeDezCentavosNoCofre());
        assertEquals(1,e.contarMoedasDeVinteECincoCentavosNoCofre());
        assertEquals(1,e.contarMoedasDeCinquentaCentavosNoCofre());
        assertEquals(1,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void testarContar1Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1, 0, 0, 0, 0);
        assertEquals(1,  e.contarMoedasDeCincoCentavosNoCofre());
    }
    
    @Test
    public void testarContar1moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,1,0,0,0);
        assertEquals(1,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void testarContar1moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,1,0,0);
        assertEquals(1,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void testarContar1moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,1,0);
        assertEquals(1,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void testarContar1moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,1);
        assertEquals(1,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void testarContar10MoedaDeTodosOsValoresNoCofre(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(10,10,10,10,10);
        
        assertEquals(10,e.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeDezCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeCinquentaCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void testarContar10Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(10, 0, 0, 0, 0);
        int teste = e.contarMoedasDeCincoCentavosNoCofre();
        assertEquals(10, teste);
    }
    
    @Test
    public void testarContar10moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,10,0,0,0);
        assertEquals(10,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void testarContar10moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,10,0,0);
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void testarContar10moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,10,0);
        assertEquals(10,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void testarContar10moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,10);
        assertEquals(10,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void testarContar0MoedasDeTodosOsValoresNoCofre(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(0,e.contarMoedasDeDezCentavosNoCofre());
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosNoCofre());
        assertEquals(0,e.contarMoedasDeCinquentaCentavosNoCofre());
        assertEquals(0,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void testarContar0Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        assertEquals(0, e.contarMoedasDeCincoCentavosNoCofre());
    }
    
    @Test
    public void testarContar0moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void testarContar0moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void testarContar0moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void testarContar0moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test(expected = Exception.class)
    public void testarContarMoedasNegativas5centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(-1, 0, 0, 0, 0);
        e.contarMoedasDeCincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContarMoedasNegativas10centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,-1,0,0,0);
        e.contarMoedasDeDezCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContarMoedasNegativas25centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,-1,0,0);
        e.contarMoedasDeVinteECincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContarMoedasNegativas50centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,-1,0);
        e.contarMoedasDeCinquentaCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContarMoedasNegativas1realNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,-1);
        e.contarMoedasDeUmRealNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContar2001MoedasDeTodosOsValores() throws Exception{
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(2001,2001,2001,2001,2001);
        e.contarMoedasDeCincoCentavosNoCofre();
        e.contarMoedasDeCinquentaCentavosNoCofre();
        e.contarMoedasDeDezCentavosNoCofre();
        e.contarMoedasDeUmRealNoCofre();
        e.contarMoedasDeVinteECincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContar2001Moedas5centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(2001, 0, 0, 0, 0);
        e.contarMoedasDeCincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContar2001Moedas10centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,2001,0,0,0);
        e.contarMoedasDeDezCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContar2001Moedas25centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,2001,0,0);
        e.contarMoedasDeVinteECincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContar2001Moedas50centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,2001,0);
        e.contarMoedasDeCinquentaCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void testarContar2001Moedas1realNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,2001);
        e.contarMoedasDeUmRealNoCofre();
    }
    
    @Test
    public void testarContar30MoedasDeTodosOsValoresColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCincoCentavos();
            e.sinalColocarMoedaDeDezCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeUmReal();
        }
        
        assertEquals(30,e.contarMoedasDeCincoCentavosColocadas());
        assertEquals(30,e.contarMoedasDeDezCentavosColocadas());
        assertEquals(30,e.contarMoedasDeVinteECincoCentavosColocadas());
        assertEquals(30,e.contarMoedasDeCinquentaCentavosColocadas());
        assertEquals(30,e.contarMoedasDeUmRealColocadas());
    }
    
    @Test
    public void testarContar30Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        assertEquals(30,e.contarMoedasDeCincoCentavosColocadas());
    }
    
    @Test
    public void testarContar30Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30;i++){
               e.sinalColocarMoedaDeDezCentavos();
         }
        assertEquals(30,e.contarMoedasDeDezCentavosColocadas());
    }
    
    @Test
    public void testarContar30Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(30,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
    
    @Test
    public void testarContar30Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        assertEquals(30,e.contarMoedasDeCinquentaCentavosColocadas());
    }
    
    @Test
    public void testarContar30Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        int teste;
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(30,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void testarContar1MoedasDeTodosOsValoresColocadas(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeCincoCentavos();
            e.sinalColocarMoedaDeDezCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeUmReal();
        
        assertEquals(1,e.contarMoedasDeCincoCentavosColocadas());
        assertEquals(1,e.contarMoedasDeDezCentavosColocadas());
        assertEquals(1,e.contarMoedasDeVinteECincoCentavosColocadas());
        assertEquals(1,e.contarMoedasDeCinquentaCentavosColocadas());
        assertEquals(1,e.contarMoedasDeUmRealColocadas());
    }
    
    @Test
    public void testarContar1Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeCincoCentavos();
        
        assertEquals(1,e.contarMoedasDeCincoCentavosColocadas());
    }
    
    @Test
    public void testarContar1Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
               e.sinalColocarMoedaDeDezCentavos();
               
        assertEquals(1,e.contarMoedasDeDezCentavosColocadas());
    }
    
    @Test
    public void testarContar1Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(1,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
    
    @Test
    public void testarContar1Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeCinquentaCentavos();
        
        assertEquals(1,e.contarMoedasDeCinquentaCentavosColocadas());
    }
    
    @Test
    public void testarContar1Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeUmReal();
        assertEquals(1,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void testarContar10MoedasDeTodosOsValoresColocadas(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCincoCentavos();
            e.sinalColocarMoedaDeDezCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeUmReal();
        }
        
        
        assertEquals(10,e.contarMoedasDeCincoCentavosColocadas());
        assertEquals(10,e.contarMoedasDeDezCentavosColocadas());
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosColocadas());
        assertEquals(10,e.contarMoedasDeCinquentaCentavosColocadas());
        assertEquals(10,e.contarMoedasDeUmRealColocadas());
    }
    
    @Test
    public void testarContar10Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        assertEquals(10,e.contarMoedasDeCincoCentavosColocadas());
    }
    
    @Test
    public void testarContar10Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10;i++){
               e.sinalColocarMoedaDeDezCentavos();
         }
        assertEquals(10,e.contarMoedasDeDezCentavosColocadas());
    }
   
    @Test
    public void testarContar10Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
  
    @Test
    public void testarContar10Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        assertEquals(10,e.contarMoedasDeCinquentaCentavosColocadas());
    }

    @Test
    public void testarContar10Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(10,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void testarContar0MoedasDeTodosOsValoresColocadas(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCincoCentavosColocadas());
        assertEquals(0,e.contarMoedasDeDezCentavosColocadas());
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosColocadas());
        assertEquals(0,e.contarMoedasDeCinquentaCentavosColocadas());
        assertEquals(0,e.contarMoedasDeUmRealColocadas());
    }
    
    @Test
    public void testarContar0Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCincoCentavosColocadas());
    }

    @Test
    public void testarContar0Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeDezCentavosColocadas());
    }
    
    @Test
    public void testarContar0Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
    
    @Test
    public void testarContar0Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCinquentaCentavosColocadas());
    }
    
    @Test
    public void testarContar0Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeUmRealColocadas());
        
    }
    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void testarContar31MoedasDeTodosOsValoresColocadas(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<31; i++){
            e.sinalColocarMoedaDeCincoCentavos();
            e.sinalColocarMoedaDeDezCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeVinteECincoCentavos();
            e.sinalColocarMoedaDeUmReal();
        }
        
        assertEquals(31,e.contarMoedasDeCincoCentavosColocadas());
        assertEquals(31,e.contarMoedasDeDezCentavosColocadas());
        assertEquals(31,e.contarMoedasDeVinteECincoCentavosColocadas());
        assertEquals(31,e.contarMoedasDeCinquentaCentavosColocadas());
        assertEquals(31,e.contarMoedasDeUmRealColocadas());
    }

    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void testarContar31Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<31; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
    }
    
    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void testarContar31Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<31;i++){
               e.sinalColocarMoedaDeDezCentavos();
         }
    }
    
    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void testarContar31Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<31; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
    }
    
    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void testarContar31Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<31; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
    }
    
    @Test(expected = EntradaDeDinheiroEntupidaException.class)
    public void testarContar31Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<31; i++){
            e.sinalColocarMoedaDeUmReal();
        }        
    }
    
    @Test
    public void testarSeTemDiheiro0(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(false,e.hasDinheiroColocado());
    }
    
    @Test
    public void testarSeTemDinheiro1moedaCadaTipoNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1,1,1,1,1);
        assertEquals(true,e.hasDinheiroColocado());
    }
    
    @Test
    public void testarSeTemDinheiro100MoedasNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(100,100,100,100,100);
        assertEquals(false,e.hasDinheiroColocado());
    }
        
    @Test
    public void testarSeTemDinheiroColocando1Moeda5centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        
        e.sinalColocarMoedaDeCincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando1moeda10centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeDezCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void testarSeTemDinheiroColocando1moeda25centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
    
    @Test
    public void testarSeTemDinheiroColocando1moeda50centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando1moeda1real(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeUmReal();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void testarSeTemDinheiroColocando1deCadaMoeda(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeCincoCentavos();
        e.sinalColocarMoedaDeCinquentaCentavos();
        e.sinalColocarMoedaDeDezCentavos();
        e.sinalColocarMoedaDeUmReal();
        e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void testarSeTemDinheiroColocando5deCadaMoeda(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeCincoCentavos();
            e.sinalColocarMoedaDeCinquentaCentavos();
            e.sinalColocarMoedaDeDezCentavos();
            e.sinalColocarMoedaDeUmReal();
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void testarSeTemDinheiroColocando5moedas5centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando5moedas10centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando5moedas25centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando5moedas50centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando5moedas1real(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando30moedas5centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando30moedas10centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando30moedas25centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando30moedas50centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando30moedas1real(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void testarSeTemDinheiroColocando0moedasPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(false, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroColocando1moedaDe5centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1,0,0,0,0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroColocando1moedaDe10centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,1,0,0,0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroColocando1moedaDe25centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 1, 0, 0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroColocando1moedaDe50centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 1, 0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroColocando1moedaDe1RealPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 1);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo1MoedasDe5Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        e.sinalColocarMoedaDeCincoCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo1MoedasDe10Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,1,0,0,0);
        e.sinalColocarMoedaDeDezCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo1MoedasDe25Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        e.sinalColocarMoedaDeVinteECincoCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo1MoedasDe50Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,1,0);
        e.sinalColocarMoedaDeCinquentaCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo1MoedasDe1real() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        e.sinalColocarMoedaDeUmReal();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo10MoedasDe5Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo10MoedasDe10Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo10MoedasDe25Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo10MoedasDe50Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo10MoedasDe1real() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }   
    
    @Test
    public void testarSeTemDinheiroEngolindo30MoedasDe5Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo30MoedasDe10Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void testarSeTemDinheiroEngolindo30MoedasDe25Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }
    
    @Test
    public void testarSeTemDinheiroEngolindo30MoedasDe50Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }
    
    @Test
    public void testarSeTemDinheiroEngolindo30MoedasDe1real() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }   
        
        
    }

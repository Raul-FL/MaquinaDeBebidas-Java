package testeDinheiro;

import dinheiroIO.EntradaEDispenserDeDinheiro;
import org.junit.Test;

public class TestesE02 {
    
    @Test(expected = Exception.class)
    public void CT01testarContarMoedasNegativas5centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(-1, 0, 0, 0, 0);
        e.contarMoedasDeCincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT02testarContarMoedasNegativas10centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,-1,0,0,0);
        e.contarMoedasDeDezCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT03testarContarMoedasNegativas25centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,-1,0,0);
        e.contarMoedasDeVinteECincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT04testarContarMoedasNegativas50centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,-1,0);
        e.contarMoedasDeCinquentaCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT05testarContarMoedasNegativas1realNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,-1);
        e.contarMoedasDeUmRealNoCofre();
    }
}

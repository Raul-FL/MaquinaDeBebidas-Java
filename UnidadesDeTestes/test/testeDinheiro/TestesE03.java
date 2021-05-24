package testeDinheiro;

import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.EntradaDeDinheiroEntupidaException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestesE03 {
    
    
    @Test(expected = Exception.class)
    public void CT01testarContar2001MoedasDeTodosOsValores() throws Exception{
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(2001,2001,2001,2001,2001);
        e.contarMoedasDeCincoCentavosNoCofre();
        e.contarMoedasDeCinquentaCentavosNoCofre();
        e.contarMoedasDeDezCentavosNoCofre();
        e.contarMoedasDeUmRealNoCofre();
        e.contarMoedasDeVinteECincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT02testarContar2001Moedas5centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(2001, 0, 0, 0, 0);
        e.contarMoedasDeCincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT03testarContar2001Moedas10centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,2001,0,0,0);
        e.contarMoedasDeDezCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT04testarContar2001Moedas25centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,2001,0,0);
        e.contarMoedasDeVinteECincoCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT05testarContar2001Moedas50centavosNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,2001,0);
        e.contarMoedasDeCinquentaCentavosNoCofre();
    }
    
    @Test(expected = Exception.class)
    public void CT06testarContar2001Moedas1realNoCofre() throws Exception{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,2001);
        e.contarMoedasDeUmRealNoCofre();
    }
        
        
}
    


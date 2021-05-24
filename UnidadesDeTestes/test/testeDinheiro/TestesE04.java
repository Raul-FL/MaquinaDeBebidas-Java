package testeDinheiro;

import dinheiroIO.EntradaEDispenserDeDinheiro;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestesE04 {
    
    @Test
    public void CT01testarContar0MoedasDeTodosOsValoresNoCofre(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0, e.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(0, e.contarMoedasDeDezCentavosNoCofre());
        assertEquals(0, e.contarMoedasDeVinteECincoCentavosNoCofre());
        assertEquals(0, e.contarMoedasDeCinquentaCentavosNoCofre());
        assertEquals(0, e.contarMoedasDeUmRealNoCofre());
    }

    @Test
    public void CT02testarContar0Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCincoCentavosColocadas());
    }

    @Test
    public void CT03testarContar0Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeDezCentavosColocadas());
    }
    
    @Test
    public void CT04testarContar0Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
    
    @Test
    public void CT05testarContar0Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCinquentaCentavosColocadas());
    }
    
    @Test
    public void CT06testarContar0Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void CT07testarSeTemDiheiro0(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(false,e.hasDinheiroColocado());
    }
        
    @Test
    public void CT08testarSeTemDinheiroColocando0moedasPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(false, e.hasMoedasDevolvidasNoDispenser());
    }
    
    @Test
    public void CT09testarContar0MoedasDeTodosOsValoresColocadas(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        assertEquals(0,e.contarMoedasDeCincoCentavosColocadas());
        assertEquals(0,e.contarMoedasDeDezCentavosColocadas());
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosColocadas());
        assertEquals(0,e.contarMoedasDeCinquentaCentavosColocadas());
        assertEquals(0,e.contarMoedasDeUmRealColocadas());
    }
    
    @Test
    public void CT10testarContar0Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 0);
        assertEquals(0, e.contarMoedasDeCincoCentavosNoCofre());
    }
    
    @Test
    public void CT11testarContar0moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void CT12testarContar0moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void CT13testarContar0moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void CT14testarContar0moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        assertEquals(0,e.contarMoedasDeUmRealNoCofre());
    }
    
}

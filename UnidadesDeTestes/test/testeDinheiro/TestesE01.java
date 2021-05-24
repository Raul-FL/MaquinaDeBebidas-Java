package testeDinheiro;

import bebidasO.DispenserDeBebidas;
import org.junit.Test;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.EntradaDeDinheiroEntupidaException;
import interfaceComUsuario.Display;
import interfaceComUsuario.Teclado;
import logica.Controlador;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestesE01 {

    DispenserDeBebidas bebi;
    EntradaEDispenserDeDinheiro din;
    Display tela;
    Teclado tecla;
    Controlador controlador;

    @Before
    public void setUp() {

        bebi = new DispenserDeBebidas(10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        din = new EntradaEDispenserDeDinheiro(10, 10, 10, 10, 10);
        tela = new Display();
        tecla = new Teclado();
        controlador = new Controlador(bebi, din, tela, tecla);

    }
    

    @Test
    public void CT04testarSeTem1Moeda5centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1, 0, 0, 0, 0);
        assertEquals(1, e.contarMoedasDeCincoCentavosNoCofre());
    }
    
    @Test
    public void CT05testarSeTem1Moeda10centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 1, 0, 0, 0);
        assertEquals(1, e.contarMoedasDeDezCentavosNoCofre());
    }

    @Test
    public void CT06testarSeTem1Moeda25centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 1, 0, 0);
        assertEquals(1, e.contarMoedasDeVinteECincoCentavosNoCofre());
    }    
    
    @Test
    public void CT07testarSeTem1Moeda50centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 1, 0);
        assertEquals(1, e.contarMoedasDeCinquentaCentavosNoCofre());
    }

    @Test
    public void CT08testarSeTem1Moeda1RealNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 1);
        assertEquals(1, e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void CT09testarSe30Tem1Moeda5centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(30, 0, 0, 0, 0);
        assertEquals(30, e.contarMoedasDeCincoCentavosNoCofre());
    }
    
    @Test
    public void CT10testarSeTem30Moeda10centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 30, 0, 0, 0);
       assertEquals(30, e.contarMoedasDeDezCentavosNoCofre());
    }

    @Test
    public void CT11testarSeTem30Moeda25centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 30, 0, 0);
        assertEquals(30, e.contarMoedasDeVinteECincoCentavosNoCofre());
    }    
    
    @Test
    public void CT12testarSeTem30Moeda50centavosNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 30, 0);
        assertEquals(30, e.contarMoedasDeCinquentaCentavosNoCofre());
    }

    @Test
    public void CT13testarSeTem30Moeda1RealNaCriacao(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 30);
        assertEquals(30, e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void CT14testarContar1Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeCincoCentavos();
        
        assertEquals(1,e.contarMoedasDeCincoCentavosColocadas());
    }
    
    @Test
    public void CT15testarContar1Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
               e.sinalColocarMoedaDeDezCentavos();
               
        assertEquals(1,e.contarMoedasDeDezCentavosColocadas());
    }
    
    @Test
    public void CT16testarContar1Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
            e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(1,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
    
    @Test
    public void CT17testarContar1Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);    
        e.sinalColocarMoedaDeCinquentaCentavos();
        assertEquals(1,e.contarMoedasDeCinquentaCentavosColocadas());
    }
    
    @Test
    public void CT18testarContar1Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);        
        e.sinalColocarMoedaDeUmReal();
        assertEquals(1,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void CT19testarContar30Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        assertEquals(30,e.contarMoedasDeCincoCentavosColocadas());
    }
    
    @Test
    public void CT20testarContar30Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30;i++){
               e.sinalColocarMoedaDeDezCentavos();
         }
        assertEquals(30,e.contarMoedasDeDezCentavosColocadas());
    }
    
    @Test
    public void CT21testarContar30Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(30,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
    
    @Test
    public void CT22testarContar30Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        assertEquals(30,e.contarMoedasDeCinquentaCentavosColocadas());
    }
    
    @Test
    public void CT23testarContar30Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        int teste;
        
        for(int i=0; i<30; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(30,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void CT24testarSeTemDinheiroColocando1Moeda5centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        
        e.sinalColocarMoedaDeCincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void CT25testarSeTemDinheiroColocando1moedaDe5centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1,0,0,0,0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }
        
    @Test
    public void CT26testarSeTemDinheiroColocando30moedas5centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }
    
    @Test
    public void CT27testarSeTemDinheiroEngolindo29MoedasDe25Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<29; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }
    
    @Test
    public void CT28testarContar10Moedas5centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        assertEquals(10,e.contarMoedasDeCincoCentavosColocadas());
    }
    
    @Test
    public void CT29testarContar10Moedas10centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10;i++){
               e.sinalColocarMoedaDeDezCentavos();
         }
        assertEquals(10,e.contarMoedasDeDezCentavosColocadas());
    }
   
    @Test
    public void CT30testarContar10Moedas25centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosColocadas());
    }
  
    @Test
    public void CT31testarContar10Moedas50centavosColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        assertEquals(10,e.contarMoedasDeCinquentaCentavosColocadas());
    }

    @Test
    public void CT32testarContar10Moedas1RealColocadas(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(10,e.contarMoedasDeUmRealColocadas());
        
    }
    
    @Test
    public void CT33testarSeTemDinheiroColocando5moedas1real(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(30,30,30,30,30);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(30, e.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(30, e.contarMoedasDeDezCentavosNoCofre());
        assertEquals(30, e.contarMoedasDeVinteECincoCentavosNoCofre());
        assertEquals(30, e.contarMoedasDeCinquentaCentavosNoCofre());
        assertEquals(30, e.contarMoedasDeUmRealNoCofre());
    }
        
    @Test
   public void CT34testar30moedasCadaTipoCriacao() throws EntradaDeDinheiroEntupidaException{
       EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);

       for(int i=0; i<10; i++){
           e.sinalColocarMoedaDeCincoCentavos();
       }

       e.engolirTodoODinheiroColocado();
       assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
   }

    @Test
    public void CT35testarContar1Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1, 0, 0, 0, 0);
        assertEquals(1,  e.contarMoedasDeCincoCentavosNoCofre());
    }

    @Test
    public void CT36testarContar1moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,1,0,0,0);
        assertEquals(1,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void CT37testarContar1moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,1,0,0);
        assertEquals(1,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void CT38testarContar1moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,1,0);
        assertEquals(1,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void CT39testarContar1moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,1);
        assertEquals(1,e.contarMoedasDeUmRealNoCofre());
    }
           
    @Test
    public void CT40testarContar10Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(10, 0, 0, 0, 0);
        int teste = e.contarMoedasDeCincoCentavosNoCofre();
        assertEquals(10, teste);
    }
    
    @Test
    public void CT41testarContar10moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,10,0,0,0);
        assertEquals(10,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void CT42testarContar10moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,10,0,0);
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void CT43testarContar10moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,10,0);
        assertEquals(10,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void CT44testarContar10moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,10);
        assertEquals(10,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void CT45testarContar2000Moedas5centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(2000, 0, 0, 0, 0);
        int teste = e.contarMoedasDeCincoCentavosNoCofre();
        assertEquals(2000, teste);
    }
    
    @Test
    public void CT46testarContar2000moedas10centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,2000,0,0,0);
        assertEquals(2000,e.contarMoedasDeDezCentavosNoCofre());
    }
    
    @Test
    public void CT47testarContar2000moedas25centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,2000,0,0);
        assertEquals(2000,e.contarMoedasDeVinteECincoCentavosNoCofre());
    }
    
    @Test
    public void CT48testarContar2000moedas50centavosNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,2000,0);
        assertEquals(2000,e.contarMoedasDeCinquentaCentavosNoCofre());
    }
    
    @Test
    public void CT49testarContar2000moedas1realNoCofre(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,2000);
        assertEquals(2000,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void CT50testarContar1MoedaDeTodosOsValoresNoCofre(){
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
    public void CT51testarContar10MoedaDeTodosOsValoresNoCofre(){
        
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(10,10,10,10,10);
        
        assertEquals(10,e.contarMoedasDeCincoCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeDezCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeVinteECincoCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeCinquentaCentavosNoCofre());
        assertEquals(10,e.contarMoedasDeUmRealNoCofre());
    }
    
    @Test
    public void CT52testarSeTemDinheiroColocando1Moeda5centavos2(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        
        e.sinalColocarMoedaDeCincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT53testarSeTemDinheiroColocando1moeda10centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeDezCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void CT54testarSeTemDinheiroColocando1moeda25centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void CT55testarSeTemDinheiroColocando1moeda50centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT56testarSeTemDinheiroColocando1moeda1real(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeUmReal();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void CT57testarSeTemDinheiroColocando1deCadaMoeda(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        e.sinalColocarMoedaDeCincoCentavos();
        e.sinalColocarMoedaDeCinquentaCentavos();
        e.sinalColocarMoedaDeDezCentavos();
        e.sinalColocarMoedaDeUmReal();
        e.sinalColocarMoedaDeVinteECincoCentavos();
        assertEquals(true,e.hasDinheiroColocado());
    }
        
    @Test
    public void CT58testarSeTemDinheiroColocando5deCadaMoeda(){
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
    public void CT59testarSeTemDinheiroColocando5moedas5centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT60testarSeTemDinheiroColocando5moedas10centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT61testarSeTemDinheiroColocando5moedas25centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT62testarSeTemDinheiroColocando5moedas50centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT63testarSeTemDinheiroColocando5moedas1real2(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<5;i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT64testarSeTemDinheiroColocando30moedas5centavos2(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT65testarSeTemDinheiroColocando30moedas10centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT66testarSeTemDinheiroColocando30moedas25centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT67testarSeTemDinheiroColocando30moedas50centavos(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT68testarSeTemDinheiroColocando30moedas1real(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(50,50,50,50,50);
        for(int i=0;i<30;i++){
            e.sinalColocarMoedaDeUmReal();
        }
        assertEquals(true,e.hasDinheiroColocado());
    }

    @Test
    public void CT69testarSeTemDinheiroColocando1moedaDe5centavosPorParametro2(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(1,0,0,0,0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT70testarSeTemDinheiroColocando1moedaDe10centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,1,0,0,0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT71testarSeTemDinheiroColocando1moedaDe25centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 1, 0, 0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT72testarSeTemDinheiroColocando1moedaDe50centavosPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 1, 0);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT73testarSeTemDinheiroColocando1moedaDe1RealPorParametro(){
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0, 0, 0, 0, 1);
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT74testarSeTemDinheiroEngolindo1MoedasDe5Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        e.sinalColocarMoedaDeCincoCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT75testarSeTemDinheiroEngolindo1MoedasDe10Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,1,0,0,0);
        e.sinalColocarMoedaDeDezCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT76testarSeTemDinheiroEngolindo1MoedasDe25Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        e.sinalColocarMoedaDeVinteECincoCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT77testarSeTemDinheiroEngolindo1MoedasDe50Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,1,0);
        e.sinalColocarMoedaDeCinquentaCentavos();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT78testarSeTemDinheiroEngolindo1MoedasDe1real() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        e.sinalColocarMoedaDeUmReal();
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
   public void CT79testarSeTemDinheiroEngolindo10MoedasDe5Centavos2() throws EntradaDeDinheiroEntupidaException{
       EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);

       for(int i=0; i<10; i++){
           e.sinalColocarMoedaDeCincoCentavos();
       }

       e.engolirTodoODinheiroColocado();
       assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
   }

    @Test
    public void CT80testarSeTemDinheiroEngolindo10MoedasDe10Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT81testarSeTemDinheiroEngolindo10MoedasDe25Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT82testarSeTemDinheiroEngolindo10MoedasDe50Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT83testarSeTemDinheiroEngolindo10MoedasDe1real() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        for(int i=0; i<10; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }   
        
    @Test
    public void CT84testarSeTemDinheiroEngolindo29MoedasDe5Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<29; i++){
            e.sinalColocarMoedaDeCincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT85testarSeTemDinheiroEngolindo29MoedasDe10Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<29; i++){
            e.sinalColocarMoedaDeDezCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT86testarSeTemDinheiroEngolindo29MoedasDe25Centavos2() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<29; i++){
            e.sinalColocarMoedaDeVinteECincoCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT87testarSeTemDinheiroEngolindo29MoedasDe50Centavos() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        
        for(int i=0; i<29; i++){
            e.sinalColocarMoedaDeCinquentaCentavos();
        }
        
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }

    @Test
    public void CT88testarSeTemDinheiroEngolindo29MoedasDe1real() throws EntradaDeDinheiroEntupidaException{
        EntradaEDispenserDeDinheiro e = new EntradaEDispenserDeDinheiro(0,0,0,0,0);
        for(int i=0; i<29; i++){
            e.sinalColocarMoedaDeUmReal();
        }
        e.engolirTodoODinheiroColocado();
        assertEquals(true, e.hasMoedasDevolvidasNoDispenser());
    }           
        
    @Test
    public void comEstaqueCOCA_COLA() {
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.COCA_COLA, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueCOCA_LIGHT() {
        
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.COCA_LIGHT, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueCOCA_ZERO() {

        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.COCA_ZERO, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueFANTA_LARANJA() {
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_LARANJA, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueFANTA_UVA() {
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_UVA, controlador.valorInserido()));
    }
        
    @Test
    public void comEstaqueKUAT_GUARANA() {

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.KUAT_GUARANA, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueSCHWEPPES() {
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();
        din.sinalColocarMoedaDeUmReal();

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueSCHWEPPES_CITRUS() {

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES_CITRUS, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueSPRITE() {

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE, controlador.valorInserido()));
    }

    @Test
    public void comEstaqueSPRITE_ZERO() {

        assertTrue(controlador.vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE_ZERO, controlador.valorInserido()));
    }

}

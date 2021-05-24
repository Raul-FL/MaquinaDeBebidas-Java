package maquinadebebidas;

import bebidasO.DispenserDeBebidas;
import bebidasO.IDispenserDeBebidas;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import dinheiroIO.IEntradaEDispenserDeDinheiro;
import excecoes.DispenserDeBebidasEmperradoException;
import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemBebidaDisponivelException;
import excecoes.SemMoedasSuficientesException;
import excecoes.SinalInvalidoNoDispenserDeBebidasException;
import excecoes.SinalInvalidoNoTecladoException;
import interfaceComUsuario.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.IControlador;

public class Controlador implements IControlador {

    DispenserDeBebidas bebidas;
    EntradaEDispenserDeDinheiro dinheiro;
    Display tela;
    Teclado teclado;
    boolean manutencao = true;

    public Controlador(IDispenserDeBebidas bebidas, IEntradaEDispenserDeDinheiro dinheiro, IDisplay tela, ITeclado teclado) {
        this.bebidas = (DispenserDeBebidas) bebidas;
        this.dinheiro = (EntradaEDispenserDeDinheiro) dinheiro;
        this.tela = (Display) tela;
        this.teclado = (Teclado) teclado;
    }

    public void checkup() {
        if (bebidas.isDispenserTravado() && !bebidas.isDispenserAberto()
                && !dinheiro.hasDinheiroColocado()) {
            manutencao = false;
        }
    }

    @Override
    public void dinheiroInserido() {

        try {
            if (dinheiro.hasMoedasDevolvidasNoDispenser()) {
               
                tela.mostrarMensagem("moeda inserida");
                tela.mostrarMensagem("Valor inserido: " + valorInserido());
              
            } else {
                dinheiro.devolverTodoODinheiroColocado();
                throw new SemMoedasSuficientesException("Sem moedas no dispenser");
            }
        } catch (EntradaDeDinheiroEntupidaException ex) {
            tela.mostrarMensagem(ex.getMessage());
            manutencao = true;
        } catch (SemMoedasSuficientesException e) {
            manutencao = true;
            tela.mostrarMensagem(e.getMessage());
        }
    }

    public BigDecimal valorInserido() {

        BigDecimal moedacinco = new BigDecimal(dinheiro.contarMoedasDeCincoCentavosColocadas()).multiply(new BigDecimal(5));
        BigDecimal moedadez = new BigDecimal(dinheiro.contarMoedasDeDezCentavosColocadas()).multiply(new BigDecimal(10));
        BigDecimal moedavintecinco = new BigDecimal(dinheiro.contarMoedasDeVinteECincoCentavosColocadas()).multiply(new BigDecimal(25));
        BigDecimal moedacinquenta = new BigDecimal(dinheiro.contarMoedasDeCinquentaCentavosColocadas()).multiply(new BigDecimal(50));
        BigDecimal moedaumreal = new BigDecimal(dinheiro.contarMoedasDeUmRealColocadas()).multiply(new BigDecimal(100));

        BigDecimal result = new BigDecimal(0);
        result = result.add(moedacinco);
        result = result.add(moedadez);
        result = result.add(moedavintecinco);
        result = result.add(moedacinquenta);
        result = result.add(moedaumreal);
        
        System.out.println("resultado"+result);
        return result;
    }

    @Override
    public void botaoPressionado(int botao) {
        try {
            switch (botao) {
                case Teclado.BOTAO_COCA_COLA:
                    teclado.sinalBotaoCocaCola();
                    BigDecimal Valorprod = new BigDecimal("260");
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.COCA_COLA)) {
                        calculartroco(Valorprod, valorInserido());
                    }
                    break;
                case Teclado.BOTAO_COCA_LIGHT:
                    String precoCocaLight = "295";
                    teclado.sinalBotaoCocaLight();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.COCA_LIGHT)) {
                        calculartroco(new BigDecimal(precoCocaLight), valorInserido());
                    }

                    break;
                case Teclado.BOTAO_COCA_ZERO:
                    String precoCocaZero = "310";
                    teclado.sinalBotaoCocaZero();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.COCA_ZERO)) {
                        calculartroco(new BigDecimal(precoCocaZero), valorInserido());
                    }

                    break;
                case Teclado.BOTAO_SPRITE:
                    String precoSprite = "225";
                    teclado.sinalBotaoSprite();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE)) {
                        calculartroco(new BigDecimal(precoSprite), valorInserido());
                    }

                    break;
                case Teclado.BOTAO_SPRITE_ZERO:
                    String precoSpriteZero = "290";
                    teclado.sinalBotaoSpriteZero();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE_ZERO)) {
                        calculartroco(new BigDecimal(precoSpriteZero), valorInserido());
                    }

                case Teclado.BOTAO_FANTA_LARANJA:
                    String precoFantaLaranja = "195";
                    teclado.sinalBotaoFantaLaranja();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_LARANJA)) {
                        calculartroco(new BigDecimal(precoFantaLaranja), valorInserido());
                    }

                    break;
                case Teclado.BOTAO_FANTA_UVA:
                    String precoFantaUva = "195";
                    teclado.sinalBotaoFantaUva();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_UVA)) {
                        calculartroco(new BigDecimal(precoFantaUva), valorInserido());
                    }
                    break;
                case Teclado.BOTAO_KUAT_GUARANA:
                    String precoKuatGuarana = "175";
                    teclado.sinalBotaoKuatGuarana();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.KUAT_GUARANA)) {
                        calculartroco(new BigDecimal(precoKuatGuarana), valorInserido());
                    }
                    break;
                case Teclado.BOTAO_SCHWEPPES:
                    String precoSchweppes = "275";
                    teclado.sinalBotaoSchweppes();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES)) {
                        calculartroco(new BigDecimal(precoSchweppes), valorInserido());
                    }

                    break;
                case Teclado.BOTAO_SCHWEPPES_CITRUS:
                    String precoSchweppesCitrus = "285";
                    teclado.sinalBotaoSchweppesCitrus();
                    if (vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES_CITRUS)) {
                        calculartroco(new BigDecimal(precoSchweppesCitrus), valorInserido());
                    }

                    break;
                default:
                    teclado.sinalGetBotaoPressionado();

                    break;
            }

        } catch (SinalInvalidoNoTecladoException | NullPointerException ex) {
            System.out.println("ESCOLHA UMA BEBIDA");
             menuBebidas();
        }
    }

    public boolean vereficaEstoqueBebidas(int bebida) {

    
                if (DispenserDeBebidas.COCA_COLA == bebida) {
                try {
                     tela.mostrarMensagem("COCA_COLA");
                    bebidas.liberarBebida(DispenserDeBebidas.COCA_COLA);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                    tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                    menuBebidas();
                    return false;
                }
                   
                }
                if (DispenserDeBebidas.COCA_LIGHT == bebida) {
                    
                try {
                    tela.mostrarMensagem("COCA_LIGHT");
                    bebidas.liberarBebida(DispenserDeBebidas.COCA_LIGHT);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                     tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                     menuBebidas();
                     return false;
                }
                    
                }
                if (DispenserDeBebidas.COCA_ZERO == bebida) {
                try {
                     tela.mostrarMensagem("COCA_ZERO");
                    bebidas.liberarBebida(DispenserDeBebidas.COCA_ZERO);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                   tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                   menuBebidas();
                   return false;
                }
                   
                }
                if (DispenserDeBebidas.FANTA_LARANJA == bebida) {
                try {
                        tela.mostrarMensagem("FANTA_LARANJA");
                    bebidas.liberarBebida(DispenserDeBebidas.FANTA_LARANJA);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                   tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                   menuBebidas();
                   return false;
                }
                
                }
                if (DispenserDeBebidas.FANTA_UVA == bebida) {
                try {
                      tela.mostrarMensagem("FANTA_UVA");
                    bebidas.liberarBebida(DispenserDeBebidas.FANTA_UVA);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                    tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                    menuBebidas();
                    return false;
                }
                  
                }
                if (DispenserDeBebidas.KUAT_GUARANA == bebida) {
                try {
                             tela.mostrarMensagem("KUAT_GUARANA");
                    bebidas.liberarBebida(DispenserDeBebidas.KUAT_GUARANA);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                    tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                    menuBebidas();
                    return false;
                }
           
                }
                if (DispenserDeBebidas.SCHWEPPES == bebida) {
                try {
                           tela.mostrarMensagem("SCHWEPPES");
                    bebidas.liberarBebida(DispenserDeBebidas.SCHWEPPES);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                   tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                   menuBebidas();
                   return false;
                }
             
                }
                if (DispenserDeBebidas.SCHWEPPES_CITRUS == bebida) {
                try {
                      tela.mostrarMensagem("SCHWEPPES_CITRUS");
                    bebidas.liberarBebida(DispenserDeBebidas.SCHWEPPES_CITRUS);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                   tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                   menuBebidas();
                   return false;
                }
                  
                }
                if (DispenserDeBebidas.SPRITE == bebida) {
                try {
                     tela.mostrarMensagem("SPRITE");
                    bebidas.liberarBebida(DispenserDeBebidas.SPRITE);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                   tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                   menuBebidas();
                   return false;
                }
                   
                }
                if (DispenserDeBebidas.SPRITE_ZERO == bebida) {
                    
                try {
                     tela.mostrarMensagem("SPRITE_ZERO");
                    bebidas.liberarBebida(DispenserDeBebidas.SPRITE_ZERO);
                    return true;
                } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SemBebidaDisponivelException ex) {
                    tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                    menuBebidas();
                    return false;
                }
                   
                }
            
      
        return true;
    }

    public BigDecimal calculartroco(BigDecimal bebidas, BigDecimal valor) {
        DecimalFormat formatter = new DecimalFormat();
        BigDecimal falta ;
        BigDecimal troco = new BigDecimal("0");

        if (valor.intValueExact() < bebidas.intValueExact()) {
            falta = bebidas.subtract(valor);

            tela.mostrarMensagem("DINHEIRO INSUFICIENTE R$" + formatter.format(falta.divide(new BigDecimal(100)).round(MathContext.DECIMAL64)));
        }
        if (valor == bebidas) {
            tela.mostrarMensagem("NÃ£o SObra");

        }

        if (valor.intValueExact() > bebidas.intValueExact()) {
            troco = valor.subtract(bebidas);

            BigDecimal cincoCentavos = new BigDecimal("0");
            BigDecimal dezCentavos = new BigDecimal("0");
            BigDecimal vintaEcincoCentavos = new BigDecimal("0");
            BigDecimal cinquentaCentavos = new BigDecimal("0");
            BigDecimal humReal = new BigDecimal("0");
            tela.mostrarMensagem("R$" + troco.divide(new BigDecimal(100).round(MathContext.DECIMAL32)));

            if (dinheiro.contarMoedasDeUmRealNoCofre() > 0) {

                try {
                    while (troco.intValueExact() >= 100) {
                        troco = troco.subtract(new BigDecimal("100"));

                        humReal = humReal.add(new BigDecimal("1"));
                    }
                    dinheiro.devolverMoedasDeUmRealComoTroco(humReal.intValueExact());
                    dinheiro.contarMoedasDeUmRealNoCofre();
                    System.out.println("[" + humReal + "]Moedas de Hum Real");
                    System.out.println("[" + dinheiro.contarMoedasDeUmRealNoCofre() + "]Moedas de Hum Real no cofre");

                } catch (SemMoedasSuficientesException ex) {
                    tela.mostrarMensagem("DINHEIRO INSUFICIENTE");

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 51 real");
            }

            if (dinheiro.contarMoedasDeCinquentaCentavosNoCofre() > 0) {

                try {
                    while (troco.intValueExact() >= 50) {
                        troco = troco.subtract(new BigDecimal("50"));
                        cinquentaCentavos = cinquentaCentavos.add(new BigDecimal("1"));
                    }

                    dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(cinquentaCentavos.intValueExact());
                    System.out.println("[" + cinquentaCentavos + "]Moedas de 50 Centavos");
                } catch (SemMoedasSuficientesException ex) {
                    tela.mostrarMensagem("DINHEIRO INSUFICIENTE");

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 50");
            }
            if (dinheiro.contarMoedasDeVinteECincoCentavosNoCofre() > 0) {

                try {
                    while (troco.intValueExact() >= 25) {
                        troco = troco.subtract(new BigDecimal("25"));
                        vintaEcincoCentavos = vintaEcincoCentavos.add(new BigDecimal("1"));
                    }

                    dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(vintaEcincoCentavos.intValueExact());
                    System.out.println("[" + vintaEcincoCentavos + "]Moedas de 25 Centavos");
                } catch (SemMoedasSuficientesException ex) {
                    tela.mostrarMensagem("DINHEIRO INSUFICIENTE");

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 25");
            }

            if (dinheiro.contarMoedasDeDezCentavosNoCofre() > 0) {

                try {
                    while (troco.intValueExact() >= 10) {
                        troco = troco.subtract(new BigDecimal("10"));
                        dezCentavos = dezCentavos.add(new BigDecimal("1"));
                    }

                    dinheiro.devolverMoedasDeDezCentavosComoTroco(dezCentavos.intValueExact());
                    System.out.println("[" + dezCentavos + "]Moedas de 10 Centavos");
                } catch (SemMoedasSuficientesException ex) {
                    tela.mostrarMensagem("DINHEIRO INSUFICIENTE");

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 10");
            }
            if (dinheiro.contarMoedasDeCincoCentavosNoCofre() > 0) {

                try {
                    while (troco.intValueExact() >= 5) {
                        troco = troco.subtract(new BigDecimal("5"));
                        cincoCentavos = cincoCentavos.add(new BigDecimal("1"));
                    }

                    dinheiro.devolverMoedasDeCincoCentavosComoTroco(cincoCentavos.intValueExact());
                    System.out.println("[" + cincoCentavos + "]Moedas de 5 Centavos");
                } catch (SemMoedasSuficientesException ex) {
                    tela.mostrarMensagem("DINHEIRO INSUFICIENTE");

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 5");
            }

        }
        if (troco.intValueExact() != 0) {
            tela.mostrarMensagem("Em ManutenÃ§Ã£o R$" + troco);
        }
        try {
            dinheiro.engolirTodoODinheiroColocado();
        } catch (EntradaDeDinheiroEntupidaException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
  System.out.println("moedas 1 no cofre apos engolir "+dinheiro.contarMoedasDeUmRealNoCofre() );
  System.out.println("moedas 50 no cofre apos engolir "+dinheiro.contarMoedasDeCinquentaCentavosNoCofre() );
  System.out.println("moedas 25 no cofre apos engolir "+dinheiro.contarMoedasDeVinteECincoCentavosNoCofre() );
  System.out.println("moedas 10 no cofre apos engolir "+dinheiro.contarMoedasDeDezCentavosNoCofre() );
  System.out.println("moedas 05 no cofre apos engolir "+dinheiro.contarMoedasDeCincoCentavosNoCofre() );

        return troco;

    }

    public void pegarBebida() {
        Scanner in = new Scanner(System.in);
        String a = "random";
        boolean got = true;
        try {
            bebidas.destravarDispenser();
            while (!a.equalsIgnoreCase(a)) {
                System.out.println("Digite [A] abrir para pegar a bebida");
                a = in.nextLine();
                if (bebidas.isDispenserAberto()) {
                    bebidas.sinalGetBebidaLiberada();
                    got = false;
                } else {
                    manutencao = true;
                    throw new DispenserDeBebidasEmperradoException();
                }
            }

            if (bebidas.isDispenserAberto() && !got) {
                bebidas.sinalFecharPortinha();
                bebidas.travarDispenser();
            } else {
                manutencao = true;
                throw new DispenserDeBebidasEmperradoException();
            }

        } catch (DispenserDeBebidasEmperradoException ex) {
            tela.mostrarMensagem(ex.getMessage());
        }

    }

    public void menuColocarMoedas() {

        Scanner entrada = new Scanner(System.in);

        boolean loop = true;

        while (loop == true) {

            try {
                System.out.println("Selecione a moeda que deseja colocar");
                System.out.println("[1] 5 centavos");
                System.out.println("[2] 10 centavos");
                System.out.println("[3] 25 centavos");
                System.out.println("[4] 50 centavos");
                System.out.println("[5] 1 real");
                System.out.println("[6] Devolver dinheiro inserido");
                System.out.println("[0] Sair");

                int in = entrada.nextInt();
                switch (in) {

                    case 1:
                        dinheiro.sinalColocarMoedaDeCincoCentavos();
                        valorInserido();

                        break;

                    case 2:
                        dinheiro.sinalColocarMoedaDeDezCentavos();
                        valorInserido();
                        break;

                    case 3:
                        dinheiro.sinalColocarMoedaDeVinteECincoCentavos();
                        valorInserido();
                        break;

                    case 4:
                        dinheiro.sinalColocarMoedaDeCinquentaCentavos();
                        valorInserido();
                        break;

                    case 5:
                        dinheiro.sinalColocarMoedaDeUmReal();
                        valorInserido();
                        break;

                    case 6:
                        dinheiro.devolverTodoODinheiroColocado();
                        break;

                    case 0:
                        tela.mostrarMensagem("Dinheiro na inserido" + valorInserido().divide(new BigDecimal(100)).round(MathContext.DECIMAL64));
                        loop = false;
                        menuBebidas();
                        break;

                }
            } catch (EntradaDeDinheiroEntupidaException ex) {
                manutencao = true;
                tela.mostrarMensagem(ex.getMessage());
            }

        }
    }

    public void menuBebidas() {
        boolean loop = true;

        //while(manutencao){
        //    checkup();
        //}
        do {

            try {

                Scanner entrada = new Scanner(System.in);

                while (loop == true) {
                    System.out.println("Selecione Um Produto:");
                    System.out.println("================================================");
                    System.out.println("1. Coca cola - R$ 2,60");
                    System.out.println("2. Coca Zero - R$ 3,10");
                    System.out.println("3. Cola Light - R$ 2,95");
                    System.out.println("4. Fanta Laranja - R$ 1,95");
                    System.out.println("5. Fanta Uva - R$ 1,95");
                    System.out.println("6. Sprite - R$ 2,25");
                    System.out.println("7. Sprite Zero - R$ 2,90");
                    System.out.println("8. Kuat GuaranÃƒÂ¡ - R$ 1,75");
                    System.out.println("9. Schweppes - R$ 2,75");
                    System.out.println("10. Scheppes Citrus - R$ 2,85");
                    System.out.println();

                    int in = entrada.nextInt();

                    switch (in) {

                        case 1:
                            botaoPressionado(Teclado.BOTAO_COCA_COLA);
                            loop = false;
                            break;

                        case 2:
                            botaoPressionado(Teclado.BOTAO_COCA_ZERO);
                            loop = false;
                            break;

                        case 3:
                            botaoPressionado(Teclado.BOTAO_COCA_LIGHT);
                            loop = false;
                            break;

                        case 4:
                            botaoPressionado(Teclado.BOTAO_SPRITE);
                            loop = false;
                            break;

                        case 5:
                            botaoPressionado(Teclado.BOTAO_SPRITE_ZERO);
                            loop = false;

                            break;

                        case 6:
                            botaoPressionado(Teclado.BOTAO_FANTA_LARANJA);
                            loop = false;
                            break;

                        case 7:

                            botaoPressionado(Teclado.BOTAO_KUAT_GUARANA);
                            loop = false;
                            break;

                        case 8:
                            botaoPressionado(Teclado.BOTAO_SCHWEPPES);
                            loop = false;
                            break;

                        case 9:
                            botaoPressionado(Teclado.BOTAO_SCHWEPPES_CITRUS);
                            loop = false;
                            break;
                        default:
                            botaoPressionado(teclado.sinalGetBotaoPressionado());
                            break;
                    }
                }
            } catch (SinalInvalidoNoTecladoException | NullPointerException ex) {
                System.err.println("ESCOLHA UMA BEBIDA");
                menuBebidas();
                loop = false;
            }
        } while (loop == false);
    }
}

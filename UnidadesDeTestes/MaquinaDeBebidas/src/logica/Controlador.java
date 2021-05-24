package logica;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador implements IControlador {

    DispenserDeBebidas bebidas;
    EntradaEDispenserDeDinheiro dinheiro;
    Display tela;
    Teclado teclado;
    boolean manutencao = true;
    private BigDecimal diferencaValorInsValCofre;

    public Controlador(IDispenserDeBebidas bebidas, IEntradaEDispenserDeDinheiro dinheiro, IDisplay tela, ITeclado teclado) {
        this.bebidas = (DispenserDeBebidas) bebidas;
        this.dinheiro = (EntradaEDispenserDeDinheiro) dinheiro;
        this.tela = (Display) tela;
        this.teclado = (Teclado) teclado;

        checkup();

    }

    public void checkup() {
        if (bebidas.isDispenserTravado() && !bebidas.isDispenserAberto()
                && !dinheiro.hasDinheiroColocado()) {
            manutencao = false;
        }
    }

    public int contarMoedas() {
        int moedasColocadas= dinheiro.contarMoedasDeCincoCentavosColocadas()
                + dinheiro.contarMoedasDeDezCentavosColocadas()
                + dinheiro.contarMoedasDeVinteECincoCentavosColocadas()
                + dinheiro.contarMoedasDeCinquentaCentavosColocadas()
                + dinheiro.contarMoedasDeUmRealColocadas();

        return moedasColocadas;
    }

    @Override
    public void dinheiroInserido() {

        try {
            if (contarMoedas() >= 30) {
                manutencao = true;
                throw new EntradaDeDinheiroEntupidaException("ENTRADA DE $ ENTUPIDA");
            }
            if (dinheiro.hasDinheiroColocado()) {
                tela.mostrarMensagem("moeda inserida");
                tela.mostrarMensagem("R$" + valorInserido().divide(new BigDecimal(100), MathContext.DECIMAL64));

            } else if (contarMoedas() == 0) {
                dinheiro.devolverTodoODinheiroColocado();
                tela.mostrarMensagem("");
            }
        } catch (EntradaDeDinheiroEntupidaException ex) {
            tela.mostrarMensagem(ex.getMessage());
            manutencao = true;
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

        System.out.println("Resultado " + result.divide(new BigDecimal(100).round(MathContext.DECIMAL64)));

        return result;
    }

    @Override
    public void botaoPressionado(int botao) {
        boolean loop = true;

        try {
            if (!bebidas.isDispenserTravado() && bebidas.isDispenserAberto()) {
                throw new DispenserDeBebidasEmperradoException("DISPENSER EMPERRADO");
            } else if (!bebidas.isDispenserTravado() && !bebidas.isDispenserAberto()) {
                throw new DispenserDeBebidasEmperradoException("DISPENSER EMPERRADO");
            }
            if (contarMoedas() >= 30) {
                throw new EntradaDeDinheiroEntupidaException("ENTRADA DE $ ENTUPIDA");
            }
            switch (botao) {
                case Teclado.BOTAO_COCA_COLA:
                    teclado.sinalBotaoCocaCola();
                    BigDecimal Valorprod = new BigDecimal("260");
                    if (valorInserido().intValueExact() >= Valorprod.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.COCA_COLA, Valorprod)) {
                            calculartroco(Valorprod, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.COCA_COLA, Valorprod)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }

                    break;
                case Teclado.BOTAO_COCA_LIGHT:
                    teclado.sinalBotaoCocaCola();
                    BigDecimal Valorcocalight = new BigDecimal("295");
                    if (valorInserido().intValueExact() >= Valorcocalight.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.COCA_COLA, Valorcocalight)) {
                            calculartroco(Valorcocalight, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.COCA_LIGHT, Valorcocalight)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }

                    break;
                case Teclado.BOTAO_COCA_ZERO:
                    teclado.sinalBotaoCocaZero();
                    BigDecimal precoCocaZero = new BigDecimal("310");

                    if (valorInserido().intValueExact() >= precoCocaZero.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.COCA_ZERO, precoCocaZero)) {
                            calculartroco(precoCocaZero, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.COCA_ZERO, precoCocaZero)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");

                    }
                    break;
                case Teclado.BOTAO_SPRITE:
                    BigDecimal precoSprite = new BigDecimal("225");
                    teclado.sinalBotaoSprite();
                    if (valorInserido().intValueExact() >= precoSprite.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE, precoSprite)) {
                            calculartroco(precoSprite, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE, precoSprite)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }
                    break;
                case Teclado.BOTAO_SPRITE_ZERO:
                    BigDecimal precoSpriteZero = new BigDecimal("290");
                    teclado.sinalBotaoSpriteZero();
                    if (valorInserido().intValueExact() >= precoSpriteZero.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE_ZERO, precoSpriteZero)) {
                            calculartroco(precoSpriteZero, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.SPRITE_ZERO, precoSpriteZero)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }

                    break;
                case Teclado.BOTAO_FANTA_LARANJA:
                    BigDecimal precoFantaLaranja = new BigDecimal("195");
                    teclado.sinalBotaoFantaLaranja();
                    if (valorInserido().intValueExact() >= precoFantaLaranja.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_LARANJA, precoFantaLaranja)) {
                            calculartroco(precoFantaLaranja, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_LARANJA, precoFantaLaranja)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }
                    break;
                case Teclado.BOTAO_FANTA_UVA:
                    BigDecimal precoFantaUva = new BigDecimal("195");
                    teclado.sinalBotaoFantaUva();
                    if (valorInserido().intValueExact() >= precoFantaUva.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_UVA, precoFantaUva)) {
                            calculartroco(precoFantaUva, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.FANTA_UVA, precoFantaUva)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }

                    break;
                case Teclado.BOTAO_KUAT_GUARANA:
                    BigDecimal precoKuatGuarana = new BigDecimal("175");
                    BigDecimal valor = valorInserido();
                    teclado.sinalBotaoKuatGuarana();
                    if (valorInserido().intValueExact() >= precoKuatGuarana.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.KUAT_GUARANA, precoKuatGuarana)) {
                            calculartroco(precoKuatGuarana, valor);
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.KUAT_GUARANA, precoKuatGuarana)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }
                    break;
                case Teclado.BOTAO_SCHWEPPES:
                    BigDecimal precoSchweppes = new BigDecimal("275");
                    teclado.sinalBotaoSchweppes();
                    if (valorInserido().intValueExact() >= precoSchweppes.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES, precoSchweppes)) {
                            calculartroco(precoSchweppes, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES, precoSchweppes)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }
                    break;
                case Teclado.BOTAO_SCHWEPPES_CITRUS:
                    BigDecimal precoSchweppesCitrus = new BigDecimal("285");
                    teclado.sinalBotaoSchweppesCitrus();
                    if (valorInserido().intValueExact() >= precoSchweppesCitrus.intValueExact()) {
                        if (vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES_CITRUS, precoSchweppesCitrus)) {
                            calculartroco(precoSchweppesCitrus, valorInserido());
                        }

                    } else if (!vereficaEstoqueBebidas(DispenserDeBebidas.SCHWEPPES_CITRUS, precoSchweppesCitrus)) {
                        throw new SemBebidaDisponivelException("BEBIDA INDISPONÃ�VEL");

                    } else {
                        tela.mostrarMensagem("DINHEIRO INSUFICIENTE");
                    }
                    break;

                case Teclado.BOTAO_DEVOLVER_DINHEIRO:
                    teclado.sinalBotaoDevolverDinheiro();
                    // while (dinheiro.hasMoedasDevolvidasNoDispenser()) {
                    dinheiro.devolverTodoODinheiroColocado();

                    break;
                default:

                    teclado.sinalGetBotaoPressionado();
                    loop = false;
                    break;
            }

        } catch (EntradaDeDinheiroEntupidaException ex) {
            tela.mostrarMensagem("ENTRADA DE $ ENTUPIDA");
        } catch (SinalInvalidoNoTecladoException | NullPointerException ex) {
            tela.mostrarMensagem("PROBLEMA NO DISPENSER");
        } catch (DispenserDeBebidasEmperradoException ex) {
            tela.mostrarMensagem(ex.getMessage());
        } catch (SemBebidaDisponivelException ex) {
            tela.mostrarMensagem(ex.getMessage());

        }

    }

    public boolean vereficaEstoqueBebidas(int bebida, BigDecimal valor) {

        if (DispenserDeBebidas.COCA_COLA == bebida) {
            try {
                if(valorInserido().intValueExact() > valor.intValueExact()){
                    tela.mostrarMensagem("COCA_COLA");
                    bebidas.liberarBebida(DispenserDeBebidas.COCA_COLA);
                    return true;
                }

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
                System.out.println("SINAL INVÃ�LIDO");
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                return false;
            }
        }
        if (DispenserDeBebidas.COCA_LIGHT == bebida) {
            try {
                tela.mostrarMensagem("COCA_LIGHT");
                bebidas.liberarBebida(DispenserDeBebidas.COCA_LIGHT);
                return true;
            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                tela.mostrarMensagem(ex.getMessage());
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }
        if (DispenserDeBebidas.COCA_ZERO == bebida) {
            try {
                tela.mostrarMensagem("COCA_ZERO");
                bebidas.liberarBebida(DispenserDeBebidas.COCA_ZERO);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }
        }
        if (DispenserDeBebidas.FANTA_LARANJA == bebida) {
            try {
                tela.mostrarMensagem("FANTA_LARANJA");
                bebidas.liberarBebida(DispenserDeBebidas.FANTA_LARANJA);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }
        if (DispenserDeBebidas.FANTA_UVA == bebida) {
            try {
                tela.mostrarMensagem("FANTA_UVA");
                bebidas.liberarBebida(DispenserDeBebidas.FANTA_UVA);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");
                // menuBebidas();
                return false;
            }

        }
        if (DispenserDeBebidas.KUAT_GUARANA == bebida) {
            try {
                tela.mostrarMensagem("KUAT_GUARANA");
                bebidas.liberarBebida(DispenserDeBebidas.KUAT_GUARANA);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }
        if (DispenserDeBebidas.SCHWEPPES == bebida) {
            try {
                tela.mostrarMensagem("SCHWEPPES");
                bebidas.liberarBebida(DispenserDeBebidas.SCHWEPPES);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }
        if (DispenserDeBebidas.SCHWEPPES_CITRUS == bebida) {
            try {
                tela.mostrarMensagem("SCHWEPPES_CITRUS");
                bebidas.liberarBebida(DispenserDeBebidas.SCHWEPPES_CITRUS);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }
        if (DispenserDeBebidas.SPRITE == bebida) {
            try {
                tela.mostrarMensagem("SPRITE");
                bebidas.liberarBebida(DispenserDeBebidas.SPRITE);
                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }
        if (DispenserDeBebidas.SPRITE_ZERO == bebida) {

            try {
                tela.mostrarMensagem("SPRITE_ZERO");
                bebidas.liberarBebida(DispenserDeBebidas.SPRITE_ZERO);

                return true;

            } catch (SinalInvalidoNoDispenserDeBebidasException ex) {
                Logger.getLogger(Controlador.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (SemBebidaDisponivelException ex) {
                tela.mostrarMensagem("BEBIDA INDISPONÃ�VEL");

                return false;
            }

        }

        return true;
    }

    public BigDecimal contarValorDoCofre() {

        BigDecimal moedacinco = new BigDecimal(dinheiro.contarMoedasDeCincoCentavosNoCofre()).multiply(new BigDecimal(5));
        BigDecimal moedadez = new BigDecimal(dinheiro.contarMoedasDeDezCentavosNoCofre()).multiply(new BigDecimal(10));
        BigDecimal moedavintecinco = new BigDecimal(dinheiro.contarMoedasDeVinteECincoCentavosNoCofre()).multiply(new BigDecimal(25));
        BigDecimal moedacinquenta = new BigDecimal(dinheiro.contarMoedasDeCinquentaCentavosNoCofre()).multiply(new BigDecimal(50));
        BigDecimal moedaumreal = new BigDecimal(dinheiro.contarMoedasDeUmRealNoCofre()).multiply(new BigDecimal(100));
        BigDecimal result = new BigDecimal(0);

        result = result.add(moedacinco);
        result = result.add(moedadez);
        result = result.add(moedavintecinco);
        result = result.add(moedacinquenta);
        result = result.add(moedaumreal);

        return result;
    }

    // calcula o troco 
    public BigDecimal calculartroco(BigDecimal bebidas, BigDecimal valor) {
        BigDecimal falta;
        BigDecimal diferenca = new BigDecimal("0");
        BigDecimal troco = new BigDecimal("0");
        BigDecimal valorMenosTroco = new BigDecimal("0");
        boolean dinheiroSuf = true;
        try {
            if (contarValorDoCofre().intValueExact() < valorInserido().intValueExact()) {
                BigDecimal diferencaValorInsValCofre = valorInserido().subtract(contarValorDoCofre());
                valorMenosTroco = diferencaValorInsValCofre.subtract(bebidas);
                dinheiro.devolverMoedasDeCincoCentavosComoTroco(dinheiro.contarMoedasDeCincoCentavosNoCofre());
                dinheiro.devolverMoedasDeDezCentavosComoTroco(dinheiro.contarMoedasDeDezCentavosNoCofre());
                dinheiro.devolverMoedasDeVinteECincoCentavosComoTroco(dinheiro.contarMoedasDeVinteECincoCentavosNoCofre());
                dinheiro.devolverMoedasDeCinquentaCentavosComoTroco(dinheiro.contarMoedasDeCinquentaCentavosNoCofre());
                dinheiro.devolverMoedasDeUmRealComoTroco(dinheiro.contarMoedasDeUmRealNoCofre());
                manutencao = true;

                throw new SemMoedasSuficientesException("R$" + valorMenosTroco.divide(new BigDecimal(100)).round(MathContext.DECIMAL64));
            }
        } catch (SemMoedasSuficientesException ex) {
            tela.mostrarMensagem(ex.getMessage());
            return valorMenosTroco;
        }
        if (valor.intValueExact() < bebidas.intValueExact()) {
            try {

                falta = bebidas.subtract(valor);
                dinheiro.engolirTodoODinheiroColocado();
                tela.mostrarMensagem("R$" + falta.divide(new BigDecimal(100)).round(MathContext.DECIMAL64));
                dinheiroSuf = false;

            } catch (EntradaDeDinheiroEntupidaException ex) {
                tela.mostrarMensagem("ENTRADA DE $ ENTUPIDA");
                manutencao = true;
            }
        }
        if (valor == bebidas) {
            tela.mostrarMensagem("NÃ£o SObra");
            dinheiroSuf = false;
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
                    dinheiroSuf = false;
                    manutencao = true;

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 1 real");
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
                    dinheiroSuf = false;
                    manutencao = true;

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
                    dinheiroSuf = false;
                    manutencao = true;

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
                    dinheiroSuf = false;
                    manutencao = true;

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 10");
                valor.subtract(contarValorDoCofre());
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
                    dinheiroSuf = false;
                    manutencao = true;

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Controlador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                System.err.println("Sem moedas de 5");
            }

        }
        if (troco.intValueExact() != 0) {
            tela.mostrarMensagem("R$" + troco.divide(new BigDecimal(100)).round(MathContext.DECIMAL64));
          manutencao=true;
        }

        if (dinheiroSuf == true) {
            pegarBebida();
            return troco;
        }

        try {
            dinheiro.engolirTodoODinheiroColocado();

        } catch (EntradaDeDinheiroEntupidaException ex) {
            Logger.getLogger(Controlador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("moedas 1 no cofre apos engolir " + dinheiro.contarMoedasDeUmRealNoCofre());
        System.out.println("moedas 50 no cofre apos engolir " + dinheiro.contarMoedasDeCinquentaCentavosNoCofre());
        System.out.println("moedas 25 no cofre apos engolir " + dinheiro.contarMoedasDeVinteECincoCentavosNoCofre());
        System.out.println("moedas 10 no cofre apos engolir " + dinheiro.contarMoedasDeDezCentavosNoCofre());
        System.out.println("moedas 05 no cofre apos engolir " + dinheiro.contarMoedasDeCincoCentavosNoCofre());
        diferenca = diferenca.add(troco.subtract(diferencaValorInsValCofre));
        return troco;

    }


    public void pegarBebida() {

        try {

            bebidas.destravarDispenser();
            bebidas.sinalAbrirPortinha();
            if (bebidas.isDispenserAberto()) {
                bebidas.sinalGetBebidaLiberada();
                System.out.println("Porta aberta bebida liberada");
                bebidas.sinalFecharPortinha();
                bebidas.travarDispenser();
                if (bebidas.isDispenserTravado()) {
                    System.out.println("Pegou a bebida, fechou e travou o dispenser");
                }
            } else {
                manutencao = true;
                throw new DispenserDeBebidasEmperradoException("DISPENSER EMPERRADO");
            }

        } catch (DispenserDeBebidasEmperradoException ex) {
            tela.mostrarMensagem(ex.getMessage());
        }

    }

}

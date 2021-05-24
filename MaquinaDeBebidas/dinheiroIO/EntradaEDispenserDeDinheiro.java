package dinheiroIO;

import dinheiroIO.IEntradaEDispenserDeDinheiro;
import excecoes.EntradaDeDinheiroEntupidaException;
import excecoes.SemMoedasSuficientesException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntradaEDispenserDeDinheiro
implements IEntradaEDispenserDeDinheiro {
    private HashMap<Integer, Integer> moedasNoCofre = new HashMap();
    private HashMap<Integer, Integer> moedasColocadasNaEntrada = new HashMap();
    private HashMap<Integer, Integer> moedasNoDispenser = new HashMap();

    public EntradaEDispenserDeDinheiro(int quantidadeCincoCentavos, int quantidadeDezCentavos, int quantidadeVinteECincoCentavos, int quantidadeCinquentaCentavos, int quantidadeUmReal) {
        if (quantidadeCincoCentavos < 0 || quantidadeCinquentaCentavos < 0 || quantidadeDezCentavos < 0 || quantidadeUmReal < 0 || quantidadeVinteECincoCentavos < 0) {
            throw new IllegalArgumentException();
        }
        if (quantidadeCincoCentavos > 2000 || quantidadeCinquentaCentavos > 2000 || quantidadeDezCentavos > 2000 || quantidadeUmReal > 2000 || quantidadeVinteECincoCentavos > 2000) {
            throw new IllegalArgumentException();
        }
        this.moedasNoCofre.put(5, quantidadeCincoCentavos);
        this.moedasNoCofre.put(10, quantidadeDezCentavos);
        this.moedasNoCofre.put(25, quantidadeVinteECincoCentavos);
        this.moedasNoCofre.put(50, quantidadeCinquentaCentavos);
        this.moedasNoCofre.put(100, quantidadeUmReal);
        this.moedasColocadasNaEntrada.put(5, 0);
        this.moedasColocadasNaEntrada.put(10, 0);
        this.moedasColocadasNaEntrada.put(25, 0);
        this.moedasColocadasNaEntrada.put(50, 0);
        this.moedasColocadasNaEntrada.put(100, 0);
        this.moedasNoDispenser.put(5, 0);
        this.moedasNoDispenser.put(10, 0);
        this.moedasNoDispenser.put(25, 0);
        this.moedasNoDispenser.put(50, 0);
        this.moedasNoDispenser.put(100, 0);
    }

    @Override
    public int contarMoedasDeCincoCentavosColocadas() {
        return this.moedasColocadasNaEntrada.get(5);
    }

    @Override
    public int contarMoedasDeDezCentavosColocadas() {
        return this.moedasColocadasNaEntrada.get(10);
    }

    @Override
    public int contarMoedasDeVinteECincoCentavosColocadas() {
        return this.moedasColocadasNaEntrada.get(25);
    }

    @Override
    public int contarMoedasDeCinquentaCentavosColocadas() {
        return this.moedasColocadasNaEntrada.get(50);
    }

    @Override
    public int contarMoedasDeUmRealColocadas() {
        return this.moedasColocadasNaEntrada.get(100);
    }

    @Override
    public boolean hasDinheiroColocado() {
        boolean temDinheiro = false;
        for (Map.Entry<Integer, Integer> par : this.moedasColocadasNaEntrada.entrySet()) {
            if (par.getValue() <= 0) continue;
            temDinheiro = true;
        }
        return temDinheiro;
    }

    @Override
    public void engolirTodoODinheiroColocado() throws EntradaDeDinheiroEntupidaException {
        int quantidadeDeMoedas = 0;
        for (Map.Entry<Integer, Integer> par222 : this.moedasColocadasNaEntrada.entrySet()) {
            quantidadeDeMoedas += par222.getValue().intValue();
        }
        if (quantidadeDeMoedas > 29) {
            throw new EntradaDeDinheiroEntupidaException();
        }
        for (Map.Entry<Integer, Integer> par222 : this.moedasColocadasNaEntrada.entrySet()) {
            this.moedasNoCofre.put(par222.getKey(), par222.getValue() + this.moedasNoCofre.get(par222.getKey()));
        }
        for (Map.Entry<Integer, Integer> par222 : this.moedasNoCofre.entrySet()) {
            this.moedasColocadasNaEntrada.put(par222.getKey(), 0);
        }
        for (Map.Entry<Integer, Integer> par222 : this.moedasNoCofre.entrySet()) {
            if (this.moedasNoCofre.get(par222.getKey()) <= 2000) continue;
            throw new EntradaDeDinheiroEntupidaException();
        }
    }

    @Override
    public void devolverTodoODinheiroColocado() throws EntradaDeDinheiroEntupidaException {
        int quantidadeDeMoedas = 0;
        for (Map.Entry<Integer, Integer> par22 : this.moedasColocadasNaEntrada.entrySet()) {
            quantidadeDeMoedas += par22.getValue().intValue();
        }
        if (quantidadeDeMoedas > 30) {
            throw new EntradaDeDinheiroEntupidaException();
        }
        for (Map.Entry<Integer, Integer> par22 : this.moedasColocadasNaEntrada.entrySet()) {
            this.moedasNoDispenser.put(par22.getKey(), par22.getValue() + this.moedasNoDispenser.get(par22.getKey()));
        }
        for (Map.Entry<Integer, Integer> par22 : this.moedasNoDispenser.entrySet()) {
            this.moedasColocadasNaEntrada.put(par22.getKey(), 0);
        }
    }

    @Override
    public void devolverMoedasDeCincoCentavosComoTroco(int quantidade) throws SemMoedasSuficientesException, IllegalArgumentException {
        if (quantidade < 0) {
            throw new IllegalArgumentException();
        }
        if (quantidade > this.moedasNoCofre.get(5)) {
            throw new SemMoedasSuficientesException();
        }
        this.moedasNoCofre.put(5, this.moedasNoCofre.get(5) - quantidade);
        this.moedasNoDispenser.put(5, this.moedasNoDispenser.get(5) + quantidade);
    }

    @Override
    public void devolverMoedasDeDezCentavosComoTroco(int quantidade) throws SemMoedasSuficientesException, IllegalArgumentException {
        if (quantidade < 0) {
            throw new IllegalArgumentException();
        }
        if (quantidade > this.moedasNoCofre.get(10)) {
            throw new SemMoedasSuficientesException();
        }
        this.moedasNoCofre.put(10, this.moedasNoCofre.get(10) - quantidade);
        this.moedasNoDispenser.put(10, this.moedasNoDispenser.get(10) + quantidade);
    }

    @Override
    public void devolverMoedasDeVinteECincoCentavosComoTroco(int quantidade) throws SemMoedasSuficientesException, IllegalArgumentException {
        if (quantidade < 0) {
            throw new IllegalArgumentException();
        }
        if (quantidade > this.moedasNoCofre.get(25)) {
            throw new SemMoedasSuficientesException();
        }
        this.moedasNoCofre.put(25, this.moedasNoCofre.get(25) - quantidade);
        this.moedasNoDispenser.put(25, this.moedasNoDispenser.get(25) + quantidade);
    }

    @Override
    public void devolverMoedasDeCinquentaCentavosComoTroco(int quantidade) throws SemMoedasSuficientesException, IllegalArgumentException {
        if (quantidade > this.moedasNoCofre.get(50)) {
            throw new SemMoedasSuficientesException();
        }
        this.moedasNoCofre.put(50, this.moedasNoCofre.get(50) - quantidade);
        this.moedasNoDispenser.put(50, this.moedasNoDispenser.get(50) + quantidade);
    }

    @Override
    public void devolverMoedasDeUmRealComoTroco(int quantidade) throws SemMoedasSuficientesException, IllegalArgumentException {
        if (quantidade < 0) {
            throw new IllegalArgumentException();
        }
        if (quantidade > this.moedasNoCofre.get(100)) {
            throw new SemMoedasSuficientesException();
        }
        this.moedasNoCofre.put(100, this.moedasNoCofre.get(100) - quantidade);
        this.moedasNoDispenser.put(100, this.moedasNoDispenser.get(100) + quantidade);
    }

    @Override
    public boolean hasMoedasDevolvidasNoDispenser() {
        boolean temDinheiro = false;
        for (Map.Entry<Integer, Integer> par : this.moedasNoDispenser.entrySet()) {
            if (par.getValue() <= 0) continue;
            temDinheiro = true;
        }
        return temDinheiro;
    }

    public void sinalColocarMoedaDeCincoCentavos() {
        this.moedasColocadasNaEntrada.put(5, this.moedasColocadasNaEntrada.get(5) + 1);
    }

    public void sinalColocarMoedaDeDezCentavos() {
        this.moedasColocadasNaEntrada.put(10, this.moedasColocadasNaEntrada.get(10) + 1);
    }

    public void sinalColocarMoedaDeVinteECincoCentavos() {
        this.moedasColocadasNaEntrada.put(25, this.moedasColocadasNaEntrada.get(25) + 1);
    }

    public void sinalColocarMoedaDeCinquentaCentavos() {
        this.moedasColocadasNaEntrada.put(50, this.moedasColocadasNaEntrada.get(50) + 1);
    }

    public void sinalColocarMoedaDeUmReal() {
        this.moedasColocadasNaEntrada.put(100, this.moedasColocadasNaEntrada.get(100) + 1);
    }

    public int sinalPegarMoedasDeCincoCentavos() {
        int moedas = this.moedasNoDispenser.get(5);
        this.moedasNoDispenser.put(5, 0);
        return moedas;
    }

    public int sinalPegarMoedasDeDezCentavos() {
        int moedas = this.moedasNoDispenser.get(10);
        this.moedasNoDispenser.put(10, 0);
        return moedas;
    }

    public int sinalPegarMoedasDeVinteECincoCentavos() {
        int moedas = this.moedasNoDispenser.get(25);
        this.moedasNoDispenser.put(25, 0);
        return moedas;
    }

    public int sinalPegarMoedasDeCinquentaCentavos() {
        int moedas = this.moedasNoDispenser.get(50);
        this.moedasNoDispenser.put(50, 0);
        return moedas;
    }

    public int sinalPegarMoedasDeUmReal() {
        int moedas = this.moedasNoDispenser.get(100);
        this.moedasNoDispenser.put(100, 0);
        return moedas;
    }

    @Override
    public int contarMoedasDeCincoCentavosNoCofre() {
        return this.moedasNoCofre.get(5);
    }

    @Override
    public int contarMoedasDeDezCentavosNoCofre() {
        return this.moedasNoCofre.get(10);
    }

    @Override
    public int contarMoedasDeVinteECincoCentavosNoCofre() {
        return this.moedasNoCofre.get(25);
    }

    @Override
    public int contarMoedasDeCinquentaCentavosNoCofre() {
        return this.moedasNoCofre.get(50);
    }

    @Override
    public int contarMoedasDeUmRealNoCofre() {
        return this.moedasNoCofre.get(100);
    }
}


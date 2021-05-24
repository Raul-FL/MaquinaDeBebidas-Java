package maquinadebebidas;

import bebidasO.DispenserDeBebidas;
import dinheiroIO.EntradaEDispenserDeDinheiro;
import excecoes.SemMoedasSuficientesException;
import interfaceComUsuario.Display;
import interfaceComUsuario.Teclado;


class Maquina {
	
	
	public static void main(String[] args) {
		
		
        EntradaEDispenserDeDinheiro dinheiro = new EntradaEDispenserDeDinheiro(10, 10, 10, 10, 10);
        DispenserDeBebidas bebidas = new DispenserDeBebidas(10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        Display tela = new Display();
        Teclado teclado = new Teclado();
      Controlador con = new Controlador(bebidas, dinheiro, tela, teclado);
      con.menuColocarMoedas();
    }
}
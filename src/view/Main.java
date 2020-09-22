package view;

import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class Main {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int i = 0; i < 4; i++) {
			Thread cruzamento = new Cruzamento(i, semaforo);
			cruzamento.start();
		}

	}

}

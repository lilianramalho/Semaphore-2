package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {
	int carro;
	Semaphore semaforo;
	String sentido;
	
	public Cruzamento(int carro , Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		direcao();
		try {
			semaforo.acquire();
			cruzando();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cruzou();
		semaforo.release();
	}
	
	public void direcao() {
		if (carro == 0) {
			sentido = "NORTE";
		}else if (carro == 1) {
			sentido = "SUL";
		}else if (carro == 2) {
			sentido = "LESTE";
		}else if (carro == 3) {
			sentido = "OESTE";
		}
	}
	
	public void cruzando() {
		System.out.println("O carro "+carro+ " está sentido "+sentido);
		
		try {
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cruzou() {
		System.out.println("O carro " +carro+ " cruzou sentido "+sentido);
	}
}

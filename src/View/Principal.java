package View;
import java.util.concurrent.Semaphore;
import Controller.Carros;
public class Principal {
	public static void main(String[] args) {
			
		Semaphore semaforo = new Semaphore (1); 
			String [] Sentido  = {"Frente", "Esquerda", "Direita", "Frente"};	
		int totalcar = 4;

		 
		for (int idthread = 1; idthread <= totalcar; idthread++) {
			Thread Carros = new Carros (semaforo,idthread, Sentido [idthread - 1]);
			Carros.start();
			}

		}
		}

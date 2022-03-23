package Controller;

import java.util.concurrent.Semaphore;

public class Carros extends Thread{
public String Sentido;
private Semaphore semaforo;
private int idthread;

 
public  Carros (Semaphore semaforo,int idthread, String Sentido ) {
	 this.semaforo = semaforo;
	 this.Sentido = Sentido;
	 this.idthread = idthread;
 }

public void run () {
	
	CE();
	 try {
		 CA();
		semaforo.acquire();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	 finally {
		 semaforo.release();
	 }CC();
}

public void CA () {
		 int t = 0;
			
			t = (int) ((Math.random()*3000)+1000);
			
			try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				e.printStackTrace ();
			}
			
			System.out.println("O carro:" + idthread + " esta passando pelo cruzamento.");
	 }
 
 public void CE () {
	 System.out.println("O carro:" + idthread + " Parou no Cruzamento!");
 }
 
 public void CC () {
	 System.out.println("O carro:" + idthread + " Cruzou Para " + Sentido);
 }

 }
 

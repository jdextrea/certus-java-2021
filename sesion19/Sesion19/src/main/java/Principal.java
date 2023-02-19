
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jdextre
 */
public class Principal extends Thread{
	private static double[] vec = new double[80000000];//80.000.000
	private int inicio, fin;
	
	public Principal(int inicio, int fin){
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public static void main(String[] args){
		iniciavec();
		
		//opcion NO concurrente:
		vec_NOconcurrente();
		
		//opcion concurrente:
		vec_concurrente();
	}
	
	//Metodo que inicia el vector estatico con valores aleatorios
	private static void iniciavec(){
		Random rand = new Random(System.nanoTime());
		
		for(int i = 0; i < vec.length; i++){
			vec[i] = rand.nextInt();
		}
	}
	
	//Metodo que NO utiliza el paralelismo y por tanto se ejecuta de forma secuencial
	private static void vec_NOconcurrente(){
		double tiempo = System.nanoTime();
		for(int i = 0; i < vec.length; i++){
			vec[i] /= 10;
			vec[i] *= 10;
			vec[i] /= 10;
		}
		System.out.println("Version NO concurrente: "+ ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}
	
	//Metodo que ejecuta los hilos que que se lanzan
	public void run(){
		for(int i = inicio; i < fin; i++){
			vec[i] /= 10;
			vec[i] *= 10;
			vec[i] /= 10;
		}
	}
	
	//Metodo que ejecuta nproc hilos en paralelo y que llaman al metodo run para realizar la multiplicacion del
	//vector de forma paralela
	private static void vec_concurrente(){
		int nproc = Runtime.getRuntime().availableProcessors(); //Devuelve cuantos nucleos tiene la CPU
		int inicio = 0, fin = 0;
		Principal[] prin = new Principal[nproc];
		
		double tiempo = System.nanoTime(); 	//Comienzo para capturar el tiempo que tarda en ejecutarse 
											//este metodo
		
		for(int i = 0; i < nproc; i++){//Multiplicacion del vector por los nproc hilos
			inicio = fin;
			fin += vec.length/nproc;
			prin[i] = new Principal(inicio, fin);
			prin[i].start();
		}
		
		for(int i = 0; i < nproc; i++){
			try{
				prin[i].join();
			}catch(Exception e){}
		}
		System.out.println("Version Concurrente: "+ ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}		
}

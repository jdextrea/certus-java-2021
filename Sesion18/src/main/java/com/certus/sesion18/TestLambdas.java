/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.certus.sesion18;
    import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestLambdas {

	public static void main(String[] args) {
		List< Usuario> names = new ArrayList<Usuario>();		
	      names.add(new Usuario("Elivar", "Oswaldo", 10, new Direccion("San Pedro")));
	      names.add(new Usuario("Antonio", "Carrion", 15, new Direccion("bellavista")));
	      names.add(new Usuario("Juan", "Andrade", 12,new Direccion("San Pedro1")));
	      names.add(new Usuario("Luis", "Aguilar", 17,new Direccion("San Pedro2")));
	      names.add(new Usuario("Fidel", "Narvaez", 8,new Direccion("San Pedro3")));
	      names.add(new Usuario("Paul", "Guevara", 5,new Direccion("San Pedro4")));
	      //Predicate<Tipo>
	      //predicado: obtiene le número de usuarios con edad mayor >12 años
	      System.out.println("Ejemplo de predicado:");
	      System.out.println("Usuarios mayores a 12 años: "+names.stream().filter(x->x.getEdad()>12 ).count());
	      
	      //Function<T,R>
	      //Funcion: Obtiene la dirección que corresponde al usuario de la posición 0 de la lista
	      System.out.println("\nEjemplo de función:");
	      Function<Usuario,Direccion> funDireccion= v->v.getDir();
	      System.out.println(funDireccion.apply(names.get(0)).getNombre());
	      
	     // Consumer<Tipo>
	      //ejemplo consumidor: Actualiza el apellido del usuario de la posición 0 de la lista
	      System.out.println("\nEjemplo de consumidor:");
	      Consumer<Usuario> cambiaApellido = u->u.setApellido("Aguirre");
	      cambiaApellido.accept(names.get(0));
	       
	      //imprime usuario actualizado
	      names.forEach(System.out::println);
	      
	      //Supplier<Tipo>
	      //proveedor: Crea un nuevo usuario y lo imprime con la función get
	      System.out.println("\nEjemplo de proveedor:");
	      Supplier<Usuario> u=()->new Usuario("Augusto", "Velez", 5,new Direccion("Cayambe"));
	      System.out.println(u.get());	      
	}
}

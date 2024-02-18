package Arreglos;

import java.util.ArrayList;

import Clases.Persona;

public class PersonaArreglo {
	
	ArrayList<Persona> personas;

	/*public PersonaArreglo() {
		mi tonteria
	}*/
	public void crearArrayList() {
		
		personas = new ArrayList(); 
	}
	
	public void insertarPersona(Persona persona) {
		personas.add(persona);
	}
	
	public  ArrayList<Persona> devolverInformacion() {
		return personas;
	}
	public int longitud() {
		return personas.size();
	}
	public  Persona getPersona(int index) {
		return personas.get(index);
	}
	
}

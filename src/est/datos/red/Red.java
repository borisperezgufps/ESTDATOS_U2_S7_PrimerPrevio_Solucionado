package est.datos.red;

import est.datos.listas.DoubleCircularLinkedList;
import est.datos.listas.LinkedList;

public class Red {

	private LinkedList<Computador> listaBeta;
	private DoubleCircularLinkedList<Computador> listaAlfa;
	
	public Red() {
		listaBeta = new LinkedList<Computador>();
		listaAlfa = new DoubleCircularLinkedList<Computador>();
	}
	
	/**
	 * Este m�todo agrega los computadores a la lista Beta correspondiente
	 * a los computadores apagados.
	 * @param direccionIP
	 */
	public void agregarComputadorApagado(int direccionIP) {
		
		Computador com = new Computador();
		com.setDireccionIP(direccionIP);
		// La variable encendido se inicializa como false
		// La variable maxMem se inicializa en el constructor
		
		listaBeta.agregar(com);				
		
	}
	
	/**
	 * Enciende un computador. Imprime OK si fue exitoso, e imprime NOK
	 * si no encuentra el computador.
	 * @param dirIP
	 */
	public void encenderComputador(int dirIP) throws Exception {
		
		Computador pcAEliminar = new Computador();
		pcAEliminar.setDireccionIP(dirIP);
		
		Computador cEliminado = listaBeta.eliminar(pcAEliminar);
		if(cEliminado==null)
			throw new Exception("No se encontr� el computador");
		
		cEliminado.setEncendido(true);
		
		listaAlfa.agregar(cEliminado);
	}
	
	/**
	 * Apaga un computador. Imprime OK si fue exitoso, e imprime NOK
	 * si no encuentra el computador.
	 * @param dirIP
	 */
	public void apagarComputador(int dirIP) throws Exception {
		
		Computador pcAEliminar = new Computador();
		pcAEliminar.setDireccionIP(dirIP);
		
		Computador cEliminado = listaAlfa.eliminar(pcAEliminar);
		if(cEliminado==null)
			throw new Exception("No se encontr� el computador");
		
		cEliminado.setEncendido(false);
		cEliminado.setMaxMem(1000);
		
		listaBeta.agregar(cEliminado);
	}
	
	
	public void consumirInternet(int numVeces) throws Exception{		
		
		for(int x=0;x<numVeces;x++) {
		
			for(int t=0;t<listaAlfa.getSize();t++) {
				Computador c = listaAlfa.get(t); // Se requiri� la implementaci�n de este m�todo en la lista
				int memoriaUsadaM = (int) (Math.random() * 100);
				c.setMaxMem(c.getMaxMem()-memoriaUsadaM);
				if(c.getMaxMem()<=0) {
					apagarComputador(c.getDireccionIP());
				}
			}
			
		}
	}
	
	public void finalizarRed() {
		LinkedList<Computador> listaGamma = new LinkedList<Computador>();
		
		/*
		 * Se obtienen los nodos de cada lista y se van agregando.
		 * Como debe representarse la concatenaci�n, entonces deben sacarse
		 * primer los nodos de una lista, y luego los nodos de la otra lista. 
		 */
		
		
		for(int t=0;t<listaAlfa.getSize();t++) {
			Computador c = listaAlfa.get(t); // Se requiri� la implementaci�n de este m�todo en la lista
			
			listaGamma.agregar(c);
		}
		
		for(int t=0;t<listaBeta.getSize();t++) {
			Computador c = listaBeta.get(t); // Se requiri� la implementaci�n de este m�todo en la lista
			
			listaGamma.agregar(c);
		}
		
			
	}
	
}

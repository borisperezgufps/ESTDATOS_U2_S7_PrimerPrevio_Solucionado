package est.datos.listas;

public class Nodo<E> {

	private E data; 
	private Nodo<E> next;
	
	public Nodo(E ele) {
		data = ele;
	}
	
	public void setNext(Nodo<E> next) {
		this.next = next;
	}
	
	public Nodo<E> getNext(){
		return next;
	}
	
	public E getData() {
		return data;
	}
	
}

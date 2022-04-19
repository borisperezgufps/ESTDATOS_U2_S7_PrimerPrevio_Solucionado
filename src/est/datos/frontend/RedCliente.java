package est.datos.frontend;

import est.datos.red.Red;

public class RedCliente {

	public static void main(String[] args) {
		Red r = new Red();
		
		r.agregarComputadorApagado(4); // OK
		r.agregarComputadorApagado(3); // OK
		r.agregarComputadorApagado(7); // OK
		r.agregarComputadorApagado(2); // OK
		r.agregarComputadorApagado(5); // OK
		
		try {
			
			r.encenderComputador(7); // OK
			r.encenderComputador(2); // OK
			r.encenderComputador(4); // OK
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			r.consumirInternet(3);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
				
		try {
			
			r.apagarComputador(2); // OK
			r.apagarComputador(4); // OK
			r.apagarComputador(8); // NOK
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		r.finalizarRed();
		
		
	}
	
}

package est.datos.red;

public class Computador {

	private int direccionIP;
	private boolean encendido;
	private int maxMem;
	
	public Computador() {
		maxMem = 1000;
	}
	
	public int getMaxMem() {
		return maxMem;
	}
	public void setMaxMem(int maxMem) {
		this.maxMem = maxMem;
	}
	public int getDireccionIP() {
		return direccionIP;
	}
	public void setDireccionIP(int direccionIP) {
		this.direccionIP = direccionIP;
	}
	public boolean isEncendido() {
		return encendido;
	}
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	
	@Override
	public boolean equals(Object obj) {
		int cont = 0;
		
		Computador com = (Computador) obj;
		
		if(com.getDireccionIP()>0) {
			if(this.getDireccionIP()==com.getDireccionIP())
				cont++;
		}
		
		if(cont>0)
			return true;
		
		return false;
	}
	
	
}

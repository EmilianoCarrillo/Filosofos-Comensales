package Monitores;

class Mesa{
	
	ListaCircular<String> estadoOf = new ListaCircular<String>();
	
	public Mesa() {
		for(int i =0; i < 5 ; i++) {
			estadoOf.add("Pensando");
		}
	}
	
	public void probar_bocado(int i) {
		if (estadoOf.get(i) == "Hambriento" && estadoOf.get(i - 1) != "Comiendo" && estadoOf.get(i + 1) != "Comiendo") {
			estadoOf.set(i, "Comiendo");
		}
	}
	
	public void tomar_tenedores(int i) {
		while (estadoOf.get(i - 1) == "Comiendo" || estadoOf.get(i + 1) == "Comiendo") {
			Util.myWait(this);
		}
		estadoOf.set(i, "hambriento");
		probar_bocado(i);
	}

	public void bajar_tenedores(int i) {
		probar_bocado(i - 1);
		probar_bocado(i + 1);
		estadoOf.set(i, "Pensando");
		//notify();
	}
	
}
package Semaforos;

class Mesa{
	
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoBinario sinc[] = new SemaforoBinario[5];
	ListaCircular<String> estadoOf = new ListaCircular<String>();
	
	public Mesa() {
		for(int i =0; i < 5 ; i++) {
			sinc[i] = new SemaforoBinario(false);
			estadoOf.add("Pensando");
		}
	}
	
	public void probar_bocado(int i) {
		if (estadoOf.get(i) == "Hambriento" && estadoOf.get(i - 1) != "Comiendo" && estadoOf.get(i + 1) != "Comiendo") {
			estadoOf.set(i, "Comiendo");
			sinc[i].V();
		}
	}
	
	public void tomar_tenedores(int i) {
		mutex.P();
			estadoOf.set(i, "Hambriento");
			probar_bocado(i);
		mutex.V();
		sinc[i].P();
	}

	public void bajar_tenedores(int i) {
		mutex.P();
			probar_bocado(i - 1);
			probar_bocado(i + 1);
		mutex.V();
	}
	
}
package Monitores;

class Mesa {

	ListaCircular<String> estadoOf = new ListaCircular<String>();

	public Mesa() {
		for (int i = 0; i < 5; i++) {
			estadoOf.add("PENSAR");
		}
	}

	public void tomar_tenedores(int i) {
		// Condición de sincronización *********************************************
		while (estadoOf.get(i - 1) == "COMER" || estadoOf.get(i + 1) == "COMER") {
			// //Variable de condición *********************************************
			Util.myWait(this);
		}
		estadoOf.set(i, "HAMBRE");
		probar_bocado(i);
	}
	
	// Método de ingreso ********************************
		public void probar_bocado(int i) {
			if (estadoOf.get(i) == "HAMBRE" && estadoOf.get(i - 1) != "COMER" && estadoOf.get(i + 1) != "COMER") {
				estadoOf.set(i, "COMER");
			}
		}

	// Método de ingreso ********************************
	public void bajar_tenedores(int i) {
		probar_bocado(i - 1);
		probar_bocado(i + 1);
		estadoOf.set(i, "PENSAR");
		// notify();
	}

}
package Monitores;

public class Filosofo implements Runnable {
	Mesa mesa = null;
	int i;

	public Filosofo(Mesa mesa, int i) {
		this.i = i;
		this.mesa = mesa;

		new Thread(this).start();
	}

	public void run() {
		while (true) {
			System.out.println("👴🏻" + i + "💭 ");

			mesa.tomar_tenedores(i);
			Util.mySleep(2000);

			System.out.println("👴🏻" + i + "🍝  tenedores: " + i + ", " + ((i + 1) % 5));

			Util.mySleep(2000);
			mesa.bajar_tenedores(i);

			System.out.println("👴🏻" + i + "⬇️  tenedores: " + i + ", " + ((i + 1) % 5));
		}
	}
}
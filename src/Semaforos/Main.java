package Semaforos;

public class Main {
	public static void main(String[] args) {
		Mesa buffer = new Mesa();
		Filosofo filosofos[] = new Filosofo[5];

		for (int i = 0; i < 5; i++) {
			filosofos[i] = new Filosofo(buffer, i);
		}
	}
}

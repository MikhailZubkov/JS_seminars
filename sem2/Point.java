package JavaProject.Seminars.sem2;

class Point {
	int x, y;   // поля класса

	void print () {  // Не статическая = экземплярная
		System.out.printf ("%d %d\n", x, y);
	}

	static void hello () {  // статическая
		// x, y — нелегально
		System.out.println ("Hello!");
	}

	public static void main (String[] args) {
		Point p = new Point ();
		p.x = 100;
		p.y = 50;
		System.out.println (p.x);
		System.out.println (p.y);

		p.print ();

		Point.hello ();
	}
}

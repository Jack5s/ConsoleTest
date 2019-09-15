package test;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

public class Application {
	public static class P {
		String name = "P";

		public P(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private static P p1 = new P("p1");;

	public static void main(String[] args) {
		System.out.println(-1 % 5);
	}

	static void changeObj(P p) {
		p = new P("pp");
		System.out.println("change p:" + p.toString());
		// p = p1;
		// System.out.println(p.toString());
	}
}
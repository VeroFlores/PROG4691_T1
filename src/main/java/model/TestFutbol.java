package model;

public class TestFutbol {
	public static void main (String[] args) {
		CRUD ope = new CRUD();
		//Listar prooductos
		for(Clube c: ope.seleccionarTodo()) {
			System.out.println(c);
		}
	}
}

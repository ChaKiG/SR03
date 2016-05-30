package calculette;

public class Main {

	public static void main(String[] args) {
		CalculetteProxy c = new CalculetteProxy( "http://localhost:8080/calculette/services/Calculette");
		try {
			System.out.println(c.add(3, 4));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

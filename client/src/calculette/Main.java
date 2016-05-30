package calculette;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CalculetteProxy c = new CalculetteProxy( "http://localhost:8080/calculette/services/Calculette");
		CalculetteProxy c = new CalculetteProxy( );
		try {
			c.add(3, 4);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

package testes;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for testes");
		//$JUnit-BEGIN$
		suite.addTestSuite(TesteRenovarLivro.class);
		suite.addTestSuite(TesteAluguelLivro.class);
		suite.addTestSuite(TesteEntrarFilaEspera.class);
		//$JUnit-END$
		return suite;
	}

}

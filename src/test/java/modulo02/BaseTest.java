//package modulo02;
//
//import org.junit.After;
//import org.junit.Before;
//
//import com.github.jknack.handlebars.Options;
//import com.github.tomakehurst.wiremock.WireMockServer;
//
//public class BaseTest {
//
//	protected WireMockServer wireMockServer;
//
//	@Before
//	public void setup( ) {
//		wireMockServer = new WireMockServer();
//		wireMockServer.start();
//	}
//
//	@After()
//	public void tearDown() {
//		if (wireMockServer != null && wireMockServer.isRunning()) {
//			wireMockServer.stop();
//		}
//	}
//}

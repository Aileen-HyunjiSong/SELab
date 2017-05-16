import junit.framework.TestCase;
import org.easymock.EasyMock;
import java.io.IOException;

public class CurrencyTest extends TestCase {
	
	public void testToEuros() throws IOException {
		Currency test = new Currency(5.0, "KRW");
		Currency expected = new Currency(4.0, "EUR");
		ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
		EasyMock.expect(mock.getRate("KRW", "EUR")).andReturn(0.8);
		EasyMock.replay(mock);
		Currency actual = test.toEuros(mock);
		assertEquals(expected, actual);
	}
}

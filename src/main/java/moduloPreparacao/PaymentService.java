package moduloPreparacao;

import moduloPreparacao.domain.Order;
import moduloPreparacao.domain.PaymentResponse;
import moduloPreparacao.domain.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String url = "http://localhost:8082/api/payment";
	
	public StatusEnum processPayment(Order order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity(headers);
		
		PaymentResponse response = restTemplate.exchange(url, HttpMethod.POST, entity, PaymentResponse.class).getBody();
		return response.getStatus();
	}
}

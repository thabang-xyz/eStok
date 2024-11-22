package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.PaymentRequest;
import com.novation.estok.estok.domain.PaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EftPaymentsService {
    @Value("${eft.base-url}")
    private String baseUrl;

    @Value("${eft.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public EftPaymentsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PaymentResponse makePayment(PaymentRequest paymentRequest) {
        String url = baseUrl + "/make-payment";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<PaymentRequest> entity = new HttpEntity<>(paymentRequest, headers);

        ResponseEntity<PaymentResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, PaymentResponse.class);

        return response.getBody();
    }
}

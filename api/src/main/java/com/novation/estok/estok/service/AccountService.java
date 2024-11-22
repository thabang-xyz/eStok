package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.Account;
import com.novation.estok.estok.domain.AccountDetailsResponse;
import com.novation.estok.estok.model.AccountDTO;
import com.novation.estok.estok.repos.AccountRepository;
import com.novation.estok.estok.util.NotFoundException;

import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AccountService {

    @Value("${accounts.base-url}")
    private String baseUrl;

    @Value("${accounts.api-key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public void AccountsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public AccountDetailsResponse getAccountDetails(String accountId) {
        String url = baseUrl + "/details/" + accountId;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<AccountDetailsResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, AccountDetailsResponse.class);

        return response.getBody();
    }
    private final AccountRepository accountRepository;

    public AccountService(RestTemplate restTemplate, final AccountRepository accountRepository) {
        this.restTemplate = restTemplate;
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> findAll() {
        final List<Account> accounts = accountRepository.findAll(Sort.by("id"));
        return accounts.stream()
                .map(account -> mapToDTO(account, new AccountDTO()))
                .collect(Collectors.toList());
    }

    public AccountDTO get(final Long id) {
        return accountRepository.findById(id)
                .map(account -> mapToDTO(account, new AccountDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final AccountDTO accountDTO) {
        final Account account = new Account();
        mapToEntity(accountDTO, account);
        return accountRepository.save(account).getId();
    }

    public void update(final Long id, final AccountDTO accountDTO) {
        final Account account = accountRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(accountDTO, account);
        accountRepository.save(account);
    }

    public void delete(final Long id) {
        accountRepository.deleteById(id);
    }

    private AccountDTO mapToDTO(final Account account, final AccountDTO accountDTO) {
        accountDTO.setId(account.getId());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setName(account.getName());
        accountDTO.setDescription(account.getDescription());
        return accountDTO;
    }

    private Account mapToEntity(final AccountDTO accountDTO, final Account account) {
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setName(accountDTO.getName());
        account.setDescription(accountDTO.getDescription());
        return account;
    }

}

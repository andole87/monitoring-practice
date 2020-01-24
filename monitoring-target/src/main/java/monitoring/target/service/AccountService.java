package monitoring.target.service;

import lombok.RequiredArgsConstructor;
import monitoring.target.domain.Account;
import monitoring.target.domain.AccountRepository;
import monitoring.target.dto.AccountRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;

    public Account register(AccountRequestDto requestDto) {
        return accountRepository.save(requestDto.toEntity());
    }

    public Account findById(long id) {
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }
}

package monitoring.target.web.controller;

import lombok.RequiredArgsConstructor;
import monitoring.target.domain.Account;
import monitoring.target.dto.AccountRequestDto;
import monitoring.target.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> register(@RequestBody AccountRequestDto requestDto, HttpSession session) {
        Account account = accountService.register(requestDto);
        session.setAttribute("accountId",account.getId());
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity leave(long accountId, HttpSession session) {
        accountService.deleteById(accountId);
        session.removeAttribute("accountId");
        return ResponseEntity.ok().build();
    }
}

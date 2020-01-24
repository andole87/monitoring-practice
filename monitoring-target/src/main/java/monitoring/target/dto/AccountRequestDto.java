package monitoring.target.dto;

import lombok.Data;
import monitoring.target.domain.Account;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Data
public class AccountRequestDto {
    private String name;
    private String password;

    public Account toEntity() {
        return new Account(name,password);
    }
}

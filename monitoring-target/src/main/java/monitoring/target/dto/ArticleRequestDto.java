package monitoring.target.dto;

import lombok.Data;
import monitoring.target.domain.Account;
import monitoring.target.domain.Article;

@Data
public class ArticleRequestDto {
    private String  title;
    private String  contents;

    public Article toEntity(Account author) {
        return new Article(title, contents, author);
    }
}

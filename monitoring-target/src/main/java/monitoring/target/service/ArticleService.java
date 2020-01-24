package monitoring.target.service;

import lombok.RequiredArgsConstructor;
import monitoring.target.domain.Account;
import monitoring.target.domain.Article;
import monitoring.target.domain.ArticleRepository;
import monitoring.target.dto.ArticleRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AccountService accountService;

    public Article publish(long authorId, ArticleRequestDto requestDto) {
        Account author = accountService.findById(authorId);
        return articleRepository.save( requestDto.toEntity(author));
    }

    public List<Article> findByPage (Pageable pageable) {
        Page<Article> paged = articleRepository.findAll(pageable);
        return paged.getContent();
    }

    public void removeById(long articleId) {
        articleRepository.deleteById(articleId);
    }
}

package monitoring.target.web.controller;

import lombok.RequiredArgsConstructor;
import monitoring.target.domain.Article;
import monitoring.target.dto.ArticleRequestDto;
import monitoring.target.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> paged(@PageableDefault Pageable pageable){
        List<Article> paged = articleService.findByPage(pageable);
        return ResponseEntity.ok(paged);
    }

    @PostMapping
    public ResponseEntity<Article> publish(HttpSession session, @RequestBody ArticleRequestDto requestDto) {
        long accountId = (long)session.getAttribute("accountId");
        Article article = articleService.publish(accountId, requestDto);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity remove(@PathVariable long articleId) {
        articleService.removeById(articleId);
        return ResponseEntity.ok().build();
    }
}

package monitoring.target.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50)
    private String title;

    @Lob
    @Column(name = "contents")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "fk_article_account")
    private Account author;

    public Article(String title, String contents, Account author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
}

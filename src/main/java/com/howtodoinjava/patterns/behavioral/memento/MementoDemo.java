import java.util.Objects;

final class Article {
    private String content;

    Article(String content) {
        this.content = Objects.requireNonNull(content);
    }

    void write(String content) {
        this.content = Objects.requireNonNull(content);
    }

    String content() {
        return content;
    }

    Snapshot save() {
        return new Snapshot(this, content);
    }

    void restore(Snapshot snapshot) {
        if (snapshot.owner != this) {
            throw new IllegalArgumentException("Snapshot belongs to another article");
        }
        content = snapshot.content;
    }

    static final class Snapshot {
        private final Article owner;
        private final String content;

        private Snapshot(Article owner, String content) {
            this.owner = owner;
            this.content = content;
        }
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Article article = new Article("First draft");
        Article.Snapshot beforeEdit = article.save();

        article.write("Revised draft");
        System.out.println(article.content());

        article.restore(beforeEdit);
        System.out.println(article.content());
    }
}

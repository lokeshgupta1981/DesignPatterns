import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



interface ReportDocument {
    String read() throws IOException;
}

final class FileReport implements ReportDocument {
    private final String content;

    FileReport(Path path) throws IOException {
        System.out.println("Loading the report file");
        content = Files.readString(path);
    }

    public String read() {
        return content;
    }
}

final class LazyReport implements ReportDocument {
    private final Path path;
    private FileReport target;

    LazyReport(Path path) {
        this.path = path;
    }

    public String read() throws IOException {
        if (target == null) {
            target = new FileReport(path);
        }
        return target.read();
    }
}

public class ProxyDemo {
    public static void main(String[] args) throws IOException {
        Path path = Files.createTempFile("report-", ".txt");
        try {
            Files.writeString(path, "Completed orders 12");
            ReportDocument report = new LazyReport(path);
            System.out.println("Proxy created");
            System.out.println(report.read());
            System.out.println(report.read());
        } finally {
            Files.deleteIfExists(path);
        }
    }
}

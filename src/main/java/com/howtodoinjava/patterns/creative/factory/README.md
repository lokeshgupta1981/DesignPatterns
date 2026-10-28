# Factory: text and HTML previews

JDK 17 or later. From the repository root:

```shell
javac -d out src/main/java/com/howtodoinjava/patterns/creative/factory/*.java
java -cp out com.howtodoinjava.patterns.creative.factory.FactoryDemo
```

RendererFactory is a simple factory: its enum switch chooses a renderer. PreviewService uses Factory Method: its shared preview workflow validates text, and concrete service subclasses override createRenderer(). Both forms use the same Renderer implementations.

HtmlRenderer escapes ampersands and angle brackets in plain text before placing it inside an HTML paragraph. It is limited to this element-text context, not attribute/script encoding or HTML sanitization. PlainTextRenderer returns the supplied text. No network or browser service is invoked.

The demo prints normal results, separate renderer identities, the missing-format exception and the blank-preview exception. Blank-text rejection belongs to PreviewService; the renderers themselves accept blank non-null text.

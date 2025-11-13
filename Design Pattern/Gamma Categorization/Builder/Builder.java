import java.util.ArrayList;

class HtmlElement {
    public String name;
    public String text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
        this.name = "";
        this.text = "";
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }
    
    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = " ".repeat(indent * indentSize);
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.format("%s%s%s", i, text, newLine));
        }
        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }
        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    public String toString() {
        return root.toString();
    }
}

public class Builder {

    public static void main(String[] args) {
        String hello = "Hello";
        System.out.println("<p>" + hello + "</p>");

        String[] words = {"Hello", "World"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (String word : words) {
            sb.append("<li>").append(word).append("</li>");
        }
        sb.append("</ul>");
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("<ul>");
        for (String word : words) {
            sb2.append("<li>").append(word).append("</li>");
        }
        sb2.append("</ul>");
        System.out.println(sb2);

        HtmlBuilder htmlBuilder = new HtmlBuilder("ul");
        htmlBuilder.addChild("li", "Hello").addChild("li", "World");
        System.out.println(htmlBuilder);
    }
}

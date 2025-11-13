import java.util.ArrayList;
import java.util.List;

class Code {
    public String name;
    public String type;

    public Code(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("public %s %s;", type, name);
    }
}

class Class {
    public String name;
    public List<Code> fields = new ArrayList<>();

    public Class() {}
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nl = System.lineSeparator();
        sb.append(String.format("public class %s {%s", name, nl));
        for (Code field : fields) {
            sb.append(String.format("  %s;%s", field.toString(), nl));
        }
        sb.append("}");
        return sb.toString();
    }
}

class CodeBuilder {
    private Class cls = new Class();

    public CodeBuilder(String className) {
        cls.name = className;
    }

    public CodeBuilder addField(String type, String name) {
        cls.fields.add(new Code(name, type));
        return this;
    }

    @Override
    public String toString() {
        return cls.toString();
    }
}

public class Exercise {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}
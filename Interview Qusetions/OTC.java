/*
* Please solve the following puzzle which simulates generic directory structures.
* The solution should be directory agnostic.
* Be succinct yet readable. You should not exceed more than 200 lines.
* Consider adding comments and asserts to help the understanding.
* Code can be compiled with javac Directory.java
* Code should be executed as: java -ea Directory (-ea option it's to enabled the assert)
*/


/**
* change the code here.
*/
class Shell {
    Shell cd(final String path) {
        return this;
    }
    
    public String path() {
        return "/";
    }
}

public class OTC {
    public static void main(String[] args) {
        final Shell shell = new Shell();
        assert shell.path().equals("/");
        
        shell.cd("/");
        assert shell.path().equals("/");
        
        shell.cd("usr/..");
        assert shell.path().equals("/");
        
        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");
        
        shell.cd("..");
        assert shell.path().equals("/usr");
        
        shell.cd("//lib///");
        assert shell.path().equals("/lib");
    }
} 
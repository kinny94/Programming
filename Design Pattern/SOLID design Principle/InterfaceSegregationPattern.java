// Interface Segregation Principle - A client should not be forced to depend on interfaces they don't use
// If you have some API that takes a base class, you should be able to pass a subclass to it without breaking the code
// Instead of having a single interface with all the methods, we should have smaller interfaces with the methods we need
class Document {}

interface Machine {
    // Even though all we need a printer to do is print, we are forced to implement the scan and fax methods
    // even though they are not necessary for a printer
    // so we need to segregate the interface into smaller interfaces
    void print(Document d);
    void scan(Document d);
    void fax(Document d);
}

class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {
        System.out.println("Printing document");
    }

    @Override
    public void scan(Document d) {
        System.out.println("Scanning document");
    }

    @Override
    public void fax(Document d) {
        System.out.println("Faxing document");
    }
}

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {
        System.out.println("Printing document");
    }

    // Following methods are not valid for an old fashioned printer
    // but since we are implementing the Machine interface, we are forced to implement them
    // even though they are not valid for an old fashioned printer
    // other alternatives are to throw an exception or to implement them with a dummy implementation
    // but then we have to throw the exception in the implementation of the interface as well
    @Override
    public void scan(Document d) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fax(Document d) {
        throw new UnsupportedOperationException();
    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

interface Fax {
    void fax(Document d);
}

// YAGNI - You Ain't Gonna Need It
// Don't add functionality that you don't need
// If you don't need it, don't add it
// If you need it, add it
// If you don't need it, don't add it
class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {
        System.out.println("Printing document");
    }
}

class JustAScanner implements Scanner {
    @Override
    public void scan(Document d) {
        System.out.println("Scanning document");
    }
}

class JustAFax implements Fax {
    @Override
    public void fax(Document d) {
        System.out.println("Faxing document");
    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {
        System.out.println("Printing document");
    }

    @Override
    public void scan(Document d) {
        System.out.println("Scanning document");
    }
}

interface MultiFunctionDevice extends Printer, Scanner, Fax {}

class MultiFunctionMachine implements MultiFunctionDevice {
    @Override
    public void print(Document d) {
        System.out.println("Printing document");
    }

    @Override
    public void scan(Document d) {
        System.out.println("Scanning document");
    }

    @Override
    public void fax(Document d) {
        System.out.println("Faxing document");
    }
}

public class InterfaceSegregationPattern {
    public static void main(String[] args) {
        MultiFunctionPrinter multiFunctionPrinter = new MultiFunctionPrinter();
        multiFunctionPrinter.print(new Document());
        multiFunctionPrinter.scan(new Document());
        multiFunctionPrinter.fax(new Document());
    }
}

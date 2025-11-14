import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;
 
    public File(String name) {
        this.name = name;
    }
    
    public void showDetails() {
        System.out.println(name);
    }
}

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class CompositeBetter {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        Folder folder1 = new Folder("Documents");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        // subfolder
        Folder subfolder1 = new Folder("Subfolder1");
        FileSystemComponent file3 = new File("file3.txt");
        subfolder1.addComponent(file3);
        folder1.addComponent(subfolder1);
        folder1.showDetails();
    }
}

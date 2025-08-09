package main.StructuralPattern.CompositePattern;


import java.util.ArrayList;
import java.util.List;

//Component Interface
interface FileSystemComponent {
    void ls();  // List contents or name
}

//Leaf Class
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void ls() {
        System.out.println("File: " + name);
    }
}

//Composite Class
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    public void ls() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : children) {
            component.ls();
        }
    }
}

public class CompositePatternExample {

    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");

        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);

        FileSystemComponent file3 = new File("file3.txt");
        Folder folder2 = new Folder("Pictures");
        folder2.add(file3);

        Folder root = new Folder("Root");
        root.add(folder1);
        root.add(folder2);

        root.ls();
    }
}

import java.util.*; 

class File { 
    private String name;
    private int size;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;
}

class Directory { 
    private String name; 
    private List<File> files;
    private List<Directory> subDirectories; 
    private Date createdTimestamp;
    private Data lastModifiedTimestamp;
}

class FileSystem { 
    private Directory rootDirectory; 

    public FileSystem() { 
        rootDirectory = new Directory("root");
    }
}

public class Main { 
    public static void main(String[] args) 
    {
        FileSystem fs = new FileSystem(); 

        Directory documents = fs.createDirectory("documents", fs.getRootDirectory());
        File file1 = fs.createFile("file1.txt", documents);
        File file2 = fs.createdFile("file2.txt", documents);

        fs.listDirectoryContents(documents);
    }
}
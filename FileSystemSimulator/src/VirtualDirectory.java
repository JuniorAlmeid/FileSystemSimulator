import java.util.ArrayList;
import java.util.List;

public class VirtualDirectory {
    private String name;
    private VirtualDirectory parent;
    private List<VirtualDirectory> directories = new ArrayList<>();
    private List<String> files = new ArrayList<>();

    public VirtualDirectory(String name, VirtualDirectory parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public VirtualDirectory getParent() {
        return parent;
    }

    public void createDirectory(String name) {
        directories.add(new VirtualDirectory(name, this));
    }

    public void deleteDirectory(String name) {
        directories.removeIf(d -> d.getName().equals(name));
    }

    public void createFile(String name) {
        if (files.contains(name)) throw new RuntimeException("Arquivo já existe");
        files.add(name);
    }

    public void deleteFile(String name) {
        if (!files.remove(name)) throw new RuntimeException("Arquivo não encontrado");
    }

    public void rename(String oldName, String newName) {
        for (VirtualDirectory d : directories) {
            if (d.getName().equals(oldName)) {
                d.name = newName;
                return;
            }
        }
        int idx = files.indexOf(oldName);
        if (idx >= 0) {
            files.set(idx, newName);
        } else {
            throw new RuntimeException("Arquivo ou diretório não encontrado");
        }
    }

    public void copyFile(String source, String target) {
        if (!files.contains(source)) throw new RuntimeException("Arquivo de origem não encontrado");
        if (files.contains(target)) throw new RuntimeException("Arquivo de destino já existe");
        files.add(target);
    }

    public VirtualDirectory getSubDirectory(String name) {
        for (VirtualDirectory d : directories) {
            if (d.getName().equals(name)) return d;
        }
        return null;
    }

    public String listString() {
        StringBuilder sb = new StringBuilder();
        for (VirtualDirectory d : directories) {
            sb.append("[DIR] ").append(d.getName()).append("\n");
        }
        for (String f : files) {
            sb.append("[FILE] ").append(f).append("\n");
        }
        return sb.toString().isEmpty() ? "Vazio." : sb.toString();
    }
}

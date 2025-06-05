public class FileSystemSimulator {
    private VirtualDirectory root = new VirtualDirectory("root", null);
    private VirtualDirectory currentDir = root;
    private Journal journal = new Journal();

    public String runCommand(String input) {
        String[] parts = input.split(" ");
        String cmd = parts[0];
        StringBuilder response = new StringBuilder();

        try {
            switch (cmd) {
                case "mkdir":
                    currentDir.createDirectory(parts[1]);
                    journal.log("Criado diretório: " + parts[1]);
                    break;
                case "rmdir":
                    currentDir.deleteDirectory(parts[1]);
                    journal.log("Removido diretório: " + parts[1]);
                    break;
                case "touch":
                    currentDir.createFile(parts[1]);
                    journal.log("Criado arquivo: " + parts[1]);
                    break;
                case "rm":
                    currentDir.deleteFile(parts[1]);
                    journal.log("Removido arquivo: " + parts[1]);
                    break;
                case "rename":
                    currentDir.rename(parts[1], parts[2]);
                    journal.log("Renomeado: " + parts[1] + " para " + parts[2]);
                    break;
                case "copy":
                    currentDir.copyFile(parts[1], parts[2]);
                    journal.log("Copiado: " + parts[1] + " para " + parts[2]);
                    break;
                case "cd":
                    if (parts[1].equals("..")) {
                        if (currentDir.getParent() != null)
                            currentDir = currentDir.getParent();
                    } else {
                        VirtualDirectory sub = currentDir.getSubDirectory(parts[1]);
                        if (sub == null)
                            throw new RuntimeException("Diretório não encontrado");
                        currentDir = sub;
                    }
                    break;
                case "pwd":
                    response.append(getPath(currentDir));
                    break;
                case "ls":
                    response.append(currentDir.listString());
                    break;
                case "log":
                    response.append(journal.getLog());
                    break;
                case "exit":
                    response.append("Encerrando...");
                    System.exit(0);
                    break;
                default:
                    response.append("Comando inválido.");
            }
        } catch (Exception e) {
            response.append("Erro: ").append(e.getMessage());
        }

        return response.toString();
    }

    private String getPath(VirtualDirectory dir) {
        if (dir.getParent() == null) return "/" + dir.getName();
        return getPath(dir.getParent()) + "/" + dir.getName();
    }
}

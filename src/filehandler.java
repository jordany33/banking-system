import java.io.*;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public boolean fileExists() {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public void createFile() throws IOException {
        File file = new File(filePath);
        file.createNewFile();
    }

    public BufferedWriter getBufferedWriter(boolean append) throws IOException {
        return new BufferedWriter(new FileWriter(filePath, append));
    }

    public BufferedReader getBufferedReader() throws IOException {
        return new BufferedReader(new FileReader(filePath));
    }

    public Scanner getFileScanner() throws FileNotFoundException {
        return new Scanner(new File(filePath));
    }

    public String readAllContent() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = getBufferedReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void replaceContent(String oldContent, String newContent) throws IOException {
        String fileContent = readAllContent();
        fileContent = fileContent.replace(oldContent, newContent);
        try (BufferedWriter writer = getBufferedWriter(false)) {
            writer.write(fileContent);
        }
    }

    public void appendContent(String content) throws IOException {
        try (BufferedWriter writer = getBufferedWriter(true)) {
            writer.write(content);
            writer.newLine();
        }
    }
}

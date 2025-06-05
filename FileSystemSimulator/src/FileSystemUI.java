import javax.swing.*;
import java.awt.*;

public class FileSystemUI {
    private FileSystemSimulator simulator = new FileSystemSimulator();
    private JTextArea outputArea;
    private JTextField inputField;

    public void start() {
        JFrame frame = new JFrame("Simulador de Sistema de Arquivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        inputField = new JTextField();
        JButton executeButton = new JButton("Executar");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(executeButton, BorderLayout.EAST);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        executeButton.addActionListener(e -> executeCommand());
        inputField.addActionListener(e -> executeCommand());

        frame.setVisible(true);
        appendOutput("Sistema iniciado. Digite comandos abaixo.");
    }

    private void executeCommand() {
        String command = inputField.getText().trim();
        if (!command.isEmpty()) {
            appendOutput("> " + command);
            String result = simulator.runCommand(command);
            appendOutput(result);
            inputField.setText("");
        }
    }

    private void appendOutput(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileSystemUI().start());
    }
}

package app.ui;

import app.AppConfig;
import app.ImageLoader;
import app.component.ComponentFactory;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {
    private final ImageIcon scaledIcon;
    private final JTextField textField;
    private final JLabel dialogLabel;
    private final JDialog dialog;

    public MainFrame() {
        super("テスト画面");
        scaledIcon = ImageLoader.createScaledIcon(AppConfig.IMAGE_PATH, AppConfig.IMAGE_HEIGHT);
        textField = ComponentFactory.createTextField();
        dialogLabel = ComponentFactory.createLabel("入力されたテキスト: ", 18, JLabel.CENTER);
        dialog = createDialog();

        setupFrame();
        addComponents();
    }

    private void setupFrame() {
        setLayout(new BorderLayout());
        setBackground(AppConfig.BACKGROUND_COLOR);
        setIconImage(scaledIcon.getImage());
        setSize(AppConfig.WINDOW_WIDTH, AppConfig.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponents() {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(textField);
        inputPanel.add(createSendButton());

        add(ComponentFactory.createLabel("test_app", 24, JLabel.CENTER), BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
    }

    private JDialog createDialog() {
        JDialog resultDialog = new JDialog(this, "入力結果");
        resultDialog.setLayout(new BorderLayout());
        resultDialog.add(dialogLabel, BorderLayout.CENTER);
        resultDialog.add(createImagePanel(), BorderLayout.NORTH);
        resultDialog.add(createCloseButtonPanel(resultDialog), BorderLayout.SOUTH);
        resultDialog.setSize(AppConfig.WINDOW_WIDTH, AppConfig.WINDOW_HEIGHT);
        return resultDialog;
    }

    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(AppConfig.BACKGROUND_COLOR);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        imagePanel.add(ComponentFactory.createLabel("ぽた", 24, JLabel.CENTER), BorderLayout.NORTH);
        imagePanel.add(new JLabel(scaledIcon), BorderLayout.CENTER);
        return imagePanel;
    }

    private JPanel createCloseButtonPanel(JDialog resultDialog) {
        JButton closeButton = ComponentFactory.createButton("らじゃー");
        closeButton.addActionListener(e -> resultDialog.dispose());

        JPanel closeButtonPanel = new JPanel();
        closeButtonPanel.add(closeButton);
        return closeButtonPanel;
    }

    private JButton createSendButton() {
        JButton sendButton = ComponentFactory.createButton("送信");
        sendButton.addActionListener(e -> {
            dialogLabel.setText("入力されたテキスト: " + textField.getText());
            textField.setText("");
            dialog.setVisible(true);
        });
        return sendButton;
    }
}

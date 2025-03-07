import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertionPage extends JFrame {

    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel btnPanel;
    private JTextField nameField;
    private JTextField companyField;
    private JTextField countField;
    private JButton addBtn;
    private JButton closeBtn;

    private ArrayList<Product> availableProducts = new ArrayList<Product>();

    private MainFrame mainFrame;

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public InsertionPage(){
        setTitle("New Item");
        setLocationRelativeTo(null);
        setSize(400,300);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Product p = new Product(nameField.getText(), companyField.getText(), Integer.parseInt(countField.getText()));
                availableProducts.add(p);
            }
        });
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setAvailableProducts(availableProducts);
                dispose();
            }
        });
    }
}

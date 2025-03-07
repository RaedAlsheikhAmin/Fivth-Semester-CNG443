import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame{

    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel btnPanel;
    private JTextField inputField;
    private JLabel inputLabel;
    private JComboBox availableOptions;
    private JButton addBtn;
    private JButton deleteBtn;

    private ArrayList<Product> availableProducts = new ArrayList<>();

    public void setAvailableProducts(ArrayList<Product> products){
        this.availableProducts = products;
    }

    public MainFrame(){
        setTitle("Main Window");
        setLocationRelativeTo(null);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertionPage ip = new InsertionPage();

                ip.setMainFrame(MainFrame.this);
                ip.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        for (Product p:
                             availableProducts) {
                            availableOptions.addItem(p.getName());
                        }
                        setVisible(true);
                    }
                });
                setVisible(false);
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                availableOptions.removeItem(availableOptions.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
    }
}

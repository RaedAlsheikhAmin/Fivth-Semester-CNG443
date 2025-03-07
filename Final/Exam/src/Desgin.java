import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The type Desgin.
 * @author Raed Alsheikh Amin
 * @version 17.0.8
 */
public class Desgin extends JFrame {
    private JComboBox labelcombo;
    private JLabel firstlabel;
    private JPanel mainpanel;
    private JComboBox studentbox;
    private JButton addInternshipButton;
    private JButton serializeButton;
    private JTextField internshiplabel;
    private JTextField statuslabel;
    private JLabel labelinternship;
    private JLabel labelstatus;
    private JTextArea listingarea;
    private Exam main;
    private boolean filechecking(File file) {
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println(file.getName()+" File created successfully."+" The File path: "+file+"\n");
                } else {
                    JOptionPane.showMessageDialog(Desgin.this,"Failed to create the file: "+file.getName()," File creating Error",JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * it will create a digested message using MD5 hashing algorithm for security check.
     */
    public void DigestingUser()  {
        File file=new File("obj.dat");
        if(filechecking(file)) return;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedInputStream bis = new BufferedInputStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while (true) {
            try {
                if (!((ch = bis.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            baos.write(ch);
        }
        byte buffer[] = baos.toByteArray();
        // Get a MessageDigest for the appropriate algorithm.
        MessageDigest algorithm = null; // SHA-1 or MD5
        try {
            algorithm = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Ensure the digest's buffer is empty.
        algorithm.reset();

        // Fill the digest's buffer with data to compute a message digest from.
        algorithm.update(buffer);

        // Generate the digest. This does any necessary padding required by the
        // algorithm.
        byte digest[] = algorithm.digest();

        // Save or print digest bytes.
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
            hexString.append(" ");
        }
        // Write the MD5 hash to an external file
        File md5File = new File("objMD.dat");
        if(filechecking(md5File)) return;
        try (FileWriter writer = new FileWriter(md5File)) {
            writer.write(hexString.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JOptionPane.showMessageDialog(Desgin.this,"MD5 hash of obj.dat has been stored in objMD5.dat\n"+hexString.toString());

    }

    /**
     * Serilizing user.
     */
    public void serilizingUser()
    {
        try {
            File file=new File("obj.dat");
            if(filechecking(file)) return;

            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(Student s: main.students){//error is happening here
                out.writeObject(s);
            }




            out.close();
            fileOut.close();
            System.out.println("\nSerialized data is saved in obj.dat\n");
            JOptionPane.showMessageDialog(Desgin.this,"Serialized data is saved in obj.dat");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    /**
     * Instantiates a new Desgin.
     *
     * @param main the main
     */
    Desgin(Exam main){
        studentbox.setVisible(false);
        addInternshipButton.setVisible(false);
        serializeButton.setVisible(false);
        statuslabel.setVisible(false);
        labelinternship.setVisible(false);
        labelstatus.setVisible(false);
        internshiplabel.setVisible(false);
        labelcombo.addItem("Yes");
        labelcombo.addItem("NO");
        labelcombo.setSelectedItem("NO");
        this.main=main;
        setTitle("Exam");
        setLocationRelativeTo(null);
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainpanel);
        pack();
        this.main = main;
        setVisible(true);
        PersistentDatabaseStorage p=new PersistentDatabaseStorage();
        labelcombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(labelcombo.getSelectedItem()=="Yes")
                {
                    studentbox.setVisible(true);
                    addInternshipButton.setVisible(true);
                    serializeButton.setVisible(true);


                    p.readStudent(main);
                    for(Student s:main.students)
                    {
                        studentbox.addItem(s.getID());
                    }

                    //p.readInternship(main);
                }
                else if (labelcombo.getSelectedItem()=="NO")
                {
                    studentbox.setVisible(false);
                    addInternshipButton.setVisible(false);
                    serializeButton.setVisible(false);
                    listingarea.setVisible(false);
                    Student s1=new Student(1,"Robert Stevens");
                    Student s2=new Student(2,"Carole Goble");
                    main.students.add(s1);
                    main.students.add(s2);
                }
            }
        });
        addInternshipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statuslabel.setVisible(true);
                labelinternship.setVisible(true);
                labelstatus.setVisible(true);
                internshiplabel.setVisible(true);
                JOptionPane.showMessageDialog(Desgin.this,"Please fill the Fields");
                if(statuslabel.getText().isEmpty() || internshiplabel.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Desgin.this,"Fields Can not be empty","Empty Filed",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int internshipid=Integer.parseInt(internshiplabel.getText());
                if(!statuslabel.getText().equals("fail") || !statuslabel.getText().equals("pass"))
                {
                    JOptionPane.showMessageDialog(Desgin.this,"please enter either pass or fail","status field error",JOptionPane.ERROR_MESSAGE);
                    return;

                }
                String status=statuslabel.getText();


            }
        });
        serializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serilizingUser();
                DigestingUser();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //asking the user when he closes the window.
                int choice = JOptionPane.showConfirmDialog(Desgin.this,
                        "Do you want to save the data before closing?",
                        "Confirm Close",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    //writeStudent(bnb);
                    //writeInternship(bnb);
                }

                if (choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION) {
                    // Close the window if user chooses YES or NO because in both options we should close
                    serilizingUser();//writing the object anyways
                    DigestingUser();//creating MD5 anyways
                    dispose();
                }
            }
        });
    }
}

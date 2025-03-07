package Bed_And_Breakfast;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 * The Main class that will handle the Gui form for BNB application
 */
public class Main extends JFrame implements Runnable{
    private JPanel mainpanel;
    private JButton adduserbut;
    private JButton deleteuserbut;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton userInfoButton;
    private JButton deletePropertyButton;
    private JButton propertyInfoButton;
    private JButton addPropertyButton;
    private JButton addBookingButton;
    private JButton userBookingInfoButton;
    private JButton bookingCostButton;
    private JButton listUsersButton;
    private JButton listPropertiesButton;
    private JButton addFeedbackToAButton;
    private JButton comparePropertiesButton;
    private JPanel jpaneluser;
    private JLabel dob;
    private JTextField dobuser;
    private JLabel fn;
    private JTextField firstname;
    private JTextField lastname;
    private JLabel ln;
    private JTextField registrationdatetxt;
    private JLabel rd;
    private JRadioButton hostRadioButton;
    private JRadioButton goldCustomerRadioButton;
    private JRadioButton standardCustomerRadioButton;
    private JLabel userType;
    private JTextField paymethod;
    private JComboBox levelbox;
    private JTextField taxnumber;
    private JLabel tn;
    private JTextField userid;
    private JTextField userinfoid;
    private JScrollPane usersscrollpane;
    private JTextArea textareaforusers;
    private JTextField bedrooms;
    private JTextField rooms;
    private JTextField Priceperday;
    private JTextField City;
    private JRadioButton fullHouseRadioButton;
    private JRadioButton sharedPropertyRadioButton;
    private JTextField hostidtxt;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JLabel hostdetails;
    private JTextField hostname;
    private JTextField hostsurname;
    private JTextField hostdob;
    private JTextField hostRD;
    private JTextField hosttaxnum;
    private JLabel nameforproperty;
    private JLabel surnameforproperty;
    private JLabel dateofbirthforproperty;
    private JLabel registrationdateforproperty;
    private JLabel taxnumforproperty;
    private JTextField propertyfullsize;
    private JLabel propertyfullsizelabel;
    private JTextField propertyidtxt;
    private JTextField propertyinfotxt;
    private JTextArea textareproperties;
    private JCheckBox YESCheckBox;
    private JTextField propertyidfeedback;
    private JTextField feedback;
    private JTextField firstpropertyid;
    private JTextField secondpropertyid;
    private JTable feedbacktable;
    private JTextField addbookinguseridtextfield;
    private JTextField addbookingpropertyidtxtfield;
    private JTextField addbookingstartdate;
    private JTextField addbookingenddate;
    private JLabel addbookingstartdatelabel;
    private JTextField bookinginfouserid;
    private JTextArea textAreabookinginfo;
    private JTextField useridcost;
    private JTextField propertyidcost;
    private JTextArea textareaforcost;
    private JButton userDiscountButton;
    private JTextField useriddiscount;
    private JTextArea textareamainpanel;
    private JButton savefilebutton;
    private JTextField useridadduserbutton;
    private JTextField propertyidaddpropertybutton;
    private JTable userinfotable;
    private JRadioButton yesRadioButton1;
    private JTable userstable;
    private BASIC bnb;
    private File selectedDirectory;//it will get the file directory

    /**
     * this method will be called at the beginning of the prgoram that it can check the directory and save it in its field to be used later.
     *
     */
    private void invoknewmenuitem(){//I made it as a method that I can Use it even if the event didn't occur.

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Directory for reading and writing");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int userSelection = fileChooser.showDialog(null, "Select");

        if (userSelection == JFileChooser.APPROVE_OPTION) {
             selectedDirectory = fileChooser.getSelectedFile();
            // Handle the selected directory (e.g., display the path)
            JOptionPane.showMessageDialog(null, "You selected: " + selectedDirectory.getAbsolutePath());
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            // Handle if the user cancels the selection
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Exit the program
            }

        }

    }
    //starting dealing with I/O to read and write data

    /**
     * it will clear the data file everytime it is called, and write new data.
     * @param fileName
     */
    private  void clearFileContents(String fileName) {
        try (FileWriter file = new FileWriter(fileName, false)) {}
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write host data.
     *
     * @param host      the host
     * @param writeMode the write mode
     */
    public  void writeHostData(Host host, boolean writeMode) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(selectedDirectory + "\\host.dat",writeMode))) {
            dos.writeInt(host.getUserId());
            dos.writeLong(host.getDateOfBirth().getTime());
            dos.writeUTF(host.getFirstName());
            dos.writeUTF(host.getLastName());
            dos.writeLong(host.getRegisterationdate().getTime());
            dos.writeDouble(host.getTaxNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read host data host.
     *
     * @param dis the dis
     * @return the host
     */
    public  Host readHostData(DataInputStream dis) {
        try {
            Host host = new Host();
            host.setUserId(dis.readInt());
            host.setDateOfBirth(new Date(dis.readLong()));
            host.setFirstName(dis.readUTF());
            host.setLastName(dis.readUTF());
            host.setRegisterationdate(new Date(dis.readLong()));
            host.setTaxNumber(dis.readDouble());
            return host;
        } catch (EOFException e) {
            return null; // Return null when the end of the file is reached
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Read standard data user.
     *
     * @param dis the dis
     * @return the user
     */
    public  User readStandardData(DataInputStream dis) {
        try {
            Standard standard = new Standard();
            standard.setUserId(dis.readInt());
            standard.setDateOfBirth(new Date(dis.readLong()));
            standard.setFirstName(dis.readUTF());
            standard.setLastName(dis.readUTF());
            standard.setRegisterationdate(new Date(dis.readLong()));
            standard.setPreferredPaymentMethod(dis.readUTF());
            return standard;
        } catch (EOFException e) {
            return null; // Return null when the end of the file is reached
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Write standard data.
     *
     * @param standard  the standard
     * @param writeMode the write mode
     */
    public  void writeStandardData(Standard standard,boolean writeMode) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(selectedDirectory + "\\standard.dat",writeMode))) {
            dos.writeInt(standard.getUserId());
            dos.writeLong(standard.getDateOfBirth().getTime());
            dos.writeUTF(standard.getFirstName());
            dos.writeUTF(standard.getLastName());
            dos.writeLong(standard.getRegisterationdate().getTime());
            dos.writeUTF(standard.getPreferredPaymentMethod());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write gold data.
     *
     * @param gold      the gold
     * @param writeMode the write mode
     */
    public  void writeGoldData(Gold gold,boolean writeMode) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(selectedDirectory + "\\gold.dat",writeMode))) {
            dos.writeInt(gold.getUserId());
            dos.writeLong(gold.getDateOfBirth().getTime());
            dos.writeUTF(gold.getFirstName());
            dos.writeUTF(gold.getLastName());
            dos.writeLong(gold.getRegisterationdate().getTime());
            dos.writeUTF(gold.getPreferredPaymentMethod());
            dos.writeInt(gold.getGoldlevel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read gold data gold.
     *
     * @param dis the dis
     * @return the gold
     */
    public  Gold readGoldData(DataInputStream dis) {
        try {
            Gold gold = new Gold();
            gold.setUserId(dis.readInt());
            gold.setDateOfBirth(new Date(dis.readLong()));
            gold.setFirstName(dis.readUTF());
            gold.setLastName(dis.readUTF());
            gold.setRegisterationdate(new Date(dis.readLong()));
            gold.setPreferredPaymentMethod(dis.readUTF());
            gold.setGoldlevel(dis.readInt());
            return gold;
        } catch (EOFException e) {
            return null; // Return null when the end of the file is reached
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Write shared property data.
     *
     * @param property   the property
     * @param writeMode  the write mode
     * @param hostExists the host exists
     */
    public void writeSharedPropertyData(SharedProperty property,boolean writeMode,boolean hostExists) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(selectedDirectory + "\\sharedProperty.dat",writeMode))) {
            dos.writeInt(property.getPropertyId());
            dos.writeInt(property.getNumberOfBedrooms());
            dos.writeInt(property.getNumberOfRooms());
            dos.writeUTF(property.getCity());
            dos.writeDouble(property.getPricePerDay());
            dos.writeInt(property.getInspection().size());
            for (HashMap.Entry<LocalDate, String> entry : property.getInspection().entrySet()) {
                dos.writeUTF(String.valueOf(entry.getKey()));
                dos.writeUTF(entry.getValue());
            }
            Host temphost = property.getHost();
            if (!hostExists) {
                writeHostData(temphost,writeMode);
            }
            dos.writeInt(temphost.getUserId());
            dos.writeLong(temphost.getDateOfBirth().getTime());
            dos.writeUTF(temphost.getFirstName());
            dos.writeUTF(temphost.getLastName());
            dos.writeLong(temphost.getRegisterationdate().getTime());
            dos.writeDouble(temphost.getTaxNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Read shared property data property.
     *
     * @param dis the dis
     * @return the property
     */
    public  Property readSharedPropertyData(DataInputStream dis) {
        try {
            SharedProperty sharedProperty  = new SharedProperty();
            sharedProperty.setPropertyId(dis.readInt());
            sharedProperty.setNumberOfBedrooms(dis.readInt());
            sharedProperty.setNumberOfRooms(dis.readInt());
            sharedProperty.setCity(dis.readUTF());
            sharedProperty.setPricePerDay((float) dis.readDouble());
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                LocalDate date = LocalDate.parse(dis.readUTF());
                String report = dis.readUTF();
                sharedProperty.getInspection().put(date, report);
            }
            Host host = new Host();
            host.setUserId(dis.readInt());
            host.setDateOfBirth(new Date(dis.readLong()));
            host.setFirstName(dis.readUTF());
            host.setLastName(dis.readUTF());
            host.setRegisterationdate(new Date(dis.readLong()));
            host.setTaxNumber(dis.readDouble());
            sharedProperty.setHost(host);
            return sharedProperty;
        } catch (EOFException e) {
            return null; // Return null when the end of the file is reached
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Write full property data.
     *
     * @param property   the property
     * @param writeMode  the write mode
     * @param hostExists the host exists
     */
    public  void writeFullPropertyData(FullProperty property,boolean writeMode, boolean hostExists) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(selectedDirectory + "\\fullProperty.dat",writeMode))) {
            dos.writeInt(property.getPropertyId());
            dos.writeInt(property.getNumberOfBedrooms());
            dos.writeInt(property.getNumberOfRooms());
            dos.writeUTF(property.getCity());
            dos.writeDouble(property.getPricePerDay());
            dos.writeDouble(property.getPropertysize());
            dos.writeInt(property.getInspection().size());
            for (HashMap.Entry<LocalDate, String> entry : property.getInspection().entrySet()) {
                dos.writeUTF(String.valueOf(entry.getKey()));
                dos.writeUTF(entry.getValue());
            }
            Host temphost = property.getHost();
            if (!hostExists) {
                writeHostData(temphost,writeMode);
            }
            dos.writeInt(temphost.getUserId());
            dos.writeLong(temphost.getDateOfBirth().getTime());
            dos.writeUTF(temphost.getFirstName());
            dos.writeUTF(temphost.getLastName());
            dos.writeLong(temphost.getRegisterationdate().getTime());
            dos.writeDouble(temphost.getTaxNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read full property data property.
     *
     * @param dis the dis
     * @return the property
     */
    public  Property readFullPropertyData(DataInputStream dis) {
        try {
            FullProperty fullProperty  = new FullProperty();
            fullProperty.setPropertyId(dis.readInt());
            fullProperty.setNumberOfBedrooms(dis.readInt());
            fullProperty.setNumberOfRooms(dis.readInt());
            fullProperty.setCity(dis.readUTF());
            fullProperty.setPricePerDay((float) dis.readDouble());
            fullProperty.setPropertysize(dis.readDouble());
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                LocalDate date = LocalDate.parse(dis.readUTF());
                String report = dis.readUTF();
                fullProperty.getInspection().put(date, report);
            }
            Host host = new Host();
            host.setUserId(dis.readInt());
            host.setDateOfBirth(new Date(dis.readLong()));
            host.setFirstName(dis.readUTF());
            host.setLastName(dis.readUTF());
            host.setRegisterationdate(new Date(dis.readLong()));
            host.setTaxNumber(dis.readDouble());
            fullProperty.setHost(host);
            return fullProperty;
        } catch (EOFException e) {
            return null; // Return null when the end of the file is reached
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * it will start the reading from the files if they exist, otherwise it will creat new files.
     */
    private void startingIO(){
        File file = new File(selectedDirectory, "sharedProperty.dat");

        if (filechecking(file)) return;

// Now, proceed with reading the file
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            Property temp;
            while ((temp = readSharedPropertyData(inputStream)) != null) {
                bnb.properties.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        file = new File(selectedDirectory, "fullProperty.dat");
        if (filechecking(file)) return;
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            Property temp;
            while ((temp = readFullPropertyData(inputStream)) != null) {
                bnb.properties.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        file = new File(selectedDirectory, "host.dat");
        if (filechecking(file)) return;


        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            User temp;
            while ((temp = readHostData(inputStream)) != null) {
                bnb.users.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = new File(selectedDirectory, "standard.dat");
        if (filechecking(file)) return;

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            User temp;
            while ((temp = readStandardData(inputStream)) != null) {
                bnb.users.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = new File(selectedDirectory, "gold.dat");
        if (filechecking(file)) return;
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            User temp;
            while ((temp = readGoldData(inputStream)) != null) {
                bnb.users.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bnb.users.sort(Comparator.comparing(User::getUserId));
        bnb.properties.sort(Comparator.comparing(Property::getPropertyId));

    }

    private boolean filechecking(File file) {
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    textareamainpanel.append(file.getName()+" File created successfully."+" The File path: "+file+"\n");
                } else {
                    JOptionPane.showMessageDialog(Main.this,"Failed to create the file: "+file.getName()," File creating Error",JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * this method will write the object using objectoutputstream to check later for MD5 Security.
     */
    public void serilizingUser()
    {
        try {
            File file=new File("User.ser");
            if(filechecking(file)) return;

            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(bnb.users);




            out.close();
            fileOut.close();
            textareamainpanel.append("\nSerialized data is saved in User.ser\n");
            JOptionPane.showMessageDialog(Main.this,"Serialized data is saved in User.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    /**
     * it will create a digested message using MD5 hashing algorithm for security check.
     */
    public void DigestingUser()  {
        File file=new File("User.ser");
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
        File md5File = new File("UserMD5.txt");
        if(filechecking(md5File)) return;
        try (FileWriter writer = new FileWriter(md5File)) {
            writer.write(hexString.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JOptionPane.showMessageDialog(Main.this,"MD5 hash of User.ser has been stored in UserMD5.txt\n"+hexString.toString());

    }

    /**
     * it will make the first connection only to show the database info and to check if the connection is working smoothly or not.
     */
    public void showingDatabseInfo(){
        //starting the connection. for showing the info at the beginning
        Connection connection = null;
        Statement statement = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            textareamainpanel.append("Driver loaded\n");

            // STEP 2 -- Establish a connection
            textareamainpanel.append("Establishing a connection\n");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BasicDB", "cng443user", "1234");
            JOptionPane.showMessageDialog(Main.this,"Database connected");

            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement
            ResultSet resultSet = statement.executeQuery("select * from User");
            textareamainpanel.append("List of users:\n"+"user ID  \t Name  \t   Surname    \t   Date of Birth   \t  Registration Date \ttype   \t   preferred payment method\n");

            // Iterate through the result and print the user names
            while (resultSet.next())
                textareamainpanel.append("   "+resultSet.getString(1) + " \t  " + resultSet.getString(3) + " \t  " + resultSet.getString(4) + "\t   "
                        + resultSet.getString(2)+ "   \t  "
                        + resultSet.getString(5)+ "\t\t"
                        + resultSet.getString(6)+ " \t  \t"
                        + resultSet.getString(7)+"\n");


            resultSet = statement.executeQuery("select * from Property");
            textareamainpanel.append("\n\nList of Properties:\n"+"property ID  \t #beds  \t   #rooms    \t   city   \t  price \ttype  \tsize\n");


            // Iterate through the result and print the property names
            while (resultSet.next())
                textareamainpanel.append("   "+resultSet.getString(1) + " \t  " + resultSet.getString(2) + " \t   " + resultSet.getString(3) + "\t   "
                        + resultSet.getString(4)+ "   \t  "
                        + resultSet.getString(5)+ "$\t"
                        + resultSet.getString(6)+ " \t"
                        + resultSet.getString(7)+"\n");




        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try

        //close the connection.
    }//end of the method

    /**
     * it will read the object , create a MD5 and then compare both MD5s
     * for some reason this method doesn't work unless I make (GOLD,STANDARD,HOST,USER) SERILIZABLE, User itself is not enough. i am facing a problem in line 684
     */
    public void checkSecurity() {
        ArrayList<User> deserializedUsers=null;

        File file = new File("User.ser");
        if (filechecking(file)) return;

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            deserializedUsers = (ArrayList<User>) ois.readObject();//error here if user related classes are not Serializable
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            textareamainpanel.append("\n due to not having MD5 at the beginning you may encounter this  problem!!\n");
            JOptionPane.showMessageDialog(Main.this, "Check Security Method", "Deserialization Fail", JOptionPane.ERROR_MESSAGE);
            return; // Return deserialization failure
        }

        // Convert deserializedUsers to a byte array
        byte[] serializedUserBytes;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {

            oos.writeObject(deserializedUsers);
            serializedUserBytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(Main.this, "Serialization Fail", "Check Security Method", JOptionPane.ERROR_MESSAGE);
            return; // Return if serialization failed
        }

        // Calculate MD5 hash from deserialized user objects
        byte[] calculatedMD5 = calculateMD5(serializedUserBytes);

        // Retrieve stored MD5 hash from file or wherever it was stored
        byte[] storedMD5 = getStoredMD5FromFile(); // Implement this method to retrieve stored MD5

        if (storedMD5 == null) {
            JOptionPane.showMessageDialog(Main.this, "No previous MD5 hash found.", "Check Security Method", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Compare the two MD5 hashes
        boolean integrityIntact = MessageDigest.isEqual(calculatedMD5, storedMD5);

        if (!integrityIntact) {
            // Data has been modified
            JOptionPane.showMessageDialog(Main.this, "Data has been Modified! Be Careful!", "Getting Attacked", JOptionPane.ERROR_MESSAGE);
        } else {
            // Data is intact
            JOptionPane.showMessageDialog(Main.this, "Data integrity is intact.");
        }
    }

    /**
     * it will take the name of the previous stored MD5 file and then read the data, and cnvert it to byte array.
     * @return
     */
    private byte[] getStoredMD5FromFile() {
        File md5File = new File("UserMD5.txt");
        if(filechecking(md5File))  {
            //when the file originally doesn't exist.
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(md5File))) {
            String storedMD5String = reader.readLine();
            if (storedMD5String != null && !storedMD5String.isEmpty()) {
                // Convert the stored MD5 string to a byte array
                String[] storedMD5HexStrings = storedMD5String.split(" ");
                byte[] storedMD5Bytes = new byte[storedMD5HexStrings.length];
                for (int i = 0; i < storedMD5HexStrings.length; i++) {
                    storedMD5Bytes[i] = (byte) Integer.parseInt(storedMD5HexStrings[i], 16);
                }
                return storedMD5Bytes;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Return null if there was an error reading the stored MD5
    }

    /**
     * it will calculate the MD5 for byte array.
     * @param data
     * @return
     */
    private byte[] calculateMD5(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * it will perform the thread after starting it.
     */
    public void run()
    {
        checkSecurity();
    }





    /**
     * Instantiates a new Main.
     *
     * @param bnb the bnb
     */
    public Main(BASIC bnb) {

        levelbox.setVisible(false);
        taxnumber.setVisible(false);
        tn.setVisible(false);
        levelbox.addItem("1");
        levelbox.addItem("2");
        levelbox.addItem("3");
        textareaforusers.setEditable(false);
        propertyfullsize.setVisible(false);
        propertyfullsizelabel.setVisible(false);
        hostdob.setVisible(false);
        nameforproperty.setVisible(false);
        surnameforproperty.setVisible(false);
        dateofbirthforproperty.setVisible(false);
        taxnumforproperty.setVisible(false);
        registrationdateforproperty.setVisible(false);
        hostname.setVisible(false);
        hostRD.setVisible(false);
        hostsurname.setVisible(false);
        hosttaxnum.setVisible(false);
        //setting my table for the feedback button
        DefaultTableModel feedbackTableModel = new DefaultTableModel();
        feedbacktable.setModel(feedbackTableModel);
        feedbackTableModel.addColumn("Property ID");
        feedbackTableModel.addColumn("Feedback");
        feedbackTableModel.addColumn("Date");


        //setting the menu and menu iteams
        JMenu filemenu = new JMenu("File");
        JMenuItem mnew = new JMenuItem("new");
        JMenuItem mexit = new JMenuItem("Exit");
        JMenuItem mabout = new JMenuItem("About");
        filemenu.add(mnew);
        filemenu.add(mabout);
        filemenu.add(mexit);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(filemenu);
        setJMenuBar(menuBar);




        setTitle("Bed & Breakfast Booking System");
        setLocationRelativeTo(null);
        setSize(1600, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainpanel);
        pack();
        this.bnb = bnb;
        setVisible(true);

        //filechooser invoking no need to invoke in the 4th assignment
        //invoknewmenuitem();
        //starting input output initialization to check if the file exists or not. no need to do it in the 4th assignment
        //startingIO();




        //starting reading data from datastorage class and strong it into the users and properties linked lists
        showingDatabseInfo();
        DataStorage.readUsersandProperties(bnb);

/**
 * adduser button, it will take the info from the panel and then check if the user ID already exists or not, if not, it will add a new user.
 */
        adduserbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = null;

                String dateOfBirth = dobuser.getText();
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String registrationdate = registrationdatetxt.getText();
                if(useridadduserbutton.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Main.this, "You should specify the User ID", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int userID=Integer.parseInt(useridadduserbutton.getText());
                String preferredpaymentmethod = paymethod.getText();
                if (dateOfBirth.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || registrationdate.isEmpty() || preferredpaymentmethod.isEmpty()) {
                    // Alert the user that the date of birth field is empty
                    JOptionPane.showMessageDialog(Main.this, "You should fill all the fields", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                for(User temp:bnb.users)
                {
                    if(temp.getUserId()==userID)
                    {
                        JOptionPane.showMessageDialog(Main.this,"A User with ID "+userID+" already exists, write another user ID");
                        return;
                    }
                }


                boolean hostusertype = hostRadioButton.isSelected();
                boolean goldusertype = goldCustomerRadioButton.isSelected();
                boolean standardusertype = standardCustomerRadioButton.isSelected();

                if (!hostusertype && !goldusertype && !standardusertype) {
                    JOptionPane.showMessageDialog(Main.this, "You should choose the User type", "User Type Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if (goldusertype) {
                    int level = Integer.parseInt((String) levelbox.getSelectedItem());
                    user = new Gold(userID, dateOfBirth, firstName, lastName, registrationdate, preferredpaymentmethod, level);
                    writeGoldData((Gold) user,goldusertype);
                } else if (standardusertype) {
                    user = new Standard(userID, dateOfBirth, firstName, lastName, registrationdate, preferredpaymentmethod);
                    writeStandardData((Standard) user,standardusertype);
                } else if (hostusertype) {
                    double TaxNum = Double.parseDouble(taxnumber.getText());
                    user = new Host(userID, dateOfBirth, firstName, lastName, registrationdate, TaxNum);
                    writeHostData((Host)user,hostusertype);
                }

                bnb.users.add(user);//to add user to my arraylist in basic
                JOptionPane.showMessageDialog(Main.this, "User info: " + firstName + " " + lastName + " " + dateOfBirth + " " + registrationdate + " " + preferredpaymentmethod);
                textareamainpanel.append(user.toString()+"\n");

                JOptionPane.showMessageDialog(Main.this, "User with ID " + userID + " Has been added");
                bnb.setUserID(bnb.getUserID() + 1);
                //to clear the fields
                dobuser.setText("");
                firstname.setText("");
                lastname.setText("");
                registrationdatetxt.setText("");
                paymethod.setText("");
                taxnumber.setText("");
                useridadduserbutton.setText("");
                hostRadioButton.setSelected(false);
                goldCustomerRadioButton.setSelected(false);
                standardCustomerRadioButton.setSelected(false);

            }
        });
        deleteuserbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userid.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Main.this, "You should write an ID number to delete", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int userId = Integer.parseInt(userid.getText());
                for (User user : bnb.getUsers()) {
                    if (user.getUserId() == userId) {
                        bnb.users.remove(user);
                        if(user instanceof Host)
                        {
                         clearFileContents(selectedDirectory+"\\host.dat");
                        }
                        else if(user instanceof Gold)
                        {
                            clearFileContents(selectedDirectory+"\\gold.dat");
                        }
                        else if(user instanceof Standard)
                        {
                            clearFileContents(selectedDirectory+"\\standard.dat");
                        }
                        JOptionPane.showMessageDialog(Main.this, "User with ID " + userId + " deleted successfully.");
                        userid.setText("");
                        return;
                    }
                }

                JOptionPane.showMessageDialog(Main.this, "User with ID: " + userId + " not found!!");
                userid.setText("");
            }

        });


        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (hostRadioButton.isSelected()) {
                    tn.setVisible(true);
                    taxnumber.setVisible(true);
                    levelbox.setVisible(false);
                } else if (goldCustomerRadioButton.isSelected()) {
                    tn.setVisible(false);
                    taxnumber.setVisible(false);
                    levelbox.setVisible(true);

                } else if (standardCustomerRadioButton.isSelected()) {
                    tn.setVisible(false);
                    taxnumber.setVisible(false);
                    levelbox.setVisible(false);
                }

            }


        };
        hostRadioButton.addItemListener(listener);
        goldCustomerRadioButton.addItemListener(listener);
        standardCustomerRadioButton.addItemListener(listener);
        /**
         * user info button, it will take user id from the panel and return the info of that user.
         */
        userInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean userFound = false;
                if (userinfoid.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Main.this, "You should write an ID number for the info", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int userId = Integer.parseInt(userinfoid.getText());


                for (User user : bnb.getUsers()) {
                    if (user.getUserId() == userId) {
                        userFound = true;
                        JOptionPane.showMessageDialog(Main.this, user); // Utilize the overridden toString method
                        break; // No need to continue searching after finding the user
                    }
                }


                if (!userFound) {
                    JOptionPane.showMessageDialog(Main.this, "User with ID " + userId + " does not exist.");
                }
                userinfoid.setText("");
            }
        });
        /**
         * list users button, it will list all the users and their booking by looping through the Array list.
         */
        listUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textareaforusers.append("\nList of Users:\n");

                for (User user : bnb.getUsers()) {
                    textareaforusers.append("\n");
                    textareaforusers.append(user.toString());
                    textareaforusers.append("\n");
                    textareaforusers.append("List of Booking for user " + user.getUserId() + "\n================================\n");
                    if (user instanceof Host)
                        textareaforusers.append("\nHost Can not have booking\n****************************\n");
                    try{
                    if(!user.getBookings().isEmpty()) {
                        for (Booking booking : user.getBookings()) {
                            textareaforusers.append("Booking Start Date: " + booking.getStartDate().toString());
                            textareaforusers.append(" , Booking End Date: " + booking.getEndDate().toString());
                            textareaforusers.append("The booking is in Property: " + booking.getPropertyId());
                            textareaforusers.append("\n--------------------------------\n");
                        }
                    }


                    }
                    catch (NullPointerException nexp)
                    {
                        textareaforusers.append("No booking found!\n");
                    }
                }
            }
        });
        /**
         * it will add property to the system by taking the info from the panel and checking.
         * it will check if the host exists or not as well.
         * and it will offer to create a new host if the host doesn't exist.
         */
        addPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                Property property = null;
                try {
                    if (bedrooms.getText().isEmpty() || rooms.getText().isEmpty() || City.getText().isEmpty() || Priceperday.getText().isEmpty() || hostidtxt.getText().isEmpty() || propertyidaddpropertybutton.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Main.this, "Please fill all the fields", "Fields Empty Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int numberOfBedrooms = Integer.parseInt(bedrooms.getText());

                    int numberOfRooms = Integer.parseInt(rooms.getText());
                    String city = City.getText();
                    float pricePerDay = Float.parseFloat(Priceperday.getText());
                    int propertyid = Integer.parseInt(propertyidaddpropertybutton.getText());
                    int hostid = Integer.parseInt(hostidtxt.getText());
                    if (!fullHouseRadioButton.isSelected() && !sharedPropertyRadioButton.isSelected()) {
                        JOptionPane.showMessageDialog(Main.this, "Select the property type", "Property type Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    for (Property temp : bnb.properties) {
                        if (temp.getPropertyId() == propertyid) {
                            JOptionPane.showMessageDialog(Main.this, "Property wtih ID " + propertyid + " already exists, write another ID");
                            return;
                        }
                    }
                    Host hostToAdd = null;
                    for (User user : bnb.getUsers()) {
                        if (user.getUserId() == hostid && user instanceof Host) {
                            hostToAdd = (Host) user;
                            break;
                        }
                    }

                    if (hostToAdd == null) {
                        JOptionPane.showMessageDialog(Main.this, "Host with ID " + hostid + " does not exist. First create a new host then assign the property!");
                        if (!noRadioButton.isSelected() && !yesRadioButton.isSelected()) {
                            JOptionPane.showMessageDialog(Main.this, "Please Select if you want to add a new host or not", "Radio Selection Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (noRadioButton.isSelected())
                            return;
                        else if (yesRadioButton.isSelected()) {
                            String dob = hostdob.getText();
                            String firstname = hostname.getText();
                            String lastname = hostsurname.getText();
                            String regdate = hostRD.getText();
                            double taxnum = Double.parseDouble(hosttaxnum.getText());

                            hostToAdd = new Host(hostid, dob, firstname, lastname, regdate, taxnum);//creating a new host to add to property.

                            bnb.getUsers().add(hostToAdd);//that we avoid duplication since host is a user.
                            writeHostData(hostToAdd, true);
                        }

                    }

                    if (sharedPropertyRadioButton.isSelected()) {
                        property = new SharedProperty(propertyid, numberOfBedrooms, numberOfRooms, city, pricePerDay, hostToAdd);
                        writeSharedPropertyData((SharedProperty) property, true, hostToAdd != null);
                    } else if (fullHouseRadioButton.isSelected()) {
                        double propertysize = Double.parseDouble(propertyfullsize.getText());
                        if (propertyfullsize.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(Main.this, "You enter the size of the property", "Size Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        property = new FullProperty(propertyid, numberOfBedrooms, numberOfRooms, city, pricePerDay, hostToAdd, propertysize);
                        writeFullPropertyData((FullProperty) property, true, hostToAdd != null);
                    }
                    bnb.properties.add(property);
                    JOptionPane.showMessageDialog(Main.this, "Property added successfully. Property ID: " + propertyid);
                    bnb.setPropertyID(bnb.getPropertyID() + 1);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(Main.this, "Please Fill all the fields and Enter valid values", "Number Formate Exception", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //cleaning all the fields
                bedrooms.setText("");
                rooms.setText("");
                City.setText("");
                Priceperday.setText("");
                propertyfullsize.setText("");
                hostidtxt.setText("");
                hostname.setText("");
                hostdob.setText("");
                hostRD.setText("");
                hostsurname.setText("");
                hosttaxnum.setText("");
                propertyidaddpropertybutton.setText("");
            }
        });
        yesRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hostdob.setVisible(true);
                nameforproperty.setVisible(true);
                surnameforproperty.setVisible(true);
                dateofbirthforproperty.setVisible(true);
                taxnumforproperty.setVisible(true);
                registrationdateforproperty.setVisible(true);
                hostname.setVisible(true);
                hostRD.setVisible(true);
                hostsurname.setVisible(true);
                hosttaxnum.setVisible(true);
            }
        });
        fullHouseRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                propertyfullsize.setVisible(true);
                propertyfullsizelabel.setVisible(true);
            }
        });
        sharedPropertyRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                propertyfullsize.setVisible(false);
                propertyfullsizelabel.setVisible(false);
            }
        });
        noRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hostdob.setVisible(false);
                nameforproperty.setVisible(false);
                surnameforproperty.setVisible(false);
                dateofbirthforproperty.setVisible(false);
                taxnumforproperty.setVisible(false);
                registrationdateforproperty.setVisible(false);
                hostname.setVisible(false);
                hostRD.setVisible(false);
                hostsurname.setVisible(false);
                hosttaxnum.setVisible(false);

            }
        });
        /**
         * it will read the property id from the panel and delete the specified property.
         */
        deletePropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (propertyidtxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Main.this, "Please write the ID of the Property to delete", "Empty ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int propertyId = Integer.parseInt(propertyidtxt.getText());
                for (Property property : bnb.getProperties()) {
                    if (property.getPropertyId() == propertyId) {
                        bnb.getProperties().remove(property);
                        JOptionPane.showMessageDialog(Main.this, "Property with ID " + propertyId + " deleted successfully.");
                        propertyidtxt.setText("");
                        if(property instanceof SharedProperty)
                        {
                            clearFileContents(selectedDirectory+"\\sharedProperty.dat");
                        }
                        else if(property instanceof FullProperty)
                        {
                            clearFileContents(selectedDirectory+"\\fullProperty.dat");
                        }
                        return;
                    }
                }

                JOptionPane.showMessageDialog(Main.this, "Property with ID " + propertyId + " does not exist.");
                propertyidtxt.setText("");
            }

        });
        /**
         * it will display the property info for specific property id.
         */
        propertyInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (propertyinfotxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Main.this, "Please write the ID of the Property to display the info", "Empty ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int propertyId = Integer.parseInt(propertyinfotxt.getText());
                for (Property property : bnb.getProperties()) {
                    if (property.getPropertyId() == propertyId) {
                        JOptionPane.showMessageDialog(Main.this, property);
                        propertyinfotxt.setText("");
                        return;
                    }
                }

                JOptionPane.showMessageDialog(Main.this, "Property with ID " + propertyId + " does not exist.");
                propertyinfotxt.setText("");
            }
        });
        /**
         * it will list all the properties and it will offer if their host is needed to be listed or not.
         */
        listPropertiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textareproperties.append("List of Properties:\n");
                for (Property property : bnb.getProperties()) {
                    textareproperties.append(property.toString());
                    if (YESCheckBox.isSelected())
                        textareproperties.append(property.getHost().toString());
                    textareproperties.append("\n----------------------------\n");
                }
            }
        });
        /**
         * it will add a feedback to a specific property id.
         */
        addFeedbackToAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Property property;
                if (propertyidfeedback.getText().isEmpty() || feedback.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Main.this, "Please enter a property Id and The Feedback", "Fields Empty Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int propertyId = Integer.parseInt(propertyidfeedback.getText());
                String report = feedback.getText();

                property = bnb.getPropertyById(propertyId);
                LocalDate currentDate = LocalDate.now();
                try {
                    if (property != null) {
                        if (property.inspection == null) {
                            property.inspection = new HashMap<>(); // Initialize the HashMap if it's null
                        }
                        if (!property.inspection.containsKey(currentDate)) {
                            property.inspection.put(currentDate, report);
                            JOptionPane.showMessageDialog(Main.this, "Inspection has been added: " + report + ", on Date: " + currentDate);
                            //adding data to the table as an object
                            Object[] rowData = {propertyId, report, currentDate};
                            feedbackTableModel.addRow(rowData);

                        } else {
                            JOptionPane.showMessageDialog(Main.this, "You can not give feedback more than once a day!");

                        }
                    }
                }
                catch (NullPointerException nuee)
                {
                    JOptionPane.showMessageDialog(Main.this,"something wrong with adding the feedback");
                    return;
                }
                if (property == null) {
                    JOptionPane.showMessageDialog(Main.this, "Property with ID " + propertyId + " doesn't exist");
                }

                feedback.setText("");
                propertyidfeedback.setText("");
            }
        });
        /**
         * it will take two properties and compare their prices.
         */
        comparePropertiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstpropertyid.getText().isEmpty() || secondpropertyid.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Main.this, "Please Fill Both Fields", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int propertyId1 = Integer.parseInt(firstpropertyid.getText());
                int propertyId2 = Integer.parseInt(secondpropertyid.getText());

                Property property1 = bnb.getPropertyById(propertyId1);
                Property property2 = bnb.getPropertyById(propertyId2);

                if (property1 == null) {
                    JOptionPane.showMessageDialog(Main.this, "the first property doesn't exist!");
                    return;
                }
                if (property2 == null) {
                    JOptionPane.showMessageDialog(Main.this, "the second property doesn't exist!");
                    return;
                }
                if (property1.compareTo(property2) > 0)
                    JOptionPane.showMessageDialog(Main.this, "Property with ID: " + propertyId2 + " is cheaper");
                else if (property1.compareTo(property2) == 0)
                    JOptionPane.showMessageDialog(Main.this, "“they have the same price!");
                else
                    JOptionPane.showMessageDialog(Main.this, "Property with ID: " + propertyId1 + " is cheaper");
            }
        });
        /**
         * this is a menu item to exist the application
         */
        mexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /**
         * it is a menu item to give info about the application
         */
        mabout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Main.this,":) Welcome to a Basic BNB Application to handle reservations :)\n Created By Raed Alsheikh Amin");
            }
        });
        /**
         * it will add a booking for a specific user in a specific property.
         */
        addBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(addbookingpropertyidtxtfield.getText().isEmpty() || addbookinguseridtextfield.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Main.this,"Please Fill All the Fields","Empty Field Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int userId=Integer.parseInt(addbookinguseridtextfield.getText());
                int propertyId=Integer.parseInt(addbookingpropertyidtxtfield.getText());

                // Check if the user with the given ID exists
                Customer userToAddBooking = null;
                for (User user : bnb.getUsers()) {
                    if (user.getUserId() == userId && user instanceof Customer customer) {
                        userToAddBooking=(Customer)user;
                        break;
                    }
                    else if(user.getUserId()==userId && user instanceof Host)
                        JOptionPane.showMessageDialog(Main.this,"Host can not make reservation unless he is a customer!");
                }

                if (userToAddBooking == null) {
                    JOptionPane.showMessageDialog(Main.this,"Customer with ID " + userId + " does not exist. Booking cannot be added.");
                    return;
                }

                // Check if the property with the given ID exists
                Property propertyToAddBooking = null;
                for (Property property : bnb.getProperties()) {
                    if (property.getPropertyId() == propertyId) {
                        propertyToAddBooking = property;
                        break;
                    }
                }

                if (propertyToAddBooking == null) {
                    JOptionPane.showMessageDialog(Main.this,"Property with ID " + propertyId + " does not exist. Booking cannot be added.");
                    return;
                }

                if(addbookingstartdate.getText().isEmpty()||addbookingenddate.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Main.this,"Please Enter both the Start date and End date of the booking","Empty duration Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Ask for start date
                String startDateString = addbookingstartdate.getText();

                // Ask for end date
                String endDateString = addbookingenddate.getText();

                // Record the booking
                Booking booking = new Booking(userId, propertyId, startDateString, endDateString);
                userToAddBooking.addbooking(booking);

                JOptionPane.showMessageDialog(Main.this,"Booking added successfully.");
                addbookingenddate.setText("");
                addbookingstartdate.setText("");
                addbookingpropertyidtxtfield.setText("");
                addbookinguseridtextfield.setText("");

            }
        });
/**
 * it will get the booking info for specific user id.
 */
        userBookingInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean userexists=false;
                if(bookinginfouserid.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Main.this,"Please Enter the User ID","Empty Field Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int userId=Integer.parseInt(bookinginfouserid.getText());

                for (User user : bnb.users) {
                    if (user.getUserId() == userId && user instanceof Customer customer) {
                        textAreabookinginfo.append("Customer with ID "+userId+" booking info\n==================\n");
                        userexists = true;
                        try {

                            for (Booking booking : customer.getBookings()) {
                                textAreabookinginfo.append("Booking Start Date: " + booking.getStartDate().toString());
                                textAreabookinginfo.append(" , Booking End Date: " + booking.getEndDate().toString());
                                textAreabookinginfo.append(" ,The booking is in Property: " + booking.getPropertyId());
                                textAreabookinginfo.append("\n--------------------------------\n");
                            }
                        }
                        catch (NullPointerException boss)
                        {
                            JOptionPane.showMessageDialog(Main.this,"No booking is found");
                            return;
                        }
                    }
                }

                if (!userexists) {
                    JOptionPane.showMessageDialog(Main.this,"No Customer found with User ID " + userId);
                }
                bookinginfouserid.setText("");
            }
        });
        /**
         * it will display the booking cost before and after the discount for specific user.
         */
        bookingCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean userFound = false;
                boolean propertyFound = false;
                if(useridcost.getText().isEmpty()||propertyidcost.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Main.this,"Please Fill both Fields","Empty Field Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int userId= Integer.parseInt(useridcost.getText());
                int propertyId=Integer.parseInt(propertyidcost.getText());

                textareaforcost.append("Booking Costs for User ID " + userId + " and Property ID " + propertyId + ":"+"\n");

                for (User user : bnb.getUsers()) {
                    if (user.getUserId() == userId && user instanceof Customer) {
                        userFound = true;
                        Customer customer=(Customer) user;
                    try {
                        for (Booking booking : customer.getBookings()) {
                            if (booking.getPropertyId() == propertyId) {
                                propertyFound = true;

                                Property property = bnb.getPropertyById(propertyId);

                                if (property != null) {
                                    double cost = booking.totalCost(property);
                                    double discount = bnb.getDiscountForUser(userId);
                                    double costafterdiscount = cost - (discount * cost);
                                    textareaforcost.append("Booking Cost: $" + cost + "\n");
                                    textareaforcost.append("applicable discount:  " + 100*discount + "%\n");
                                    textareaforcost.append("Booking Cost after applying the discount for Gold Customers and 10 years loyal Standard Customers: $" + costafterdiscount + "\n");
                                }
                            }
                        }
                    }catch (NullPointerException boss2)
                    {
                        JOptionPane.showMessageDialog(Main.this,"No booking if found to display the cost");
                        return;
                    }

                        if (!propertyFound) {
                            JOptionPane.showMessageDialog(Main.this,"No bookings found for Property ID " + propertyId);
                        }
                    }
                }

                if (!userFound) {
                    JOptionPane.showMessageDialog(Main.this,"User with ID " + userId + " does not exist.");
                }
                propertyidcost.setText("");
                useridcost.setText("");
            }
        });
        /**
         * it will check what type of user to show the applicable discount
         */
        userDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean userFound = false;
                if(useriddiscount.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(Main.this,"Please Fill the User ID Field","Empty Field Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int userID=Integer.parseInt(useriddiscount.getText());

                for (User user : bnb.users) {
                    if (user.getUserId() == userID) {
                        userFound = true;
                        if(user instanceof Gold)
                        {
                            JOptionPane.showMessageDialog (Main.this,((Gold) user).getGoldlevel()+"% is applicable since the user is gold level "+((Gold) user).getGoldlevel());
                        }
                        else if(user instanceof Standard)
                        {
                            Instant instant = user.getRegisterationdate().toInstant();
                            ZoneId zoneId = ZoneId.systemDefault();
                            LocalDate localRegistrationDate = instant.atZone(zoneId).toLocalDate();

                            // Get the current date
                            LocalDate currentDate = LocalDate.now();

                            // Calculate the duration between the registration date and the current date
                            Period period = Period.between(localRegistrationDate, currentDate);

                            // Check if the registration is more than 10 years
                            if (period.getYears() >= 10) {
                                JOptionPane.showMessageDialog(Main.this,"The user has been registered for more than 10 years, so 2% Discount is applicable");
                            } else {
                                JOptionPane.showMessageDialog(Main.this,"The user has been registered for less than 10 years, so not applicable discount");
                                // No discount for the standard customer
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(Main.this,"User with ID "+userID+" is not a customer");

                        break;
                    }

                }
                if(!userFound)
                {
                    JOptionPane.showMessageDialog (Main.this,"Customer with ID "+userID+" doesn't Exist");
                }
                useriddiscount.setText("");
            }

        });
        /**
         * it will call the same method that got called at the beginning of the program to choose a file directory for the data.
         */
        mnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoknewmenuitem();
                startingIO();
            }
        });
        /**
         * it will store the data in the database when you click save/extract.
         */
        savefilebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataStorage.writeUsersAndProperties(bnb);
            }
        });
        /**
         * it will ask the user when he closes the window if he wants to save the data or not.
         */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //asking the user when he closes the window.
                int choice = JOptionPane.showConfirmDialog(Main.this,
                        "Do you want to save the data before closing?",
                        "Confirm Close",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    DataStorage.writeUsersAndProperties(bnb);
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

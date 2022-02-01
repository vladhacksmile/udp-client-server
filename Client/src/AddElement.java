import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddElement extends JDialog implements ILocalized {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameField;
    private JComboBox comboBox1;
    private JTextField cordxField;
    private JTextField cordyField;
    private JTextField annualturnoverField;
    private JTextField streetField;
    private JTextField zipcodeField;
    private JLabel nameLabel;
    private JLabel cordxLabel;
    private JLabel cordyLabel;
    private JLabel annualturnoverLabel;
    private JLabel typeLabel;
    private JLabel streetLabel;
    private JLabel zipcodeLabel;
    private boolean ready;
    private int annualTurnover;
    private Coordinates coordinates;
    private boolean addedMode;
    private Organization organization;

    public AddElement(String name, float cordX, float cordY, int annualTurnover, OrganizationType type, String street, String zipcode) {
        set(name, cordX, cordY, annualTurnover, type, street, zipcode);
        addedMode = false;
        create();
    }

    public AddElement() {
        addedMode = true;
        create();
    }

    public AddElement(Organization o) {
        organization = o;
        set(o.getName(), o.getCoordinates().getX(), o.getCoordinates().getY(), o.getAnnualTurnover(), o.getType(), Utils.getStreet(o.getOfficialAddress()), Utils.getZipCode(o.getOfficialAddress()));
        addedMode = false;
        create();
    }

    public void create() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        for (OrganizationType t : OrganizationType.values()) {
            comboBox1.addItem(t);
        }

        localize();

        /* SHOWER */
        setMinimumSize(new Dimension(425, 250));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        /* SHOWER */
    }

    public boolean isReady() {
        return ready;
    }

    public void set(String name, float cordX, float cordY, int annualTurnover, OrganizationType type,
                    String street, String zipcode) {
        nameField.setText(name);
        cordxField.setText(String.valueOf(cordX));
        cordyField.setText(String.valueOf(cordY));
        try {
            coordinates = new Coordinates(cordX, cordY);
        } catch (IncorrectValueException e) {
            GUIManager.println(e.getMessage());
        }
        annualturnoverField.setText(String.valueOf(annualTurnover));
        this.annualTurnover = annualTurnover;
        comboBox1.setSelectedItem(type);
        streetField.setText(street);
        zipcodeField.setText(zipcode);
    }

    private void onOK() {
        String[] request;

        if (addedMode) {
            request = new String[]{"add"};
        } else {
            if (organization == null) {
                request = new String[]{"updateElement", String.valueOf(Main.mainForm.getLobbyForm().getSelectedOrganization())};
            } else {
                request = new String[]{"updateElement", String.valueOf(organization.getId())};
            }
        }

        try {
            try {
                coordinates = new Coordinates(Float.parseFloat(cordxField.getText()), Float.parseFloat(cordyField.getText()));
            } catch (NumberFormatException e) {
                cordxField.setText(String.valueOf(coordinates.getX()));
                cordyField.setText(String.valueOf(coordinates.getY()));
                JOptionPane.showMessageDialog(Main.mainForm.getLobbyForm().getFrame(), LocaleManager.getBundle().getString("message_coordinates_number_format_error"), LocaleManager.getBundle().getString("message_caption_error"), JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                annualTurnover = Integer.parseInt(annualturnoverField.getText());
            } catch (NumberFormatException e) {
                annualturnoverField.setText(String.valueOf(annualTurnover));
                JOptionPane.showMessageDialog(Main.mainForm.getLobbyForm().getFrame(), LocaleManager.getBundle().getString("message_annual_turnover_number_format_error"), LocaleManager.getBundle().getString("message_caption_error"), JOptionPane.ERROR_MESSAGE);
                return;
            }
            UDPSocketClient.send(new Command(Auth.getUser(), request, new Organization(nameField.getText(), coordinates, annualTurnover, Utils.StrToType(String.valueOf(comboBox1.getSelectedItem())), new Address(streetField.getText(), zipcodeField.getText()))));
            Main.mainForm.getLobbyForm().setShouldUpdated(true);
            ready = true;
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Main.mainForm.getLobbyForm().getFrame(), LocaleManager.getBundle().getString("message_check_number_fields"), LocaleManager.getBundle().getString("message_caption_error"), JOptionPane.ERROR_MESSAGE);
        } catch (IncorrectValueException e) {
            JOptionPane.showMessageDialog(Main.mainForm.getLobbyForm().getFrame(), e.getMessage(), LocaleManager.getBundle().getString("message_caption_error"), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        ready = false;
        dispose();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        buttonOK = new JButton();
        buttonOK.setText("OK");
        panel2.add(buttonOK);
        buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        panel2.add(buttonCancel);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel3, gbc);
        nameLabel = new JLabel();
        nameLabel.setText("Введите имя:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(nameLabel, gbc);
        nameField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(nameField, gbc);
        cordxField = new JTextField();
        cordxField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(cordxField, gbc);
        annualturnoverLabel = new JLabel();
        annualturnoverLabel.setText("Введите годовой оборот:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(annualturnoverLabel, gbc);
        annualturnoverField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(annualturnoverField, gbc);
        typeLabel = new JLabel();
        typeLabel.setText("Выберите тип организации:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(typeLabel, gbc);
        streetLabel = new JLabel();
        streetLabel.setText("Введите улицу:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(streetLabel, gbc);
        streetField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(streetField, gbc);
        zipcodeLabel = new JLabel();
        zipcodeLabel.setText("Введите индекс:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(zipcodeLabel, gbc);
        zipcodeField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(zipcodeField, gbc);
        comboBox1 = new JComboBox();
        comboBox1.setToolTipText("Выберите");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(comboBox1, gbc);
        cordxLabel = new JLabel();
        cordxLabel.setText("Введите координату X:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(cordxLabel, gbc);
        cordyLabel = new JLabel();
        cordyLabel.setText("Введите координату Y:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(cordyLabel, gbc);
        cordyField = new JTextField();
        cordyField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(cordyField, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    @Override
    public void localize() {
        if (addedMode) setTitle(LocaleManager.getBundle().getString("add_element"));
        else setTitle(LocaleManager.getBundle().getString("update_element"));
        nameLabel.setText(LocaleManager.getBundle().getString("enter_name"));
        cordxLabel.setText(LocaleManager.getBundle().getString("enter_cord_x"));
        cordyLabel.setText(LocaleManager.getBundle().getString("enter_cord_y"));
        annualturnoverLabel.setText(LocaleManager.getBundle().getString("enter_annual_turnover"));
        typeLabel.setText(LocaleManager.getBundle().getString("select_type"));
        streetLabel.setText(LocaleManager.getBundle().getString("enter_street"));
        zipcodeLabel.setText(LocaleManager.getBundle().getString("enter_zipcode"));
    }
}

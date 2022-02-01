import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class LobbyForm implements ILocalized {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton sendButton;
    private JButton exitButton;
    private JFrame frame;
    private JTextArea textArea1;
    private JLabel helloField;
    private JTable collectionTable;
    private JPanel consolePanel;
    private JScrollPane scroll;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton changeButton;
    private JComboBox comboBox1;
    private JButton addButton;
    private JPanel visualPanel;
    private JPanel collectionPanel;
    private JLabel sortbyLabel;
    private JComboBox comboBox2;
    private final Thread currThread = new Thread();
    private String value;
    private DefaultTableModel tableModel;
    private boolean shouldUpdated = false;

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JLabel getHelloField() {
        return helloField;
    }

    public LobbyForm() {
        frame = new JFrame("Главное меню");
        $$$setupUI$$$();
        frame.setSize(600, 400);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(600, 815));
        frame.pack();
        DefaultCaret caret = (DefaultCaret) textArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        currThread.start();

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAction();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        textField1.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendAction();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCollection();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* String[] request = {"remove_by_id", String.valueOf(getSelectedOrganization())};
                UDPSocketClient.send(new Command(Auth.getUser(), request, null)); */
                for (int selectedRow : collectionTable.getSelectedRows()) {
                    String[] r = {"remove_by_id", "" + (int) collectionTable.getModel().getValueAt(selectedRow, 0)};
                    UDPSocketClient.send(new Command(Auth.getUser(), r, null));
                }
                Main.mainForm.getLobbyForm().setShouldUpdated(true);
            }
        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAction();
            }
        });

        collectionTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    editAction();
                }
            }
        });

        tabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tabbedPane1.getSelectedIndex() == 1) {
                    updateCollection();
                }
            }
        });
        collectionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (collectionTable.getSelectedRow() != -1) {
                    changeButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                } else {
                    changeButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }
            }
        });


        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateCollection();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAction();
            }
        });
        localize();

        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                LocaleManager.setLanguageId(comboBox2.getSelectedIndex());
                localize();
                Main.mainForm.getComboBox1().setSelectedItem(LocaleManager.getLanguageId());
            }
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setFocusTraversalPolicyProvider(false);
        tabbedPane1.setOpaque(true);
        tabbedPane1.setRequestFocusEnabled(true);
        tabbedPane1.setTabLayoutPolicy(1);
        tabbedPane1.setTabPlacement(1);
        panel1.add(tabbedPane1, BorderLayout.CENTER);
        consolePanel = new JPanel();
        consolePanel.setLayout(new BorderLayout(0, 0));
        consolePanel.setPreferredSize(new Dimension(750, 760));
        tabbedPane1.addTab("Консоль", consolePanel);
        scroll = new JScrollPane();
        scroll.setHorizontalScrollBarPolicy(30);
        scroll.setPreferredSize(new Dimension(700, 700));
        scroll.setRequestFocusEnabled(true);
        scroll.setVerticalScrollBarPolicy(20);
        consolePanel.add(scroll, BorderLayout.NORTH);
        textArea1 = new JTextArea();
        scroll.setViewportView(textArea1);
        textField1 = new JTextField();
        consolePanel.add(textField1, BorderLayout.CENTER);
        sendButton = new JButton();
        sendButton.setText("Отправить");
        consolePanel.add(sendButton, BorderLayout.EAST);
        collectionPanel = new JPanel();
        collectionPanel.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("Коллекция", collectionPanel);
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setEnabled(true);
        scrollPane1.setPreferredSize(new Dimension(462, 650));
        collectionPanel.add(scrollPane1, BorderLayout.CENTER);
        collectionTable.setAutoCreateRowSorter(true);
        collectionTable.setRequestFocusEnabled(true);
        scrollPane1.setViewportView(collectionTable);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        collectionPanel.add(panel2, BorderLayout.NORTH);
        sortbyLabel = new JLabel();
        sortbyLabel.setText("Сортировать по:");
        panel2.add(sortbyLabel);
        comboBox1 = new JComboBox();
        panel2.add(comboBox1);
        updateButton = new JButton();
        updateButton.setText("Обновить");
        panel2.add(updateButton);
        addButton = new JButton();
        addButton.setText("Добавить");
        panel2.add(addButton);
        changeButton = new JButton();
        changeButton.setEnabled(false);
        changeButton.setText("Изменить");
        panel2.add(changeButton);
        deleteButton = new JButton();
        deleteButton.setActionCommand("");
        deleteButton.setDoubleBuffered(false);
        deleteButton.setEnabled(false);
        deleteButton.setText("Удалить");
        panel2.add(deleteButton);
        tabbedPane1.addTab("Визуализация", visualPanel);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel1.add(panel3, BorderLayout.NORTH);
        helloField = new JLabel();
        helloField.setText("Привет, user!");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(helloField, gbc);
        exitButton = new JButton();
        exitButton.setHideActionText(true);
        exitButton.setHorizontalAlignment(0);
        exitButton.setText("Выход");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        panel3.add(exitButton, gbc);
        comboBox2 = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(comboBox2, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer1, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    private void createUIComponents() {
        if (tableModel == null) {
            tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
        }
        collectionTable = new JTable(tableModel);
        visualPanel = new CollectionVisual();
    }

    public void updateColumnsHeader() {
        Object[] columnsHeader = new String[]{LocaleManager.getBundle().getString("id"), LocaleManager.getBundle().getString("name"), LocaleManager.getBundle().getString("cord_x"), LocaleManager.getBundle().getString("cord_y"), LocaleManager.getBundle().getString("creation_date"), LocaleManager.getBundle().getString("annual_turnover"), LocaleManager.getBundle().getString("type"), LocaleManager.getBundle().getString("street"), LocaleManager.getBundle().getString("zipcode"), LocaleManager.getBundle().getString("author")};
        tableModel.setColumnIdentifiers(columnsHeader);
    }


    public JTextField getTextField1() {
        return textField1;
    }

    public void sendAction() {
        value = textField1.getText();
        synchronized (currThread) {
            currThread.notify();
        }
        if (UDPSocketClient.started) {
            if (GUIManager.isConsoleMode()) {
                new Thread(new MakeResponse(textField1.getText())).start();
            } else {
                value = textField1.getText();
            }
        } else {
            UDPSocketClient.close();
        }
        textField1.setText("");
    }

    public void editAction() {
        AddElement addElement = new AddElement(String.valueOf(getRow(collectionTable.getSelectedRow(), 1)), (float) getRow(collectionTable.getSelectedRow(), 2), (float) getRow(collectionTable.getSelectedRow(), 3), (int) getRow(collectionTable.getSelectedRow(), 5), Utils.StrToType(String.valueOf(getRow(collectionTable.getSelectedRow(), 6))), String.valueOf(getRow(collectionTable.getSelectedRow(), 7)), String.valueOf(getRow(collectionTable.getSelectedRow(), 8)));
    }

    public void addAction() {
        AddElement addElement = new AddElement();
    }

    public void updateCollection() {
        UDPSocketClient.send(new Command(Auth.getUser(), Utils.formRequest("getCollection"), null));
    }

    public void updateCollectionForVisual() {
        if (Main.mainForm.getLobbyForm().getTabbedPane1().getSelectedIndex() == 2)
            UDPSocketClient.send(new Command(Auth.getUser(), Utils.formRequest("getCollection"), null));
    }

    public int getSelectedOrganization() {
        if (collectionTable.getSelectedRow() != -1)
            return (int) getRow(collectionTable.getSelectedRow(), 0);
        return 0;
    }

    public Object getRow(int index, int column) {
        return collectionTable.getModel().getValueAt(index, column);
    }

    public String getValue() {
        return value;
    }

    public void logout() {
        frame.dispose();
        Main.mainForm.getFrame().setVisible(true);
        Auth.logout();
        clean();
    }

    public Thread getCurrThread() {
        return currThread;
    }

    public JTable getCollectionTable() {
        return collectionTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void clean() {
        textArea1.setText(null);
        GUIManager.setConsoleMode(true);
    }

    public boolean isShouldUpdated() {
        return shouldUpdated;
    }

    public void setShouldUpdated(boolean shouldUpdated) {
        this.shouldUpdated = shouldUpdated;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    @Override
    public void localize() {
        frame.setTitle(LocaleManager.getBundle().getString("lobby"));
        helloField.setText(String.format(LocaleManager.getBundle().getString("hello_user"), Auth.getUser().getUsername()));
        tabbedPane1.setTitleAt(0, LocaleManager.getBundle().getString("console"));
        tabbedPane1.setTitleAt(1, LocaleManager.getBundle().getString("collection"));
        tabbedPane1.setTitleAt(2, LocaleManager.getBundle().getString("visualization"));
        sendButton.setText(LocaleManager.getBundle().getString("send"));
        sortbyLabel.setText(LocaleManager.getBundle().getString("sort_by"));
        updateButton.setText(LocaleManager.getBundle().getString("update"));
        addButton.setText(LocaleManager.getBundle().getString("add"));
        changeButton.setText(LocaleManager.getBundle().getString("change"));
        deleteButton.setText(LocaleManager.getBundle().getString("delete"));
        exitButton.setText(LocaleManager.getBundle().getString("exit"));
        updateColumnsHeader();
        comboBox1.removeAllItems();
        for (int i = 0; i < collectionTable.getColumnCount(); i++) {
            comboBox1.addItem(collectionTable.getColumnName(i));
        }
        if (comboBox2.getItemCount() == 0) {
            comboBox2.addItem(LocaleManager.getBundle().getString("lang_ru"));
            comboBox2.addItem(LocaleManager.getBundle().getString("lang_no"));
            comboBox2.addItem(LocaleManager.getBundle().getString("lang_hr"));
            comboBox2.addItem(LocaleManager.getBundle().getString("lang_en"));
        }
    }
}

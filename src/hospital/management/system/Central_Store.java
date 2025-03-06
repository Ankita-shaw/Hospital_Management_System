package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Central_Store extends JFrame implements ActionListener {
    JTextField itemNameField, itemQuantityField, reorderLevelField, vendorNameField, purchasePriceField;
    Choice itemCategoryChoice, storeTypeChoice;
    JButton addItemButton, generatePOButton, returnItemButton, backButton;
    JTextArea itemListArea;

    Central_Store() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(180, 200, 220));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/169837.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,180,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(400,180,350,200);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setForeground(Color.WHITE);
        panel.add(label);


        JLabel title = new JLabel("Central Store Management");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(300, 10, 400, 30);
        title.setForeground(Color.BLACK);
        panel.add(title);

        JLabel itemLabel = new JLabel("Item Name:");
        itemLabel.setBounds(50, 50, 150, 20);
        itemLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(itemLabel);

        itemNameField = new JTextField();
        itemNameField.setBounds(200, 50, 150, 20);
        panel.add(itemNameField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(50, 100, 150, 20);
        categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(categoryLabel);

        itemCategoryChoice = new Choice();
        itemCategoryChoice.add("Medicine");
        itemCategoryChoice.add("Consumables");
        itemCategoryChoice.add("Equipment");
        itemCategoryChoice.add("Implants");
        itemCategoryChoice.add("Assets");
        itemCategoryChoice.setBounds(200, 100, 150, 20);
        panel.add(itemCategoryChoice);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 150, 150, 20);
        quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(quantityLabel);

        itemQuantityField = new JTextField();
        itemQuantityField.setBounds(200, 150, 150, 20);
        panel.add(itemQuantityField);

        JLabel reorderLabel = new JLabel("Reorder Level:");
        reorderLabel.setBounds(50, 200, 150, 20);
        reorderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(reorderLabel);

        reorderLevelField = new JTextField();
        reorderLevelField.setBounds(200, 200, 150, 20);
        panel.add(reorderLevelField);

        JLabel vendorLabel = new JLabel("Vendor Name:");
        vendorLabel.setBounds(50, 250, 150, 20);
        vendorLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(vendorLabel);

        vendorNameField = new JTextField();
        vendorNameField.setBounds(200, 250, 150, 20);
        panel.add(vendorNameField);

        JLabel purchasePriceLabel = new JLabel("Purchase Price:");
        purchasePriceLabel.setBounds(50, 300, 150, 20);
        purchasePriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(purchasePriceLabel);

        purchasePriceField = new JTextField();
        purchasePriceField.setBounds(200, 300, 150, 20);
        panel.add(purchasePriceField);

        JLabel storeTypeLabel = new JLabel("Store Type:");
        storeTypeLabel.setBounds(50, 350, 150, 20);
        storeTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(storeTypeLabel);

        storeTypeChoice = new Choice();
        storeTypeChoice.add("Central Store");
        storeTypeChoice.add("Sub Store");
        storeTypeChoice.setBounds(200, 350, 150, 20);
        panel.add(storeTypeChoice);



        addItemButton = new JButton("Add Item");
        addItemButton.setBounds(50, 420, 150, 30);
        addItemButton.setBackground(Color.GREEN);
        addItemButton.addActionListener(this);
        panel.add(addItemButton);

        generatePOButton = new JButton("Generate PO");
        generatePOButton.setBounds(230, 420, 150, 30);
        generatePOButton.setBackground(Color.BLUE);
        generatePOButton.setForeground(Color.WHITE);
        generatePOButton.addActionListener(this);
        panel.add(generatePOButton);

        returnItemButton = new JButton("Return Item");
        returnItemButton.setBounds(410, 420, 150, 30);
        returnItemButton.setBackground(Color.YELLOW);
        returnItemButton.addActionListener(this);
        panel.add(returnItemButton);

        backButton = new JButton("BACK");
        backButton.setBounds(590, 420, 150, 30);
        backButton.setBackground(Color.ORANGE);
        backButton.addActionListener(this);
        panel.add(backButton);

        fetchItemList();

        setUndecorated(true);
        setSize(850, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            addItem();
        } else if (e.getSource() == generatePOButton) {
            generatePurchaseOrder();
        } else if (e.getSource() == returnItemButton) {
            returnItem();
        } else if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    private void addItem() {
        try {
            String itemName = itemNameField.getText();
            String category = itemCategoryChoice.getSelectedItem();
            String quantity = itemQuantityField.getText();
            String reorderLevel = reorderLevelField.getText();
            String vendor = vendorNameField.getText();
            String purchasePrice = purchasePriceField.getText();
            String storeType = storeTypeChoice.getSelectedItem();

            conn c = new conn();
            String query = "INSERT INTO store_items (item_name, category, quantity, reorder_level, vendor, purchase_price, store_type) " +
                    "VALUES ('" + itemName + "', '" + category + "', '" + quantity + "', '" + reorderLevel + "', '" + vendor + "', '" + purchasePrice + "', '" + storeType + "')";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Item Added Successfully");
            fetchItemList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generatePurchaseOrder() {
        try {
            String itemName = itemNameField.getText();
            String quantity = itemQuantityField.getText();
            String vendor = vendorNameField.getText();

            conn c = new conn();
            String query = "INSERT INTO purchase_orders (item_name, quantity, vendor) " +
                    "VALUES ('" + itemName + "', '" + quantity + "', '" + vendor + "')";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Purchase Order Generated Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void returnItem() {
        try {
            String itemName = itemNameField.getText();
            String storeType = storeTypeChoice.getSelectedItem();

            conn c = new conn();
            String query = "INSERT INTO returned_items (item_name, store_type) VALUES ('" + itemName + "', '" + storeType + "')";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Item Returned Successfully");
            fetchItemList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fetchItemList() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM store_items");
            itemListArea.setText("Item Name\tCategory\tQuantity\tVendor\tStore Type\n");
            itemListArea.append("----------------------------------------------------------\n");
            while (rs.next()) {
                itemListArea.append(rs.getString("item_name") + "\t" +
                        rs.getString("category") + "\t" +
                        rs.getString("quantity") + "\t" +
                        rs.getString("vendor") + "\t" +
                        rs.getString("store_type") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Central_Store();
    }
}

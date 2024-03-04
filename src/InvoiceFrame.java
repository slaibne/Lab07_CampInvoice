import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;


public class InvoiceFrame extends JFrame
{
    ArrayList<Product> lineItems = new ArrayList<>();
    private JPanel mainPanel, titlePanel, orderPanel, buttonPanel;
    private JLabel titleLabel;
    private JTextArea orderText;
    private JScrollPane scroller;
    private JButton clearBtn, quitBtn, itemBtn;


    private ActionListener clear = new clearListener();
    private ActionListener addItem = new addItem();

    private double  completeTotal;

    InvoiceFrame()
    {
        setTitle("Item Order");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        titlePanel = new JPanel();
        orderPanel = new JPanel();
        buttonPanel = new JPanel();

        titleLabel = new JLabel("Item Order Form");

        orderText = new JTextArea(18,25);
        orderText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        scroller = new JScrollPane(orderText);

        itemBtn = new JButton("Add Item");
        itemBtn.addActionListener(addItem);
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(clear);
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(new quitListener());

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        titlePanel.add(titleLabel);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));

        orderPanel.add(scroller);
        mainPanel.add(orderPanel, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(itemBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(quitBtn);

        add(mainPanel);
    }
    private class addItem implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            lineItems.add(new Product(JOptionPane.showInputDialog("What is the name of the product?"), Double.parseDouble(JOptionPane.showInputDialog("How much is the product? (number in Digits)")), Integer.parseInt(JOptionPane.showInputDialog("How many are you buying? (Integers Only)"))));
            NumberFormat num = NumberFormat.getCurrencyInstance();
            completeTotal = 0;

            for (Product m:lineItems)
                completeTotal = completeTotal + (m.getCost()*m.getQuantity());

            orderText.setText(String.format("============Invoice============\n"
                    + "Item                Qty     Price     Total\n"));
            for (Product m:lineItems)
            {
                orderText.append(String.format(m.getName()+ "                 " + (m.getQuantity()) +"   "+ num.format(m.getCost()) +"   "+ num.format(m.getQuantity()*m.getCost())+"\n"));
            }
            orderText.append(
                    "\n=============================\n"
                            + "Total:                              "+num.format(completeTotal)+"\n"
                            + "=============================\n\n");


        }
    }

    private class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            lineItems.clear();

            orderText.setText(null);
        }
    }

    private class quitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }
}
import javax.swing.*;

public class InvoiceRunner {
    public static void main(String[] args) {
        InvoiceFrame invoice = new InvoiceFrame();
        invoice.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        invoice.setVisible(true);
    }
}
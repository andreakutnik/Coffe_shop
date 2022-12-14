import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Home implements ActionListener {
    JButton flatWhiteBtn, mochaBtn, icedCoffeeBtn, cappuccinoBtn, americanoBtn, espressoBtn, latteBtn, macchiatoBtn, cortadoBtn;

    int offset;
    final int width = 200;
    final int height = 200;
    Home() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenSizeWidth = (int) screenSize.getWidth();
        int screenSizeHeight = (int) screenSize.getHeight();

        JFrame homeFrame = new JFrame("Home");
        homeFrame.setVisible(true);
        homeFrame.setLayout(null);
        homeFrame.setSize(screenSizeWidth, screenSizeHeight);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.getContentPane().setBackground(Color.WHITE);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon flatWhiteIcon = new ImageIcon("Images/flat white.png");
        ImageIcon mochaIcon = new ImageIcon("Images/mocha.png");
        ImageIcon icedCoffeeIcon = new ImageIcon("Images/iced coffee.png");
        ImageIcon cappuccinoIcon = new ImageIcon("Images/cappuccino.png");
        ImageIcon americanoIcon = new ImageIcon("Images/americano.png");
        ImageIcon espressoIcon = new ImageIcon("Images/espresso.png");
        ImageIcon latteIcon = new ImageIcon("Images/latte.png");
        ImageIcon macchiatoIcon = new ImageIcon("Images/macchiato.png");
        ImageIcon cortadoIcon = new ImageIcon("Images/cortado.png");



        flatWhiteBtn = new JButton();
        flatWhiteBtn.setBounds(60, 140, width, height);
        offset = flatWhiteBtn.getInsets().left;
        flatWhiteBtn.setIcon(resizeIcon(flatWhiteIcon, flatWhiteBtn.getWidth() - offset, flatWhiteBtn.getHeight() - offset));
        flatWhiteBtn.addActionListener(this);
        homeFrame.add(flatWhiteBtn);

        mochaBtn = new JButton();
        mochaBtn.setBounds(60 + width + 20, 140, width, height);
        offset = mochaBtn.getInsets().left;
        mochaBtn.setIcon(resizeIcon(mochaIcon, mochaBtn.getWidth() - offset, mochaBtn.getHeight() - offset));
        mochaBtn.addActionListener(this);
        homeFrame.add(mochaBtn);

        icedCoffeeBtn = new JButton();
        icedCoffeeBtn.setBounds(60 + 2 * (width + 20), 140, width, height);
        offset = icedCoffeeBtn.getInsets().left;
        icedCoffeeBtn.setIcon(resizeIcon(icedCoffeeIcon, icedCoffeeBtn.getWidth() - offset, icedCoffeeBtn.getHeight() - offset));
        icedCoffeeBtn.addActionListener(this);
        homeFrame.add(icedCoffeeBtn);

        cappuccinoBtn = new JButton();
        cappuccinoBtn.setBounds(60 + 3 * (width + 20), 140, width, height);
        offset = cappuccinoBtn.getInsets().left;
        cappuccinoBtn.setIcon(resizeIcon(cappuccinoIcon, cappuccinoBtn.getWidth() - offset, cappuccinoBtn.getHeight() - offset));
        cappuccinoBtn.addActionListener(this);
        homeFrame.add(cappuccinoBtn);

        americanoBtn = new JButton();
        americanoBtn.setBounds(60 + 4 * (width + 20), 140, width, height);
        offset = americanoBtn.getInsets().left;
        americanoBtn.setIcon(resizeIcon(americanoIcon, americanoBtn.getWidth() - offset, americanoBtn.getHeight() - offset));
        americanoBtn.addActionListener(this);
        homeFrame.add(americanoBtn);

        espressoBtn = new JButton();
        espressoBtn.setBounds(60, 140 + height + 20, width, height);
        offset = espressoBtn.getInsets().left;
        espressoBtn.setIcon(resizeIcon(espressoIcon, espressoBtn.getWidth() - offset, espressoBtn.getHeight() - offset));
        espressoBtn.addActionListener(this);
        homeFrame.add(espressoBtn);

        latteBtn = new JButton();
        latteBtn.setBounds(60 + width + 20, 140 + height + 20, width, height);
        offset = latteBtn.getInsets().left;
        latteBtn.setIcon(resizeIcon(latteIcon, latteBtn.getWidth() - offset, latteBtn.getHeight() - offset));
        latteBtn.addActionListener(this);
        homeFrame.add(latteBtn);

        macchiatoBtn = new JButton();
        macchiatoBtn.setBounds(60 + 2 * (width + 20), 140 + height + 20, width, height);
        offset = macchiatoBtn.getInsets().left;
        macchiatoBtn.setIcon(resizeIcon(macchiatoIcon, macchiatoBtn.getWidth() - offset, macchiatoBtn.getHeight() - offset));
        macchiatoBtn.addActionListener(this);
        homeFrame.add(macchiatoBtn);

        cortadoBtn = new JButton();
        cortadoBtn.setBounds(60 + 3 * (width + 20), 140 + height + 20, width, height);
        offset = cortadoBtn.getInsets().left;
        cortadoBtn.setIcon(resizeIcon(cortadoIcon, cortadoBtn.getWidth() - offset, cortadoBtn.getHeight() - offset));
        cortadoBtn.addActionListener(this);
        homeFrame.add(cortadoBtn);
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Home();
    }
}


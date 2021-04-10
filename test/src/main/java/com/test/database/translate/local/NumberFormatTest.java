package com.test.database.translate.local;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        double asDouble = Arrays.stream(a).average().getAsDouble();
        System.out.println(asDouble);
//        EventQueue.invokeLater(() -> {
//            NumberFormatFrame numberFormatFrame = new NumberFormatFrame();
//            numberFormatFrame.setTitle("NumberFormatTest");
//            numberFormatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            numberFormatFrame.setVisible(true);
//        });
    }
}

class NumberFormatFrame extends JFrame {
    private Locale[] locales;
    private double currentNumber;
    private JComboBox<String> localCombo = new JComboBox<>();
    private JButton parseButton = new JButton("Parse");
    private JTextField numberText = new JTextField(30);
    private JRadioButton numberRadioButton = new JRadioButton("number");
    private JRadioButton currencyRadioButton = new JRadioButton("currency");
    private JRadioButton percentRadioButton = new JRadioButton("percent");
    private ButtonGroup rgroup = new ButtonGroup();
    private NumberFormat currentNumberFormat;

    public NumberFormatFrame() {
        setLayout(new GridBagLayout());

        ActionListener listener = event -> updateDisplay();
        JPanel p = new JPanel();
        addRadioButton(p, numberRadioButton, rgroup, listener);
        addRadioButton(p, currencyRadioButton, rgroup, listener);
        addRadioButton(p, percentRadioButton, rgroup, listener);

        add(new JLabel("Locale:"), new GBC(0, 0).setAnchor(GBC.EAST));
        add(p, new GBC(1, 1));
        add(parseButton, new GBC(0, 2).setInsets(2));
        add(localCombo, new GBC(1, 0).setAnchor(GBC.WEST));
        add(numberText, new GBC(1, 2).setFill(GBC.HORIZONTAL));
        locales = (Locale[]) NumberFormat.getAvailableLocales().clone();
        for (Locale locale : locales) {
            localCombo.addItem(locale.getDisplayName());
        }
        localCombo.setSelectedItem(Locale.getDefault().getDisplayName());
        currentNumber = 123456.78;
        updateDisplay();

        localCombo.addActionListener(listener);
        parseButton.addActionListener(event -> {
            String s = numberText.getText().trim();
            try {
                Number parse = currentNumberFormat.parse(s);
                currentNumber = parse.doubleValue();
                updateDisplay();
            } catch (ParseException e) {
                numberText.setText(e.getMessage());
            }
        });
        pack();
    }

    private void addRadioButton(JPanel p, JRadioButton b, ButtonGroup rgroup, ActionListener listener) {
        b.setSelected(rgroup.getButtonCount() == 0);
        b.addActionListener(listener);
        rgroup.add(b);
        p.add(b);
    }

    private void updateDisplay() {
        Locale currentLocale = locales[localCombo.getSelectedIndex()];
        currentNumberFormat = null;
        if (numberRadioButton.isSelected()) {
            currentNumberFormat = NumberFormat.getNumberInstance(currentLocale);
        } else if (currencyRadioButton.isSelected()) {
            currentNumberFormat = NumberFormat.getCurrencyInstance(currentLocale);
        } else if (percentRadioButton.isSelected()) {
            currentNumberFormat = NumberFormat.getPercentInstance(currentLocale);
        }
        String format = currentNumberFormat.format(currentNumber);
        numberText.setText(format);
    }
}

class GBC extends GridBagConstraints {
    //初始化左上角位置

    public GBC(int gridx, int gridy) {
        this.gridx = gridx;

        this.gridy = gridy;

    }


    //初始化左上角位置和所占行数和列数

    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;

        this.gridy = gridy;

        this.gridwidth = gridwidth;

        this.gridheight = gridheight;

    }


    //对齐方式

    public GBC setAnchor(int anchor) {
        this.anchor = anchor;

        return this;

    }


    //是否拉伸及拉伸方向

    public GBC setFill(int fill) {
        this.fill = fill;

        return this;

    }


    //x和y方向上的增量

    public GBC setWeight(double weightx, double weighty) {
        this.weightx = weightx;

        this.weighty = weighty;

        return this;

    }


    //外部填充

    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);

        return this;

    }


    //外填充

    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);

        return this;

    }


    //内填充

    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;

        this.ipady = ipady;

        return this;

    }

}

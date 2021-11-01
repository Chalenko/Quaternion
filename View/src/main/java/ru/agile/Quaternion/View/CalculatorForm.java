package main.java.ru.agile.Quaternion.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.java.ru.agile.Quaternion.ViewModel.ViewModel;

public final class CalculatorForm extends JFrame {

    private static final long serialVersionUID = 7531920367718101781L;
	private JPanel mainPanel;
    private JButton btnCalc;
    private ViewModel viewModel;

    private JTextField txtZ1Re;
    private JTextField txtZ1Im;
    private JTextField txtZ2Re;
    private JTextField txtZ2Im;
    //private JComboBox<ViewModel.Operation> cbOperation;
    private JComboBox<Object> cbOperation;
    private JTextField txtResult;
    private JLabel lbStatus;

    private CalculatorForm(){
    }

    private CalculatorForm(final ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();

        loadListOfOperations();

        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                //CalculatorForm.this.viewModel.calculate();
                backBind();
            }
        });

        cbOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                //CalculatorForm.this.viewModel.processKeyInTextField(e.getKeyCode());
                backBind();
            }
        };
        txtZ1Re.addKeyListener(keyListener);
        txtZ1Im.addKeyListener(keyListener);
        txtZ2Re.addKeyListener(keyListener);
        txtZ2Im.addKeyListener(keyListener);
    }

    public CalculatorForm(String string) {
		super(string);
		
		Create();
	}

	public static void main(final String[] args) {
        new CalculatorForm("Quaternion calculator");
    }
    
    private void Create(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JTextField firstRealValue = new JTextField("0");
		firstRealValue.setHorizontalAlignment(JTextField.RIGHT);
		JLabel firstRealPath = new JLabel(" + ");
		
		JPanel firstRealPanel = new JPanel(new BorderLayout());
		firstRealPanel.add(firstRealValue, BorderLayout.CENTER);
		firstRealPanel.add(firstRealPath, BorderLayout.EAST);
		
		JTextField firstIValue = new JTextField("0");
		firstIValue.setHorizontalAlignment(JTextField.RIGHT);
		JLabel firstIPath = new JLabel(" i + ");
		
		JPanel firstIPanel = new JPanel(new BorderLayout());
		firstIPanel.add(firstIValue, BorderLayout.CENTER);
		firstIPanel.add(firstIPath, BorderLayout.EAST);
		
		JTextField firstJValue = new JTextField("0");
		firstJValue.setHorizontalAlignment(JTextField.RIGHT);
		JLabel firstJPath = new JLabel(" j + ");
		
		JPanel firstJPanel = new JPanel(new BorderLayout());
		firstJPanel.add(firstJValue, BorderLayout.CENTER);
		firstJPanel.add(firstJPath, BorderLayout.EAST);
		
		JTextField firstKValue = new JTextField("0");
		firstKValue.setHorizontalAlignment(JTextField.RIGHT);
		JLabel firstKPath = new JLabel(" k ");
		
		JPanel firstKPanel = new JPanel(new BorderLayout());
		firstKPanel.add(firstKValue, BorderLayout.CENTER);
		firstKPanel.add(firstKPath, BorderLayout.EAST);
		
		
		JPanel firstInputQuaternionPanel = new JPanel(new GridLayout(1, 4));
		firstInputQuaternionPanel.add(firstRealPanel);
		firstInputQuaternionPanel.add(firstIPanel);
		firstInputQuaternionPanel.add(firstJPanel);
		firstInputQuaternionPanel.add(firstKPanel);
		
		JPanel inputDataPanel = new JPanel(new GridLayout(3, 1));
		inputDataPanel.add(firstInputQuaternionPanel);
		
		JPanel mainPanel = new JPanel(new GridLayout(3, 1));
		mainPanel.add(inputDataPanel);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		/*
		firstTeamPoint = new JTextField();
		firstTeamPoint.setBackground(Color.BLUE);
		firstTeamPoint.setForeground(Color.WHITE);
		firstTeamPoint.setFont(fontScore);
		firstTeamPoint.setHorizontalAlignment(JTextField.CENTER);
		firstTeamPoint.setText(String.valueOf(firstTeamScore));
		firstTeamPoint.setCaretColor(firstTeamPoint.getBackground());
		firstTeamPoint.setSelectedTextColor(firstTeamPoint.getForeground());
		firstTeamPoint.setSelectionColor(firstTeamPoint.getBackground());
		
		firstTeamExtraMinPanel = new JTextField();
		firstTeamExtraMinPanel.setBackground(Color.BLUE);
		firstTeamExtraMinPanel.setForeground(Color.WHITE);
		firstTeamExtraMinPanel.setFont(fontMin);
		firstTeamExtraMinPanel.setHorizontalAlignment(JTextField.LEADING);
		firstTeamExtraMinPanel.setText(textExtraMin.concat(Integer.toString(firstTeamExtraMin)));
		firstTeamExtraMinPanel.setCaretColor(firstTeamExtraMinPanel.getBackground());
		firstTeamExtraMinPanel.setSelectedTextColor(firstTeamExtraMinPanel.getForeground());
		firstTeamExtraMinPanel.setSelectionColor(firstTeamExtraMinPanel.getBackground());
		
		JComponent firstTeamPanel = new JPanel(new BorderLayout());
		firstTeamPanel.add(firstTeamName, BorderLayout.NORTH);
		firstTeamPanel.add(firstTeamPoint, BorderLayout.CENTER);
		firstTeamPanel.add(firstTeamExtraMinPanel, BorderLayout.SOUTH);
		
		JTextField secondTeamName = new JTextField();
		secondTeamName.setBackground(Color.WHITE);
		secondTeamName.setForeground(Color.BLUE);
		secondTeamName.setFont(fontName);
		secondTeamName.setHorizontalAlignment(JTextField.CENTER);
		secondTeamName.setText("Second team name");
		secondTeamName.setCaretColor(secondTeamName.getBackground());
		secondTeamName.setSelectedTextColor(secondTeamName.getForeground());
		secondTeamName.setSelectionColor(secondTeamName.getBackground());
		
		secondTeamPoint = new JTextField();
		secondTeamPoint.setBackground(Color.WHITE);
		secondTeamPoint.setForeground(Color.BLUE);
		secondTeamPoint.setFont(fontScore);
		secondTeamPoint.setHorizontalAlignment(JTextField.CENTER);
		secondTeamPoint.setText(String.valueOf(secondTeamScore));
		secondTeamPoint.setCaretColor(secondTeamPoint.getBackground());
		secondTeamPoint.setSelectedTextColor(secondTeamPoint.getForeground());
		secondTeamPoint.setSelectionColor(secondTeamPoint.getBackground());
		
		secondTeamExtraMinPanel = new JTextField();
		secondTeamExtraMinPanel.setBackground(Color.WHITE);
		secondTeamExtraMinPanel.setForeground(Color.BLUE);
		secondTeamExtraMinPanel.setFont(fontMin);
		secondTeamExtraMinPanel.setHorizontalAlignment(JTextField.LEADING);
		secondTeamExtraMinPanel.setText(textExtraMin.concat(Integer.toString(secondTeamExtraMin)));
		secondTeamExtraMinPanel.setCaretColor(secondTeamExtraMinPanel.getBackground());
		secondTeamExtraMinPanel.setSelectedTextColor(secondTeamExtraMinPanel.getForeground());
		secondTeamExtraMinPanel.setSelectionColor(secondTeamExtraMinPanel.getBackground());
		
		JComponent secondTeamPanel = new JPanel(new BorderLayout());
		secondTeamPanel.add(secondTeamName, BorderLayout.NORTH);
		secondTeamPanel.add(secondTeamPoint, BorderLayout.CENTER);
		secondTeamPanel.add(secondTeamExtraMinPanel, BorderLayout.SOUTH);
		
		mainPanel.add(firstTeamPanel); mainPanel.add(secondTeamPanel);
		
		firstTeamPoint.addKeyListener(kl);
		firstTeamExtraMinPanel.addKeyListener(kl);
		secondTeamPoint.addKeyListener(kl);
		secondTeamExtraMinPanel.addKeyListener(kl);
		
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/emblema.jpg")).getImage());
		
		info = new JTextField();
		info.setBackground(Color.WHITE);
		info.setForeground(Color.BLACK);
		info.setHorizontalAlignment(JTextField.CENTER);
		info.setFont(infoFont);
		info.setText(infoText);
		info.setCaretColor(info.getBackground());
		info.setSelectedTextColor(info.getForeground());
		info.setSelectionColor(info.getBackground());
		info.setEnabled(false);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		this.getContentPane().add(info, BorderLayout.SOUTH);
		*/
		
		this.pack();
		this.setVisible(true);
		//this.setResizable(false);
	}

    private void loadListOfOperations() {
        //ViewModel.Operation[] operations = ViewModel.Operation.values();
        //cbOperation.setModel(new JComboBox<>(operations).getModel());
    }

    private void bind() {
        //viewModel.setRe1(txtZ1Re.getText());
        //viewModel.setIm1(txtZ1Im.getText());
        //viewModel.setRe2(txtZ2Re.getText());
        //viewModel.setIm2(txtZ2Im.getText());

        //viewModel.setOperation((ViewModel.Operation) cbOperation.getSelectedItem());
    }

    private void backBind() {
        //btnCalc.setEnabled(viewModel.isCalculateButtonEnabled());

        //txtResult.setText(viewModel.getResult());
        //lbStatus.setText(viewModel.getStatus());
    }
}

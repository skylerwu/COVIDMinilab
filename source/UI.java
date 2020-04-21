import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.image.*;

public class UI extends JFrame {

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UI frame = new UI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public UI() {
			getContentPane().setBackground(new Color(175, 238, 238));
			getContentPane().setLayout(null);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1322, 890);
			
			//GETTING CIRCLEQUEUE OF DATA
			CircleQueueDriver trial = new CircleQueueDriver();
			CircleQueue data = trial.getCQueue();
			
			//IMPORTANT
			
			JLabel lblTotalCases = new JLabel("TOTAL CASES:");
			lblTotalCases.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalCases.setBounds(26, 101, 193, 60);
			getContentPane().add(lblTotalCases);
			
			JLabel lblTotalRecovered = new JLabel("TOTAL RECOVERED:");
			lblTotalRecovered.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalRecovered.setBounds(414, 100, 269, 60);
			getContentPane().add(lblTotalRecovered);
			
			JLabel lblTotalDeaths = new JLabel("TOTAL DEATHS:");
			lblTotalDeaths.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblTotalDeaths.setBounds(892, 99, 211, 60);
			getContentPane().add(lblTotalDeaths);

			/*ChartPanel chPanel = new ChartPanel(chart.getChart());
			panel.add(chPanel);
			chPanel.setPreferredSize(new Dimension(560, 367)); //size according to my window
			chPanel.setMouseWheelEnabled(true);*/
			
			JLabel lblMostDeaths = new JLabel("Most Deaths By State");
			lblMostDeaths.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblMostDeaths.setBounds(892, 152, 269, 66);
			getContentPane().add(lblMostDeaths);
			
			JTextArea Deaths = new JTextArea();
			Deaths.setLineWrap(false);
			Deaths.setRows(8);
			Deaths.setBounds(234, 241, -197, 434);
			getContentPane().add(Deaths);
			
			//DISPLAY SORTED BY MOST DEATHS BY STATE
			StateStatistics.key = StateStatistics.KeyType.numDead;
			data.insertionSort();
			Deaths.setText(data.toString());
			
			JLabel lblMostCasesBy = new JLabel("Most Cases By State");
			lblMostCasesBy.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblMostCasesBy.setBounds(26, 163, 269, 66);
			getContentPane().add(lblMostCasesBy);
	
			
			/*JTextField txtSearchForA = new JTextField();
			txtSearchForA.setForeground(Color.BLACK);
			txtSearchForA.setFont(new Font("Big Caslon", Font.PLAIN, 16));
			txtSearchForA.setText("Search for a State:");
			txtSearchForA.setBounds(910, 15, 266, 39);
			getContentPane().add(txtSearchForA);
			txtSearchForA.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Big Caslon", Font.BOLD, 16));
			btnSearch.setForeground(Color.BLACK);
			btnSearch.setBounds(1184, 16, 117, 39);
			getContentPane().add(btnSearch);
			*/
			
			JLabel lblNewLabel_5 = new JLabel("CDC Logo");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(36, 16, 77, 74);
			getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setIcon(new ImageIcon("CDC.png"));
			
			JLabel lblNewLabel_1 = new JLabel("CDC Covid-19 Case Database");
			lblNewLabel_1.setFont(new Font("Big Caslon", Font.BOLD, 40));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(300, 27, 560, 55);
			getContentPane().add(lblNewLabel_1);
			//COVIDPieChartTest chart = new COVIDPieChartTest("Distribution of COVID-19 Cases");

			JLabel lblNewLabel = new JLabel("US Map");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(875, 531, 306, 225);
			getContentPane().add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon("corona.jpg"));

			
		}
}


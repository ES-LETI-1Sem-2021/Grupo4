package pt.iscte.es.grupo4.scrumgest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.*;
import com.julienvey.trello.impl.TrelloImpl;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
/**
 * @author sarag
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Trello trelloApi;
	HashMap<TList, Card> sprintAndCards;
	List<Card> cards;
	List<Member> members;
	List<TList> sprint;
	List<Card> sprintCards;
	List<Board> member;
	Map<String, List<Card>> memberCards;
	Board board;
	GHRepository repository;

	/**
	 * Creates the main frame of the project.
	 * 
	 * @throws IOException
	 */
	public GUI() throws IOException {
		setResizable(false);
		sprint = new ArrayList<TList>();
		sprintCards = new ArrayList<Card>();
		setTitle("SCRUM Gest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 229);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		TrelloConnect();
		TrelloContents();
		GitHubConnect();

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBounds(0, 0, 220, 56);
		panel.add(panel_3);

		JLabel lblNewLabel = new JLabel("Project Identification");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(textField);
		textField.setColumns(15);
		textField.setText("ES-LETI-1Sem-2021-Grupo4");

		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 58, 220, 160);
		panel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Group Identification");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblNewLabel_1);

		JList<String> list = new JList<String>();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "Sara Fonseca - 60188", "Fabio Cruz - 62003", "Gon???alo Lopes - 54342" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		list.setBackground(Color.WHITE);
		panel_2.add(list);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(226, 0, 22, 218);
		panel.add(verticalStrut);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 55, 190, 1);
		panel.add(horizontalStrut);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "SPRINT Data", "Trello Data", "Github Data" }));
		comboBox.setBackground(Color.WHITE);
		panel_1.add(comboBox);

		JButton btnNewButton = new JButton("View");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int key = comboBox.getSelectedIndex();
				switch (key) {

				case 0: {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SubFrame1 frame1 = new SubFrame1(cards, memberCards);
								frame1.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
				case 1: {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SubFrame2 frame2 = new SubFrame2(cards, memberCards);
								frame2.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
				case 2: {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SubFrame3 frame3 = new SubFrame3(repository);
								frame3.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
				}

			}
		});
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}

		});
		panel_1.add(btnNewButton);

	}

	/**
	 * This method deals with the connection to Trello.
	 */
	@SuppressWarnings("deprecation")
	public void TrelloConnect() {
		trelloApi = new TrelloImpl("d9a050a2b06b9d83d847f5145d5c9a01",
				"92b59d9c284cecc282dbbc981c376919b95eac07e8a53cb2ae13926f371c0aa8");

	}

	/**
	 * This method retrieves content from a specified member Trello board, such as
	 * cards and members.
	 */
	public void TrelloContents() {
		member = trelloApi.getMemberBoards("saragirao");
		for (Board board : member) {
			this.board = board;
			cards = board.fetchCards();
			members = board.fetchMembers();
		}
		FetchCardsbyMember();
	}

	/**
	 * This method populates a Map (memberCards) with the member's username as key
	 * and the member's cards as entry.
	 */
	public void FetchCardsbyMember() {
		memberCards = new HashMap<String, List<Card>>();
		for (Member id : members) {
			memberCards.put(id.getUsername(), board.fetchMemberCards(id.getId()));
		}
	}

	/**
	 * This method deals with the GitHub connection. It requires an authentication
	 * token to do the connection, if this token is invalid an error message is
	 * displayed and the program is terminated.
	 */
	public void GitHubConnect() {
		String token = JOptionPane.showInputDialog("Please enter your GitHub authentication token.");
		GitHub github;
		try {
			github = new GitHubBuilder().withOAuthToken(token).build();
			repository = github.getRepository("gmmsl-iscte/ES-LETI-1Sem-2021-Grupo4");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Invalid token", "Warning", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @param textField the textField to update
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * This method reads a file from a given path.
	 * @param path The file's path.
	 * @param encoding The encoding.
	 * @return The file as a String.
	 * @throws IOException
	 */
	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}

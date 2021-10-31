package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import java.awt.Dimension;
import com.julienvey.trello.domain.*;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class SubFrame1 extends JFrame {
	List<TList> sprint;
	List<Card> cards;
	JList<String> list;
	JList<String> list_1;
	DefaultListModel<String> model;
	DefaultListModel<String> model1;
	DefaultListModel<String> model2;
	private JPanel contentPane;
	final int nMembers = 2;
	int costSprint;
	final int nSprints = 3;

	/**
	 * Create the frame.
	 */
	public SubFrame1(List<Card> cards) {
		this.cards = cards;
		model = new DefaultListModel<>();
		model1 = new DefaultListModel<String>();
		model2 = new DefaultListModel<String>();

		DevelopedProducts();
		SprintDuration();
		MeetingText();

		setResizable(false);
		setTitle("SPRINT Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 787, 294);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 30));
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Data in each SPRINT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));

		JPanel panel_6 = new JPanel();
		JPanel panel_7 = new JPanel();
		JPanel panel_8 = new JPanel();

		panel_3.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JTextArea txtrDevelopedProductBacklog = new JTextArea();
		txtrDevelopedProductBacklog.setLineWrap(true);
		txtrDevelopedProductBacklog.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrDevelopedProductBacklog.setRows(2);
		txtrDevelopedProductBacklog.setText("Developed Product Backlog items");
		txtrDevelopedProductBacklog.setWrapStyleWord(true);
		txtrDevelopedProductBacklog.setOpaque(false);
		txtrDevelopedProductBacklog.setFocusable(false);
		txtrDevelopedProductBacklog.setEditable(false);
		panel_6.add(txtrDevelopedProductBacklog, BorderLayout.NORTH);

		list = new JList<String>();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setModel(model);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(list);
		panel_6.add(scroll, BorderLayout.CENTER);

		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JTextArea txtrSprintBeginningAnd = new JTextArea();
		txtrSprintBeginningAnd.setText("SPRINT beginning and end date");
		txtrSprintBeginningAnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrSprintBeginningAnd.setWrapStyleWord(true);
		txtrSprintBeginningAnd.setLineWrap(true);
		txtrSprintBeginningAnd.setOpaque(false);
		txtrSprintBeginningAnd.setFocusable(false);
		txtrSprintBeginningAnd.setEditable(false);
		panel_7.add(txtrSprintBeginningAnd, BorderLayout.NORTH);

		list_1 = new JList<String>();
		list_1.setModel(model1);
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane scroll1 = new JScrollPane();
		scroll1.setViewportView(list_1);
		panel_7.add(scroll1, BorderLayout.CENTER);
		panel_3.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JTextArea txtrSprintPlanning = new JTextArea();
		txtrSprintPlanning.setText("SPRINT Planning, Review and Retrospective\u2019s resulting text");
		txtrSprintPlanning.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrSprintPlanning.setWrapStyleWord(true);
		txtrSprintPlanning.setOpaque(false);
		txtrSprintPlanning.setFocusable(false);
		txtrSprintPlanning.setLineWrap(true);
		txtrSprintPlanning.setEditable(false);
		panel_8.add(txtrSprintPlanning, BorderLayout.NORTH);

		JScrollPane scroll2 = new JScrollPane();
		panel_8.add(scroll2, BorderLayout.CENTER);

		JList<String> list_2 = new JList<String>();
		list_2.setModel(model2);
		list_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scroll2.setViewportView(list_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(415, 305, 382, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 30));
		panel_1.add(panel_4, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Global SPRINT data");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_11 = new JPanel();
		JPanel panel_12 = new JPanel();

		panel_5.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JTextArea txtrTotalHoursOf_1 = new JTextArea();
		txtrTotalHoursOf_1.setWrapStyleWord(true);
		txtrTotalHoursOf_1.setText("Total hours of work performed so far");
		txtrTotalHoursOf_1.setRows(2);
		txtrTotalHoursOf_1.setOpaque(false);
		txtrTotalHoursOf_1.setLineWrap(true);
		txtrTotalHoursOf_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrTotalHoursOf_1.setFocusable(false);
		txtrTotalHoursOf_1.setEditable(false);
		panel_11.add(txtrTotalHoursOf_1, BorderLayout.NORTH);

		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new GridLayout(2, 2, 0, 0));

		panel_5.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));

		JTextArea txtrHumanResourcesCost = new JTextArea();
		txtrHumanResourcesCost.setWrapStyleWord(true);
		txtrHumanResourcesCost.setText("Human resources cost throughout the project , so far ");
		txtrHumanResourcesCost.setRows(2);
		txtrHumanResourcesCost.setOpaque(false);
		txtrHumanResourcesCost.setLineWrap(true);
		txtrHumanResourcesCost.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrHumanResourcesCost.setFocusable(false);
		txtrHumanResourcesCost.setEditable(false);
		panel_12.add(txtrHumanResourcesCost, BorderLayout.NORTH);

		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(2, 2, 0, 0));

		JPanel panel_17 = new JPanel();
		panel_17.setBounds(10, 305, 382, 294);
		contentPane.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));

		JPanel panel_2_1 = new JPanel();
		panel_17.add(panel_2_1, BorderLayout.NORTH);
		panel_2_1.setPreferredSize(new Dimension(10, 30));

		JLabel lblNewLabel_2 = new JLabel("Data in each SPRINT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2_1.add(lblNewLabel_2);

		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(1, 2, 0, 0));
		JPanel panel_9 = new JPanel();
		panel_18.add(panel_9);

		panel_9.setLayout(new BorderLayout(0, 0));

		JTextArea txtrTotalHoursOf = new JTextArea();
		txtrTotalHoursOf.setText("Total hours of work planned vs performed");
		txtrTotalHoursOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrTotalHoursOf.setWrapStyleWord(true);
		txtrTotalHoursOf.setOpaque(false);
		txtrTotalHoursOf.setLineWrap(true);
		txtrTotalHoursOf.setFocusable(false);
		txtrTotalHoursOf.setEditable(false);
		panel_9.add(txtrTotalHoursOf, BorderLayout.NORTH);

		JPanel panel_15 = new JPanel();
		panel_9.add(panel_15, BorderLayout.CENTER);
		JPanel panel_10 = new JPanel();
		panel_18.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JTextArea txtrCostOfHuman = new JTextArea();
		txtrCostOfHuman.setText("Human resources cost");
		txtrCostOfHuman.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrCostOfHuman.setLineWrap(true);
		txtrCostOfHuman.setEditable(false);
		txtrCostOfHuman.setOpaque(false);
		txtrCostOfHuman.setFocusable(false);
		txtrCostOfHuman.setWrapStyleWord(true);
		panel_10.add(txtrCostOfHuman, BorderLayout.NORTH);

		JPanel panel_16 = new JPanel();
		panel_10.add(panel_16, BorderLayout.CENTER);


	}

	public void DevelopedProducts() {
		List<Card> devCards = new ArrayList<Card>();

		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("Developed")) {
					devCards.add(card);

				}

			}

		}
		for (Card card2 : devCards) {
			List<Label> devLabels = card2.getLabels();
			for (Label label : devLabels) {
				if (label.getName().equals("SPRINT1"))
					model.addElement("SPRINT 1: " + card2.getName());
				if (label.getName().equals("SPRINT2"))
					model.addElement("SPRINT 2: " + card2.getName());
				if (label.getName().equals("SPRINT3"))
					model.addElement("SPRINT 3: " + card2.getName());
			}
		}
	}

	public void MeetingText() {
		List<Card> sprint1 = new ArrayList<Card>();
		List<Card> sprint2 = new ArrayList<Card>();
		List<Card> sprint3 = new ArrayList<Card>();

		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("SPRINT1")) {
					sprint1.add(card);

				}

			}

		}
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("SPRINT2")) {
					sprint2.add(card);

				}

			}

		}
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("SPRINT3")) {
					sprint3.add(card);

				}

			}

		}
		for (Card card2 : sprint1) {
			List<Label> planLabels = card2.getLabels();
			for (Label label : planLabels) {
				if (label.getName().equals("Planning Meeting"))
					model2.addElement("SPRINT 1 Planning: " + card2.getDesc());
				if (label.getName().equals("Review Meeting"))
					model2.addElement("SPRINT 1 Review: " + card2.getDesc());
				if (label.getName().equals("Retrospective Meeting"))
					model2.addElement("SPRINT 1 Retrospective: " + card2.getDesc());
			}
		}
		for (Card card2 : sprint2) {
			List<Label> planLabels = card2.getLabels();
			for (Label label : planLabels) {
				if (label.getName().equals("Planning Meeting"))
					model2.addElement("SPRINT 2 Planning: " + card2.getDesc());
				if (label.getName().equals("Review Meeting"))
					model2.addElement("SPRINT 2 Review: " + card2.getDesc());
				if (label.getName().equals("Retrospective Meeting"))
					model2.addElement("SPRINT 2 Retrospective: " + card2.getDesc());
			}
		}
		for (Card card2 : sprint3) {
			List<Label> planLabels = card2.getLabels();
			for (Label label : planLabels) {
				if (label.getName().equals("Planning Meeting"))
					model2.addElement("SPRINT 3 Planning: " + card2.getDesc());
				if (label.getName().equals("Review Meeting"))
					model2.addElement("SPRINT 3 Review: " + card2.getDesc());
				if (label.getName().equals("Retrospective Meeting"))
					model2.addElement("SPRINT 3 Retrospective: " + card2.getDesc());
			}
		}
	}

	public void SprintDuration() {
		for (Card card : cards) {
			for (int j = 0; j < card.getLabels().size(); j++) {
				String label = card.getLabels().get(j).getName();
				if (card.getName().equals("SPRINT Duration")) {
					if (label.equals("SPRINT1"))
						model1.addElement("SPRINT 1:  " + card.getDesc());
					if (label.equals("SPRINT2"))
						model1.addElement("SPRINT 2:  " + card.getDesc());
					if (label.equals("SPRINT3"))
						model1.addElement("SPRINT 3:  " + card.getDesc());
				}
			}

		}

	}

	
}
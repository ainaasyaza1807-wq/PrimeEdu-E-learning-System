package module_4;

import controller.QuestionController;
import Entity.Question;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class QuestionManagementFrame extends JFrame {

    private JTextField txtQuestionId;
    private JTextField txtQuizId;

    private JTextArea txtQuestion;

    private JTextField txtOptionA;
    private JTextField txtOptionB;
    private JTextField txtOptionC;
    private JTextField txtOptionD;

    private JTextField txtCorrectAnswer;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnBack;

    private JTable tblQuestions;
    private DefaultTableModel model;

    public QuestionManagementFrame() {

        setTitle("Question Management");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("QUESTION MANAGEMENT");

        lblTitle.setBounds(
                380,
                20,
                250,
                30);

        panel.add(lblTitle);

        JLabel lblQuizId =
                new JLabel("Quiz ID:");

        lblQuizId.setBounds(
                50,
                70,
                120,
                25);

        panel.add(lblQuizId);

        txtQuizId =
                new JTextField();

        txtQuizId.setBounds(
                180,
                70,
                200,
                25);

        panel.add(txtQuizId);

        JLabel lblQuestionId =
                new JLabel("Question ID:");

        lblQuestionId.setBounds(
                50,
                110,
                120,
                25);

        panel.add(lblQuestionId);

        txtQuestionId =
                new JTextField();

        txtQuestionId.setBounds(
                180,
                110,
                200,
                25);

        panel.add(txtQuestionId);

        JLabel lblQuestion =
                new JLabel("Question:");

        lblQuestion.setBounds(
                50,
                150,
                120,
                25);

        panel.add(lblQuestion);

        txtQuestion =
                new JTextArea();

        JScrollPane questionScroll =
                new JScrollPane(txtQuestion);

        questionScroll.setBounds(
                180,
                150,
                300,
                70);

        panel.add(questionScroll);

        JLabel lblA =
                new JLabel("Option A:");

        lblA.setBounds(50,240,120,25);
        panel.add(lblA);

        txtOptionA = new JTextField();
        txtOptionA.setBounds(180,240,250,25);
        panel.add(txtOptionA);

        JLabel lblB =
                new JLabel("Option B:");

        lblB.setBounds(50,280,120,25);
        panel.add(lblB);

        txtOptionB = new JTextField();
        txtOptionB.setBounds(180,280,250,25);
        panel.add(txtOptionB);

        JLabel lblC =
                new JLabel("Option C:");

        lblC.setBounds(50,320,120,25);
        panel.add(lblC);

        txtOptionC = new JTextField();
        txtOptionC.setBounds(180,320,250,25);
        panel.add(txtOptionC);

        JLabel lblD =
                new JLabel("Option D:");

        lblD.setBounds(50,360,120,25);
        panel.add(lblD);

        txtOptionD = new JTextField();
        txtOptionD.setBounds(180,360,250,25);
        panel.add(txtOptionD);

        JLabel lblCorrect =
                new JLabel("Correct Answer:");

        lblCorrect.setBounds(
                50,
                400,
                120,
                25);

        panel.add(lblCorrect);

        txtCorrectAnswer =
                new JTextField();

        txtCorrectAnswer.setBounds(
                180,
                400,
                100,
                25);

        panel.add(txtCorrectAnswer);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnSearch = new JButton("Search");
        btnRefresh = new JButton("Refresh");
        btnBack = new JButton("Back");

        btnAdd.setBounds(550,70,120,30);
        btnUpdate.setBounds(680,70,120,30);

        btnDelete.setBounds(550,120,120,30);
        btnSearch.setBounds(680,120,120,30);

        btnRefresh.setBounds(550,170,120,30);
        btnBack.setBounds(680,170,120,30);

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnSearch);
        panel.add(btnRefresh);
        panel.add(btnBack);

        model = new DefaultTableModel();

        model.addColumn("Question ID");
        model.addColumn("Quiz ID");
        model.addColumn("Question");
        model.addColumn("Correct Answer");

        tblQuestions =
                new JTable(model);

        JScrollPane tableScroll =
                new JScrollPane(tblQuestions);

        tableScroll.setBounds(
                40,
                470,
                900,
                150);

        panel.add(tableScroll);

        add(panel);

        btnAdd.addActionListener(e -> addQuestion());
        btnUpdate.addActionListener(e -> updateQuestion());
        btnDelete.addActionListener(e -> deleteQuestion());
        btnSearch.addActionListener(e -> searchQuestion());

        btnRefresh.addActionListener(
                e -> loadQuestions());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void addQuestion() {

        QuestionController controller =
                new QuestionController();

        boolean success =
                controller.addQuestion(

                        txtQuizId.getText(),
                        txtQuestion.getText(),
                        txtOptionA.getText(),
                        txtOptionB.getText(),
                        txtOptionC.getText(),
                        txtOptionD.getText(),
                        txtCorrectAnswer.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Question Added");

            loadQuestions();
        }
    }

    private void updateQuestion() {

        QuestionController controller =
                new QuestionController();

        boolean success =
                controller.updateQuestion(

                        Integer.parseInt(
                                txtQuestionId.getText()),

                        txtQuestion.getText(),
                        txtOptionA.getText(),
                        txtOptionB.getText(),
                        txtOptionC.getText(),
                        txtOptionD.getText(),
                        txtCorrectAnswer.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Question Updated");

            loadQuestions();
        }
    }

    private void deleteQuestion() {

        QuestionController controller =
                new QuestionController();

        boolean success =
                controller.deleteQuestion(

                        Integer.parseInt(
                                txtQuestionId.getText()));

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Question Deleted");

            loadQuestions();
        }
    }

    private void searchQuestion() {

        QuestionController controller =
                new QuestionController();

        Question question =
                controller.searchQuestion(

                        Integer.parseInt(
                                txtQuestionId.getText()));

        if(question != null){

            txtQuizId.setText(
                    question.getQuizId());

            txtQuestion.setText(
                    question.getQuestionText());

            txtCorrectAnswer.setText(
                    question.getCorrectAnswer());
        }
    }

    private void loadQuestions() {

        model.setRowCount(0);

        QuestionController controller =
                new QuestionController();

        ArrayList<Question> list =
                controller.getQuestionsByQuiz(
                        txtQuizId.getText());

        for(Question question : list){

            model.addRow(new Object[]{

                    question.getQuestionId(),
                    question.getQuizId(),
                    question.getQuestionText(),
                    question.getCorrectAnswer()
            });
        }
    }
}
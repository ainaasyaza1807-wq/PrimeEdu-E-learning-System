package module_4;

import controller.QuizController;
import Entity.Quiz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class CreateQuizFrame extends JFrame {

    private JTextField txtQuizId;
    private JTextField txtTitle;
    private JTextField txtSubjectCode;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnQuestion;
    private JButton btnBack;

    private JTable tblQuiz;
    private DefaultTableModel model;

    public CreateQuizFrame() {

        setTitle("Quiz Management");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        loadQuizzes();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("QUIZ MANAGEMENT");

        lblTitle.setBounds(
                350,
                20,
                250,
                30);

        panel.add(lblTitle);

        JLabel lblQuizId =
                new JLabel("Quiz ID:");

        lblQuizId.setBounds(
                50,
                80,
                120,
                25);

        panel.add(lblQuizId);

        txtQuizId =
                new JTextField();

        txtQuizId.setBounds(
                180,
                80,
                220,
                25);

        panel.add(txtQuizId);

        JLabel lblQuizTitle =
                new JLabel("Quiz Title:");

        lblQuizTitle.setBounds(
                50,
                120,
                120,
                25);

        panel.add(lblQuizTitle);

        txtTitle =
                new JTextField();

        txtTitle.setBounds(
                180,
                120,
                220,
                25);

        panel.add(txtTitle);

        JLabel lblSubjectCode =
                new JLabel("Subject Code:");

        lblSubjectCode.setBounds(
                50,
                160,
                120,
                25);

        panel.add(lblSubjectCode);

        txtSubjectCode =
                new JTextField();

        txtSubjectCode.setBounds(
                180,
                160,
                220,
                25);

        panel.add(txtSubjectCode);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnSearch = new JButton("Search");
        btnRefresh = new JButton("Refresh");
        btnQuestion = new JButton("Manage Questions");
        btnBack = new JButton("Back");

        btnAdd.setBounds(500,80,120,30);
        btnUpdate.setBounds(630,80,120,30);

        btnDelete.setBounds(500,120,120,30);
        btnSearch.setBounds(630,120,120,30);

        btnRefresh.setBounds(500,160,120,30);
        btnQuestion.setBounds(630,160,180,30);

        btnBack.setBounds(500,200,120,30);

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnSearch);
        panel.add(btnRefresh);
        panel.add(btnQuestion);
        panel.add(btnBack);

        model = new DefaultTableModel();

        model.addColumn("Quiz ID");
        model.addColumn("Title");
        model.addColumn("Subject Code");

        tblQuiz =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblQuiz);

        scrollPane.setBounds(
                50,
                280,
                780,
                220);

        panel.add(scrollPane);

        add(panel);

        btnAdd.addActionListener(e -> addQuiz());
        btnUpdate.addActionListener(e -> updateQuiz());
        btnDelete.addActionListener(e -> deleteQuiz());
        btnSearch.addActionListener(e -> searchQuiz());
        btnRefresh.addActionListener(e -> loadQuizzes());

        btnQuestion.addActionListener(e -> {

            new QuestionManagementFrame();
        });

        btnBack.addActionListener(e -> dispose());
    }

    private void addQuiz() {

        QuizController controller =
                new QuizController();

        boolean success =
                controller.addQuiz(

                        txtQuizId.getText(),
                        txtTitle.getText(),
                        txtSubjectCode.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Quiz Added");

            loadQuizzes();
        }
    }

    private void updateQuiz() {

        QuizController controller =
                new QuizController();

        boolean success =
                controller.updateQuiz(

                        txtQuizId.getText(),
                        txtTitle.getText(),
                        txtSubjectCode.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Quiz Updated");

            loadQuizzes();
        }
    }

    private void deleteQuiz() {

        QuizController controller =
                new QuizController();

        boolean success =
                controller.deleteQuiz(
                        txtQuizId.getText());

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Quiz Deleted");

            loadQuizzes();
        }
    }

    private void searchQuiz() {

        QuizController controller =
                new QuizController();

        Quiz quiz =
                controller.searchQuiz(
                        txtQuizId.getText());

        if(quiz != null){

            txtTitle.setText(
                    quiz.getTitle());

            txtSubjectCode.setText(
                    quiz.getSubjectCode());

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Quiz Not Found");
        }
    }

    private void loadQuizzes() {

        model.setRowCount(0);

        QuizController controller =
                new QuizController();

        ArrayList<Quiz> list =
                controller.getAllQuizzes();

        for(Quiz quiz : list){

            model.addRow(new Object[]{

                    quiz.getQuizId(),
                    quiz.getTitle(),
                    quiz.getSubjectCode()
            });
        }
    }
}
package module_4;

import controller.QuestionController;
import controller.ResultController;
import Entity.Question;

import javax.swing.*;
import java.util.ArrayList;

public class TakeQuizFrame extends JFrame {

    private JTextField txtQuizId;

    private JTextArea txtQuestion;

    private JRadioButton rbA;
    private JRadioButton rbB;
    private JRadioButton rbC;
    private JRadioButton rbD;

    private ButtonGroup group;

    private JButton btnLoad;
    private JButton btnSubmit;
    private JButton btnBack;

    private ArrayList<Question> questions;

    private int currentIndex = 0;
    private int score = 0;

    // TEMP STUDENT
    private final int studentId = 1;

    public TakeQuizFrame() {

        setTitle("Take Quiz");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("TAKE QUIZ");

        lblTitle.setBounds(
                340,
                20,
                200,
                30);

        panel.add(lblTitle);

        JLabel lblQuizId =
                new JLabel("Quiz ID:");

        lblQuizId.setBounds(
                50,
                70,
                100,
                25);

        panel.add(lblQuizId);

        txtQuizId =
                new JTextField();

        txtQuizId.setBounds(
                150,
                70,
                200,
                25);

        panel.add(txtQuizId);

        btnLoad =
                new JButton("Load Quiz");

        btnLoad.setBounds(
                400,
                70,
                120,
                25);

        panel.add(btnLoad);

        txtQuestion =
                new JTextArea();

        txtQuestion.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(txtQuestion);

        scrollPane.setBounds(
                50,
                120,
                650,
                120);

        panel.add(scrollPane);

        rbA = new JRadioButton();
        rbB = new JRadioButton();
        rbC = new JRadioButton();
        rbD = new JRadioButton();

        group = new ButtonGroup();

        group.add(rbA);
        group.add(rbB);
        group.add(rbC);
        group.add(rbD);

        rbA.setBounds(80,270,500,25);
        rbB.setBounds(80,310,500,25);
        rbC.setBounds(80,350,500,25);
        rbD.setBounds(80,390,500,25);

        panel.add(rbA);
        panel.add(rbB);
        panel.add(rbC);
        panel.add(rbD);

        btnSubmit =
                new JButton("Next Question");

        btnBack =
                new JButton("Back");

        btnSubmit.setBounds(
                220,
                470,
                150,
                35);

        btnBack.setBounds(
                420,
                470,
                120,
                35);

        panel.add(btnSubmit);
        panel.add(btnBack);

        add(panel);

        btnLoad.addActionListener(
                e -> loadQuiz());

        btnSubmit.addActionListener(
                e -> nextQuestion());

        btnBack.addActionListener(
                e -> dispose());
    }

    private void loadQuiz() {

        QuestionController controller =
                new QuestionController();

        questions =
                controller.getQuestionsByQuiz(
                        txtQuizId.getText());

        currentIndex = 0;
        score = 0;

        displayQuestion();
    }

    private void displayQuestion() {

        if(questions == null ||
           questions.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No Questions Found");

            return;
        }

        Question q =
                questions.get(currentIndex);

        txtQuestion.setText(
                q.getQuestionText());

        rbA.setText(
                "A. " + q.getOptionA());

        rbB.setText(
                "B. " + q.getOptionB());

        rbC.setText(
                "C. " + q.getOptionC());

        rbD.setText(
                "D. " + q.getOptionD());

        group.clearSelection();
    }

    private void nextQuestion() {

        if(questions == null ||
           questions.isEmpty()) {

            return;
        }

        Question q =
                questions.get(currentIndex);

        String answer = "";

        if(rbA.isSelected()) {

            answer = "A";

        } else if(rbB.isSelected()) {

            answer = "B";

        } else if(rbC.isSelected()) {

            answer = "C";

        } else if(rbD.isSelected()) {

            answer = "D";
        }

        if(answer.equalsIgnoreCase(
                q.getCorrectAnswer())) {

            score++;
        }

        currentIndex++;

        if(currentIndex < questions.size()) {

            displayQuestion();

        } else {

            saveResult();
        }
    }

    private void saveResult() {

        int finalScore =
                (score * 100)
                / questions.size();

        ResultController controller =
                new ResultController();

        controller.saveResult(

                txtQuizId.getText(),
                studentId,
                finalScore
        );

        JOptionPane.showMessageDialog(

                this,

                "Quiz Completed\n"
                + "Score: "
                + finalScore
                + "%"
        );

        dispose();
    }
}
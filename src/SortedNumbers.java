import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

class Window extends JFrame {
    Window() {
        super("SortedNumbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //остановка программы при закрытии окна
        setLocation(450, 100); //передаем координаты точки, в которых появится при открытии окно программы
        setSize(400, 200); //задаем размер окна
        setResizable(false); //запретили изменение размеров окна пользователем

        JTextField textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.LEFT);
        getContentPane().add(textField, BorderLayout.NORTH);

        textField.setFocusable(true);

        JTextField textField1 = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.LEFT);
        getContentPane().add(textField1, BorderLayout.SOUTH);


        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String[] sourceValues = text.split(" ");
                List<Integer> result = new ArrayList<Integer>();
                for (String value : sourceValues) {
                    result.add(Integer.valueOf(value));
                }
                Collections.sort(result);
                StringBuilder b = new StringBuilder();
                for (Integer i : result) {
                    b.append(i).append(" ");
                }
                textField1.setText(b.toString());
            }
        });


        JTextField text = new JTextField("Введите в поле 10 чисел через пробел и нажмите Enter");
        getContentPane().add(text, BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();  //создаем панель меню
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem clear = new JMenuItem("Очистить"); //создаем в меню пункт очистки поля ввода
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
                textField1.setText(null);
            }
        });
        fileMenu.add(clear); //добавляем очистку в список меню Файл


        JMenuItem exit = new JMenuItem("Выйти из программы"); //создаем в меню пункт выхода из программы
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        fileMenu.add(exit); //добавляем выход в список меню Файл

        menuBar.add(fileMenu); // добавляем список меню Файл в панель Меню
        setJMenuBar(menuBar); //передаем программе созданную панель Меню


    }
}


public class SortedNumbers {

    public static void main(String[] args) {
        JFrame frame = new Window();
        frame.setVisible(true); //отображаем окно на экране


    }

}


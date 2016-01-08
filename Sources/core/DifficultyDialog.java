package Sources.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Neonkitza on 1/8/2016.
 */
public class DifficultyDialog extends JDialog {


    public DifficultyDialog()
    {
        setTitle("Difficulty selection");
        setSize(600, 600);
        setLocationRelativeTo(Frame.getInstance());
        setVisible(true);
        setAlwaysOnTop(true);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton easyb = new JButton("Easy");
        JButton mediumb = new JButton("Medium");
        JButton hardb = new JButton("Hard");

        easyb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.getInstance().getBot().setDif(Difficulty.EASY);
                dispose();
            }
        });

        mediumb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.getInstance().getBot().setDif(Difficulty.MEDIUM);
                dispose();
            }
        });

        hardb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.getInstance().getBot().setDif(Difficulty.HARD);
                dispose();
            }
        });

        panel.add(easyb); panel.add(mediumb); panel.add(hardb);

        setContentPane(panel);


    }
}

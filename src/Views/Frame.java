package Views;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame() {
    	super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        Insets inset = this.getInsets();
        setPreferredSize(new Dimension(500+inset.left+inset.right,700+inset.top+inset.bottom));
        pack();
    }
}

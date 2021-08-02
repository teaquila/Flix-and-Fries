package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }

}

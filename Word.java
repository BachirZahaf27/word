/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Word {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        ///////
        JFrame frame =new JFrame();
        JTable table =new JTable();
        
        Object[] colums ={"Path"};
        DefaultTableModel model = new   DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        
        table.setBackground(Color.cyan);
        table.setForeground(Color.white);
        Font font =new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        
        JTextField txt_search=new JTextField();

        
        JButton Search =new JButton("search");
        
        txt_search.setBounds(20,220,100,25);

        
        Search.setBounds(150, 220,100, 25 );
        
        JScrollPane pane =new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        frame.add(txt_search);
        
        frame.add(Search);
        
        Object[] row = new Object[4];
        //search
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                row[0]=txt_search.getText();

                model.addRow(row);
            }
        });
        
        
        
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /////
        
        
        
        
        
        
        
        
        
        
        
    }
    
}

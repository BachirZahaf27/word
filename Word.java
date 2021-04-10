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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import static word.IndexFiles.indexDocs;



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
        
        Object[] row = new Object[1];
        //Search for the word
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                String word=txt_search.getText();// this to put the word that we are searching for into a string so we can put it on the function SearchFiles.java
                //NOW HERE WE HAVE TO CALL THE FUNCTIONS IndexFiles.JAVA 
                //IndexFiles index=new IndexFiles();
                
     /// BECAUSE I DONT KNOW HOW TO CALL THE FUNCTION INDEXFILES I JUST COPY THE CONTENT OF IT     
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    String indexPath = "C:\\Users\\user\\Desktop\\la mémoire\\Lucene-Tutorials-master\\index";
    String docsPath = "C:\\Users\\user\\Desktop\\la mémoire\\Lucene-Tutorials-master\\test data";
    boolean create = true;

    final Path docDir = Paths.get(docsPath);
    if (!Files.isReadable(docDir)) {
      System.out.println("Document directory '" +docDir.toAbsolutePath()+ "' does not exist or is not readable, please check the path");
      System.exit(1);
    }
    
    Date start = new Date();
    try {
      System.out.println("Indexing to directory '" + indexPath + "'...");

      Directory dir = FSDirectory.open(Paths.get(indexPath));
      Analyzer analyzer = new StandardAnalyzer();
      IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

      if (create) {
        // Create a new index in the directory, removing any
        // previously indexed documents:
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
     } else {
        // Add new documents to an existing index:
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
      }

      // Optional: for better indexing performance, if you
      // are indexing many documents, increase the RAM
     // buffer.  But if you do this, increase the max heap
      // size to the JVM (eg add -Xmx512m or -Xmx1g):
      //
      // iwc.setRAMBufferSizeMB(256.0);

      IndexWriter writer = new IndexWriter(dir, iwc);
      indexDocs(writer, docDir);

      // NOTE: if you want to maximize search performance,
      // you can optionally call forceMerge here.  This can be
      // a terribly costly operation, so generally it's only
      // worth it when your index is relatively static (ie
      // you're done adding documents to it):
      //
      // writer.forceMerge(1);

      writer.close();

      Date end = new Date();
      System.out.println(end.getTime() - start.getTime() + " total milliseconds");

     } catch (IOException ae) {
      System.out.println(" caught a " + e.getClass() +
       "\n with message: " + ae.getMessage());
    }
    //////////////////////////////////////////////////////////////////////////////            
                
                
                
                
                
                //NOW HERE WE HAVE TO CALL THE FUNCTIONS SearchFiles.JAVA
                //SearchFiles search=SearchFiles(String word);                                 // and we have to put the varible tha we are searching for
                //row[0]=search.getText();// and now we can put the result in the table

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

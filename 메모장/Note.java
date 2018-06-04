import java.awt.*;  
import javax.swing.*;  
import javax.swing.filechooser.*;  
import javax.swing.text.StyledEditorKit;  
import java.awt.event.*;  
import java.io.*;  
  
public class Note extends JFrame  
{  
 // ���� ����  
 JTextArea text;  
 Container pane;  
 JMenuBar nb = new JMenuBar();  
 JMenu file, help;  
 JMenuItem new1,save1,save2,close1,info1,help1;  
 JFileChooser open = new JFileChooser();//���� �� ���丮 ���� ������Ʈ ����  
   
   
 public Note()  
 {  
  super("MemoNote"); // �θ�Ŭ���� ������ ȣ��  
  pane=getContentPane(); //JFrame �������� ���� ������ ���� ����  
  pane.setLayout(new BorderLayout()); //JFrame ����  
  setJMenuBar(nb); // �޴��� ����  
   
  // �޴� �� �޴� ������ ����  
  file = new JMenu("����(F)");  
  help = new JMenu("����(I)");  
    
  // �����ȣ ����  
  file.setMnemonic('F');  
  help.setMnemonic('I');  
    
  //���� �޴� ���� ����  
  new1 = new JMenuItem("������");  
  save1 = new JMenuItem("����");
  save2 = new JMenuItem("�ٸ��̸����� ����");
  close1 = new JMenuItem("�ݱ�");  
  
  // �޴� ����Ű�� ���� ����  
    new1.setAccelerator(KeyStroke.getKeyStroke('N',Event.CTRL_MASK));  // Ctrl + N  
    save1.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK)); // Ctrl + S
    save2.setAccelerator(KeyStroke.getKeyStroke('A',Event.CTRL_MASK)); //Ctrl + A
    close1.setAccelerator(KeyStroke.getKeyStroke('Q',Event.CTRL_MASK)); // Ctrl + Q  
  
  //���� �޴� ����  
  info1 = new JMenuItem("����");  
  info1.setAccelerator(KeyStroke.getKeyStroke('R',Event.CTRL_MASK)); // Ctrl + R  
  
  // �޴��� ���� 
  file.add(new1);   
  file.add(save1);
  file.add(save2);
  file.add(close1);  
  help.add(info1);  
    
  // �޴� �ϼ�  
  nb.add(file);  
  nb.add(help);  
   
  // �޴����� ������ Ŭ�������� �̺�Ʈ ó��  
  new1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    text.setText(""); // text������ ��� �����  
   }  
  });  
 
   //�޴����� ���� Ŭ�������� �̺�Ʈ ó��  
  save1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    int re = open.showSaveDialog(Note.this);  
    if (re==JFileChooser.APPROVE_OPTION) // �������� ���̾�α׸� ����  
    {  
     File file_open = open.getSelectedFile(); // ������ ���ϸ��� �����´�  
   
     try  
     {  
     PrintWriter pw   = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); 
     // PrintWriter��ü�� �����ؼ�  
     pw.write(text.getText()); // ȭ���� ������ ���Ͽ� ����  
     pw.close();  
     }  
       
     catch(FileNotFoundException ie2)  
        {}  
     catch(IOException ie)  
        {}  
    }  
   }  
  });  
  //�޴����� �ٸ��̸����� ������ Ŭ���������� �̺�Ʈ ó��
  save2.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    int re = open.showSaveDialog(Note.this);  
    if (re==JFileChooser.APPROVE_OPTION) // �������� ���̾�α׸� ����  
    {  
     File file_open = open.getSelectedFile(); // ������ ���ϸ��� �����´�  
   
     try  
     {  
     PrintWriter pw   = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); 
     // PrintWriter��ü�� �����ؼ�  
     pw.write(text.getText()); // ȭ���� ������ ���Ͽ� ����  
     pw.close();  
     }  
       
     catch(FileNotFoundException ie2)  
        {}  
     catch(IOException ie)  
        {}  
    }  
   }  
  });  
   
  //�޴����� �ݱ⸦ Ŭ�������� �̺�Ʈ ó��  
  close1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    dispose(); // â�� �ݰ�   
    System.exit(0); // �����Ѵ�  
   }  
  });  
   
  // �޴����� ������ Ŭ�������� �̺�Ʈ ó��  
  info1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
 // ������ �����ִ� ���̾�α׸� ����  
   JOptionPane.showMessageDialog(pane , "�������� �޸��� ���α׷�^^");  
   }  
  });   
  text = new JTextArea();  
   
  // ȭ�鿡 ������ text���� ���� ����  
  text.setCaretColor(Color.black);   
  text.setSelectedTextColor(Color.white);  
  text.setSelectionColor(Color.blue);  
  text.setBackground(Color.white);  
   
  pane.add(new JScrollPane(text));  
  
 }  
   
 public static void main(String[] args)  
 {  
  Note note = new Note(); // ��ü����  
  note.setSize(500,500); // ������ ����  
  note.setVisible(true); // ȭ�鿡 ���̰� ��  
 }  
}  
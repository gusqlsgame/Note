import java.awt.*;  
import javax.swing.*;  
import javax.swing.filechooser.*;  
import javax.swing.text.StyledEditorKit;  
import java.awt.event.*;  
import java.io.*;  
  
public class Note extends JFrame  
{  
 // 변수 선언  
 JTextArea text;  
 Container pane;  
 JMenuBar nb = new JMenuBar();  
 JMenu file, help;  
 JMenuItem new1,save1,save2,close1,info1,help1;  
 JFileChooser open = new JFileChooser();//파일 및 디렉토리 선택 컴포넌트 선언  
   
   
 public Note()  
 {  
  super("MemoNote"); // 부모클래스 생성자 호출  
  pane=getContentPane(); //JFrame 디자인을 위한 컨텐츠 영역 선언  
  pane.setLayout(new BorderLayout()); //JFrame 정렬  
  setJMenuBar(nb); // 메뉴바 붙임  
   
  // 메뉴 및 메뉴 아이템 생성  
  file = new JMenu("파일(F)");  
  help = new JMenu("정보(I)");  
    
  // 단축기호 설정  
  file.setMnemonic('F');  
  help.setMnemonic('I');  
    
  //파일 메뉴 내용 생성  
  new1 = new JMenuItem("새파일");  
  save1 = new JMenuItem("저장");
  save2 = new JMenuItem("다른이름으로 저장");
  close1 = new JMenuItem("닫기");  
  
  // 메뉴 단축키를 위한 셋팅  
    new1.setAccelerator(KeyStroke.getKeyStroke('N',Event.CTRL_MASK));  // Ctrl + N  
    save1.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK)); // Ctrl + S
    save2.setAccelerator(KeyStroke.getKeyStroke('A',Event.CTRL_MASK)); //Ctrl + A
    close1.setAccelerator(KeyStroke.getKeyStroke('Q',Event.CTRL_MASK)); // Ctrl + Q  
  
  //정보 메뉴 생성  
  info1 = new JMenuItem("정보");  
  info1.setAccelerator(KeyStroke.getKeyStroke('R',Event.CTRL_MASK)); // Ctrl + R  
  
  // 메뉴바 내용 
  file.add(new1);   
  file.add(save1);
  file.add(save2);
  file.add(close1);  
  help.add(info1);  
    
  // 메뉴 완성  
  nb.add(file);  
  nb.add(help);  
   
  // 메뉴에서 새파일 클릭했을때 이벤트 처리  
  new1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    text.setText(""); // text내용을 모두 지운다  
   }  
  });  
 
   //메뉴에서 저장 클릭했을때 이벤트 처리  
  save1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    int re = open.showSaveDialog(Note.this);  
    if (re==JFileChooser.APPROVE_OPTION) // 파일저장 다이얼로그를 띄운다  
    {  
     File file_open = open.getSelectedFile(); // 저장할 파일명을 가져온다  
   
     try  
     {  
     PrintWriter pw   = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); 
     // PrintWriter객체를 생성해서  
     pw.write(text.getText()); // 화면의 내용을 파일에 쓴다  
     pw.close();  
     }  
       
     catch(FileNotFoundException ie2)  
        {}  
     catch(IOException ie)  
        {}  
    }  
   }  
  });  
  //메뉴에서 다른이름으로 저장을 클릭했을때의 이벤트 처리
  save2.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    int re = open.showSaveDialog(Note.this);  
    if (re==JFileChooser.APPROVE_OPTION) // 파일저장 다이얼로그를 띄운다  
    {  
     File file_open = open.getSelectedFile(); // 저장할 파일명을 가져온다  
   
     try  
     {  
     PrintWriter pw   = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); 
     // PrintWriter객체를 생성해서  
     pw.write(text.getText()); // 화면의 내용을 파일에 쓴다  
     pw.close();  
     }  
       
     catch(FileNotFoundException ie2)  
        {}  
     catch(IOException ie)  
        {}  
    }  
   }  
  });  
   
  //메뉴에서 닫기를 클릭했을때 이벤트 처리  
  close1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
    dispose(); // 창을 닫고   
    System.exit(0); // 종료한다  
   }  
  });  
   
  // 메뉴에서 정보를 클릭했을때 이벤트 처리  
  info1.addActionListener(new ActionListener()  
  {  
   public void actionPerformed(ActionEvent e)  
   {  
 // 정보를 보여주는 다이얼로그를 띄운다  
   JOptionPane.showMessageDialog(pane , "현빈이의 메모장 프로그램^^");  
   }  
  });   
  text = new JTextArea();  
   
  // 화면에 보여질 text들의 색상 지정  
  text.setCaretColor(Color.black);   
  text.setSelectedTextColor(Color.white);  
  text.setSelectionColor(Color.blue);  
  text.setBackground(Color.white);  
   
  pane.add(new JScrollPane(text));  
  
 }  
   
 public static void main(String[] args)  
 {  
  Note note = new Note(); // 객체생성  
  note.setSize(500,500); // 사이즈 지정  
  note.setVisible(true); // 화면에 보이게 함  
 }  
}  
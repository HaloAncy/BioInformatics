package guiD;

import FastA.FastA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JPanel;

public class jframegg extends JFrame{

    //作为按钮容器
    private JPanel buttonPanel;

    public jframegg(){

        //设置容器
        Container container=getContentPane();
        //设置网格布局(行数，列数，水平间距，纵向间距)
        container.setLayout(new GridLayout(2,2,10,10));

        //以设置网格布局初始化面板
        GridLayout grid=new GridLayout(2,1,10,10);

        //设置面板(buttonPanel与Panel两种)
        buttonPanel=new JPanel();
        buttonPanel.setLayout(grid);
        container.add(buttonPanel);
        //颜色
        //buttonPanel.setBackground(Color.RED);

        JPanel Panel2=new JPanel();
        Panel2.setLayout(grid);
        container.add(Panel2);

        JPanel Panel3=new JPanel();
        Panel3.setLayout(grid);
        container.add(Panel3);

        JPanel Panel4=new JPanel();
        Panel4.setLayout(new GridLayout(2,2,10,10));
        container.add(Panel4);

        //空布局(用于占位，布局中不能存在空白块)
        JPanel Blank1=new JPanel();
        JPanel Blank2=new JPanel();
        JPanel Blank3=new JPanel();
        Panel4.add(Blank1);
        Panel4.add(Blank2);
        Panel4.add(Blank3);

        //退出按钮
        JButton buttonexit =new JButton("Exit");
        buttonexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Panel4.add(buttonexit);

        //super("Fasta");
        JButton button1 =new JButton("Fasta");
        buttonPanel.add(button1);
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFrame frame=new JFrame("FASTA");
                frame.setSize(800,1000);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setLayout(null);
                frame.setResizable(false);

                //路径文本框(单行)
                JTextField path = new JTextField();
                path.setText("src/sequence.txt");
                path.setBounds(10, 10, 665, 30);
                //设置不可键盘输入
                path.setEditable(false);
                frame.add(path);

                Font fn = new Font("宋体", Font.BOLD, 20);
                //输出文本域(多行)
                /*查找表*/
                JTextArea text1 = new JTextArea();
                //创建滚动条面板,并添加文本域对象
                JScrollPane sp1=new JScrollPane(text1);
                sp1.setBounds(10,80,780,350);
                text1.setFont(fn);
                frame.add(sp1);

                /*位移向量表*/
                JTextArea text2 = new JTextArea();
                JScrollPane sp2=new JScrollPane(text2);
                sp2.setBounds(10,435,780,350);
                text2.setFont(fn);
                frame.add(sp2);

                /*最大匹配位移*/
                JTextArea text3 = new JTextArea();
                JScrollPane sp3=new JScrollPane(text3);
                sp3.setBounds(10,790,780,150);
                text3.setFont(fn);
                frame.add(sp3);

                //选择文件按钮
                JButton button = new JButton("选择文件");
                button.setBounds(685, 10, 100, 30);
                frame.add(button);
                //选择源码文件
                //N:\略略略略\生物信息学\实验\FASTA\sequence.txt
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser chooser = new JFileChooser(path.getText());
                        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        chooser.showDialog(path,"确定");
                        File f = chooser.getSelectedFile();
                        if(f!=null) {
                            path.setText(f.getPath());
                            FastA.gainFile(f);//传入算法获取S、T
                        }
                    }
                });

                JTextField ktext = new JTextField();
                ktext.setText("请输入k值。");
                ktext.setBounds(595, 45, 80, 30);
                frame.add(ktext);
                //button.setFocusable(true);//使button获得焦点
                //
                ktext.addFocusListener(new FocusAdapter()
                {
                    public void focusGained(FocusEvent e){
                        ktext.setText("");
                    }
                    public void focusLost(FocusEvent e){
                        //需判断是否输入(文本框是否为空)-否则直接输入...
                        if("".equals(ktext.getText().trim())) {
                            ktext.setText("请输入k值。");
                        }//trim()去掉首尾空格
                    }
                });

                //执行算法按钮(同时需要获取k值)
                JButton button2 = new JButton("确定");
                button2.setBounds(685, 45, 100, 30);
                frame.add(button2);
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String strk = ktext.getText();

                        FastA.gainknum(strk);

                        FastA ipa=new FastA();
                        ipa.IPA(FastA.ops(),FastA.opt(),FastA.opk());
                        text1.setText(FastA.printS());
                        text2.setText(FastA.printT());
                        text3.setText(FastA.printD());
                    }
                });

            }
        });

        //空布局时按钮设置
        /*button.setBackground(Color.red);
        button.setPreferredSize(new Dimension(30,30));
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setBounds(10, 10, 100, 50);*/

        JButton button2 =new JButton("Dot Matrix");
        buttonPanel.add(button2);
        JButton button3 =new JButton("Dp");
        Panel3.add(button3);
        JButton button4 =new JButton("M");
        Panel3.add(button4);

        Image img = new ImageIcon("head.png").getImage() ;
        setIconImage(img);

        //将所有组件添加到内容窗格
        //add(new NotHelloWorldComponent());
        //使用组件的首选大小
        pack();
    }
}

/*
class NotHelloWorldComponent extends JComponent {

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    //创建一个能够进行绘制的组件
    //paintComponent方法有一个Graphics类型的参数，该参数保存着用于绘制图像和文本的设置
    public void paintComponent(Graphics g) {
        //显示文本
        g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
    }

    //组件要告诉用户它应该多大，覆盖getPreferredSize方法
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}


class Panelcreat extends JPanel{

    //以设置网格布局初始化面板
    private GridLayout grid=new GridLayout(2,1,10,10);

    public Panelcreat(){
        setLayout(grid);
    }
}
*/

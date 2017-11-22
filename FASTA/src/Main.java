import guiD.*;

import FastA.FastA;
import FastaInput.FastaInput;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {

        //所有Swing组件都必须↓
        //事件分派线程：将鼠标点击和按键控制转移到用户接口组件
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new jframegg();
            //框架属性
            frame.setTitle("Bioinformatics");
            //定义用户关闭这个框架时的响应动作
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //显示框架
            frame.setVisible(true);
            //设置窗口大小不可改变
            frame.setResizable(false);
            //框架大小
            frame.setSize(400,300);
            //居中
            frame.setLocationRelativeTo(null);
        });

        //项目路径
        String path_ = System.getProperty("user.dir");
        System.out.print("文件路径：");
        System.out.println(path_);

        //默认字符大写
        String Sx="HARFYAAQIVL";
        String Tx="VDMAAQIA";

        /*int k=1;
        FastA.IPA(Sx,Tx,k);
        FastA.printS();
        FastA.printT();
        FastA.printD();*/

        /*//Fasta格式输入
        // N:\略略略略\生物信息学\实验\FASTA\input.txt
        Scanner in=new Scanner(System.in);
        String path=in.nextLine();
        File file=new File(path);
        FastaInput inp=new FastaInput();
        inp.Input(file);
        System.out.println(inp.Flprint());
        System.out.println(inp.seqprint());*/
    }
}

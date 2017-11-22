import Dot_Matrix.DM;

public class Main {

    public static void main(String[] args) {
        String X="GCGATGCATTGAGTATCATA";
        String Y="GCCATGCACAGAACATCATA";

        int winsize=5; //窗口大小
        int step=1; //步长
        int stringency=3; //正确度

        DM.Got(X,Y,winsize,step,stringency);
        DM.Print();
        DM.Longest();
    }
}

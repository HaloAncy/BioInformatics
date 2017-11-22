package FastA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FastA {

    private static String Ss;
    private static String Tt;
    private static int Kk;

    private static class S{
        String k_s;
        ArrayList<Integer> loc;
        //int[] loc;
    }

    private static class T{
        String k_t;
        ArrayList<Integer> disp;
    }

    //保持静态
    private static S[] mS;
    private static T[] mT;
    private static ArrayList<Integer> mD=new ArrayList<Integer>();
    //标志变量
    private static int Snum=0;

    //static只能调用一次
    public void IPA(String s,String t,int k){
        int slen=s.length();
        int tlen=t.length();

        mS=new S[slen];
        mT=new T[tlen];

        //初始化
        Snum=0;
        for (int i=0;i<slen;i++){
            mS[i]=new S();
            mS[i].loc=new ArrayList<Integer>();
            //mS[i].loc=new int[slen-k+1];
        }
        for (int i=0;i<tlen;i++){
            mT[i]=new T();
            mT[i].disp=new ArrayList<Integer>();
            //mT[i].disp=new int[tlen-k+1];
        }

        //创建查找表——以串为单位
        for (int i=0;i<slen-k+1;i++){
            String s_str=s.substring(i,i+k);
            int index=Snum;
            for (int j=0;j<Snum;j++){
                if (mS[j].k_s.equals(s_str)){
                    index=j;
                    mS[j].loc.add(i);
                    break;
                }
            }
            if (index==Snum){
                mS[Snum].k_s=s_str;
                mS[Snum].loc.add(i);
                Snum++;
            }
        }

        //创建位移向量表
        for (int i=0;i<tlen-k+1;i++){
            String t_str=t.substring(i,i+k);
            mT[i].k_t=t_str;
            for (int j=0;j<Snum;j++){
                if (mS[j].k_s.equals(t_str)){
                    for (int x=0;x<mS[j].loc.size();x++){
                        int a=mS[j].loc.get(x)-i;
                        mT[i].disp.add(a);
                        mD.add(a);
                    }
                }
            }
        }
    }

    //打印
    public static String printS(){
        String pS="";
        for (int i=0;i<Snum;i++){
            pS+=(mS[i].k_s+":");
            for (int j=0;j<mS[i].loc.size();j++){
                pS+=(mS[i].loc.get(j)+" ");
            }
            pS+=('\n');
        }
        //System.out.println();
        return pS;
    }

    public static String printT(){
        String pT="";
        for (int i=0;i<mT.length;i++){
            pT+=(mT[i].k_t+":");
            for (int j=0;j<mT[i].disp.size();j++){
                pT+=(mT[i].disp.get(j)+" ");
            }
            pT+=('\n');
        }
        //System.out.println();
        return pT;
    }

    public static String printD(){
        String pD="";
        Collections.sort(mD);
        int min=mD.get(0);
        int max=mD.get(mD.size()-1);
        int[][] mD2=new int[max-min+1][2];
        for (int i=0;i<max-min+1;i++){
            mD2[i][0]=min+i;
            mD2[i][1]=0;
        }
        for (int i=0;i<mD.size();i++){
            mD2[mD.get(i)-min][1]++;
        }
        for (int i=0;i<mD2.length;i++){
            pD+=String.format("%5d",mD2[i][0]);
        }
        pD+=('\n');
        for (int i=0;i<mD2.length;i++){
            pD+=String.format("%5d",mD2[i][1]);
        }
        return pD;
    }

    //自ui传递文件及k值
    public static void gainFile(File file){

        StringBuilder result=new StringBuilder();
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String s=null;
            s=br.readLine();
            result.append(s);
            Ss=result.toString();
            result.setLength(0);//清空
            s=br.readLine();
            result.append(s);
            Tt=result.toString();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        /*System.out.println(Ss);
        System.out.println(Tt);*/
    }

    public static void gainknum(String strk){
        try {
            Kk = Integer.parseInt(strk);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    //向外传递类中定量
    public static String ops(){
        return Ss;
    }

    public static String opt(){
        return Tt;
    }

    public static int opk(){
        return Kk;
    }
}
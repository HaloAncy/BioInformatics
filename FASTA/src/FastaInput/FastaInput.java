package FastaInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FastaInput {

    private static String Firstline;
    private static String seq;

    public static void Input(File file){

        StringBuilder result=new StringBuilder();

        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String s=null;
            if (br.read()!='>'){
                System.out.println("文件有误。");
            }else{
                boolean sign=true;
                while ((s=br.readLine())!=null){
                    if(sign){
                        Firstline=s;
                        sign=false;
                        continue;
                    }
                    result.append(s);
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("路径有误。");
        }

        seq=result.toString();
    }

    public static String Flprint(){
        return Firstline;
    }

    //上面有错误情况 需判断null
    public static String seqprint(){
        return seq;
    }
}



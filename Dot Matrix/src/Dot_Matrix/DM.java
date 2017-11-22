package Dot_Matrix;

public class DM {

    private static int xl;
    private static int yl;
    private static String x_;
    private static String y_;

    public static int[][] spot=new int[100][100];

    public static void Got(String x,String y,int w,int p,int s){

        x_=x;
        y_=y;
        xl=x.length();
        yl=y.length();
        //int l=(xl>yl)?yl:xl; //min

        for (int i=0;i<xl-w+1;i+=p){
            String xx=x.substring(i,i+w);
            for (int j=0;j<yl-w+1;j+=p){
                String yy=y.substring(j,j+w);
                int sum=0; //匹配点数
                for (int k=0;k<w;k++){
                    if (xx.charAt(k)==yy.charAt(k)){
                        sum++;
                    }
                }
                if (sum>=s){
                    spot[i+w/2][yl-j-w/2-1]=1;
                }
            }
        }
    }

    public static void Print(){
        for (int j=0;j<yl;j++){
            System.out.print(y_.charAt(yl-j-1));
            for (int i=0;i<xl;i++){
                if (spot[i][j]==1){
                    System.out.print(" # ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.print(" ");
        for (int i=0;i<xl;i++){
            System.out.print(" ");
            System.out.print(x_.charAt(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void Longest(){
        int[][] start=new int[2][10];
        int[][] end=new int[2][10];
        int length=0;
        int num=0;
        boolean sign=false;
        for (int k=xl-1;k>=0;k--){
            for (int j=yl-1,i=k;j>=0 && i<xl;j--,i++){
                //System.out.println("------"+i+"--"+j);
                if (spot[i][j]==1) {
                    if (!sign){
                        sign=true;
                        length++;
                        start[0][0]=i;
                        start[1][0]=j;
                        //System.out.println("------"+i+"--"+j);
                    }else {
                        length++;
                        //System.out.println(length);
                    }
                }else{
                    if (length!=0){
                        sign=false;
                        end[0][0]=i-1;
                        end[1][0]=j+1;

                        if (end[0][0]-start[0][0]>end[0][1]-start[0][1]){
                            start[0][1]=start[0][0];
                            start[1][1]=start[1][0];
                            end[0][1]=end[0][0];
                            end[1][1]=end[1][0];
                            num=1;
                        }else if (end[0][0]-start[0][0]==end[0][1]-start[0][1]){
                            num++;
                            start[0][num]=start[0][0];
                            start[1][num]=start[1][0];
                            end[0][num]=end[0][0];
                            end[1][num]=end[1][0];
                            //System.out.println("+++++"+(i-1)+"++"+(j+1));
                        }
                        //System.out.println("^^"+num);
                        length=0;
                    }
                }
            }
        }
        System.out.println("最长匹配：");
        for (int i=0;i<num;i++){
            System.out.println("起点：("+start[0][num]+","+start[1][num]+")");
            System.out.println("终点：("+end[0][num]+","+end[1][num]+")");
        }
    }
}

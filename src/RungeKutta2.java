import java.io.*;
public class RungeKutta2 {
    public double f(double x,double y)
    {
        return Math.log10(x+y);
    }
    public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str;
       RungeKutta2 obj=new RungeKutta2();
       double x1,xf,y1,h,s,s1,s2,s3,s4;
       System.out.println("Input Initial value of x");
       str=br.readLine();
        x1=Double.parseDouble(str);
        System.out.println("Input final value of x");
       str=br.readLine();
        xf=Double.parseDouble(str);
        System.out.println("Input Initial value of y");
       str=br.readLine();
        y1=Double.parseDouble(str);
        System.out.println("Input interval h");
       str=br.readLine();
        h=Double.parseDouble(str);
        while(x1<=xf){
            System.out.println("x = "+x1 +"y = "+y1);
            s1=obj.f(x1,y1);
            s2=obj.f(x1+h/2,y1+s1*h/2);
            s3=obj.f(x1+h/2,y1+s2*h/2);
            s4=obj.f(x1+h,y1+s3*h);
            s=(s1+2*s2+2*s3+s4)/6;
            y1=y1+h*s;

            x1=x1+h;
        }
    }

}

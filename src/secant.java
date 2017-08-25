import java.io.*;
public class secant {
public double f(double x){
    return(3*x-Math.cos(x)-1);
}

    public static void main(String[] args) throws IOException{
      RegulaFalsi obj=new RegulaFalsi();
       double x0,x1,ep,x2;
       int n,i;
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str;
       System.out.println("Input Initial Approximation");
       str=br.readLine();
       x0=Double.parseDouble(str);
       str=br.readLine();
       x1=Double.parseDouble(str);
       System.out.println("prescribed precision");
       str=br.readLine();
       ep=Double.parseDouble(str);
       System.out.println("Input Max No. of Iteration");
       str=br.readLine();
       n=Integer.parseInt(str);
       if(obj.f(x0)*obj.f(x1)>0){
           System.out.println("Initial Approximation does not cover the root");
           System.exit(0);
        }
       for(i=0;i<n;i++)
       {
           x2=x0-(x1-x0)/(obj.f(x1)-obj.f(x0))*obj.f(x0);
           System.out.println("  "+x2);
           if(Math.abs(obj.f(x2))<ep){
               System.out.println("Convergent Solution is "+x2);
               System.exit(1);

           }

           x0=x1;
           x1=x2;
       }// end of for loop
System.out.println("Does not converse in "+n+"iterations");



    }

}

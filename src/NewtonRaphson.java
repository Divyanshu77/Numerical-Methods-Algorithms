import java.io.*;

public class NewtonRaphson {
public double f(double x){
    return(3*x-Math.cos(x)-1);
}
public double fd(double x){
    return (3+Math.sin(x));
}
   
    public static void main(String[] args)throws IOException {
        NewtonRaphson obj=new NewtonRaphson();
       double x0,x1,ep,delta;
       int n,i;
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str;
       System.out.println("Input Initial Approximation");
       str=br.readLine();
       x0=Double.parseDouble(str);
       System.out.println("Input Prescrive relative error");
       str=br.readLine();
       ep=Double.parseDouble(str);
       System.out.println("Input Lower Limit for f'");
       str=br.readLine();
       delta=Double.parseDouble(str);
       System.out.println("Input Max No. of Iteration");
       str=br.readLine();
       n=Integer.parseInt(str);
       for(i=0;i<n;i++)
       {
           if(obj.fd(x0)<delta)
           {
               System.out.println("slope too small");
               System.exit(0);
           }
           x1=x0-obj.f(x0)/obj.fd(x0);
           if(Math.abs(x1-x0)/x0<ep){
               System.out.println("Convergent Solution is "+x1);
               System.exit(1);

           }
           System.out.println("f=  "+obj.f(x0)+"fd="+obj.fd(x0)+"x1="+x1);
           x0=x1;
       }// end of for loop
System.out.println("Does not converse in "+n+"iterations");



    }

}

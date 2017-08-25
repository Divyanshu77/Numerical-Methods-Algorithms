import java.io.*;
/*public class secant {
public double f(double x){
    return(3*x-Math.cos(x)-1);
}

    public static void main(String[] args) throws IOException{
      RegulaFalsi obj=new RegulaFalsi();
       double x0,x1,ep,x2;
       int n,i;
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str;*/
public class meanmediannodedirect {
    private double arr[];
    private double mean;
    private double median;
    private int size;
    public meanmediannodedirect(int n)
    {
        size=n;
        arr=new double[n];
    }
    public void getdata() throws IOException
    {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str;
       int i;
       System.out.println("Input data");
       for(i=0;i<size;i++)
       {
           str=br.readLine();
           arr[i]=Double.parseDouble(str);
       }
    }
    public void calculate()
    {
        double sum,temp;
        int i,j;
        for(i=0,sum=0;i<size;i++)
            sum=sum+arr[i];
        mean=sum/size;
        /*arrange in ascending order*/
        for(i=0;i<size-1;i++)
            for(j=0;j<size-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        if(size%2==1)
            median=arr[size/2];
        else median=(arr[size/2-1]+arr[size/2])/2;
    }
public void display()
    {
    System.out.println("mean = "+mean+"median = "+median);
    }

 public static void main(String[] args) throws IOException{
     meanmediannodedirect x=new meanmediannodedirect(7);
     x.getdata();
     x.calculate();
     x.display();
 }
}


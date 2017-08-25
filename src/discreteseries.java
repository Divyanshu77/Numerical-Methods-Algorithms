import java.io.*;
public class discreteseries{
    private double x[],f[],mean,median,mode;
    private int size;
    public discreteseries(int n){
        size=n;
        f=new double[n];
        x=new double[n];
    }
    public void getdata()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Input the value of x and its frequency");
        for(int i=0;i<size;i++)
        {
            str=br.readLine();
            x[i]=Double.parseDouble(str);
            str=br.readLine();
            f[i]=Double.parseDouble(str);
        }
    }
    public void calculate(){
        int i,big;
        double fx,f;
        for(i=0,fx=0,f=0;i<size;i++)
        {
            f+=this.f[i];
            fx+=this.f[i]*this.x[i];

        }
        mean=fx/f;
        /******************median*************/
      double cf[]=new double[size];
      cf[0]=this.f[0];
      for(i=1;i<size;i++)
          cf[i]=cf[i-1]+this.f[i];
      for(i=0;i<size&&cf[i]<f/2;i++);
      median=x[i];
      /***************mode*********************/
      big=0;
      for(i=1;i<size;i++)
          if(this.f[big]<this.f[i])
              big=i;
      mode=x[big];
    }

    public void display(){
        System.out.print("Mean = "+mean);
        System.out.print("Median = "+median);
        System.out.print("Mode = "+mode);
    }

    public static void main(String args[])throws IOException
    {
        discreteseries ds=new discreteseries(10);
        ds.getdata();
        ds.calculate();
        ds.display();
    }
    }

/******************************
Continuous Series Implementaion 
by - Divyanshu Sharma
*******************************/


import java.io.*;
public class ContinuousSeries{
    private double lb,interval,f[],mean,median,mode;
    private int size;
    public ContinuousSeries(int n){size=n;f=new double[n];}
    public void getdata()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Input Lower Bound , Upper bound and class interval");
           str=br.readLine();
            lb=Double.parseDouble(str);
               str=br.readLine();
//            up=Double.parseDouble(str);
//               str=br.readLine();
            interval=Double.parseDouble(str);
           // size=(int) ((up - lb) / interval);
           // f=new double[size];
        System.out.println("Input the  frequency");
        for(int i=0;i<size;i++)
        {
            str=br.readLine();
            f[i]=Double.parseDouble(str);
        }
        System.out.println("size="+size);
    }
    public void calculate(){
        int i,big;
        double fx,freq=0;
        for(i=0,fx=0;i<size;i++)
        {
            freq+=this.f[i];
            //f+=(lb+i*interval +lb+(i+1)*interval)/2;
            fx+=(lb+i*interval +lb+(i+1)*interval)/2*this.f[i];

        }
        mean=fx/freq;
        //System.out.println("f  ="+f);
      /******************median*************/
      double cf[]=new double[size];
      cf[0]=this.f[0];
      for(i=1;i<size;i++)
          cf[i]=cf[i-1]+this.f[i];
      for(i=0;i<size&&cf[i]<freq/2;i++);
      median=(lb+i*interval)+interval/this.f[i]*(freq/2-cf[i-1]);
      /***************mode********************/
      big=0;
      for(i=1;i<size;i++)
          if(this.f[big]<this.f[i])
              big=i;
      mode=(lb+big*interval)+( interval * (this.f[big]-this.f[big-1] ) ) / (2*this.f[big]-this.f[big-1]-this.f[big+1]);

    }

    public void display(){
        System.out.print("Mean = "+mean);
        System.out.print("Median = "+median);
        System.out.print("Mode = "+mode);
    }

    public static void main(String args[])throws IOException
    {
        ContinuousSeries ds=new ContinuousSeries(5);
        ds.getdata();
       ds.calculate();
        ds.display();
    }
    }


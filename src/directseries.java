import java.io.*;
public class directseries{
    private double arr[],mean,median;
    private int size;
    public directseries(int n){
        size=n;
        arr=new double[n];
    }
    public void getdata()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Input the elements of the series");
        for(int i=0;i<size;i++)
        {
            str=br.readLine();
            arr[i]=Double.parseDouble(str);
        }
    }
    public void calculate(){
        int i,j;
        double sum,temp;
        for(i=0,sum=0.0;i<size;i++)
            sum+=arr[i];
        mean=sum/size;
        /******************median*************/
        for(i=0;i<size;i++)
            for(j=0;j<size-i-1;j++)
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
        if(size%2==1)
            median=arr[size/2];
        else
            median=(arr[size/2]+arr[size/2-1])/2;


    }
    public void display(){
        System.out.print("Mean = "+mean);
        System.out.print("Median = "+median);
    }

    public static void main(String args[])throws IOException
    {
        directseries ds=new directseries(5);
        ds.getdata();
        ds.calculate();
        ds.display();
    }
    }

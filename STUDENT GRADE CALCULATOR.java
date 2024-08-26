import java.util.*;
class studentgradecalculator
{
    
    /**
     * 
     */
    public static void main(String[] args)
    {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter Number Of Subjects : ");
        int n =Sc.nextInt();
        char ch;
        double avrg;
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter your marks in subject "+(i+1)+":");
            a[i]=Sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+a[i];
        }
        avrg=sum/n; 
        System.out.println("value="+avrg);
        if(avrg>=90.00)
        ch='A';
        else if (avrg>=80.00)
        ch='B';
        else if (avrg>=70.00)
        ch='C';
        else
        ch='D';
        System.out.println("YOUR DETAILS ARE : ");
        for(int i=0;i<n;i++)
        {
            System.out.println("MARKS IN SUBJECT "+(i+1)+"IS"+a[i]);
        }
        System.out.println("Average Marks are "+avrg);
        System.out.println("Grade according to your average marks is "+ch);

    }
}

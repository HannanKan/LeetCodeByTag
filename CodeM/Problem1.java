import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		double total=0,totalDiscount=0,maxDiscount=0;
		int m,n;
		n=in.nextInt();
		m=in.nextInt();
		double first,second;
		//process n
		for(int i=0;i<n;i++){
			first=in.nextDouble();
			second=in.nextDouble();
			total+=first;
			if(second==1) totalDiscount+=first*0.2;
		}
		for(int i=0;i<m;i++){
			first=in.nextDouble();
			second=in.nextDouble();
			if(total>=first&&maxDiscount<second) maxDiscount=second;
		}
		double result1=total-totalDiscount,result2=total-maxDiscount;
		System.out.printf("%.2f", result1<result2?result1:result2);
    }
}
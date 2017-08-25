import java.io.*;

public class eulers {
	public double f(double x, double y) {
		return Math.log10(x + y);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		eulers obj = new eulers();
		double x1, xf, y1, h,s1;
		System.out.println("Input Initial value of x");
		str = br.readLine();
		x1 = Double.parseDouble(str);
		System.out.println("Input final value of x");
		str = br.readLine();
		xf = Double.parseDouble(str);
		System.out.println("Input Initial value of y");
		str = br.readLine();
		y1 = Double.parseDouble(str);
		System.out.println("Input interval h");
		str = br.readLine();
		h = Double.parseDouble(str);
		while (x1 <= xf) {
			System.out.println("x = " + x1 + "y = " + y1);
			s1 = obj.f(x1, y1);
			y1 = y1 + h * s1;
			x1 = x1 + h;
		}
	}

}

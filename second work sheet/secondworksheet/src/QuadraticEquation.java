public class QuadraticEquation {
    private int a,b,c;
    QuadraticEquation(int a,int b, int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
    double getDiscriminant()
    {
        return ((b*b)-(4*a*c));
    }
    double getRoot1()
    {
        return ((-1)*b+Math.sqrt(b*b-4*a*c))/(2*a);
    }
    double getRoot2()
    {
        return ((-1)*b-Math.sqrt(b*b-4*a*c))/(2*a);
    }
}

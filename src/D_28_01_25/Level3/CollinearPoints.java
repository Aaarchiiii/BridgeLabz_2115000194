package D_28_01_25.Level3;

public class CollinearPoints {
    public static boolean arePointsCollinearUsingSlopes(double x1,double y1,double x2,double y2,double x3,double y3) {
        double slopeAB=(y2-y1)/(x2-x1);
        double slopeBC=(y3-y2)/(x3-x2);
        double slopeAC=(y3-y1)/(x3-x1);
        return slopeAB==slopeBC && slopeBC==slopeAC;
    }
    public static boolean arePointsCollinearUsingArea(double x1,double y1,double x2,double y2,double x3,double y3) {
        double area=0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        return area==0;
    }
    public static void main(String[] args) {
        double x1=2,y1=4,x2=4,y2=6,x3=6,y3=8;
        boolean collinearSlopes=arePointsCollinearUsingSlopes(x1,y1,x2,y2,x3,y3);
        boolean collinearArea = arePointsCollinearUsingArea(x1,y1,x2,y2,x3,y3);
        System.out.println("Using Slopes: Are points A("+x1+","+y1+"), B("+x2+","+y2+"), C("+x3+","+y3+") collinear? "+collinearSlopes);
        System.out.println("Using Area: Are points A("+x1+","+y1+"), B("+x2+","+y2+"), C("+x3+","+y3+") collinear? "+collinearArea);
    }
}

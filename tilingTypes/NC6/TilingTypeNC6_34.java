package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_34
   extends TilingType
{
   public TilingTypeNC6_34(){
      super( "NC6-34", 6, SymmetryType.pgg );

      paramMin = new int[]{ 84, 10};
      paramMax = new int[]{180,110};
      paramDef = new int[]{110, 90};
      paramName = new String[]{"Angle 1", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {0, 4,3, 0,0,1, 0},
            {0, 4,3, 1,0,1, 0},

            {1, 5,0, 3,0,1, 1},
            {1, 3,2, 4,2,3, 1},
            {0, 4,3, 4,0,1, 1},
            {0, 4,3, 5,0,1, 1},
      };
      info = "a=b=c=e\nd=f\nC+D=360\nB+D+E=360\n(A+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1;

      double anga = getParam(paramValues, 0);
      double angc = getParam(paramValues, 1);
      double angd = 360-angc;
      double angf = angd-anga;

      double r = Functions.BisectionMethod(new Func(anga, angc), 0, 100, 0.001);
      double ln1 = lntotal / (1+r);
      double ln2 = lntotal * r / (1+r);
      
      double diag1 = calcSide(ln1,ln1,anga);
      double diag2 = calcSide(diag1,ln2,angf - (90-anga/2));
      double angABE = (90-anga/2) + calcAngle(diag1,diag2,ln2) * (angf<180+90-anga/2?1:-1);
      double angb = angABE + calcAngle(diag2, 2*ln1, ln2);

      double x1 = ln1;
      double y1 = 0;
      double x2 = x1 + ln1 * Math.cos( (180-angb) * DEG2RAD );
      double y2 = y1 + ln1 * Math.sin( (180-angb) * DEG2RAD );
      double x3 = x2 + ln2 * Math.cos( (-angb-angc) * DEG2RAD );
      double y3 = y2 + ln2 * Math.sin( (-angb-angc) * DEG2RAD );
      double x4 = x3 + ln1 * Math.cos( (-angb+180) * DEG2RAD );
      double y4 = y3 + ln1 * Math.sin( (-angb+180) * DEG2RAD );
      double x5 =      ln1 * Math.cos( anga * DEG2RAD );
      double y5 =      ln1 * Math.sin( anga * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[2].getX(5);
      offsets[1] = tiles[3].getY(4)-tiles[2].getY(5);
      offsets[2] = tiles[2].getX(5)-tiles[6].getX(1);
      offsets[3] = tiles[2].getY(5)-tiles[6].getY(1);
   }
   private class Func implements IFunction{
      private double a, c;
      Func(double a0, double c0){ a = a0; c = c0; }
      public double calculate(double r) {
         double d = 360-c;
         double f = d-a;

         double diag1 = calcSide(1,1,a);
         double ln1 = calcSide(diag1,r,f - (90-a/2));
         double ln2 = calcSide(2, r, c);
         return ln1 - ln2;
      }
   }
}
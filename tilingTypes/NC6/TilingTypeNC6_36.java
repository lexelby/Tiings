package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_36
   extends TilingType
{
   public TilingTypeNC6_36(){
      super( "NC6-36", 6, SymmetryType.pg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{270,100};
      paramDef = new int[]{150, 70};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,1,2, 1},
            {0, 4,3, 1,1,2, 1},
            {1, 3,4, 2,1,2, 0},
      };
      info = "a=b=d=f\nc=e\nC+E=360\nA+B+E=360\n(C+D+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      double a = getParam(paramValues, 0);
      
      double e = Functions.BisectionMethod(new Func(a,ln2/ln1), 60, 300, 0.0001);
      double diag = calcSide(ln1, ln2, e);
      double x = Math.asin(ln2 * Math.sin(e*DEG2RAD)/diag)/DEG2RAD;
      double y = 180-e-x;
      double base = calcSide(ln1,ln1,a);
      double r = calcAngle(base,diag,diag);
      double s = 90-a/2;
      
      double f = x+r+s;
      double b = s+r-y;
      double c = 360-e;
      double d = 720-a-b-c-e-f;

      double x1 = ln1;
      double y1 = 0;
      double x2 = x1 + ln2 * Math.cos( (180-b) * DEG2RAD );
      double y2 = y1 + ln2 * Math.sin( (180-b) * DEG2RAD );
      double x3 = x2 + ln1 * Math.cos( (-b-c) * DEG2RAD );
      double y3 = y2 + ln1 * Math.sin( (-b-c) * DEG2RAD );
      double x4 = x3 + ln2 * Math.cos( (-b-c-d+180) * DEG2RAD );
      double y4 = y3 + ln2 * Math.sin( (-b-c-d+180) * DEG2RAD );
      double x5 = x4 + ln1 * Math.cos( (-b-c-d-e) * DEG2RAD );
      double y5 = y4 + ln1 * Math.sin( (-b-c-d-e) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[0].getX(5);
      offsets[3] = tiles[2].getY(1)-tiles[0].getY(5);
   }
   private class Func implements IFunction{
      private double a,ln2;
      Func(double a0, double ln0 ){ a = a0; ln2=ln0;}
      public double calculate(double e) {
         double diag = calcSide(1, ln2, e);
         double x = Math.asin(ln2 * Math.sin(e*DEG2RAD)/diag)/DEG2RAD;
         double y = 180-e-x;
         double base = calcSide(1,1,a);
         double r = base>diag*2 ? 0 : calcAngle(base,diag,diag);
         double s = 90-a/2;
         double b = s+r-y;

         return a+b+e - 360;
      }
   }   
}
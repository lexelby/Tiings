package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_254
   extends TilingType
{
   public TilingTypeNC5_254(){
      super( "NC5-254", 5, SymmetryType.pgg );

      paramMin = new int[]{0};
      paramMax = new int[]{120};
      paramDef = new int[]{50};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,1, 0,0,1, 0},
            {1, 0,1, 1,1,0, 0},
            {1, 0,2, 2,2,0, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 0,1, 4,2,1, 0},
            
            {2, 1,2, 1,3,4, 1},
            {0, 2,1, 6,0,1, 1},
            {1, 0,1, 7,1,0, 1},
            {1, 0,2, 8,2,0, 1},
            {0, 1,0, 9,0,1, 1},
            {2, 0,1,10,2,1, 1},
      };
      info = "a=d\nb=2c\nc=e\nA+2C+E=360\nD+E=360\n(A+B+C=180)";
   }
   class Func
   implements IFunction
   {
      double dif, lnb;
      Func(double dif0, double lnb0){
         dif = dif0; lnb = lnb0;
      }
      @Override
      public double calculate(double r) {
         double opp = calcSide(lnb, 1, Math.abs(r));
         double e = calcAngle(lnb, opp, 1);
         if( r<0 ) e=360-e;
         double a2 = 180-r-e;
         return e-a2-dif;
      }
   }
   public void recalcBase(double[] paramValues) {
      double lnb = .5;
      double b = getParam(paramValues,0);

      double diag = calcSide(2*lnb, lnb, b);
      double a1 = calcAngle(diag, 2*lnb, lnb);
      // A+2B=E  -->  E-A2 = A1+2B
      double r = Functions.BisectionMethod(new Func(a1+2*b, lnb/diag), -50, 180, 0.001);
      double opp = calcSide(lnb, diag, Math.abs(r));
      double a2 = calcAngle(diag, opp, lnb);
      if( r<0 ) a2=-a2;
      double a = a1+a2;
      double e = 2*b+a;
      
      double x2 = 2*lnb + lnb*Math.cos( (180-b) * DEG2RAD);
      double y2 =         lnb*Math.sin( (180-b) * DEG2RAD);
      double dx = lnb*Math.cos( (a+e-180) * DEG2RAD);
      double dy = lnb*Math.sin( (a+e-180) * DEG2RAD);
      
      double x3 = (x2+dx)/2;
      double y3 = (y2+dy)/2;
      double x4 = (x2-dx)/2;
      double y4 = (y2-dy)/2;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb*2, 0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[5].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[11].getX(1)-tiles[4].getX(3);
      offsets[3] = tiles[11].getY(1)-tiles[4].getY(3);
   }

}

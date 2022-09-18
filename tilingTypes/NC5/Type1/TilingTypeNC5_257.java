package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_257
   extends TilingType
{
   public TilingTypeNC5_257(){
      super( "NC5-257", 5, SymmetryType.pg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{120};
      paramDef = new int[]{115};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,1, 0,0,1, 0},
            {1, 0,1, 1,1,0, 0},
            {1, 0,2, 2,2,0, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 0,1, 4,2,1, 0},
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
      public double calculate(double c2) {
         double opp = calcSide(lnb, 1, Math.abs(c2));
         double e = calcAngle(lnb, opp, 1);
         if( c2<0 ) e=360-e;
         double a2 = 180-c2-e;
         return dif+a2+2*c2+e-360;
      }
   }
   public void recalcBase(double[] paramValues) {
      double lnb = .5;
      double b = getParam(paramValues,0);

      double diag = calcSide(2*lnb, lnb, b);
      double c1 = calcAngle(diag, lnb, 2*lnb);
      double a1 = 180-c1-b;
      Func f = new Func(a1+2*c1, lnb/diag);
      double c2 = Functions.BisectionMethod(f, -30, 90, 0.001);
      double lnc = calcSide(lnb, diag, Math.abs(c2))/2;
      double a2 = calcAngle(diag, lnc*2, lnb);
      if( c2<0 ) a2=-a2;
      double a = a1+a2;
      double e = 180-c2-a2;
      
      double x4 =      lnc*Math.cos( a * DEG2RAD);
      double y4 =      lnc*Math.sin( a * DEG2RAD);
      double x3 = x4 + lnb*Math.cos( (a+e-180) * DEG2RAD);
      double y3 = y4 + lnb*Math.sin( (a+e-180) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb*2, 0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[5].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[1].getX(2)-tiles[4].getX(3);
      offsets[3] = tiles[1].getY(2)-tiles[4].getY(3);
   }

}

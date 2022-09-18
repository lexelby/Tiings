package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_40b
   extends TilingType
{
   public TilingTypeNC6_40b(){
      super( "NC6-40b", 6, SymmetryType.pgg );

      paramMin = new int[]{120,  0};
      paramMax = new int[]{210,100};
      paramDef = new int[]{160, 40};
      paramName = new String[]{"Angle", "Relative length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {1, 5,1, 1,2,4, 0},
            {0, 1,2, 2,1,2, 1},

            {0, 5,0, 0,0,5, 0},
            {1, 1,2, 4,1,2, 1},
            {1, 5,1, 5,2,4, 0},
            {0, 1,2, 6,1,2, 1},
      };
      info = "b=e\na=d=f\nA+D=360\nA+E+F=360\n2C+F=360\n(B+C+D=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln2 = lntotal * getParam(paramValues, 1)/100;
      double ln1 = lntotal - ln2;
      double f = getParam(paramValues, 0);
      
      double d = Functions.BisectionMethod(new Func(f), 0, 90, 0.0001);
      
      double dx = Math.cos(d*DEG2RAD);
      double dy = Math.sin(d*DEG2RAD) + 2 * Math.sin(f*DEG2RAD);
      double ln3 = ln2 * Math.sqrt(dx*dx+dy*dy);
      
      double s = .5 * (ln1 + ln2 + ln3);
      ln1 /= s;
      ln2 /= s;
      //ln3 /= s;
      
      double x1 = ln1;
      double y1 = 0;
      double x5 =      ln2 * Math.cos( f * DEG2RAD );
      double y5 =      ln2 * Math.sin( f * DEG2RAD );
      double x4 = x5 + ln2 * Math.cos( (180-d) * DEG2RAD );
      double y4 = y5 + ln2 * Math.sin( (180-d) * DEG2RAD );
      double x3 = x4 + ln1;
      double y3 = y4;
      double x2 = x3 + ln2 * Math.cos( (180-f) * DEG2RAD );
      double y2 = y3 + ln2 * Math.sin( (180-f) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(5)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(5)-tiles[7].getY(0);
   }
   private class Func implements IFunction{
      private double f;
      Func( double f0){ f = f0;}
      public double calculate(double d) {
         double dx = Math.cos(d*DEG2RAD);
         double dy = Math.sin(d*DEG2RAD) + 2 * Math.sin(f*DEG2RAD);
         double a = Math.atan2(dy,dx) / DEG2RAD;
         double b = f-a;
         double e = 360-(f+d);
         return 2*b+e - 360;
         //f-2*a+d;
      }
   }   
}
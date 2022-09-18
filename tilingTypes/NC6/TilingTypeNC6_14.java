package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_14
   extends TilingType
{
   public TilingTypeNC6_14(){
      super( "NC6-14", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 35};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,3,4, 0},
            {0, 0,1, 1,3,4, 1},
            {1, 1,0, 2,3,4, 1},

            {0, 3,2, 1,1,2, 0},
            {1, 1,0, 4,3,4, 0},
            {0, 0,1, 5,3,4, 1},
            {1, 1,0, 6,3,4, 1},
      };
      info = "a=c\nb=d=e=f\nA=B\nA+E=360\nB+D=180\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.0;
      double ln1 = ln *  getParam(paramValues, 0)/100;
      double ln2 = ln - ln1;
      double a = Functions.BisectionMethod(new Func(ln2/ln1), 89, 136, 0.0001);
      
      double c1 = ln2 * Math.cos( a * DEG2RAD );
      double s1 = ln2 * Math.sin( a * DEG2RAD );

      double maindiag = ln1 - 2 * ln2 * Math.cos(a*DEG2RAD);
      double diag2 = calcSide(ln1, ln2, a);
      double b = calcAngle( ln2, maindiag, diag2);
 
      double c2 = ln2 * Math.cos( b * DEG2RAD );
      double s2 = ln2 * Math.sin( b * DEG2RAD );

      double c3 = ln2 * Math.cos( (a-(180-a+b)) * DEG2RAD );
      double s3 = ln2 * Math.sin( (a-(180-a+b)) * DEG2RAD );

      baseTile.setPoint(0,     0,     0);
      baseTile.setPoint(1,   ln1,     0);
      baseTile.setPoint(2, ln1-c1,     s1);
      baseTile.setPoint(3, ln1-c1-c2,  s1+s2);
      baseTile.setPoint(4,  c1+c3,    s1+s3);
      baseTile.setPoint(5,     c1,     s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(2)-tiles[0].getX(5);
      offsets[1] = tiles[7].getY(2)-tiles[0].getY(5);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(0);
   }

   private class Func implements IFunction{
      private double lna;
      Func(double lna0){ lna = lna0; }
      public double calculate(double a) {
         double maindiag = 1 - 2 * lna * Math.cos(a*DEG2RAD);
         double diag2 = calcSide(1, lna, a);
         double c = calcAngle( diag2, lna, maindiag) - calcAngle( diag2, 1, lna);
         return c+a-180;
      }
   }   
}
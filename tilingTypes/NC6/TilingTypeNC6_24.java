package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_24
   extends TilingType
{
   public TilingTypeNC6_24(){
      super( "NC6-24", 6, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{210};
      paramDef = new int[]{110};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {0, 4,3, 0,0,1, 0},
            {0, 4,3, 1,0,1, 0},

            {1, 1,2, 2,0,1, 1},
            {1, 4,3, 4,3,4, 1},
            {0, 4,3, 4,0,1, 1},
            {0, 4,3, 5,0,1, 1},
      };
      info = "b=c=e\na=d=f\nA=D\nD+E=360\n2A+B=360\n(A=C+F)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double a = getParam(paramValues, 0);
      double x = Functions.BisectionMethod(new Func(a), 0, 2.0, 0.0001);
      double ln1 = lntotal / (1+x);
      double ln2 = lntotal * x / (1+x);
      
      double base = 2 * ln1 * Math.sin(a/2*DEG2RAD);
      double diag = Math.sqrt(base*base+ln2*ln2);
      double angabf = 90-a/2;
      double b = angabf + Math.acos(base/diag)/DEG2RAD + calcAngle(2*ln2,diag,ln1);
      
      double c1 = ln1 * Math.cos(angabf * DEG2RAD);
      double s1 = ln1 * Math.sin(angabf * DEG2RAD);
      double c2 = ln2 * Math.cos((b-angabf) * DEG2RAD);
      double s2 = ln2 * Math.sin((b-angabf) * DEG2RAD);
      baseTile.setPoint(0,    0,   0);
      baseTile.setPoint(1,   c1, -s1);
      baseTile.setPoint(2, 2*c1,   0);
      baseTile.setPoint(3, 2*c1-c2, s2);
      baseTile.setPoint(4,   c2, ln2-s2);
      baseTile.setPoint(5,    0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[3].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(1)-tiles[6].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[6].getY(0);
   }
   private class Func implements IFunction{
      private double a;
      Func(double a0){ a = a0; }
      public double calculate(double ln2) {
         double base = 2 * Math.sin(a/2*DEG2RAD);
         double diag = Math.sqrt(base*base+ln2*ln2);
         double c = 180-a/2;
         double diag2 = calcSide(1,2*ln2,c);
         return diag-diag2;
      }
   }   
   
}
package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_34
   extends TilingType
{
   public TilingTypeNC5_34(){
      super( "NC5-34", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,1,2, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 1,2, 2,0,4, 0},
            
            {0, 3,4, 3,0,1, 1},
            {1, 0,4, 4,1,2, 1},
            {1, 4,1, 5,1,4, 1},
            {0, 1,2, 6,0,4, 1},
      };
      info = "c=e\nb=a+d\nC+D=360\nA+D=180\n(A+B+E=180)";
   }

   private class Func implements IFunction{
      private double ln1,ln2;
      public Func(double ln10, double ln20){ ln1=ln10; ln2 = ln20; }
      public double calculate(double d){
         // get other angles
         //double c = 360-d;
         double f = 180-d;

         // get third side of main triangle
         double ln3 = ln1+ln2;
         double t1 = calcSide(ln1,ln3,f);
         // get length of zigzag
         double t2 = calcSide(2*ln1,ln2,d);

         return t1-t2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1*paramValues[0] / 200.;
      double ln1 = 1-ln2;
      double ln3 = ln1+ln2;

      // Calculate the angles
      double d = Functions.BisectionMethod(new Func(ln1,ln2), 0, 180, 0.001);
      double c = 360-d;
      double f = 180-d;
      double t = calcSide(ln1,ln3,f);
      double e1 = calcAngle(ln1,t,ln3);
      double e2 = calcAngle(2*ln1,t,ln2);
      double e = e1+e2;
      double b = 180-e-f;

      double x1 = ln3;
      double y1 = 0;
      double x2 = x1 + ln1 * Math.cos( (180-b) * DEG2RAD);
      double y2 = y1 + ln1 * Math.sin( (180-b) * DEG2RAD);
      double x3 = x2 + ln2 * Math.cos( (-b-c) * DEG2RAD);
      double y3 = y2 + ln2 * Math.sin( (-b-c) * DEG2RAD);
      double x4 = x3 + x2-x1;
      double y4 = y3 + y2-y1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[3].getX(3);
      offsets[1] = tiles[4].getY(0)-tiles[3].getY(3);
      offsets[2] = tiles[7].getX(0)-tiles[0].getX(3);
      offsets[3] = tiles[7].getY(0)-tiles[0].getY(3);
   }
}

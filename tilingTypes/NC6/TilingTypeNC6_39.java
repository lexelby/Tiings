package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_39
   extends TilingType
{
   public TilingTypeNC6_39(){
      super( "NC6-39", 6, SymmetryType.pg );

      paramMin = new int[]{ 90,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{105, 25};
      paramName = new String[]{"Angle", "Relative height"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,5, 0,4,5, 0},
            {0, 0,1, 1,3,4, 1},
            {1, 0,5, 2,4,5, 1},
      };
      info = "b=e\na=c=f\nA=B\nA+E=360\nC+F=180\n(B+D=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln2 = lntotal * getParam(paramValues, 1)/100;
      double ln1 = lntotal - ln2;
      double c = getParam(paramValues, 0);
      double b = Functions.BisectionMethod(new Func(ln2/ln1,c), 0, 180, 0.0001);

      double x1 = ln1;
      double y1 = 0;
      double x2 = x1 + ln2 * Math.cos( (180-c) * DEG2RAD );
      double y2 = y1 + ln2 * Math.sin( (180-c) * DEG2RAD );

      double x5 =      ln2 * Math.cos( c * DEG2RAD );
      double y5 =      ln2 * Math.sin( c * DEG2RAD );
      double x4 = x5 + ln2 * Math.cos( (c+b-180) * DEG2RAD );
      double y4 = y5 + ln2 * Math.sin( (c+b-180) * DEG2RAD );
      double x3 = x4 + ln1 * Math.cos( b * DEG2RAD );
      double y3 = y4 + ln1 * Math.sin( b * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(0);
   }

   private class Func implements IFunction{
      private double c,ln2;
      Func(double ln0, double c0){ c = c0; ln2=ln0;}
      public double calculate(double b) {
         double diag = 1 - 2*ln2*Math.cos(c*DEG2RAD);
         double diag2 = calcSide(1,ln2,c);
         double angABF = Math.asin(Math.sin(c*DEG2RAD)/diag2)/DEG2RAD;
         if( angABF!=angABF ) angABF = 0;
         double angCBE = 180-c; 
         double angEBF = angABF+b - angCBE;
         double lenEF = calcSide(diag, diag2, angEBF);
         double angBEF = Math.asin(diag2 * Math.sin(angEBF*DEG2RAD)/lenEF)/DEG2RAD;
         if( angBEF!=angBEF ) angBEF = 0;
         double e = angCBE + angBEF;
         return b+e - 180;
      }
   }   
}
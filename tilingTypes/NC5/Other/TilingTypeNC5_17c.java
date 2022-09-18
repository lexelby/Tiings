package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_17c
   extends TilingType
   implements IFunction
{
   private double c, b, ln1, ln2;
   public TilingTypeNC5_17c(){
      super( "NC5-17c", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };
      // 90.0 63.43 153.43 206.57 26.57

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,3, 1},
            {1, 4,1, 1,1,4, 1},
            {2, 0,1, 2,0,4, 1},
            {0, 4,0, 3,2,3, 0},
            {2, 2,3, 0,4,0, 1},
      };
      info = "a=b=d\nc=e\nA=90\nC+D=360\nC+E=180\n(B+E=90)";
   }
   public void initialiseImpl(){
      c = Functions.BisectionMethod(this, 0, 180, 0.001);
      b = c-90;
      double base = Math.sqrt(2);
      double y = 180-c-Math.asin( ( Math.sin(c*DEG2RAD)/base ) )/DEG2RAD;
      double fac = calcSide(1,base,y)/2;
      ln1 = 1 / (1+fac);
      ln2 = fac*ln1;
   }   

   public double calculate(double c0){
      double base = Math.sqrt(2);
      double x = Math.asin( ( Math.sin(c0*DEG2RAD)/base ) )/DEG2RAD;
      return c0-x+45-180;
   }

   public void recalcBase(double[] paramValues) {

      double x2 = ln1 + ln2 * Math.cos( (180-b) * DEG2RAD);
      double y2 =       ln2 * Math.sin( (180-b) * DEG2RAD);
      double x3 = ln1-x2;
      double y3 = ln1-y2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[5].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[5].getY(0);
      offsets[2] = tiles[4].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[4].getY(0)-tiles[0].getY(1);
   }
}

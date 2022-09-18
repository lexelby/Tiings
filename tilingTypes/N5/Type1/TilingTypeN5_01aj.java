package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01aj
   extends TilingType
   implements IFunction
{
   private double a, ln1, ln2;
   public TilingTypeN5_01aj(){
      super( "N5-1aj: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,0,4, 0},
            {1, 4,0, 1,0,4, 0},
            {0, 0,4, 2,3,4, 0},
            
            {0, 3,4, 0,1,2, 1},
            {1, 3,4, 4,0,4, 1},
            {1, 4,0, 5,0,4, 1},
            {0, 0,4, 6,3,4, 1},
      };
      info = "b=c=e\na+d=2b\nA=B\nB=C\nA+E=180\n(D=2E)";
   }
   public void initialiseImpl(){
      ln1 = Functions.BisectionMethod(this, 1, 1.4, 0.0001);
      a = calcAngle(1,2-ln1,ln1);
      ln2 = .5;
      ln1 *= ln2;
   }   

   public double calculate(double ln) {
      double b = calcAngle(ln,1,2-ln);
      double c = calcAngle(1,2-ln,ln);
      return 2*c-180 - b;
   }

   public void recalcBase(double[] paramValues) {
      double x2 = ln2 + ln2 * Math.cos((180-a) * DEG2RAD);
      double y2 =       ln2 * Math.sin((180-a) * DEG2RAD);
      double x4 =       ln1 * Math.cos(a * DEG2RAD);
      double y4 =       ln1 * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x4+ln2, y4);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(3);
   }
}

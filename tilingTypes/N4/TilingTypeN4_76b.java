package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_76b
   extends TilingType
{
   public TilingTypeN4_76b(){
      super( "N4-76b", 4, SymmetryType.pgg );

      paramMin = new int[]{ 0,  0,   0};
      paramMax = new int[]{90,100, 180};
      paramDef = new int[]{20, 60,  70};
      paramName = new String[]{ "Angle", "Aspect", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 2,3, 0,3,2, 0},
            {1, 2,3, 1,0,1, 1},
            {0, 1,2, 0,2,1, 0},
            {2, 2,3, 3,3,2, 0},
            {1, 2,3, 4,0,1, 1},
            
            {0, 1,0, 2,0,1, 1},
            {2, 2,3, 6,3,2, 1},
            {1, 2,3, 7,0,1, 0},
            {0, 1,2, 6,2,1, 1},
            {2, 2,3, 9,3,2, 1},
            {1, 2,3,10,0,1, 0},
      };
      info = "b=d\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1;
      // tile is quadrangle with top/bottom sides same length
      //  here oriented so that they slope away from each other at the same angle from the horizontal.
      double ln1 = lntotal * paramValues[1]/100.; //length of the short side of quadrangle
      double ln2 = lntotal - ln1; //
      double x1 = ln1 * Math.cos( paramValues[0] * DEG2RAD);
      double y1 = -ln1 * Math.sin( paramValues[0] * DEG2RAD);
      double x3 = ln2 * Math.cos( paramValues[2] * DEG2RAD);
      double y3 = ln2 * Math.sin( paramValues[2] * DEG2RAD);
      double x2 = x3 + x1;
      double y2 = y3 - y1;

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,  x1, y1);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(0)-tiles[8].getX(1);
      offsets[3] = tiles[0].getY(0)-tiles[8].getY(1);
   }
}

package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_46
   extends TilingType
{
   public TilingTypeP4_46(){
      super( "P4-46", 4, SymmetryType.pgg );

      paramMin = new int[]{ 0,  0,   0};
      paramMax = new int[]{90,100, 180};
      paramDef = new int[]{30, 30,  70};
      paramName = new String[]{ "Angle", "Aspect", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 2,3, 0,0,1, 1},
            {0, 0,1, 1,2,3, 1},
            };
      info = "b=d\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {

      // tile is quadrangle with top/bottom sides same length
      //  here oriented so that they slope away from each other at the same angle from the horizontal.
      double ln1 = 2 * paramValues[1]/100.; //length of the short side of quadrangle
      double ln2 = 2 - ln1; //
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
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[2].getX(1);
      offsets[3] = tiles[0].getY(3)-tiles[2].getY(1);
   }
}

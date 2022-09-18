package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_62a
   extends TilingType
{
   public TilingTypeN3_62a(){
      super( "N3-62a", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 90};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 2,0, 0,0,1, 1},
            {1, 2,1, 1,1,2, 1},
            {2, 1,0, 1,0,1, 1},
            {1, 1,2, 3,2,1, 1},
            {0, 0,1, 3,2,0, 0},

            {0, 2,0, 0,1,2, 1},
            {2, 2,0, 6,0,1, 0},
            {1, 2,1, 7,1,2, 0},
            {2, 1,0, 7,0,1, 0},
            {1, 1,2, 9,2,1, 0},
            {0, 0,1, 9,2,0, 1},
      };
      info = "2a=b\n(A+B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double c = h*Math.cos(paramValues[0] * DEG2RAD);
      double s = h*Math.sin(paramValues[0] * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,h+h,  0);
      baseTile.setPoint(2,  c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[6].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(2);
   }
}

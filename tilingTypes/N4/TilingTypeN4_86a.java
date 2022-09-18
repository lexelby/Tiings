package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_86a
   extends TilingType
{
   public TilingTypeN4_86a(){
      super( "N4-86a", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{ 90};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,2, 0},
            {2, 1,2, 1,0,1, 1},
            {0, 1,2, 2,0,1, 0},
            {1, 2,3, 3,3,2, 0},
            {2, 1,2, 4,0,1, 1},

            {0, 0,3, 5,2,3, 1},
            {1, 2,3, 6,3,2, 1},
            {2, 1,2, 7,0,1, 0},
            {0, 1,2, 8,0,1, 1},
            {1, 2,3, 9,3,2, 1},
            {2, 1,2,10,0,1, 0},
      };
      info = "b=c\nd=a+b\nA+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnbc = .5;
      double b = getParam(paramValues, 0);
      double cs = Math.cos(b * DEG2RAD);
      double sn = Math.sin(b * DEG2RAD);
      double lna = lnbc * (1-1.5/(2+cs));

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, lnbc,  0);
      baseTile.setPoint(2, lnbc+lnbc*cs, lnbc*sn);
      baseTile.setPoint(3, lna*cs, lna*sn);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(2)-tiles[9].getX(0);
      offsets[3] = tiles[2].getY(2)-tiles[9].getY(0);
   }
}

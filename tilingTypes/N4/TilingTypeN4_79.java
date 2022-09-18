package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_79
   extends TilingType
{
   public TilingTypeN4_79(){
      super( "N4-79", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 80};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,0, 0,2,3, 1},
            {1, 3,2, 1,0,1, 1},
            {1, 1,2, 2,2,1, 1},
            {0, 0,1, 3,3,2, 1},
            {2, 2,3, 4,3,0, 0},

            {2, 1,0, 0,0,3, 1},
            {0, 3,0, 6,2,3, 0},
            {1, 3,2, 7,0,1, 0},
            {1, 1,2, 8,2,1, 0},
            {0, 0,1, 9,3,2, 0},
            {2, 2,3,10,3,0, 1},
      };
      info = "d=2a\n(b=3a)\nA+D=180\nA+2B=180\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.4;
      double a = getParam(paramValues, 0);
      double x4 = ln * Math.cos(a * DEG2RAD);
      double y4 = ln * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln*3, 0);
      baseTile.setPoint(2, x4+ln*2, y4);
      baseTile.setPoint(3, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[6].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[6].getY(0);
      offsets[2] = tiles[11].getX(0)-tiles[1].getX(1);
      offsets[3] = tiles[11].getY(0)-tiles[1].getY(1);
   }
}

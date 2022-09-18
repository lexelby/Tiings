package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_48c
   extends TilingType
{
   public TilingTypeN4_48c(){
      super( "N4-48c: Radially dissected squares", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,5,4, 0},
            {0, 3,4, 1,5,4, 0},
            {1, 3,4, 2,5,4, 0},

            {0, 0,1, 0,1,2, 1},
            {1, 3,4, 4,5,4, 1},
            {0, 3,4, 5,5,4, 1},
            {1, 3,4, 6,5,4, 1},
      };
      info = "c=d\nA=90\nC=90\n(B+D=180)";
      labels = new int[]{0,-1,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, 0.5,  0);
      baseTile.setPoint(2, 1.0,  0);
      baseTile.setPoint(3,   f,  0);
      baseTile.setPoint(4, 0.5,0.5);
      baseTile.setPoint(5,   0,1-f);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[6].getX(1);
      offsets[3] = tiles[2].getY(0)-tiles[6].getY(1);
   }
}

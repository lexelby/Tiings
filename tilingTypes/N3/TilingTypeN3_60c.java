package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_60c
   extends TilingType
{
   public TilingTypeN3_60c(){
      super( "N3-60c 2:1", 4, SymmetryType.pmg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 2,3, 0,0,3, 0},
            {0, 2,3, 1,0,3, 0},
            {0, 0,2, 2,2,0, 0},
            {0, 0,3, 3,2,3, 0},
            {1, 2,3, 4,2,3, 1},
      };
      info = "a=c\nA=30\nB=30\n(C=120)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.5;
      double h = w / Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,w+w,  0);
      baseTile.setPoint(3,  w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[5].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[5].getY(0);
   }
}

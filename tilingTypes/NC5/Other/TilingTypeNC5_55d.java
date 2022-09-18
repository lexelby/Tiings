package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_55d
   extends TilingType
{
   public TilingTypeNC5_55d(){
      super( "NC5-55d", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,4,3, 0},
            {1, 3,4, 1,4,3, 0},
            {0, 4,3, 2,4,0, 0},

            {0, 2,1, 2,1,0, 1},
            {1, 4,0, 4,4,3, 1},
            {1, 3,4, 5,4,3, 1},
            {0, 4,3, 6,4,0, 1},
      };
      info = "a=d=e\nb=c+e\nA=90\nB=45\nC=90\nD=270\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double r2 = ln*Math.sqrt(2);

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1,ln+r2, 0);
      baseTile.setPoint(2,   r2, ln);
      baseTile.setPoint(3, r2/2, ln-r2/2);
      baseTile.setPoint(4,    0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[7].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(1);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(1);
   }
}

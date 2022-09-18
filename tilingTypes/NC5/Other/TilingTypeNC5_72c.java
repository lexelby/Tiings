package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_72c
   extends TilingType
{
   public TilingTypeNC5_72c(){
      super( "NC5-72c", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {1, 4,3, 0,4,0, 0},
            {0, 0,1, 1,1,0, 0},
            {0, 3,4, 2,4,3, 0},
            {1, 1,0, 3,0,1, 0},
            {2, 4,0, 4,4,3, 0},

            {2, 2,3, 0,1,2, 1},
            {1, 4,3, 6,4,0, 1},
            {0, 0,1, 7,1,0, 1},
            {0, 3,4, 8,4,3, 1},
            {1, 1,0, 9,0,1, 1},
            {2, 4,0,10,4,3, 1},
      };
      info = "a=e\nb+d=2a\nc=d\nA=90\nD=90\nE=90\n(B=45)\n(C=225)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .6;
      double f = ln1 / (1 + 1 / Math.sqrt(2));

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1*2-f, 0);
      baseTile.setPoint(2,ln1,  ln1-f);
      baseTile.setPoint(3,ln1,  ln1);
      baseTile.setPoint(4,  0,  ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(2);
   }
}

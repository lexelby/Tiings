package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_264
   extends TilingType
{
   public TilingTypeNC5_264(){
      super( "NC5-264", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 0,4, 0,0,4, 1},
            {1, 3,4, 1,3,4, 0},
            {1, 2,1, 2,1,2, 0},
            {0, 3,4, 3,3,4, 1},
            {2, 0,4, 4,0,4, 0},

            {2, 0,1, 3,2,3, 1},
            {0, 0,4, 6,0,4, 0},
            {1, 3,4, 7,3,4, 1},
            {1, 2,1, 8,1,2, 1},
            {0, 3,4, 9,3,4, 0},
            {2, 0,4,10,0,4, 1},
      };
      info = "a=e\nb=2c\nc=d\nA=30\nB=240\nC=60\nD=90\n(E=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .2;
      double h = ln * Math.sqrt(3);

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, 4*ln,  0);
      baseTile.setPoint(2, 5*ln, -h);
      baseTile.setPoint(3, 6*ln,  0);
      baseTile.setPoint(4, 3*ln,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[5].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[5].getY(1);
      offsets[2] = tiles[6].getX(3)-tiles[1].getX(1);
      offsets[3] = tiles[6].getY(3)-tiles[1].getY(1);
   }
}

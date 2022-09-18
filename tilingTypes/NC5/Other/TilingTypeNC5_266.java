package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_266
   extends TilingType
{
   public TilingTypeNC5_266(){
      super( "NC5-266", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,4, 0},
            {1, 0,1, 1,2,1, 0},
            {1, 1,2, 2,2,1, 0},
            {0, 2,1, 3,0,1, 0},
            {2, 0,4, 4,0,1, 0},

            {2, 1,0, 0,3,2, 1},
            {0, 0,1, 6,0,4, 1},
            {1, 0,1, 7,2,1, 1},
            {1, 1,2, 8,2,1, 1},
            {0, 2,1, 9,0,1, 1},
            {2, 0,4,10,0,1, 1},
      };
      info = "a=b=2e\nc=3e\nd=e\nA=B\nB+C=180\nC+D=180\n(E=2C)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .08;
      double h = ln * Math.sqrt(15);

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, 8*ln,  0);
      baseTile.setPoint(2, 5*ln,3*h);
      baseTile.setPoint(3, 1*ln,3*h);
      baseTile.setPoint(4, 2*ln,2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[6].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[6].getY(3);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(3);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(3);
   }
}

package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_224
   extends TilingType
{
   public TilingTypeNC5_224(){
      super( "NC5-224", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {2, 0,1, 1,3,2, 1},
            {2, 4,0, 1,0,4, 1},
            {1, 3,2, 3,0,1, 1},
            {0, 1,2, 4,1,2, 0},

            {0, 4,0, 5,0,1, 1},
            {1, 1,2, 6,1,2, 0},
            {2, 0,1, 7,3,2, 0},
            {2, 4,0, 7,0,4, 0},
            {1, 3,2, 9,0,1, 0},
            {0, 1,2,10,1,2, 1},
      };
      info = "a=2b=4d\nc=2e\nB=90\nC=90\nD=270\n(A+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double h2 = ln * Math.sqrt(15);
      double h1 = h2*2/3;

      baseTile.setPoint(0,  0,    0);
      baseTile.setPoint(1,  ln*2, 0);
      baseTile.setPoint(2,  ln*2, h1);
      baseTile.setPoint(3,  ln,   h1);
      baseTile.setPoint(4,  ln,   h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(0)-tiles[1].getX(0);
      offsets[1] = tiles[11].getY(0)-tiles[1].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[1].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[1].getY(0);
   }
}

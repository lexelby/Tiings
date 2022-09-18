package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_237
   extends TilingType
{
   public TilingTypeNC5_237(){
      super( "NC5-237", 5, SymmetryType.pgg);

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {1, 1,0, 0,3,2, 1},
            {0, 3,2, 1,0,1, 1},
            {0, 3,4, 2,4,3, 1},
            {1, 0,1, 3,3,2, 1},
            {2, 3,2, 4,1,0, 0},

            {2, 4,0, 0,0,1, 1},
            {1, 1,0, 6,3,2, 0},
            {0, 3,2, 7,0,1, 0},
            {0, 3,4, 8,4,3, 0},
            {1, 0,1, 9,3,2, 0},
            {2, 3,2,10,1,0, 1},
      };

      info = "a=3d\nb=2d\nc=e\nC=90\nD=90\nE=270\n(A+B=90)";
   }
   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double h = ln * Math.sqrt(2);

      baseTile.setPoint(0,    0,   0);
      baseTile.setPoint(1, ln*2,   0);
      baseTile.setPoint(2, ln*2,   h);
      baseTile.setPoint(3,   ln,   h);
      baseTile.setPoint(4,   ln, 2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[2].getX(0);
      offsets[1] = tiles[1].getY(3)-tiles[2].getY(0);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(4);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(4);
   }
}

package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bf2
   extends TilingType
{
   public TilingTypeN5_01bf2(){
      super( "N5-1bf2", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,0, 0,1,0, 0},
            {1, 1,0, 1,0,1, 0},
            {3, 0,1, 2,4,0, 1},

            {2, 3,4, 3,4,0, 0},
            {0, 4,0, 4,1,0, 0},
            {1, 1,0, 5,0,1, 0},
            {3, 0,1, 6,4,0, 1},
      };
      info = "a=c=e\nb=2a\nA=120\nB=60\nD=90\nE=120\n(C=150)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .2;
      double h = w * Math.sqrt(3);
      
      baseTile.setPoint(0,    0,   0);
      baseTile.setPoint(1,  4*w,   0);
      baseTile.setPoint(2,  3*w,   h);
      baseTile.setPoint(3,    0, 2*h);
      baseTile.setPoint(4,   -w,   h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(2);
      offsets[2] = tiles[1].getX(3)-tiles[5].getX(4);
      offsets[3] = tiles[1].getY(3)-tiles[5].getY(4);
   }
}

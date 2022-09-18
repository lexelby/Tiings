package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_34c
   extends TilingType
{
   public TilingTypeN4_34c(){
      super( "N4-34c", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 2,1, 1,0,1, 1},
            {1, 2,1, 0,1,2, 0},
            {2, 2,1, 3,0,1, 0},
            {0, 0,3, 3,0,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 0,3, 6,0,3, 1},
            {2, 2,1, 7,0,1, 1},
            {1, 2,1, 6,1,2, 0},
            {2, 2,1, 9,0,1, 0},
            {0, 0,3, 9,0,3, 1},
            };
      info = "b=c=d\nA=45\nB=150\nC=60\n(D=105)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .75;
      double h = w*Math.sqrt(3)/2;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  w, 0);
      baseTile.setPoint(2,h+w, w/2);
      baseTile.setPoint(3,  w, w);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[10].getX(3);
      offsets[1] = tiles[0].getY(3)-tiles[10].getY(3);
      offsets[2] = tiles[2].getX(3)-tiles[8].getX(0);
      offsets[3] = tiles[2].getY(3)-tiles[8].getY(0);
   }

}

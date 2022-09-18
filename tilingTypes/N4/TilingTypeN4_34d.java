package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_34d
   extends TilingType
{
   public TilingTypeN4_34d(){
      super( "N4-34d", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 0,1, 1,0,1, 0},
            {2, 2,1, 2,1,2, 0},
            {1, 0,1, 3,0,1, 1},
            {0, 0,3, 4,0,3, 0},

            {0, 0,1, 0,2,3, 1},
            {1, 0,3, 6,0,3, 0},
            {2, 0,1, 7,0,1, 1},
            {2, 2,1, 8,1,2, 1},
            {1, 0,1, 9,0,1, 0},
            {0, 0,3,10,0,3, 1},
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
      offsets[0] = tiles[1].getX(2)-tiles[1].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[1].getY(0);
      offsets[2] = tiles[5].getX(2)-tiles[11].getX(0);
      offsets[3] = tiles[5].getY(2)-tiles[11].getY(0);
   }

}

package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_34a
   extends TilingType
{
   public TilingTypeN4_34a(){
      super( "N4-34a", 4, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,3, 0,0,3, 1},
            {2, 2,3, 0,2,3, 1},
            {2, 3,0, 2,0,3, 1},
            {1, 2,3, 3,2,3, 0},
            {0, 0,3, 4,0,3, 1},
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
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[4].getY(1)-tiles[0].getY(0);
   }

}

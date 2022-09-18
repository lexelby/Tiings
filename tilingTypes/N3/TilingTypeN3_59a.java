package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_59a
   extends TilingType
{
   public TilingTypeN3_59a(){
      super( "N3-59a", 4, SymmetryType.pgg );
      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,2, 0},
            {0, 0,2, 1,0,2, 1},
            {1, 2,3, 2,3,2, 1},
            {2, 1,0, 1,0,3, 1},
            {2, 2,3, 4,3,2, 1},

            {0, 0,3, 5,1,2, 1},
            {1, 2,3, 6,3,2, 1},
            {0, 0,2, 7,0,2, 0},
            {1, 2,3, 8,3,2, 0},
            {2, 1,0, 7,0,3, 0},
            {2, 2,3,10,3,2, 0},
      };
      info = "b=2a\nA=90\n(B+C=60)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*2;
      double os = w*getParam(paramValues,0)/100;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, os,  0);
      baseTile.setPoint(2,  w,  0);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(1)-tiles[3].getX(0);
      offsets[3] = tiles[11].getY(1)-tiles[3].getY(0);
   }
}

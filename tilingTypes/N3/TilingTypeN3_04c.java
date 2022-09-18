package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_04c
   extends TilingType
{
   public TilingTypeN3_04c(){
      super( "N3-4c", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{  0};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {1, 0,1, 0,0,2, 0},
            {0, 1,2, 2,1,2, 1},

            {1, 3,0, 1,0,3, 1},
            {0, 1,2, 4,1,2, 0},
            {1, 0,1, 5,0,2, 0},
            {0, 1,2, 6,1,2, 1},
      };
      info = "c=2b\nA=60\nB=90\n(C=30)";
      labels = new int[]{0,1,2,-1};
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double h = Math.sqrt(3)/2;
      double os = getParam( paramValues,0)/100.;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  h);
      baseTile.setPoint(3,w*os,h*os);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(2)-tiles[0].getY(0);
   }
}

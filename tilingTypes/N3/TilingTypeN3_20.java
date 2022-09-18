package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_20
   extends TilingType
{
   public TilingTypeN3_20(){
      super( "N3-20", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 10};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,1,0, 1},
            {0, 2,1, 1,1,2, 1},

            {2, 2,1, 0,2,1, 1},
            {2, 1,0, 3,0,1, 1},
            {1, 1,2, 4,1,2, 0},

            {1, 3,0, 0,0,3, 0},
            {0, 1,0, 6,1,0, 1},
            {0, 2,1, 7,1,2, 1},

            {2, 2,1, 6,2,1, 1},
            {2, 1,0, 9,0,1, 1},
            {1, 1,2,10,1,2, 0},
      };
      info = "B=90\n(A+C=90)";
      labels = new int[]{0,1,2,-1};
   }

   public void recalcBase(double[] paramValues) {
      double w = getParam( paramValues,0)/100.;
      double h = 1 - w;
      double os = getParam( paramValues,1)/100.;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  h);
      baseTile.setPoint(3,w*os, h*os);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(3)-tiles[5].getX(0);
      offsets[3] = tiles[11].getY(3)-tiles[5].getY(0);
   }
}

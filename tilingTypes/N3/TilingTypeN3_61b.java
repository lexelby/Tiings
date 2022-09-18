package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_61b
   extends TilingType
{
   public TilingTypeN3_61b(){
      super( "N3-61b", 4, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,2,1, 0},
            {1, 3,1, 1,1,3, 0},
            {2, 0,1, 2,0,1, 1},
            {2, 1,3, 3,3,1, 1},
            {0, 2,1, 2,3,0, 0},

      };
      info = "2a=c\nA=90\n(B=30)\n(C=60)";
      labels = new int[]{0,1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*Math.sqrt(3);
      double f = getParam( paramValues,0)/100.;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,f*w,  h*(1-f));
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[5].getY(0)-tiles[0].getY(1);
   }
}

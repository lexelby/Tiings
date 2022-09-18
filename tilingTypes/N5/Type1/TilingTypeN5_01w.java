package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01w
   extends TilingType
{
   public TilingTypeN5_01w(){
      super( "N5-1w", 5, SymmetryType.p3 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Side split" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 4,3, 2,3,4, 0},
            {1, 1,0, 2,1,2, 0},
            {0, 4,3, 4,3,4, 0},
      };
      info = "b=c=a+d\nA=120\nB=120\nC=120\n(D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .3;
      double h = w * Math.sqrt(3);
      double f = getParam(paramValues,0)/100;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, 2*w,   0);
      baseTile.setPoint(2, 3*w,   h);
      baseTile.setPoint(3,(2+f)*w,  (2-f)*h);
      baseTile.setPoint(4,-f*w, f*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[3].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[5].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[5].getY(0);
   }
}

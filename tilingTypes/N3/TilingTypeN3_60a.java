package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_60a
   extends TilingType
{
   public TilingTypeN3_60a(){
      super( "N3-60a", 3, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,2, 0,0,2, 0},
            {1, 1,2, 1,0,2, 0},
            {1, 0,1, 2,1,0, 0},
            {0, 0,2, 3,1,2, 0},
            {2, 0,2, 4,1,2, 0},
      };
      info = "a=c\nA=30\nB=30\n(C=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.5;
      double h = w / Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,w+w,  0);
      baseTile.setPoint(2,  w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues, 0)/100;
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0) + os*offsets[0];
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0) + os*offsets[1];
   }
}

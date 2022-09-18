package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_27
   extends TilingType
{
   public TilingTypeN3_27(){
      super( "N3-27", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {2, 3,2, 1,2,3, 1},
            {2, 1,0, 2,0,1, 1},
            {1, 2,3, 3,3,2, 1},
            {0, 0,1, 4,0,1, 0},

            {0, 3,0, 0,1,3, 1},
            {1, 0,1, 6,0,1, 0},
            {2, 3,2, 7,2,3, 0},
            {2, 1,0, 8,0,1, 0},
            {1, 2,3, 9,3,2, 0},
            {0, 0,1,10,0,1, 1},
      };
      info = "2a=c\nA=90\n(B=30)\n(C=60)";
      labels = new int[]{0,1,-2,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5/(1+Math.sqrt(3));
      double w = h*Math.sqrt(3);
      double f = getParam( paramValues,0)/100;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,f*w,(1-f)*h);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[1].getX(3);
      offsets[1] = tiles[1].getY(1)-tiles[1].getY(3);
      offsets[2] = tiles[11].getX(3)-tiles[5].getX(1);
      offsets[3] = tiles[11].getY(3)-tiles[5].getY(1);
   }
}

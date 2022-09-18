package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_10
   extends TilingType
{
   public TilingTypeN4_10(){
      super( "N4-10", 4, SymmetryType.pgg);

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {1, 2,3, 1,3,2, 1},
            {0, 0,3, 2,0,3, 0},
            
            {1, 1,0, 0,1,2, 0},
            {0, 0,3, 4,0,3, 1},
            {1, 2,3, 4,3,2, 0},
            {0, 0,3, 6,0,3, 1},
      };
      info = "2b=c\nA=90\n2B+C=180\n(C+2D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .75;
      double x2 = lnb/2 * getParam( paramValues,0)/100;
      double y2 = Math.sqrt(4*lnb*lnb - (lnb-x2)*(lnb-x2));
      double y3 = y2 - y2*x2/(lnb-x2);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lnb,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3,  0, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(1);
      offsets[2] = tiles[7].getX(1)-tiles[2].getX(1);
      offsets[3] = tiles[7].getY(1)-tiles[2].getY(1);
   }

}

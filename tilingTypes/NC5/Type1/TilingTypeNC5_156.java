package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_156
   extends TilingType
{
   public TilingTypeNC5_156(){
      super( "NC5-156", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,1, 1,1,4, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 2,1, 1,4,0, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,1, 5,1,4, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "c=e\n2a=c+d\nA=90\nC=D\nC+D=360\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 0.7;
      double lnd = lnb * getParam(paramValues,0)/100;
      double lnce = lnb*2 - lnd;
      
      double dy = (lnb+lnd)/2;
      double dx = Math.sqrt(lnce*lnce-dy*dy);
      double lna = 2*dx;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0);
      baseTile.setPoint(2,  lna -dx, dy);
      baseTile.setPoint(3,  dx, lnb-dy);
      baseTile.setPoint(4,  0, lnb);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(4);
      offsets[2] = tiles[0].getX(2)-tiles[7].getX(1);
      offsets[3] = tiles[0].getY(2)-tiles[7].getY(1);
   }
}

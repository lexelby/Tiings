package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_145
   extends TilingType
{
   public TilingTypeNC5_145(){
      super( "NC5-145", 5, SymmetryType.pgg );

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

            {0, 4,0, 0,3,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,1, 5,1,4, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "c=e=2a+d\nA=90\nC=D\nC+D=360\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 0.5;
      double lnd = lna * getParam(paramValues,0)/100;
      double lnce = lna*2 + lnd;
      
      double dy = (lna+lnd)/2;
      double dx = Math.sqrt(lnce*lnce-dy*dy);
      double lnb = 2*dx;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb -dx, dy);
      baseTile.setPoint(3,  dx, lna-dy);
      baseTile.setPoint(4,  0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(4);
   }
}

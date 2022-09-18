package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_138
   extends TilingType
{
   public TilingTypeNC5_138(){
      super( "NC5-138", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 4,0, 2,0,4, 0},
      };
      info = "a=d\nc=b+e\nA=B\nD+E=360\nA+E=180\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double lna = lntotal * (getParam(paramValues,0)/200 + 1)/3;
      double lnb = lntotal - lna;
      double lnce = lnb/2;
      double lnd = lnb-lna;

      double dx = (lna-lnd)/4;
      double dy = Math.sqrt(lnce*lnce-dx*dx);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0);
      baseTile.setPoint(2,  lna-2*dx, 2*dy);
      baseTile.setPoint(3,  dx+lnd, dy);
      baseTile.setPoint(4,  dx, dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[2].getY(2)-tiles[3].getY(1);
   }
}

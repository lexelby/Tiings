package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_92
   extends TilingType
{
   public TilingTypeNC5_92(){
      super( "NC5-92", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,3,4, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 3,4, 2,1,0, 0},

            {0, 4,0, 1,2,3, 1},
            {1, 1,0, 4,3,4, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 3,4, 6,1,0, 1},
      };
      info = "a=d\nb=c=e\nB+D=360\nB+C=180\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double lnb = lntotal * (getParam(paramValues, 0)+100)/300;
      double lna = lntotal - lnb;
      double s = Math.sqrt((2*lna-lnb)/4/lnb);
      double c = Math.sqrt(1-s*s);
      c *=lnb;
      s *=lnb;
      
      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1, lnb,    0);
      baseTile.setPoint(2, c+lnb, s);
      baseTile.setPoint(3, c+lnb-lna, s);
      baseTile.setPoint(4, lnb-lna, s+s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(1);
      offsets[2] = tiles[5].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(3)-tiles[0].getY(0);
   }
}

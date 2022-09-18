package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_171
   extends TilingType
{
   public TilingTypeNC5_171(){
      super( "NC5-171", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,3, 1,3,2, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 4,0, 0,1,2, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 2,3, 5,3,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "2a=c=d+e\nA=90\nC+E=180\nC+D=360\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnd = 0.4;
      double lnb = 2 * lnd;
      double lna = lnb * getParam(paramValues,0)/100;
      double lne = lnb - lna;

      double a1 = 2 * lna;
      double a2 = lne + lnb;
      double a3 = -lnd-lna;
      double s1 = (-a2+Math.sqrt(a2*a2-4*a1*a3))/2/a1;
      double c1 = Math.sqrt(1-s1*s1);
      double s2 = 2*s1*c1;
      double c2 = c1*c1-s1*s1;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  (lne+lnb)*c1 + lna*s2, lnd - (lne+lnb)*s1 + lna*c2 );
      baseTile.setPoint(2,  lne*c1 + lna*s2, lnd - lne*s1 + lna*c2 );
      baseTile.setPoint(3,  lne*c1, lnd - lne*s1 );
      baseTile.setPoint(4,  0, lnd);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[4].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(4);
   }
}

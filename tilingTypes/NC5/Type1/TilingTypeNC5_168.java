package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_168
   extends TilingType
{
   public TilingTypeNC5_168(){
      super( "NC5-168", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {1, 3,4, 1,4,3, 0},
            {0, 2,3, 2,2,1, 0},

            {0, 0,1, 1,0,1, 1},
            {1, 2,1, 4,2,3, 1},
            {1, 3,4, 5,4,3, 1},
            {0, 2,3, 6,2,1, 1},
      };
      info = "c=d\na+e=2c\nC=90\nD+E=360\n2A+E=180\n(A+B=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnab = 0.6;
      double lne =  lnab * getParam(paramValues,0)/100;
      double lnd = lnab*2-lne;
      
      double t = lnab / (lnab + lnd-lne);
      double c = 1/Math.sqrt(1+t*t);
      double s = t*c;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  (lnd+lne+lnab)*c + lnab*s, 0);
      baseTile.setPoint(2,  (lnd+lne+lnab)*c, (lnd-lne+lnab)*s);
      baseTile.setPoint(3,  (lnd+lne)*c, (lnd-lne)*s);
      baseTile.setPoint(4,  lnd*c, lnd*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(0);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[7].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[7].getY(0);
   }
}

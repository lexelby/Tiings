package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_164
   extends TilingType
{
   public TilingTypeNC5_164(){
      super( "NC5-164", 5, SymmetryType.pgg);

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 2,0, 1,0,2, 0},
            {0, 1,2, 2,1,0, 0},

            {0, 2,3, 0,4,0, 1},
            {1, 1,0, 4,1,2, 1},
            {1, 2,0, 5,0,2, 1},
            {0, 1,2, 6,1,0, 1},
      };
      info = "b=c\na=d\nB=90\nA=E\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnd = lna * getParam(paramValues,0)/100;
      
      double ta = lna/(lna-lnd);
      double t2a = 2*ta / (1-ta*ta);
      double h = Math.sqrt(1+t2a*t2a);
      double dy = lnd/2 * t2a/h;
      double dx = lnd/2 * 1/h;
     
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna, lna);
      baseTile.setPoint(3, lna/2+dx, lna/2+dy);
      baseTile.setPoint(4, lna/2-dx, lna/2-dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(3);
   }
}

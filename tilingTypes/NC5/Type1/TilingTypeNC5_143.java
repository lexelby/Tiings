package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_143
   extends TilingType
{
   public TilingTypeNC5_143(){
      super( "NC5-143", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 2,1, 1,1,2, 1},
            {1, 0,1, 2,0,1, 0},
            
            {1, 4,0, 1,4,3, 1},
            {0, 0,1, 4,0,1, 0},
            {0, 2,1, 5,1,2, 0},
            {1, 0,1, 6,0,1, 1},
      };
      info = "e=2a=c+d\nA=90\n2B+C=180\nC+D=360\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = .5;
      double lnc = lna * getParam(paramValues,0)/100;
      double lnb = 2*lna;
      double lnd = lnb-lnc;

      double lnt = lnb-lnc+lnd;
      double s = lna/lnt;
      double c = Math.sqrt(1-s*s);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  (lnb+lnc+lnd)*c, 0);
      baseTile.setPoint(2,  (lnb+lnc)*c, lna-(lnb-lnc)*s);
      baseTile.setPoint(3,  lnb*c, lna-lnb*s);
      baseTile.setPoint(4,  0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[1].getY(3);
      offsets[2] = tiles[2].getX(4)-tiles[7].getX(4);
      offsets[3] = tiles[2].getY(4)-tiles[7].getY(4);
   }
}

package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bv
   extends TilingType
{
   public TilingTypeN5_01bv(){
      super( "N5-1bv", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
            {2, 2,1, 1,0,4, 1},
            
            {1, 1,0, 2,4,0, 1},
            {0, 3,4, 3,4,3, 1},
            {2, 2,1, 4,0,4, 0},
      };
      info = "a+d=c\nb+d=a\nA=B\nA=E\nD+E=180\n(2A+C=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = .8;
      double lnb = lna*getParam(paramValues, 0)/200.;
      double lnd = lna-lnb;
      double lne = lna-2*lnb;
      double c = lnb/lna;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0, 0,   0);
      baseTile.setPoint(1, lne, 0);
      baseTile.setPoint(2, lne+lna*c, lna*s);
      baseTile.setPoint(3, lne+lna*c-lnb*c, lna*s+lnb*s);
      baseTile.setPoint(4, -lnd*c, lnd*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[5].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(3)-tiles[0].getY(0);
   }
}

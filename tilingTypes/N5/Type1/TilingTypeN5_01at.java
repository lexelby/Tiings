package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01at
   extends TilingType
{
   public TilingTypeN5_01at(){
      super( "N5-1at", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {0, 3,2, 0,4,0, 0},
            {0, 3,2, 1,4,0, 0},
      };
      info = "d=a+e\nc=e\nB=C\nB=E\nA+B=180\n(2A=D)";
   }

   public void recalcBase(double[] paramValues) {
      double lnd = 1;
      double lne = lnd * getParam(paramValues,0)/100.;
      double lna = lnd-lne;
      double a = Math.acos((lna-lne)/2/lnd)/DEG2RAD;

      double cs = Math.cos(a*DEG2RAD);
      double sn = Math.sin(a*DEG2RAD);

      baseTile.setPoint(0,       0,          0);
      baseTile.setPoint(1, lnd+lne,          0);
      baseTile.setPoint(2, lnd+lne + lne*cs, lne*sn);
      baseTile.setPoint(3,     lne + lna*cs, lna*sn);
      baseTile.setPoint(4,           lna*cs, lna*sn);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[2].getX(4);
      offsets[3] = tiles[3].getY(0)-tiles[2].getY(4);
   }
}

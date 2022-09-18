package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ae
   extends TilingType
{
   public TilingTypeN5_01ae(){
      super( "N5-1ae: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,0, 1},
            {1, 0,1, 1,1,0, 1},
            {0, 1,0, 2,2,1, 0},

            {0, 1,2, 0,4,0, 1},
            {1, 2,1, 4,1,0, 0},
            {1, 0,1, 5,1,0, 0},
            {0, 1,0, 6,2,1, 1},
      };
      info = "a=c\nd=e\n2c=b+d\nA+B=180\nB=C\nC=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      final double s = Math.sin(18*DEG2RAD);
      final double c = Math.cos(18*DEG2RAD);
      final double s2= Math.sin(36*DEG2RAD);
      final double c2= Math.cos(36*DEG2RAD);
      final double lnc = .4;
      final double lna = 2*c2*lnc;
      final double lnb = (lnc + lna)/2;
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, lna,   0);
      baseTile.setPoint(2, lna + lnb*s,  lnb*c);
      baseTile.setPoint(3, lnb*s + lna/2,  lnb*c+lnc*s2);
      baseTile.setPoint(4, lnb*s,  lnb*c);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[4].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[4].getY(4);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(1);
   }
}

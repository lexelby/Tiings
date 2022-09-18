package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01aa
   extends TilingType
{
   public TilingTypeN5_01aa(){
      super( "N5-1aa", 5, SymmetryType.pgg );

      paramMin = new int[]{108};
      paramMax = new int[]{180};
      paramDef = new int[]{130};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,0,4, 1},
            {0, 1,2, 0,4,3, 0},
            {1, 0,4, 2,0,4, 1},

            {1, 2,1, 0,1,2, 0},
            {0, 0,4, 4,0,4, 1},
            {0, 1,2, 4,4,3, 0},
            {1, 0,4, 6,0,4, 1},
      };
      info = "c=e=d+2b\nA=90\nC+2D=360\nB+C=180\n(D+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double lnd = 1;
      double e = paramValues[0];
      double a = 180-e;
      double b = 180-a/2;

      // lnd - lne * cos(e) = lna - lne * cos(b)
      // lnd = lna + lne * (cos(e) - cos(b))
      // using lne=lna+2*lnd
      // lnd = lna + (lna+2*lnd) * (cos(e) - cos(b))
      double cs = Math.cos(e * DEG2RAD) - Math.cos(b * DEG2RAD);
      // lnd = lna + lna*c + 2*lnd*c
      // lnd = lna*(1+c) + 2*lnd*c
      // lna*(1+c) = lnd * (1 - 2*c)
      // lna = lnd * (1 - 2*c) / (1+c)
      double lna = lnd * (1-2*cs)/(1+cs);
      double lne = lna + 2 * lnd;
      
      // scale
      double f = 3/(lnd+2*lne+lna);
      lna *= f;
      lnd *= f;
      lne *= f;
      
      double x2 = lnd+ lne*Math.cos( (180-e) * DEG2RAD);
      double y2 =      lne*Math.sin( (180-e) * DEG2RAD);
      double x3 = x2 - lna;
      double y3 = y2;
      double x4 = x3 + lne*Math.cos( -b * DEG2RAD);
      double y4 = y3 + lne*Math.sin( -b * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lnd,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[1].getX(1);
      offsets[1] = tiles[2].getY(4)-tiles[1].getY(1);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(1);
   }
}

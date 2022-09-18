package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01aq
   extends TilingType
{
   public TilingTypeN5_01aq(){
      super( "N5-1aq", 5, SymmetryType.pgg );

      paramMin = new int[]{ 29};
      paramMax = new int[]{180};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 1,2, 2,2,3, 0},

            {0, 3,2, 2,4,0, 1},
            {1, 2,3, 4,1,2, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "2a=d+e\nc=d\nA=90\n2B+C=360\nC+D=180\n(B+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double b = 180-c/2;
      
      double h = 2 * Math.sin(b*DEG2RAD);
      // lna = f*h, lne = 2*(1-f)
      // 2 lna = lnd + lne
      // 2fh = 1 + 2(1-f)
      // f(2h+2) = 3
      // f = 3/(2h+2)
      double f = 3/(1+h)/2;
      double lne = 2 * (1-f);
      double lna = h*f;
      double lnb = Math.sqrt(lne*lne-(h-lna)*(h-lna));
      double dx = Math.sqrt(1-h*h/4);
      // scale
      double s = 2 / (lnb+dx+h);
      lnb *= s;
      lna *= s;
      dx *= s;
      h *= s;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, lnb,   0);
      baseTile.setPoint(2, lnb+dx, h/2);
      baseTile.setPoint(3, lnb,   h);
      baseTile.setPoint(4,   0,   lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(4);
      offsets[2] = tiles[1].getX(4)-tiles[4].getX(4);
      offsets[3] = tiles[1].getY(4)-tiles[4].getY(4);
   }
}

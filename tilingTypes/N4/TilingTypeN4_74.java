package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_74
   extends TilingType
{
   public TilingTypeN4_74(){
      super( "N4-74", 4, SymmetryType.pgg );

      paramMin = new int[]{ 45};
      paramMax = new int[]{180};
      paramDef = new int[]{140};
      paramName = new String[]{"Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 2,3, 1,2,3, 1},
            {1, 1,0, 2,1,2, 1},

            {0, 3,0, 0,0,3, 0},
            {1, 1,0, 4,1,2, 0},
            {0, 2,3, 5,2,3, 1},
            {1, 1,0, 6,1,2, 1},
      };
      info = "b=c\nB=90\nA+2C=360\n(C-D=90)";
   }
   
   public void recalcBase(double[] paramValues) {
      double a = getParam(paramValues,0);
      double d = (180 - a)/2;
      double a2 = a-45;
      double c2 = 180-d-a2;
      double lnd = Math.sqrt(2) / Math.sin(d * DEG2RAD) * Math.sin(c2 * DEG2RAD);

      // scale
      double f = 1.5 / (1 + lnd);
      double lna = 1.0 * f;
      lnd *= f;
      
      double x3 =      lnd * Math.cos(a * DEG2RAD);
      double y3 =      lnd * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1,lna,   0);
      baseTile.setPoint(2,lna, lna);
      baseTile.setPoint(3, x3,  y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(2);
      offsets[2] = tiles[6].getX(0)-tiles[2].getX(3);
      offsets[3] = tiles[6].getY(0)-tiles[2].getY(3);
   }
}

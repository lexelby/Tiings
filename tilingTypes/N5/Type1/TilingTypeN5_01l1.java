package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01l1
   extends TilingType
{
   public TilingTypeN5_01l1(){
      super( "N5-1l1: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{100, 30};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
            {1, 0,4, 0,1,2, 0},
            {1, 0,4, 1,1,2, 0},

            {1, 1,0, 2,4,3, 1},
            {0, 1,2, 4,0,4, 1},
            {0, 3,4, 5,4,3, 1},
            {1, 0,4, 6,1,2, 1},
      };
      info = "a=c=d\nA+B=180\nB=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0];
      double lnb = getParam( paramValues,1) / 100;
      double lnc = 1 - lnb;
      double lna = calcSide(lnb,lnc,f);
      double c = 180-calcAngle(lna,lnb,lnc);

      double x4 = lnb * Math.cos( (180-f) * DEG2RAD);
      double y4 = lnb * Math.sin( (180-f) * DEG2RAD);
      double x2 = lna+ x4;
      double y2 =      y4;
      double x3 = x4 + lnc * Math.cos( (c-f) * DEG2RAD);
      double y3 = y4 + lnc * Math.sin( (c-f) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lna,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[4].getX(4);
      offsets[1] = tiles[2].getY(1)-tiles[4].getY(4);
      offsets[2] = tiles[7].getX(2)-tiles[0].getX(4);
      offsets[3] = tiles[7].getY(2)-tiles[0].getY(4);
   }
}

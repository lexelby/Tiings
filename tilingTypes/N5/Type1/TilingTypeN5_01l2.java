package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01l2
   extends TilingType
{
   public TilingTypeN5_01l2(){
      super( "N5-1l2: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{100, 30};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {2, 1,2, 0,0,4, 0},
            {2, 3,2, 1,2,3, 0},
            {1, 0,4, 2,1,2, 0},
            {0, 0,4, 0,1,2, 0},
            {0, 0,4, 3,1,2, 0},

            {0, 1,0, 4,4,3, 1},
            {1, 1,2, 6,0,4, 1},
            {2, 1,2, 7,0,4, 1},
            {2, 3,2, 8,2,3, 1},
            {1, 0,4, 9,1,2, 1},
            {0, 0,4,10,1,2, 1},
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
      offsets[0] = tiles[4].getX(1)-tiles[6].getX(4);
      offsets[1] = tiles[4].getY(1)-tiles[6].getY(4);
      offsets[2] = tiles[11].getX(4)-tiles[5].getX(1);
      offsets[3] = tiles[11].getY(4)-tiles[5].getY(1);
   }
}

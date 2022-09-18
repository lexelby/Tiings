package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_230
   extends TilingType
{
   public TilingTypeNC5_230(){
      super( "NC5-230", 5, SymmetryType.pgg );

      paramMin = new int[]{0};
      paramMax = new int[]{90};
      paramDef = new int[]{65};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 0,2, 1,2,0, 0},
            {0, 0,1, 2,1,0, 0},
            {2, 0,1, 3,2,1, 0},
            {2, 0,2, 4,2,0, 0},

            {0, 3,2, 0,4,3, 1},
            {1, 1,0, 6,0,1, 1},
            {1, 0,2, 7,2,0, 1},
            {0, 0,1, 8,1,0, 1},
            {2, 0,1, 9,2,1, 1},
            {2, 0,2,10,2,0, 1},
      };
      info = "a=d\nb=2c\ne=c+2d\nB=C\nD+E=360\n(A+B+C=180)";
   }
   public void recalcBase(double[] paramValues) {
      double lnb = .5;
      double b = getParam(paramValues,0);

      double diag = calcSide(2*lnb, lnb, b); // a=2, b=1
      double r = calcAngle(diag, lnb, 2*lnb) - b;
      double lnc = (diag*diag - lnb*lnb) / 4/(lnb + diag * Math.cos(r*DEG2RAD));
      double a = 180 - b *2;
      double lna = lnb*2;

      double x4 =       lnc*Math.cos( a * DEG2RAD);
      double y4 =       lnc*Math.sin( a * DEG2RAD);
      double x2 = lna + lnb*Math.cos( (180-b) * DEG2RAD);
      double y2 =       lnb*Math.sin( (180-b) * DEG2RAD);
      double x3 = x2 - x4;
      double y3 = y2 - y4;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lna,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[5].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(3)-tiles[9].getX(4);
      offsets[3] = tiles[3].getY(3)-tiles[9].getY(4);
   }

}

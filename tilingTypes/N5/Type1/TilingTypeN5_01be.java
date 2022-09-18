package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01be
   extends TilingType
{
   public TilingTypeN5_01be(){
      super( "N5-1be: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 80, 40, 50};
      paramName = new String[]{ "Angle", "Relative length 1", "Relative length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,2,3, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 2,3, 2,4,0, 0},

            {0, 1,2, 0,0,1, 1},
            {1, 4,0, 4,2,3, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 2,3, 6,4,0, 1},
      };
      info = "a=d\nb=2c=2e\nA+E=180\nA=C\n(B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lnad = lnt * getParam(paramValues,1)/100;
      double lnb = lnt - lnad;
      double a = getParam(paramValues,0);
      double lnc = lnb * getParam(paramValues,2)/100;
      double lne = lnb - lnc;

      double diag = calcSide(lnad, lnc, a);
      double b = 2 * calcAngle(diag, lnc, lnad);
      
      double x4 =       lnad * Math.cos(a * DEG2RAD);
      double y4 =       lnad * Math.sin(a * DEG2RAD);
      double x2 = lnb + lnc * Math.cos((180-b) * DEG2RAD);
      double y2 =       lnc * Math.sin((180-b) * DEG2RAD);
      
      baseTile.setPoint(0,    0,   0);
      baseTile.setPoint(1,  lnb,   0);
      baseTile.setPoint(2,   x2,  y2);
      baseTile.setPoint(3,x4+lne,y4);
      baseTile.setPoint(4,   x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(0)-tiles[1].getY(3);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}

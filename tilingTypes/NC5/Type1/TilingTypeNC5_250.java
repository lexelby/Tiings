package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_250
   extends TilingType
{
   public TilingTypeNC5_250(){
      super( "NC5-250", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{110};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 3,4, 0,1,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 1,4, 1,4,1, 0},
            {0, 0,1, 2,1,0, 0},
            {2, 1,0, 0,3,4, 0},
            {2, 1,0, 3,3,4, 0},

            {0, 4,0, 0,1,2, 1},
            {1, 1,0, 6,0,1, 1},
            {1, 1,4, 7,4,1, 1},
            {0, 0,1, 8,1,0, 1},
            {2, 1,0, 6,3,4, 1},
            {2, 1,0, 9,3,4, 1},
      };
      info = "a=d\nb=2a\nc=e\nA+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnce = lna/2;
      double a = getParam(paramValues, 0);
      double c = Math.cos(a*DEG2RAD);
      double s = Math.sin(a*DEG2RAD);
      double lnbd = lnce * (1-c);
      double diag = calcSide(lnce,lna,a);
      double b1 = calcAngle(diag,lna,lnce);
      double b2 = calcAngle(diag,lnbd*2,lnce);
      double b = b1+b2;
      
      double x4 = lnce * c;
      double y4 = lnce * s;
      double dx = lnbd * Math.cos(b*DEG2RAD);
      double dy = lnbd * Math.sin(b*DEG2RAD);

      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-dx, dy);
      baseTile.setPoint(3, x4+dx, y4-dy);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(1)-tiles[5].getX(4);
      offsets[1] = tiles[4].getY(1)-tiles[5].getY(4);
      offsets[2] = tiles[6].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[6].getY(1)-tiles[0].getY(4);
   }
}

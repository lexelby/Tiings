package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_248
   extends TilingType
{
   public TilingTypeNC5_248(){
      super( "NC5-248", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{120,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 1,0, 2,0,1, 0},
            {2, 1,0, 3,3,4, 0},
            {2, 4,1, 4,1,4, 0},
      };
      info = "a=d\nc=e\nA+C=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.0;

      double a = getParam(paramValues, 0);
      double c = 180-a;
      
      double max = 1/(1.5- Math.cos(a*DEG2RAD));
      double lnce = ln * max * getParam(paramValues, 1)/100;
      double lnbd = ln - lnce;
      double diag = calcSide(lnbd*2, lnce, c);
      double b1 = calcAngle(diag, lnbd*2, lnce);
      double b2 = Math.asin(Math.sin(a * DEG2RAD) * lnce / diag) / DEG2RAD;
      double b = b1+b2;

      double x4 =      lnce * Math.cos(a*DEG2RAD);
      double y4 =      lnce * Math.sin(a*DEG2RAD);
      double x3 = x4 + lnbd * Math.cos(-b*DEG2RAD);
      double y3 = y4 + lnbd * Math.sin(-b*DEG2RAD);
      double x2 = x3 + lnce * Math.cos((-b+180-c)*DEG2RAD);
      double y2 = y3 + lnce * Math.sin((-b+180-c)*DEG2RAD);
      double x1 = x2 + x3-x4;
      double y1 = y2 + y3-y4;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(3);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(3);
   }
}

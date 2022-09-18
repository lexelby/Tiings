package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_129
   extends TilingType
{
   public TilingTypeNC5_129(){
      super( "NC5-129", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 65};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,0,1, 1},
            {0, 0,4, 0,3,2, 1},
            {1, 2,3, 2,0,1, 0},
      };
      info = "a=b=d\nc=a+e\nB+E=180\nB+D=360\n(A+C+E=180)\n(A=E)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.2;
      double lnd = lntotal * getParam(paramValues,0)/200;
      double lnace = lntotal - lnd;
      double lnb = lnace + lnd;

      double b = 2 * Math.asin(Math.sqrt((3*lnace-lnd)/4/lnace))/DEG2RAD;

      double x1 = lnace;
      double y1 = 0;
      double x2 = x1 + lnb * Math.cos((180-b)*DEG2RAD);
      double y2 = y1 + lnb * Math.sin((180-b)*DEG2RAD);
      double x4 =      lnace * Math.cos((180-b)*DEG2RAD);
      double y4 =      lnace * Math.sin((180-b)*DEG2RAD);
      double x3 = x4 + lnd * Math.cos((180-b-b)*DEG2RAD);
      double y3 = y4 + lnd * Math.sin((180-b-b)*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(4)-tiles[3].getX(1);
      offsets[3] = tiles[1].getY(4)-tiles[3].getY(1);
   }
}

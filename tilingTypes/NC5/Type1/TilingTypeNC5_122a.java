package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_122a
   extends TilingType
{
   public TilingTypeNC5_122a(){
      super( "NC5-122a", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,3,4, 1},
            {1, 2,3, 0,1,2, 1},
            {1, 0,1, 2,3,4, 0},
      };
      info = "a=b=e\nc=d\nB+C=360\nB+E=180\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;

      double ln1 = lntotal * (.5 + getParam(paramValues, 0)/200);
      double ln2 = lntotal - ln1;

      double cs = 2*ln2*(ln1+ln2);
      cs = (cs-ln1*ln1)/(cs+2*ln1*ln1);
      double b = Math.acos(cs)/DEG2RAD;
      double diag = calcSide(ln1+ln2,ln2,b);
      double a = calcAngle(ln1+ln2,diag,ln2) + b/2;

      double x1 = ln1;
      double y1 = 0;      
      double x2 = x1 + ln2 * Math.cos((180-b)*DEG2RAD);
      double y2 = y1 + ln2 * Math.sin((180-b)*DEG2RAD);
      double x3 = x2 + ln2;
      double y3 = y2;
      double x4 =  ln1 * Math.cos(a*DEG2RAD);
      double y4 =  ln1 * Math.sin(a*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[2].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[2].getY(0);
   }
}

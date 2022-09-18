package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_118
   extends TilingType
{
   public TilingTypeNC5_118(){
      super( "NC5-118", 5, SymmetryType.pgg );

      paramMin = new int[]{ 90};
      paramMax = new int[]{240};
      paramDef = new int[]{130};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,0, 1,0,2, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 1,2, 0,4,0, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 2,0, 5,0,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=c=d=e\n2B+E=360\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.7;

      double e = getParam(paramValues, 0);
      double b = 180-e/2;

      double diag = calcSide(ln,ln/2,e);
      double a1 = Math.asin(Math.sin(b*DEG2RAD)/2/diag * ln)/DEG2RAD;
      double a = a1 + calcAngle(diag,ln,ln/2) * (e<180?1:-1);

      double x4 = ln * Math.cos(a * DEG2RAD);
      double y4 = ln * Math.sin(a * DEG2RAD);
      double x3 = x4 + ln * Math.cos((a+e-180) * DEG2RAD);
      double y3 = y4 + ln * Math.sin((a+e-180) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = x2 + ln * Math.cos(-b * DEG2RAD);
      double y1 = y2 + ln * Math.sin(-b * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  x1, y1);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(3);
      offsets[2] = tiles[4].getX(4)-tiles[0].getX(1);
      offsets[3] = tiles[4].getY(4)-tiles[0].getY(1);
   }
}

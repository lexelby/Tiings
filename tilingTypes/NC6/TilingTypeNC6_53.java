package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_53
   extends TilingType
{
   public TilingTypeNC6_53(){
      super( "NC6-53", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{360,100,360};
      paramDef = new int[]{130, 65, 95};
      paramName = new String[]{"Angle 1", "Relative Length", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 3,2, 2,2,3, 0},

            {0, 3,4, 0,1,2, 1},
            {1, 3,2, 4,2,3, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 3,2, 6,2,3, 1},
      };
      info = "b=f\na=c=e\nA+B=360\nB=E\n(C+D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;

      double cf = getParam(paramValues, 0);
      double d = getParam(paramValues, 2);

      double x1 = ln1;
      double y1 =   0;
      double x2 = x1 + ln2 * Math.cos( (180-cf) * DEG2RAD );
      double y2 = y1 + ln2 * Math.sin( (180-cf) * DEG2RAD );
      double x5 = x1 - x2;
      double y5 = y1 - y2;
      double x4 = x5 + ln1 * Math.cos( (-cf-180+d) * DEG2RAD );
      double y4 = y5 + ln1 * Math.sin( (-cf-180+d) * DEG2RAD );
      double x3 = x4 + ln2 * Math.cos( d * DEG2RAD );
      double y3 = y4 + ln2 * Math.sin( d * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(5);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(5);
      offsets[2] = tiles[4].getX(5)-tiles[3].getX(2);
      offsets[3] = tiles[4].getY(5)-tiles[3].getY(2);
   }
}
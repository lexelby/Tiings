package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_142
   extends TilingType
{
   public TilingTypeNC5_142(){
      super( "NC5-142", 5, SymmetryType.p2 );

      paramMin = new int[]{ 72};
      paramMax = new int[]{162};
      paramDef = new int[]{150};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,2, 0,3,4, 0},
            {0, 3,4, 1,4,3, 0},
            {1, 3,4, 2,3,2, 0},
      };
      info = "a=d=e\nB=D\nC+E=360\nC=2B\n(A+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues,0)/2;

      double x4 = ln * Math.cos((180-a-a)*DEG2RAD);
      double y4 = ln * Math.sin((180-a-a)*DEG2RAD);
      double x3 = x4 + ln * Math.cos((-4*a)*DEG2RAD);
      double y3 = y4 + ln * Math.sin((-4*a)*DEG2RAD);
      double x2 = x3 + ln * Math.cos((180-3*a)*DEG2RAD);
      double y2 = y3 + ln * Math.sin((180-3*a)*DEG2RAD);
      double c = Math.cos(-a*DEG2RAD);
      double s = Math.sin(-a*DEG2RAD);
      double ln2 = -y2/s;
      double x1 = x2 + ln2 * c;
      double y1 = y2 + ln2 * s;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[1].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[1].getY(1);
   }
}

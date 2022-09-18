package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01p1
   extends TilingType
{
   public TilingTypeN5_01p1(){
      super( "N5-1p1", 5, SymmetryType.pg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{120};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,0,4, 1},
            {1, 0,4, 1,3,4, 1},
            {1, 0,4, 0,3,4, 0},
            };
      info = "a=c=d=e\n2A+D=360\nC+2E=360\n(2B+C+D=360)\n(D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double e = paramValues[0];
      double a = 90+e/2;
      double ln = .75;

      double x4 = ln*Math.cos( (a) * DEG2RAD);
      double y4 = ln*Math.sin( (a) * DEG2RAD);
      double x3 = x4 + ln*Math.cos( (a-180+e) * DEG2RAD);
      double y3 = y4 + ln*Math.sin( (a-180+e) * DEG2RAD);
      double x2 = x3 + ln*Math.cos( (a+180) * DEG2RAD);
      double y2 = y3 + ln*Math.sin( (a+180) * DEG2RAD);
      double x1 = x2 + ln*Math.cos( (a-2*e) * DEG2RAD);
      double y1 = y2 + ln*Math.sin( (a-2*e) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(2);
      offsets[2] = tiles[2].getX(1)-tiles[2].getX(3);
      offsets[3] = tiles[2].getY(1)-tiles[2].getY(3);
   }
}

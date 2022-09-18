package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_01a
   extends TilingType
{
   public TilingTypeNC5_01a(){
      super( "NC5-1a: Bob Jenkins", 5, SymmetryType.p2 );

      paramMin = new int[]{120};
      paramMax = new int[]{287};
      paramDef = new int[]{270};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,3,2, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 3,2, 2,1,2, 0},
      };
      info = "b=c=d=e\nB+D=360\nB=2C\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double e = paramValues[0];
      double d = 180-e/2;
      double c = d+d;

      double x2 = ln + ln*Math.cos( (180-c) * DEG2RAD);
      double y2 =      ln*Math.sin( (180-c) * DEG2RAD);
      double x3 = x2 + ln*Math.cos( (-c-d) * DEG2RAD);
      double y3 = y2 + ln*Math.sin( (-c-d) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (-d+180) * DEG2RAD);
      double y4 = y3 + ln*Math.sin( (-d+180) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}

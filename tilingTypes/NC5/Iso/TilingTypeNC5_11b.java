package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_11b
   extends TilingType
{
   public TilingTypeNC5_11b(){
      super( "NC5-11b: Trisected triangles", 5, SymmetryType.p6m );

      paramMin = new int[]{-120,  0};
      paramMax = new int[]{ 120,100};
      paramDef = new int[]{  30, 50};
      paramName = new String[]{ "Angle", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,3, 0,1,3, 0},
            {0, 0,3, 1,1,3, 0},
            {0, 0,1, 1,0,1, 1},
            {0, 0,3, 3,1,3, 1},
            {0, 0,3, 4,1,3, 1},
      };
      info = "a=c\nd=e\nC+E=360\nD=120\n(A+B=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .75;
      double an = paramValues[0];
      double ln2 = paramValues[1] *ln*2 * Math.sqrt(3)/6 / Math.cos((Math.abs(an)-60)*DEG2RAD) / 100;
      double x3 = ln;
      double y3 = ln*Math.sqrt(3)/3;
      double x2 = x3 + ln2 * Math.cos( (an-30) * DEG2RAD);
      double y2 = y3 + ln2 * Math.sin( (an-30) * DEG2RAD);
      double x4 = x3 + ln2 * Math.cos( (an-150) * DEG2RAD);
      double y4 = y3 + ln2 * Math.sin( (an-150) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 2*ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(0);
   }
}

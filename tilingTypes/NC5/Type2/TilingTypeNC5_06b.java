package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_06b
   extends TilingType
{
   public TilingTypeNC5_06b(){
      super( "NC5-6b", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,360};
      paramDef = new int[]{ 30,150};
      paramName = new String[]{ "Angle 1", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,0,1, 1},
            {0, 3,4, 0,2,3, 1},
            {1, 3,4, 2,0,1, 0},
      };
      info = "a=b=d=e\nA+D=360\n2C+D+E=360\nA+2B+E=360\n(B+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double d = paramValues[0];   // tip angle
      double c = paramValues[1];   // tab/indentation angle
      double ln = .6;

      double x4 =      ln*Math.cos( c * DEG2RAD);
      double y4 =      ln*Math.sin( c * DEG2RAD);
      double x3 = x4 - ln*Math.cos( (c+d) * DEG2RAD);
      double y3 = y4 - ln*Math.sin( (c+d) * DEG2RAD);
      double x2 = x3 + ln*Math.cos( d * DEG2RAD);
      double y2 = y3 + ln*Math.sin( d * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(1);
   }
}

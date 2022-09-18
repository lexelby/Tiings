package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_02a
   extends TilingType
{
   public TilingTypeN5_02a(){
      super( "N5-2a: Marjorie Rice", 5, SymmetryType.p2 );

      paramMin = new int[]{ 45};
      paramMax = new int[]{144};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 4,3, 0,2,3, 0},
            {1, 4,3, 1,2,3, 0},
      };
      info = "a=b=d=e\nA+D=180\n2A+E=360\n(B+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double b = paramValues[0];

      double x4 =      ln*Math.cos( b * DEG2RAD);
      double y4 =      ln*Math.sin( b * DEG2RAD);
      double x3 = 0;
      double y3 = y4 + y4;
      double x2 = x3 - ln*Math.cos( 2*b * DEG2RAD);
      double y2 = y3 + ln*Math.sin( 2*b * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[3].getX(1);
      offsets[1] = tiles[2].getY(2)-tiles[3].getY(1);
      offsets[2] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(4)-tiles[0].getY(0);
   }
}

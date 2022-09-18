package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_03
   extends TilingType
{
   public TilingTypeNC5_03(){
      super( "NC5-3", 5, SymmetryType.pg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,2,3, 0},
            {0, 1,0, 0,1,2, 0},
            {1, 1,0, 2,3,4, 0},
      };
      info = "a=b=c=d=e\nA=108\nB=108\nC=36\nD=252\n(E=36)";
   }

   public void recalcBase(double[] paramValues) {
      double ln =.75;
      double x2 = ln + ln*Math.cos( (72) * DEG2RAD);
      double y2 =      ln*Math.sin( (72) * DEG2RAD);
      double x3 = ln/2;
      double y3 = y2 + ln*Math.sin( (-144) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (144) * DEG2RAD);
      double y4 = y3 + ln*Math.sin( (144) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(4);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(4);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}

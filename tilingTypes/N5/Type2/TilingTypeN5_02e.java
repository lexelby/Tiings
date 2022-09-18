package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_02e
   extends TilingType
{
   public TilingTypeN5_02e(){
      super( "N5-2e", 5, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{130};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {1, 0,4, 0,2,3, 0},
            {0, 1,2, 2,1,2, 1},

            {0, 0,4, 1,3,4, 1},
            {1, 1,2, 4,1,2, 0},
            {0, 2,3, 5,0,4, 0},
            {1, 1,2, 6,1,2, 1},
      };
      info = "a=d=e\nA+D=180\nB=90\nD+2E=360\n(C+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double f2 = getParam( paramValues,0)/2.;

      double x4 =      ln*Math.cos( f2*2 * DEG2RAD);
      double y4 =      ln*Math.sin( f2*2 * DEG2RAD);
      double x3 = x4 + ln*Math.sin( f2*3 * DEG2RAD);
      double y3 = y4 - ln*Math.cos( f2*3 * DEG2RAD);
      double x2 = x3 + ln*Math.sin( f2 * DEG2RAD);
      double y2 = y3 - ln*Math.cos( f2 * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[1].getX(0);
      offsets[1] = tiles[2].getY(2)-tiles[1].getY(0);
      offsets[2] = tiles[5].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(3)-tiles[0].getY(0);
   }
}

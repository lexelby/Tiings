package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_60a
   extends TilingType
{
   public TilingTypeNC5_60a(){
      super( "NC5-60a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{ 90,100,100};
      paramDef = new int[]{ 40, 30, 50};
      paramName = new String[]{ "Angle", "Relative length", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,0,4, 0},
            {0, 0,1, 0,2,3, 1},
            {0, 4,0, 2,0,4, 1},
      };
      info = "b=d\nB+D=360\nC+D=180\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double s2 = 1. * paramValues[1]/100;
      double ln2 = 1 - s2;
      double maxln3 = Math.min(s2, ln2*Math.cos(c*DEG2RAD));
      double ln3 = paramValues[2]<=50 ? s2 * paramValues[2]/50 :
                                        s2 + maxln3* (paramValues[2]-50)/50;
      double ln1 = 2*s2 - ln3;

      double x1 =      ln2 * Math.cos( c * DEG2RAD);
      double y1 =      ln2 * Math.sin( c * DEG2RAD);
      double x2 = x1 + ln3;
      double y2 = y1;
      double x3 = x2 - ln2 * Math.cos( c * DEG2RAD);
      double y3 = y2 + ln2 * Math.sin( c * DEG2RAD);
      double x4 = x3 - ln1;
      double y4 = y3;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(0)-tiles[2].getY(2);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(1);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(1);
   }
}

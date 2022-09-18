package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_14a
   extends TilingType
{
   public TilingTypeNC5_14a(){
      super( "NC5-14a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{ 90,100,100};
      paramDef = new int[]{ 40, 30, 50};
      paramName = new String[]{ "Angle", "Relative length", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,0,4, 0},
            {0, 1,2, 0,3,4, 1},
            {0, 4,0, 2,0,4, 1},
      };
      info = "c=e\nB+C=360\nB+D=180\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double s2 = paramValues[1]/100.;
      double ln2 = 1 - s2;
      double maxln3 = Math.min(s2, ln2*Math.cos(c*DEG2RAD));
      double ln3 = paramValues[2]<=50 ? s2 * paramValues[2]/50 :
                                        s2 + maxln3* (paramValues[2]-50)/50;
      double ln1 = 2*s2 - ln3;

      double x1 = ln1;
      double y1 = 0;
      double x2 = x1 + ln2 * Math.cos( c * DEG2RAD);
      double y2 = y1 + ln2 * Math.sin( c * DEG2RAD);
      double x3 = x2 + ln3;
      double y3 = y2;
      double x4 = x3 - ln2 * Math.cos( c * DEG2RAD);
      double y4 = y3 + ln2 * Math.sin( c * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[2].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[2].getY(3);
      offsets[2] = tiles[2].getX(0)-tiles[1].getX(2);
      offsets[3] = tiles[2].getY(0)-tiles[1].getY(2);
   }
}

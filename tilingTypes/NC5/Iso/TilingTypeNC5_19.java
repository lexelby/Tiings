package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_19
   extends TilingType
{
   public TilingTypeNC5_19(){
      super( "NC5-19: Split hexagons", 5, SymmetryType.p6 );

      paramMin = new int[]{-120,  0};
      paramMax = new int[]{ 120,100};
      paramDef = new int[]{  30, 50};
      paramName = new String[]{ "Angle", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,3, 0,1,3, 0},
            {0, 0,3, 1,1,3, 0},
            {0, 0,3, 2,1,3, 0},
            {0, 0,3, 3,1,3, 0},
            {0, 0,3, 4,1,3, 0},
      };
      info = "a=c\nd=e\nC+E=360\nD=60\n(A+B=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double h = ln*Math.sqrt(3);
      double an = paramValues[0];
      double ln2 = paramValues[1] * h / Math.cos((Math.abs(an)%60-30)*DEG2RAD) / 100;

      double x4 = ln+ ln2 * Math.cos( (an-120) * DEG2RAD);
      double y4 = h + ln2 * Math.sin( (an-120) * DEG2RAD);
      double x2 = ln+ ln2 * Math.cos( (an- 60) * DEG2RAD);
      double y2 = h + ln2 * Math.sin( (an- 60) * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,2*ln,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  ln,  h);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0);
   }
}

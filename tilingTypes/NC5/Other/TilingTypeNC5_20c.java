package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_20c
   extends TilingType
{
   public TilingTypeNC5_20c(){
      super( "NC5-20c: Split squares", 6, SymmetryType.pgg );

      paramMin = new int[]{-135,  0};
      paramMax = new int[]{ 135,100};
      paramDef = new int[]{  30, 50};
      paramName = new String[]{ "Angle", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,2,4, 0},
            {0, 0,4, 1,2,4, 0},
            {1, 0,4, 2,2,4, 0},

            {0, 1,2, 0,0,1, 1},
            {1, 0,4, 4,2,4, 1},
            {0, 0,4, 5,2,4, 1},
            {1, 0,4, 6,2,4, 1},
      };
      info = "a=c\nd=e\nC+E=360\nD=90\n(A+B=90)";
      labels = new int[]{0,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];
      double ln = .5;
      double ln2 = ln * paramValues[1] / Math.cos((Math.abs(an)%90-45)*DEG2RAD) / 100;

      double x2 = ln + ln2 * Math.cos( (an- 45) * DEG2RAD);
      double y2 = ln + ln2 * Math.sin( (an- 45) * DEG2RAD);
      double x4 = ln + ln2 * Math.cos( (an-135) * DEG2RAD);
      double y4 = ln + ln2 * Math.sin( (an-135) * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,  ln,  0);
      baseTile.setPoint(2,2*ln,  0);
      baseTile.setPoint(3,  x2, y2);
      baseTile.setPoint(4,  ln, ln);
      baseTile.setPoint(5,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[6].getX(0);
      offsets[3] = tiles[2].getY(1)-tiles[6].getY(0);
   }
}

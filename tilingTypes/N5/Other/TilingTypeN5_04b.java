package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_04b
   extends TilingType
{
   public TilingTypeN5_04b(){
      super( "N5-4b", 5, SymmetryType.pgg );

      paramMin = new int[]{ 45};
      paramMax = new int[]{270};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 0,1, 2,2,1, 0},

            {0, 3,2, 0,2,1, 1},
            {1, 2,1, 4,0,1, 1},
            {1, 3,2, 5,2,3, 1},
            {0, 0,1, 6,2,1, 1},
      };
      info = "a=2b=2c\nd=e\nB=90\nD=90\n(A+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];
      double c = Math.cos((an-90) * DEG2RAD);
      double c2 = c*c;
      double ln = Math.sqrt(c2+1) - c;
      
      // scale
      double f = 1 / (1 + ln);
      double ln1 = ln * f;
      double ln2 = f;

      double x4 = ln2 * Math.cos( an * DEG2RAD);
      double y4 = ln2 * Math.sin( an * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (an-90) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (an-90) * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1,  0);
      baseTile.setPoint(2, ln1,ln1);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(3);
   }
}


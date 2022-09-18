package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_70
   extends TilingType
{
   public TilingTypeNC5_70(){
      super( "NC5-70", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 50, 90};
      paramName = new String[]{ "Relative Length", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,3,2, 1},
            {1, 2,0, 1,0,2, 1},
            {0, 3,2, 2,2,1, 0},

            {0, 2,1, 0,0,4, 1},
            {1, 2,1, 4,3,2, 0},
            {1, 2,0, 5,0,2, 0},
            {0, 3,2, 6,2,1, 1},
      };
      info = "a=c=d\nD+E=360\nB+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = paramValues[0]/100.;
      double ln1 = (3-ln2)/2;
      ln1 *=.6;
      ln2 *=.6;
      double anB = paramValues[1];

      double diag = calcSide( 2 * ln1, ln2, anB );
      // calculate base (long side, ln3)
      // diag^2 = ln3^2+ln1^2 -2 ln3 ln1 cos(b)
      double b = -2 * ln1 * Math.cos(anB * DEG2RAD);
      double c = ln1*ln1 - diag*diag;
      double ln3 = ( Math.sqrt(b*b-4*c) - b )/2;
      double anA = calcAngle(ln3, diag, ln1) - calcAngle(diag, 2*ln1, ln2);

      double x4 =      ln1 * Math.cos( anA * DEG2RAD);
      double y4 =      ln1 * Math.sin( anA * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (anA-anB+180) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (anA-anB+180) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = ln3;
      double y1 = 0;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[4].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(1);
   }
}

package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_13
   extends TilingType
{
   public TilingTypeN5_13(){
      super( "N5-13: Marjorie Rice, 1976", 5, SymmetryType.pgg );

      paramMin = new int[]{ 45};
      paramMax = new int[]{135};
      paramDef = new int[]{120};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 0,4, 0,3,2, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 3,2, 5,2,3, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "d=2a=2e\nB=90\nE=90\n2A+D=360\n(2C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c = Math.cos( paramValues[0] * DEG2RAD);
      double s = Math.sin( paramValues[0] * DEG2RAD);

      double ln2 = .5*Math.sqrt(2) * Math.sin(( 135-paramValues[0]) * DEG2RAD);

      double x4 = c/2;
      double y4 = s/2;
      double x3 = (s+c)/2;
      double y3 = (s-c)/2;
      double x2 = (s+c)/2 + s;
      double y2 = (s+c)/2;
      double x1 = x2;
      double y1 = y2 - ln2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[6].getX(0)-tiles[3].getX(3);
      offsets[3] = tiles[6].getY(0)-tiles[3].getY(3);
   }
}

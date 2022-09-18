package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_45
   extends TilingType
{
   public TilingTypeN4_45(){
      super( "N4-45", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {1, 2,3, 1,3,2, 1},
            {0, 0,3, 2,0,3, 0},

            {0, 2,3, 1,1,0, 1},
            {1, 0,3, 4,0,3, 0},
            {1, 2,3, 5,3,2, 0},
            {0, 0,3, 6,0,3, 1},
      };
      info = "2a=b+c\nA=90\n2B+C=360\n(B-D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];
      double c = Math.cos(an/2 * DEG2RAD);
      double s = Math.sin(an/2 * DEG2RAD);
      double h = 2*s;
      double w = c+.5; // 1 + (2c-1)/2
      double ln = 1.5 / (h+w);
      w *= ln;
      h *= ln;
      // h2:h = 2c-(c+.5) : 2c
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2,  w,  h*(c-.5)/c/2);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(2);
   }

}

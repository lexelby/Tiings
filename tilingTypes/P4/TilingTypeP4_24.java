package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_24
   extends TilingType
{
   public TilingTypeP4_24(){
      super( "P4-24: Bisected rhombus", 4, SymmetryType.p6 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,1, 0,0,3, 0},
            {0, 1,2, 2,2,1, 0},
            {0, 0,1, 2,0,3, 0},
            {0, 1,2, 4,2,1, 0},
            };
      info = "b+d=a\nA=120\nD=60\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      double h = Math.sqrt(3)/2;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, f, 0);
      baseTile.setPoint(2, 0.5-f, h);
      baseTile.setPoint(3, -0.5, h );
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[3].getX(3);
      offsets[1] = tiles[1].getY(3)-tiles[3].getY(3);
      offsets[2] = tiles[2].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[2].getY(3)-tiles[3].getY(3);
   }
}

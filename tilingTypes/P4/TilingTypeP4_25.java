package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_25
   extends TilingType
{
   public TilingTypeP4_25(){
      super( "P4-25: Radially split hexagons", 4, SymmetryType.p6);

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,3, 0},
            {0, 0,1, 1,0,3, 0},
            {0, 0,1, 2,0,3, 0},
            {0, 0,1, 3,0,3, 0},
            {0, 0,1, 4,0,3, 0},
            };
      info = "a=b\nA=60\nC=120\n(B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      double h = Math.sqrt(3)/2;
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, 1-f/2, h*f);
      baseTile.setPoint(2, .5, h);
      baseTile.setPoint(3, .5-f, h );
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(2);
      offsets[2] = tiles[2].getX(2)-tiles[4].getX(2);
      offsets[3] = tiles[2].getY(2)-tiles[4].getY(2);
   }
}

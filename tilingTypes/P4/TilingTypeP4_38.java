package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_38
   extends TilingType
{
   public TilingTypeP4_38(){
      super( "P4-38: Radially dissected squares 1", 4, SymmetryType.p4 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,3,2, 0},
            {0, 1,2, 1,3,2, 0},
            {0, 1,2, 2,3,2, 0},
            };
      info = "c=d\nA=90\nC=90\n(B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,   f,  0);
      baseTile.setPoint(2, 0.5,0.5);
      baseTile.setPoint(3,   0,1-f);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0);
   }
}

package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_48
   extends TilingType
{
   public TilingTypeP4_48(){
      super( "P4-48", 4, SymmetryType.cmm );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 30, 60};
      paramName = new String[]{ "Aspect", "Cut ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,3, 0,0,3, 1},
            {0, 1,2, 2,2,1, 1},
            };
      info = "A=90\nD=90\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 3*paramValues[0]/100.;
      double ln2 = (3-w)/2;
      double ln3 = w*paramValues[1]/100.;
      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,   ln3,  0);
      baseTile.setPoint(2, w-ln3,ln2);
      baseTile.setPoint(3,     0,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[1].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[1].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0);
   }
}

package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_44
   extends TilingType
{
   public TilingTypeP4_44(){
      super( "P4-44", 4, SymmetryType.pmg );

      paramMin = new int[]{-89,  0,  0};
      paramMax = new int[]{ 89,100,100};
      paramDef = new int[]{ 10, 30, 40};
      paramName = new String[]{ "Angle", "Aspect", "Side ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {0, 1,2, 0,1,2, 1},
            {0, 2,3, 2,3,2, 1},
            };
      info = "A+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*paramValues[1]/100.;
      double ln2 = 2-w;

      double ln3 = ln2*2 * paramValues[2]/100.; // left side
      double ln4 = w*Math.tan( paramValues[0] * DEG2RAD); // offset
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   w, ln4+ln3-ln2);
      baseTile.setPoint(2,   w, ln4+ln2);
      baseTile.setPoint(3,   0, ln3);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(0);
   }
}

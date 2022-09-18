package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_14
   extends TilingType
{
   public TilingTypeP4_14(){
      super( "P4-14", 5, SymmetryType.pgg);

      paramMin = new int[]{-89,  0,  0};
      paramMax = new int[]{ 89,100,100};
      paramDef = new int[]{ 10, 30, 60};
      paramName = new String[]{ "Angle", "Aspect", "Side ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
            {0, 4,0, 0,2,3, 1},
            {0, 0,1, 2,1,0, 1},
            };
      labels = new int[]{0,1,-1,2,3};
      info = "A+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2* paramValues[1]/100.;
      double ln2 = 2* (2-w);// sum of parallel side lengths
      double ln3 = ln2 * getParam( paramValues,2)/100.; // left side
      double ln4 = Math.tan( paramValues[0] * DEG2RAD); // offset

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   w, ln4+ln3-ln2/2 );
      baseTile.setPoint(2,   w, ln4 );
      baseTile.setPoint(3,   w, ln4+ln2/2 );
      baseTile.setPoint(4,   0, ln3);

   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[2].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(0);
   }
}

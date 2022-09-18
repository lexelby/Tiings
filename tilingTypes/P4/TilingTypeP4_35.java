package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_35
   extends TilingType
{
   public TilingTypeP4_35(){
      super( "P4-35", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 40};
      paramName = new String[]{ "Aspect", "Side length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,2,3, 1},
            {0, 3,0, 0,1,2, 1},
            {0, 3,2, 2,1,0, 0},
            };
      info = "b=d\nA+B=180\nA=D\n(B=C)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*paramValues[0]/100.;
      double ln2 = 2-w; // average length of parallel sides
      double ln3 = ln2*2 * getParam( paramValues,1)/100.;   // left side
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   w, ln3-ln2);
      baseTile.setPoint(2,   w, ln2 );
      baseTile.setPoint(3,   0, ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[2].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[0].getY(0);
   }
}

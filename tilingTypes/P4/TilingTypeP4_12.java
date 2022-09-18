package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_12
   extends TilingType
{
   public TilingTypeP4_12(){
      super( "P4-12&52", 5, SymmetryType.pgg);

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 10, 40, 40};
      paramName = new String[]{ "Offset", "Aspect", "Side ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,3,4, 1},
            {0, 2,3, 0,3,2, 0},
            {0, 3,4, 2,0,1, 1},
            };
      labels = new int[]{0,1,-1,2,3};
      info = "b=d\nA+B=180\nA=D\n(B=C)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2* paramValues[1]/100.;
      double ln2 = 2* (2-w);// sum of parallel side lengths
      double ln3 = ln2 * getParam( paramValues,2)/100.; // left side
      double ln4 = ln2 * getParam( paramValues,0)/100.; // offset

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   w, ln3-ln2/2 );
      baseTile.setPoint(2,   w, ln3-ln2/2 + ln4 );
      baseTile.setPoint(3,   w, ln2/2 );
      baseTile.setPoint(4,   0, ln3);

   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[3].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(3)-tiles[0].getY(0);
   }
}

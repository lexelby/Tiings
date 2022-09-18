package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_41d
   extends TilingType
{
   public TilingTypeN4_41d(){
      super( "N4-41d: mg trapezium", 5, SymmetryType.cm);

      paramMin = new int[]{  0,  0,-89};
      paramMax = new int[]{100,100, 89};
      paramDef = new int[]{ 40, 35, 10};
      paramName = new String[]{ "Aspect", "Side ratio", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 0,3, 1,0,3, 1},
            {0, 1,0, 2,0,1, 1},
      };
      info = "A+B=180\n(C+D=180)";
      labels = new int[]{0,1,2,3,-1};
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;

      double ln2 = 2 * (1.5-w); // sum of parallel side lengths
      double ln3 = ln2 * paramValues[1]/100.; // left side
      double ln4 = w*Math.tan( paramValues[2] * DEG2RAD); // offset of parallel sides

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, ln4-ln2/2+ln3);
      baseTile.setPoint(2, w, ln4+ln2/2);
      baseTile.setPoint(3, 0, ln3);
      baseTile.setPoint(4, 0, ln2/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(4)-tiles[0].getY(0);
   }
}

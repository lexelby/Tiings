package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_41a
   extends TilingType
{
   public TilingTypeN4_41a(){
      super( "N4-41a: ss trapezium", 5, SymmetryType.p2);

      paramMin = new int[]{  0,  0,-89,  0,  0};
      paramMax = new int[]{100,100, 89,100,100};
      paramDef = new int[]{ 40, 35, 10,  5, 40};
      paramName = new String[]{ "Aspect", "Side ratio", "Angle", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 1,0, 2,0,1, 0},
      };
      info = "A+B=180\n(C+D=180)";
      labels = new int[]{0,1,2,3,-1};
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;

      double ln2 = 2 * (1.5-w); // sum of parallel side lengths
      double ln3 = ln2 * paramValues[1]/100.; // left side
      double ln4 = w*Math.tan( paramValues[2] * DEG2RAD); // offset of parallel sides
      double os = ln2 * getParam(paramValues,4)/100.;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, ln4-ln2/2+ln3);
      baseTile.setPoint(2, w, ln4+ln2/2);
      baseTile.setPoint(3, 0, ln3);
      baseTile.setPoint(4, 0, ln3-os);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[3]/100.; // strip offset
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0) + os * offsets[0];
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0) + os * offsets[1];
   }
}

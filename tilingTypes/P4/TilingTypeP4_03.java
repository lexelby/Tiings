package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_03
   extends TilingType
{
   public TilingTypeP4_03(){
      super( "P4-3&6&20&29&50&55", 4, SymmetryType.p2);

      paramMin = new int[]{  0,  0,-89,  0};
      paramMax = new int[]{100,100, 89,100};
      paramDef = new int[]{ 40, 35, 10,  5};
      paramName = new String[]{ "Aspect", "Side ratio", "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            };
      info = "A+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*(1+paramValues[0])/102.;

      double ln2 = 2* (2-w);// sum of parallel side lengths
      double ln3 = ln2 * paramValues[1]/100.; // left side
      double ln4 = w*Math.tan( paramValues[2] * DEG2RAD); // offset of parallel sides
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, ln4-ln2/2+ln3);
      baseTile.setPoint(2, w, ln4+ln2/2);
      baseTile.setPoint(3, 0, ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[3]/100.; // strip offset
      offsets[0] = tiles[0].getX(1)*(1-os)+tiles[1].getX(0)*os-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)*(1-os)+tiles[1].getY(0)*os-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(0);
   }
}

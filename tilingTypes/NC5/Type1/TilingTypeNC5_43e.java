package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.NC5.TilingTypeNC5_43;

public class TilingTypeNC5_43e
   extends TilingTypeNC5_43
{
   public TilingTypeNC5_43e(){
      super( "NC5-43e: Split paralellogram", SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0,  0,  0,  0};
      paramMax = new int[]{180,100,100,100,100,100};
      paramDef = new int[]{ 70, 40, 60, 60, 20, 40};
      paramName = new String[]{ "Angle", "Relative length", "X", "Y", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 6,3, 0,3,6, 0},
            
            {0, 0,1, 0,1,0, 0},
            {1, 6,3, 2,3,6, 0},
      };
   }

   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues,5)/100;
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(3)-tiles[3].getX(0) + os * offsets[0];
      offsets[3] = tiles[1].getY(3)-tiles[3].getY(0) + os * offsets[1];
   }
}

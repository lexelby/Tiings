package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_21a
   extends TilingType
{
   public TilingTypeN4_21a(){
      super( "N4-21a", 5, SymmetryType.pmg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 70,  0};
      paramName = new String[]{ "Aspect", "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 4,3, 2,3,4, 0},

            {0, 0,2, 0,0,2, 1},
            {1, 4,3, 4,3,4, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 4,3, 6,3,4, 1},
      };
      info = "A=90\nB=90\n(C+D=180)";
      labels = new int[]{0,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*getParam( paramValues,0)/100.;
      double ln2 = 2-ln1;
      double os = ln1*getParam( paramValues,2)/100.;

      double ln3 = ln2*getParam( paramValues,1)/100.;
      ln2 -= ln3;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, os,  0);
      baseTile.setPoint(2,ln1,  0);
      baseTile.setPoint(3,ln1,ln2);
      baseTile.setPoint(4,  0,ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[3].getX(0);
      offsets[1] = tiles[7].getY(0)-tiles[3].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}

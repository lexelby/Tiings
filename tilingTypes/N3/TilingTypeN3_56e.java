package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_56e
   extends TilingType
{
   public TilingTypeN3_56e(){
      super( "N3-56e", 3, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 55};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 0,2, 1,0,1, 0},
            {1, 1,2, 2,2,1, 0},
            {0, 0,1, 3,0,2, 0},
            {2, 1,2, 4,2,1, 0},
      };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double ln1 = ln * getParam( paramValues,0)/100;
      double ln2 = ln - ln1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2,  0,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[2].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(0)-tiles[5].getX(2);
      offsets[3] = tiles[0].getY(0)-tiles[5].getY(2);
   }
}

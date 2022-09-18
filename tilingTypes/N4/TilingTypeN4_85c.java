package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_85c
   extends TilingType
{
   public TilingTypeN4_85c(){
      super( "N4-85c", 4, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 3,0, 1,2,3, 0},
            {2, 2,3, 2,3,2, 0},
            {1, 2,3, 3,3,0, 1},
            {0, 0,3, 4,0,3, 0},
      };
      info = "a=2d\nA=45\nB=90\nD=90\n(C=135)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, 3*ln,  0);
      baseTile.setPoint(2, 3*ln, ln);
      baseTile.setPoint(3, 2*ln, 2*ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
      double os = getParam(paramValues, 0) / 50 - 1;
      if( os>0 ){
         offsets[0] += offsets[2]*os;
         offsets[1] += offsets[3]*os;
      }else{
         offsets[2] -= offsets[0]*os;
         offsets[3] -= offsets[1]*os;
      }
   }
}

package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_54a
   extends TilingType
{
   public TilingTypeN3_54a(){
      super( "N3-54a", 3, SymmetryType.p2 );
      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 2,1, 0,2,1, 1},
            {2, 1,0, 1,1,0, 0},
            {2, 2,0, 1,2,0, 0},
            {0, 1,0, 3,1,0, 1},
            {1, 2,1, 4,2,1, 0},
      };
      info = "A=90\nB=30\n(C=60)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues,0)/50 - 1;
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
      if( os>0 ){
         offsets[0] += os * offsets[2];
         offsets[1] += os * offsets[3];
      }else{
         offsets[2] += os * offsets[0];
         offsets[3] += os * offsets[1];
      }
   }
}

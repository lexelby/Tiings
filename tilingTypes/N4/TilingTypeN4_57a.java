package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_57a
   extends TilingType
{
   public TilingTypeN4_57a(){
      super( "N4-57a", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 30, 50};
      paramName = new String[]{ "Side ratio", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},

            {1, 1,0, 0,1,2, 0},
            {1, 1,0, 1,1,2, 0},
      };
      info = "b=a+c\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.25;
      double w = h;

      double h1 = h * getParam(paramValues,0)/100;
      double h2 = h - h1;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h1);
      baseTile.setPoint(3, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues,1)/50 - 1;
      offsets[0] = tiles[2].getX(2)-tiles[3].getX(3);
      offsets[1] = tiles[2].getY(2)-tiles[3].getY(3);
      offsets[2] = tiles[3].getX(2)-tiles[3].getX(3);
      offsets[3] = tiles[3].getY(2)-tiles[3].getY(3);
      if( os>0 ){
         offsets[2] += offsets[0]*os;
         offsets[3] += offsets[1]*os;
      }else{
         offsets[0] -= offsets[2]*os;
         offsets[1] -= offsets[3]*os;
      }
   }
}

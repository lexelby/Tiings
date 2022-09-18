package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_36
   extends TilingType
{
   public TilingTypeN4_36(){
      super( "N4-36", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Aspect", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,3, 1,0,3, 0},
            {1, 0,1, 2,0,1, 1},
      };
      info = "A=90\nC+2D=360\n(2B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*getParam(paramValues,0)/100;
      double h = 2-w;
      double h2 = h * getParam(paramValues,1)/100;
      double w2 = (1-h2/(h+h-h2))*w/2;
    
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2,w2,  h);
      baseTile.setPoint(3, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(2);
   }
}

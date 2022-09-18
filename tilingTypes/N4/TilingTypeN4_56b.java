package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_56b
   extends TilingType
{
   public TilingTypeN4_56b(){
      super( "N4-56b", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 20};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,1, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 0,1, 2,0,3, 0},
      };
      info = "a+b=c\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 2.5 * (.5 + getParam(paramValues,0)/200);
      double w = 2.5 - h;

      double h1 = (h+w)/2;
      double h2 = h - h1;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h1);
      baseTile.setPoint(3, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues,1)/100;
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[0].getX(2)-tiles[3].getX(3) + os * offsets[0];
      offsets[3] = tiles[0].getY(2)-tiles[3].getY(3) + os * offsets[1];
   }
}

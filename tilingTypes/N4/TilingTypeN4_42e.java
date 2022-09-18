package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_42e
   extends TilingType
{
   public TilingTypeN4_42e(){
      super( "N4-42e: g trapezium", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,180,100};
      paramDef = new int[]{ 40, 35, 80, 30};
      paramName = new String[]{ "Aspect", "Side ratio", "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {0, 0,1, 1,1,2, 1},
            {1, 4,3, 2,3,4, 1},
      };
      info = "A+B=180\n(C+D=180)";
      labels = new int[]{0,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double h = 2.5 * getParam(paramValues,0)/100;
      double w = 2.5 - h;

      double h1 = h * getParam(paramValues,1)/100;
      double h2 = h - h1;

      double c = Math.cos( paramValues[2] * DEG2RAD );
      double s = Math.sin( paramValues[2] * DEG2RAD );

      double os = w * getParam(paramValues,3)/100;
      
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, os,  0);
      baseTile.setPoint(2, w,  0);
      baseTile.setPoint(3, w+h1*c, h1*s);
      baseTile.setPoint(4,   h2*c, h2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}

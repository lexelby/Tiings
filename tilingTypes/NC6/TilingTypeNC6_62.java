package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_62
   extends TilingType
{
   public TilingTypeNC6_62(){
      super( "NC6-62", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 60, 55, 60, 40};
      paramName = new String[]{"Aspect", "Indent", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,4,0, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 4,0, 2,0,2, 0},

            {0, 3,4, 0,2,3, 1},
            {1, 0,2, 4,4,0, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 4,0, 6,0,2, 1},
      };
      info = "a=c\nb=f\nd=e\nB+F=360\n(A+C+D+E=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;

      double ind = (getParam(paramValues, 1)/50 -1 )*w;
      double w1 = w-ind;
      double x = getParam(paramValues, 2)/100 * w1;
      double basey = x /w1 * -h/2;
      double y = basey + getParam(paramValues, 3)/100 * h;

      double x5 = x;
      double y5 = y;
      double x4 = w1;
      double y4 = h/2;
      double x3 = w+ind;
      double y3 = 0;
      double x2 = w1;
      double y2 = -h/2;
      double x1 = w1-x;
      double y1 = -h/2+y;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(3);
   }
}
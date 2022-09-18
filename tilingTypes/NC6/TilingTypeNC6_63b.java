package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_63b
   extends TilingType
{
   public TilingTypeNC6_63b(){
      super( "NC6-63b", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 55, 60, 20, 40};
      paramName = new String[]{"Aspect", "Indent", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,0,3, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 3,0, 2,0,3, 0},

            {1, 2,3, 0,2,3, 1},
            {0, 3,0, 4,0,3, 1},
            {0, 1,0, 5,0,1, 1},
            {1, 3,0, 6,0,3, 1},
      };
      info = "a=e\nb=c\nB+2C=360\nE+F=360\n(A+D=C)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;

      double ind = (getParam(paramValues, 1)/50 - 1 ) * h;
      double h1 = h-ind;
      double x = (getParam(paramValues, 2)/50 - 1 ) * w;
      double rangey = (1 - Math.abs(x)/w) * 2*ind + h1;
      double y = (getParam(paramValues, 3)/50 - 1 ) * rangey;

      double x1 = w;
      double y1 = -2*ind;
      double x2 = 2*w;
      double y2 = 0;
      double x3 = 2*w;
      double y3 = 2*h1;
      double x4 = w-x;
      double y4 = h1-y;
      double x5 = w+x;
      double y5 = h1+y;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(1);
   }
}